package com.mize.domain.sce.serviceEntity;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import com.mize.domain.auth.User;
import com.mize.domain.common.Locale;
import com.mize.domain.serviceentity.SEAddress;
import com.mize.domain.serviceentity.SEAmount;
import com.mize.domain.serviceentity.SEAttachment;
import com.mize.domain.serviceentity.SELabor;
import com.mize.domain.serviceentity.SENote;
import com.mize.domain.serviceentity.SEOtherCharges;
import com.mize.domain.serviceentity.SEPart;
import com.mize.domain.serviceentity.SEProvider;
import com.mize.domain.serviceentity.SERequest;
import com.mize.domain.serviceentity.SERequester;
import com.mize.domain.serviceentity.ServiceEntity;
import com.mize.domain.servicelocator.BusinessEntity;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.user.UserBE;
import com.mize.domain.util.Formatter;


@ContextConfiguration(locations={"/test-context.xml"})
public class ServiceEntityTest extends JPATest {
	private static final String SERVICE_ENTITY_QUERY = "select * from service_entity where id = ?";
	EntityManager entityManager = null;
	ServiceEntity serviceEntity = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		serviceEntity = findExistingServiceEntityObject(entityManager);
		this.serviceEntity = getSEAddressObjectToSave(serviceEntity);
		EntityTransaction tx =entityManager.getTransaction();
		tx.begin();
		entityManager.persist(serviceEntity);
		tx.commit();
	}

	@Test
	public void test() {
		try {
			List<ServiceEntity> serviceEntitys = jdbcTemplate.query(SERVICE_ENTITY_QUERY, new Object[]{serviceEntity.getId()}, new ServiceEntityRowMapper());
			if(!Formatter.isEmpty(serviceEntitys)){
				ServiceEntity entitys = serviceEntitys.get(0);
				assertTrue(serviceEntity.getId().equals(entitys.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class ServiceEntityRowMapper implements RowMapper<ServiceEntity> {
		@Override
		public ServiceEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			ServiceEntity serviceEntity = new ServiceEntity();
			serviceEntity.setId(rs.getLong("id"));
			BusinessEntity be = new BusinessEntity();
			be.setId(rs.getLong("tenant_id"));
			SERequester requester = new SERequester();
			requester.setBusinessEntity(be);
			serviceEntity.setRequester(requester);
			serviceEntity.setCode(rs.getString("entity_code"));
			serviceEntity.setStatus(rs.getString("entity_status"));
			Locale locale = new Locale();
			locale.setId(rs.getLong("locale_id"));
			serviceEntity.setLocale(locale);
			serviceEntity.setCurrencyCode(rs.getString("currency_code"));
			serviceEntity.setEntityReference(rs.getString("entity_reference"));
			SEAmount partAmount = new SEAmount();
			partAmount.setId(rs.getLong("part_amount_id"));
			serviceEntity.setPartAmount(partAmount);
			SEAmount laborAmount = new SEAmount();
			laborAmount.setId(rs.getLong("labor_amount_id"));
			serviceEntity.setLaborAmount(laborAmount);
			SEAmount otherAmount = new SEAmount();
			otherAmount.setId(rs.getLong("other_amount_id"));
			serviceEntity.setOtherAmount(otherAmount);
			SEAmount totalAmount = new SEAmount();
			totalAmount.setId(rs.getLong("total_amount_id"));
			serviceEntity.setTotalAmount(totalAmount);
			serviceEntity.setCreatedDate(Formatter.dateTime(rs.getTimestamp("created_date")));
			serviceEntity.setUpdatedDate(Formatter.dateTime(rs.getTimestamp("updated_date")));
			serviceEntity.setCreatedBy(rs.getLong("created_by"));
			serviceEntity.setUpdatedBy(rs.getLong("updated_by"));
			serviceEntity.setType(rs.getString("service_type"));
			serviceEntity.setSalesPerson(rs.getString("sales_person"));
			serviceEntity.setShipComplete(rs.getString("ship_complete"));
			serviceEntity.setProcessId(rs.getString("process_id"));
			return serviceEntity;
		}
	}
	
	
	private ServiceEntity getSEAddressObjectToSave(ServiceEntity entity) {
		serviceEntity = new ServiceEntity();	
		serviceEntity.setStatus(ServiceEntity.Status.Draft.toString());
		serviceEntity.setLocale(new Locale(1l));
		serviceEntity.setCurrencyCode("Dollar");
		serviceEntity.setServiceType("BackFilling");
		SEProvider provider = new SEProvider();
		BusinessEntity businessEntity = new BusinessEntity();
		businessEntity.setId(961L);
		businessEntity = entityManager.find(BusinessEntity.class, businessEntity.getId());
		provider.setBusinessEntity(businessEntity);
		SEAddress address = new SEAddress();
		address.setAddress1("test1");
		address.setAddress2("test2");
		provider.setServiceEntity(serviceEntity);
		provider.setAddress(address);
		serviceEntity.setProvider(provider);
		
		SERequester requester = new SERequester();
		BusinessEntity businessEntity1 = new BusinessEntity();
		businessEntity1.setId(961l);
		businessEntity1 = entityManager.find(BusinessEntity.class, businessEntity1.getId());
		requester.setBusinessEntity(businessEntity1);
		SEAddress address1 = new SEAddress();
		address1.setAddress1("test1");
		address1.setAddress2("test2");
		requester.setAddress(address1);
		requester.setServiceEntity(serviceEntity);
		serviceEntity.setRequester(requester);
		User user = new User();
		user.setId(785l);
		UserBE be = new UserBE();
		be.setBeId(961l);
		user.setUserBe(be);
		serviceEntity.setUser(user);
		SERequest request = new SERequest();
		request.setType(ServiceEntity.Type.Warranty.toString());
		request.setFailureDate(DateTime.now());
		request.setRepairDate(DateTime.now().plusDays(1));
		request.setProdId(100l);
		request.setServiceEntity(serviceEntity);
		SEPart part = new SEPart();
		part.setRequest(request);
		part.setCode("9152413200");
		part.setType("starndar");
		part.setSerialNumber("1111");
		SEAmount seAmount = new SEAmount();
		seAmount.setRequestedAmount(BigDecimal.valueOf(300));
		seAmount.setAdjustedAmount(BigDecimal.valueOf(301));
		seAmount.setRequestedQuantity(BigDecimal.valueOf(20));
		seAmount.setAdjustedQuantity(BigDecimal.valueOf(20));
		part.setAmount(seAmount);
		
		SEPart part1 = new SEPart();
		part1.setRequest(request);
		part1.setCode("9152413200");
		part1.setType("starndar");
		part1.setSerialNumber("1111");
		seAmount.setRequestedAmount(BigDecimal.valueOf(300));
		seAmount.setAdjustedAmount(BigDecimal.valueOf(301));
		seAmount.setRequestedQuantity(BigDecimal.valueOf(20));
		seAmount.setAdjustedQuantity(BigDecimal.valueOf(20));
		part.setAmount(seAmount);
		request.getParts().add(part);
		request.getParts().add(part1);
		
		SELabor labor = new SELabor();
		SEAmount seLaborAmount = new SEAmount();
		labor.setRequest(request);
		labor.setCode("L001");
		labor.setType("hour1");
		seLaborAmount.setRequestedAmount(BigDecimal.valueOf(300));
		seLaborAmount.setAdjustedAmount(BigDecimal.valueOf(301));
		seLaborAmount.setRequestedQuantity(BigDecimal.valueOf(20));
		seLaborAmount.setAdjustedQuantity(BigDecimal.valueOf(21));
		labor.setAmount(seLaborAmount);
		
		SELabor labor1 = new SELabor();
		SEAmount seLaborAmount2 = new SEAmount();
		labor1.setRequest(request);
		labor1.setCode("L0011");
		labor1.setType("hour");
		seLaborAmount2.setRequestedAmount(BigDecimal.valueOf(300));
		seLaborAmount2.setAdjustedAmount(BigDecimal.valueOf(301));
		seLaborAmount2.setRequestedQuantity(BigDecimal.valueOf(20));
		seLaborAmount2.setAdjustedQuantity(BigDecimal.valueOf(21));
		labor1.setAmount(seLaborAmount2);
		request.getLabors().add(labor);
		request.getLabors().add(labor1);
		
		SEOtherCharges other = new SEOtherCharges();
		SEAmount seOtherAmount = new SEAmount();
		other.setRequest(request);
		other.setCode("O001");
		other.setType("misc");
		seOtherAmount.setRequestedAmount(BigDecimal.valueOf(300));
		seOtherAmount.setAdjustedAmount(BigDecimal.valueOf(301));
		seOtherAmount.setRequestedQuantity(BigDecimal.valueOf(20));
		seOtherAmount.setAdjustedQuantity(BigDecimal.valueOf(21));
		other.setAmount(seOtherAmount);
		
		SEOtherCharges other1 = new SEOtherCharges();
		SEAmount seOtherAmount1 = new SEAmount();
		other1.setRequest(request);
		other1.setCode("O0011");
		other1.setType("misc");
		seOtherAmount1.setRequestedAmount(BigDecimal.valueOf(300));
		seOtherAmount1.setAdjustedAmount(BigDecimal.valueOf(301));
		seOtherAmount1.setRequestedQuantity(BigDecimal.valueOf(20));
		seOtherAmount1.setAdjustedQuantity(BigDecimal.valueOf(21));
		other1.setAmount(seOtherAmount1);
		request.getOthersCharges().add(other);
		request.getOthersCharges().add(other1);
		
		SEAttachment attachment = new SEAttachment();
		attachment.setName("upload");
		attachment.setServiceEntity(serviceEntity);
		serviceEntity.getAttachments().add(attachment);		
		serviceEntity.getRequests().add(request);
		
		SENote note = new SENote();
		note.setNotes("test notes");
		note.setServiceEntity(serviceEntity);
		serviceEntity.getNotes().add(note);
		return serviceEntity;
	}

}
