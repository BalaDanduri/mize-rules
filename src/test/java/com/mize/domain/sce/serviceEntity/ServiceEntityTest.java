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
import com.mize.domain.serviceentity.ServiceEntityAddress;
import com.mize.domain.serviceentity.ServiceEntityAmount;
import com.mize.domain.serviceentity.ServiceEntityAttachment;
import com.mize.domain.serviceentity.ServiceEntityLabor;
import com.mize.domain.serviceentity.ServiceEntityNotes;
import com.mize.domain.serviceentity.ServiceEntityOtherCharge;
import com.mize.domain.serviceentity.ServiceEntityPart;
import com.mize.domain.serviceentity.ServiceEntityProvider;
import com.mize.domain.serviceentity.ServiceEntityRequest;
import com.mize.domain.serviceentity.ServiceEntityRequester;
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
			ServiceEntityRequester requester = new ServiceEntityRequester();
			requester.setBusinessEntity(be);
			serviceEntity.setRequester(requester);
			serviceEntity.setCode(rs.getString("entity_code"));
			serviceEntity.setStatus(rs.getString("entity_status"));
			Locale locale = new Locale();
			locale.setId(rs.getLong("locale_id"));
			serviceEntity.setLocale(locale);
			serviceEntity.setCurrencyCode(rs.getString("currency_code"));
			serviceEntity.setEntityReference(rs.getString("entity_reference"));
			ServiceEntityAmount partAmount = new ServiceEntityAmount();
			partAmount.setId(rs.getLong("part_amount_id"));
			serviceEntity.setPartAmount(partAmount);
			ServiceEntityAmount laborAmount = new ServiceEntityAmount();
			laborAmount.setId(rs.getLong("labor_amount_id"));
			serviceEntity.setLaborAmount(laborAmount);
			ServiceEntityAmount otherAmount = new ServiceEntityAmount();
			otherAmount.setId(rs.getLong("other_amount_id"));
			serviceEntity.setOtherAmount(otherAmount);
			ServiceEntityAmount totalAmount = new ServiceEntityAmount();
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
		ServiceEntityProvider provider = new ServiceEntityProvider();
		BusinessEntity businessEntity = new BusinessEntity();
		businessEntity.setId(961L);
		businessEntity = entityManager.find(BusinessEntity.class, businessEntity.getId());
		provider.setBusinessEntity(businessEntity);
		ServiceEntityAddress address = new ServiceEntityAddress();
		address.setAddress1("test1");
		address.setAddress2("test2");
		provider.setServiceEntity(serviceEntity);
		provider.setAddress(address);
		serviceEntity.setProvider(provider);
		
		ServiceEntityRequester requester = new ServiceEntityRequester();
		BusinessEntity businessEntity1 = new BusinessEntity();
		businessEntity1.setId(961l);
		businessEntity1 = entityManager.find(BusinessEntity.class, businessEntity1.getId());
		requester.setBusinessEntity(businessEntity1);
		ServiceEntityAddress address1 = new ServiceEntityAddress();
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
		ServiceEntityRequest request = new ServiceEntityRequest();
		request.setType(ServiceEntity.Type.Warranty.toString());
		request.setFailureDate(DateTime.now());
		request.setRepairDate(DateTime.now().plusDays(1));
		request.setProdId(100l);
		request.setServiceEntity(serviceEntity);
		ServiceEntityPart part = new ServiceEntityPart();
		part.setRequest(request);
		part.setCode("9152413200");
		part.setType("starndar");
		part.setSerialNumber("1111");
		ServiceEntityAmount seAmount = new ServiceEntityAmount();
		seAmount.setRequestedAmount(BigDecimal.valueOf(300));
		seAmount.setAdjustedAmount(BigDecimal.valueOf(301));
		seAmount.setRequestedQuantity(BigDecimal.valueOf(20));
		seAmount.setAdjustedQuantity(BigDecimal.valueOf(20));
		part.setAmount(seAmount);
		
		ServiceEntityPart part1 = new ServiceEntityPart();
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
		
		ServiceEntityLabor labor = new ServiceEntityLabor();
		ServiceEntityAmount seLaborAmount = new ServiceEntityAmount();
		labor.setRequest(request);
		labor.setCode("L001");
		labor.setType("hour1");
		seLaborAmount.setRequestedAmount(BigDecimal.valueOf(300));
		seLaborAmount.setAdjustedAmount(BigDecimal.valueOf(301));
		seLaborAmount.setRequestedQuantity(BigDecimal.valueOf(20));
		seLaborAmount.setAdjustedQuantity(BigDecimal.valueOf(21));
		labor.setAmount(seLaborAmount);
		
		ServiceEntityLabor labor1 = new ServiceEntityLabor();
		ServiceEntityAmount seLaborAmount2 = new ServiceEntityAmount();
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
		
		ServiceEntityOtherCharge other = new ServiceEntityOtherCharge();
		ServiceEntityAmount seOtherAmount = new ServiceEntityAmount();
		other.setRequest(request);
		other.setCode("O001");
		other.setType("misc");
		seOtherAmount.setRequestedAmount(BigDecimal.valueOf(300));
		seOtherAmount.setAdjustedAmount(BigDecimal.valueOf(301));
		seOtherAmount.setRequestedQuantity(BigDecimal.valueOf(20));
		seOtherAmount.setAdjustedQuantity(BigDecimal.valueOf(21));
		other.setAmount(seOtherAmount);
		
		ServiceEntityOtherCharge other1 = new ServiceEntityOtherCharge();
		ServiceEntityAmount seOtherAmount1 = new ServiceEntityAmount();
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
		
		ServiceEntityAttachment attachment = new ServiceEntityAttachment();
		attachment.setName("upload");
		attachment.setServiceEntity(serviceEntity);
		serviceEntity.getAttachments().add(attachment);		
		serviceEntity.getRequests().add(request);
		
		ServiceEntityNotes note = new ServiceEntityNotes();
		note.setNotes("test notes");
		note.setServiceEntity(serviceEntity);
		serviceEntity.getNotes().add(note);
		return serviceEntity;
	}

}
