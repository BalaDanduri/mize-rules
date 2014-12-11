package com.mize.domain.sce.serviceentity;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTimeZone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Country;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityAttachment;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.State;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.MizeDateTime;

@ContextConfiguration(locations={"/test-context.xml"})
public class ServiceEntityTest extends JPATest {
	private static String SERVICE_ENTITY_QUERY = "select * from srvc_enty where id = ?";
	EntityManager entityManager;
	ServiceEntity serviceEntity;
	ServiceEntityAudit audit;
	List<ServiceEntityAudit> audits;
	ServiceEntityMessage message;
	List<ServiceEntityMessage> messages;
    ServiceEntityComment comment;
    List<ServiceEntityComment> comments;
    ServiceEntityAttachment attachment;
    List<ServiceEntityAttachment> attachments;
    ServiceEntityRelation relation;
    List<ServiceEntityRelation> relations;
    ServiceEntityRequester requester;
    ServiceEntityProvider provider;
    ServiceEntityPayment payment;
    
    
	@Before
	public void setUp() {
		entityManager = getEntityManager();
	}
	
	@After
	public void tearDown() {
		if(serviceEntity != null) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(serviceEntity);
			tx.commit();
		}
		entityManager.close();
	}
	
	
	@Test
	public void saveServiceEntity() {
		try {
			prepareServiceEntity();
			prepareAudits();
			prepareMessages();
			prepareComments();
			prepareAttachments();
			prepareRequester();
			prepareProvider();
			preparePayment();
			prepareAmounts();
			persist();					
			ServiceEntity dbServiceEntity = jdbcTemplate.queryForObject(SERVICE_ENTITY_QUERY, new Object[]{serviceEntity.getId()}, new ServiceEntityRowMapper());
			assertTrue(dbServiceEntity != null && dbServiceEntity.getId() != null);
		}catch(Throwable th) {
			th.printStackTrace();
			tearDown();
			fail("Got Exception");
			throw th;
		}
	}
	
	@Test
	public void updateServiceEntity() {
		try {
			createServiceEntity();			
			serviceEntity.setEntityStatus("PENDING");
			persist();
			ServiceEntity dbServiceEntity = jdbcTemplate.queryForObject(SERVICE_ENTITY_QUERY, new Object[]{serviceEntity.getId()}, new ServiceEntityRowMapper());
			assertTrue(dbServiceEntity != null && dbServiceEntity.getId() != null);
			assertTrue("PENDING".equals(dbServiceEntity.getEntityStatus()));
			
		} catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class ServiceEntityRowMapper implements RowMapper<ServiceEntity> {

		@Override
		public ServiceEntity mapRow(ResultSet rs, int rowNum)throws SQLException {
			ServiceEntity serviceEntity = new ServiceEntity();
			serviceEntity.setId(rs.getLong("id"));
			serviceEntity.setEntityCode(rs.getString("entity_code"));
			serviceEntity.setEntityType(rs.getString("entity_type"));
			serviceEntity.setEntityStatus(rs.getString("entity_status"));
			return serviceEntity;
		}
		
	}
	
	private void prepareServiceEntity() {
		serviceEntity = new ServiceEntity();
		serviceEntity.setEntityCode("CLM123");
		serviceEntity.setEntityType("Claim");
		serviceEntity.setEntityStatus("DRAFT");
	}
	
	private void createServiceEntity() {
		prepareServiceEntity();
		persist();
	}
	
	private void persist() {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(serviceEntity);
		tx.commit();
	}
	
	private void prepareAudits() {
		audit = new ServiceEntityAudit();
		audit.setServiceEntity(serviceEntity);
		audit.setStatusCode("DRAFT");
		audit.setStatusDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		audit.setStatusBy(779L);	
		audits = new ArrayList<ServiceEntityAudit>();
		audits.add(audit);
		serviceEntity.setAudits(audits);
	}
	
	private void prepareMessages() {
		message = new ServiceEntityMessage();
		message.setServiceEntity(serviceEntity);
		message.setMessageSeverity(5);
		message.setMessageValue("Invalid Address Type");
		message.setMessageId(462L);
		message.setMessageUiReference("Address");
		message.setMessageField("address_type");
		messages = new ArrayList<ServiceEntityMessage>();
		messages.add(message);
		serviceEntity.setMessages(messages);
	}
	
	private void prepareComments() {
		comment = new ServiceEntityComment();
		comment.setServiceEntity(serviceEntity);
		EntityComment entityComment = new EntityComment();
		entityComment.setComments("Creating draft claim");
		entityComment.setCreatedBy(779L);
		entityComment.setCreatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		entityComment.setUpdatedBy(779L);
		entityComment.setUpdatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		entityComment.setCommentType("Internal");
		comment.setEntityComment(entityComment);
		comments = new ArrayList<ServiceEntityComment>();
		comments.add(comment);
		serviceEntity.setComments(comments);
	}
	
	private void prepareAttachments() {
		attachment = new ServiceEntityAttachment();
		attachment.setServiceEntity(serviceEntity);
		EntityAttachment entityAttachment = new EntityAttachment();
		entityAttachment.setType("Image");
		entityAttachment.setName("MachineInternal.jpg");
		entityAttachment.setUrl("http://amazon.s3.com/image/MachineInternal.jpg");
		entityAttachment.setCreatedBy(779L);
		entityAttachment.setCreatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		entityAttachment.setUpdatedBy(779L);
		entityAttachment.setUpdatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		attachment.setEntityAttachment(entityAttachment);
		attachments = new ArrayList<ServiceEntityAttachment>();
		attachments.add(attachment);
		serviceEntity.setAttachments(attachments);
	}
	
	private void prepareRequester() {
		requester = new ServiceEntityRequester();
		requester.setServiceEntity(serviceEntity);
		BusinessEntity requesterBe = new BusinessEntity();
		requesterBe.setId(961L);
		requester.setBusinessEntity(requesterBe);
		EntityAddress entityAddress = new EntityAddress();
		entityAddress.setType("Billing");
		entityAddress.setAddress1("8610 Hidden River Parkway");
		entityAddress.setAddress2("Suite 200");
		entityAddress.setCity("Tampa");
		State state = new State();
		state.setId(9L);
		entityAddress.setState(state);
		Country country = new Country();
		country.setId(1L);
		entityAddress.setCountry(country);
		entityAddress.setZip("33637");
		requester.setAddress(entityAddress);
		serviceEntity.setRequester(requester);
	}
	
	private void prepareProvider() {
		provider = new ServiceEntityProvider();
		provider.setServiceEntity(serviceEntity);
		BusinessEntity providerBe = new BusinessEntity();
		providerBe.setId(961L);
		provider.setBusinessEntity(providerBe);
		EntityAddress entityAddress = new EntityAddress();
		entityAddress.setType("Shipping");
		entityAddress.setAddress1("8610 Hidden River Parkway");
		entityAddress.setAddress2("Suite 200");
		entityAddress.setCity("Tampa");
		State state = new State();
		state.setId(9L);
		entityAddress.setState(state);
		Country country = new Country();
		country.setId(1L);
		entityAddress.setCountry(country);
		entityAddress.setZip("33637");
		provider.setAddress(entityAddress);
		serviceEntity.setProvider(provider);
	}
	
	private void preparePayment() {
		payment = new ServiceEntityPayment();
		payment.setServiceEntity(serviceEntity);
		BusinessEntity payeeBe = new BusinessEntity();
		payeeBe.setId(961L);
		payment.setPayeeEntity(payeeBe);
		EntityAddress entityAddress = new EntityAddress();
		entityAddress.setType("Shipping");
		entityAddress.setAddress1("8610 Hidden River Parkway");
		entityAddress.setAddress2("Suite 200");
		entityAddress.setCity("Tampa");
		State state = new State();
		state.setId(9L);
		entityAddress.setState(state);
		Country country = new Country();
		country.setId(1L);
		entityAddress.setCountry(country);
		entityAddress.setZip("33637");
		payment.setPayeeAddress(entityAddress);
		serviceEntity.setPayment(payment);
	}
	
	private void prepareAmounts() {
		ServiceEntityAmount partAmount = new ServiceEntityAmount();
		partAmount.setRequestedQty(BigDecimal.valueOf(100));
		partAmount.setAdjustedQty(BigDecimal.valueOf(15));
		partAmount.setTotalAmount(BigDecimal.valueOf(2500));
		serviceEntity.setPartAmount(partAmount);
		
		ServiceEntityAmount laborAmount = new ServiceEntityAmount();
		laborAmount.setRequestedQty(BigDecimal.valueOf(50));
		laborAmount.setAdjustedQty(BigDecimal.valueOf(25));
		laborAmount.setTotalAmount(BigDecimal.valueOf(3500));
		serviceEntity.setLaborAmount(laborAmount);
		
		ServiceEntityAmount otherAmount = new ServiceEntityAmount();
		otherAmount.setRequestedQty(BigDecimal.valueOf(0));
		otherAmount.setAdjustedQty(BigDecimal.valueOf(0));
		otherAmount.setAdjustedAmount(BigDecimal.valueOf(250));
		otherAmount.setTaxAmount(BigDecimal.valueOf(500));
		otherAmount.setTotalAmount(BigDecimal.valueOf(1500));
		serviceEntity.setOtherAmount(otherAmount);
		
		ServiceEntityAmount totalAmount = new ServiceEntityAmount();
		totalAmount.setRequestedQty(BigDecimal.valueOf(0));
		totalAmount.setAdjustedQty(BigDecimal.valueOf(0));
		totalAmount.setAdjustedAmount(BigDecimal.valueOf(550));
		totalAmount.setTaxAmount(BigDecimal.valueOf(700));
		totalAmount.setTotalAmount(BigDecimal.valueOf(5500));
		serviceEntity.setTotalAmount(totalAmount);
	}

}
