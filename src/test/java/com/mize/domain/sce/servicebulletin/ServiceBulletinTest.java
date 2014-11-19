package com.mize.domain.sce.servicebulletin;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Country;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityAttachment;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.Locale;
import com.mize.domain.common.State;
import com.mize.domain.labor.LaborHour;
import com.mize.domain.part.Part;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.MizeDateTime;
import com.mize.domain.util.MizeObjectMapper;

@ContextConfiguration(locations = { "/test-context.xml" })
public class ServiceBulletinTest extends JPATest {
	private static String SERVICE_ENTITY_QUERY = "select * from srvc_blltn  where id = ?";
	EntityManager entityManager;
	ServiceBulletin serviceBulletin;
	ServiceBulletinIntl serviceBulletinIntl;
	List<ServiceBulletinIntl> serviceBulletinIntls;
	ServiceBulletinAudit audit;
	List<ServiceBulletinAudit> audits;
	ServiceBulletinMessage message;
	List<ServiceBulletinMessage> messages;
	ServiceBulletinComment comment;
	List<ServiceBulletinComment> comments;
	ServiceBulletinAttachment attachment;
	List<ServiceBulletinAttachment> attachments;
	ServiceBulletinProcedure serviceBulletinProcedure;
	List<ServiceBulletinProcedure> serviceBulletinProcedures;
	ServiceBulletinProcedureIntl serviceBulletinProcedureIntl;
	List<ServiceBulletinProcedureIntl> serviceBulletinProcedureIntls;
	ServiceBulletinProcedurePart part;
	List<ServiceBulletinProcedurePart> parts;
	ServiceBulletinProcedureLabor labor;
	List<ServiceBulletinProcedureLabor> labors;
	ServiceBulletinProcedureOther other;
	List<ServiceBulletinProcedureOther> others;

	Locale locale;

	ServiceBulletinRespBusinessUnit rbu;

	@Before
	public void setUp() {
		entityManager = getEntityManager();
	}

	@After
	public void tearDown() {
		if (serviceBulletin != null) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(serviceBulletin);
			tx.commit();
		}
		entityManager.close();
	}

	@Test
	public void saveServiceBulletin() {
		try {
			createServiceBulletin();
			System.out.println(getJsonNotNullString(serviceBulletin));
			persist(serviceBulletin);
			ServiceBulletin dbServiceBulletin = jdbcTemplate.queryForObject(SERVICE_ENTITY_QUERY, new Object[] { serviceBulletin.getId() },
					new ServiceBulletinRowMapper());
			assertTrue(dbServiceBulletin != null && dbServiceBulletin.getId() != null);
		} catch (Throwable th) {
			th.printStackTrace();
			tearDown();
			fail("Got Exception");
			throw th;
		}
	}

	private void createServiceBulletin() {
		prepareServiceBulletin();
		serviceBulletinIntl();
		prepareAudits();
		prepareMessages();
		prepareComments();
		prepareAttachments();
		prepareRespBusinessUnit();
		prepareServiceBulletinProcedure();
		//prepareAmounts();
	}

	private void prepareServiceBulletinProcedure() {
		serviceBulletinProcedure = new ServiceBulletinProcedure();
		serviceBulletinProcedure.setServiceBulletin(serviceBulletin);
		serviceBulletinProcedure.setProcedureCode("SBL01");
		serviceBulletinProcedure.setProcedureReference("SBL01REF");
		serviceBulletinProcedure.setCauseCode("04");
		serviceBulletinProcedure.setComplaintCode("001");
		serviceBulletinProcedure.setCorrectiveActionCode("01");
		prepareServiceBulletinProcedureIntls();
		prepareLabor();
		prepareParts();
		prePareOtherCharges();
		serviceBulletinProcedures = new ArrayList<ServiceBulletinProcedure>(1);
		serviceBulletinProcedures.add(serviceBulletinProcedure);
		serviceBulletin.setProcedures(serviceBulletinProcedures);
	}

	private void prePareOtherCharges() {
		other = new ServiceBulletinProcedureOther();
		other.setChargeCode("CHRG001");
		other.setChargeType("Cleaning");
		other.setChargeDescription("Cleaning expenses");
		other.setChargeUom("Hour");
		other.setChargeReference("CHRG001Ref");

		ServiceBulletinAmount otherAmount = new ServiceBulletinAmount();
		otherAmount.setApprovedQty(BigDecimal.valueOf(1));
		otherAmount.setApprovedAmount(BigDecimal.valueOf(250));
		otherAmount.setApprovedTotalAmount(BigDecimal.valueOf(250));
		other.setChargeAmount(otherAmount);
		other.setServiceBulletinProcedure(serviceBulletinProcedure);

		others = new ArrayList<ServiceBulletinProcedureOther>(1);
		others.add(other);
		serviceBulletinProcedure.setOtherCharges(others);

	}

	private void prepareParts() {

		 part = new ServiceBulletinProcedurePart();

		part.setPartCode("MI0004");
		part.setPartCode("MI-SRL-0122");
		part.setPartType("Standard");
		part.setPartUom("Quantity");
		part.setPartReference("MI-SRL-0122");
		part.setIsReturnable("Y");
		part.setName("Part Name");
		part.setDescription("Part Description");

		Part prt = new Part();
		prt.setId(41L);
		part.setPart(prt);

		ServiceBulletinAmount partAmount = new ServiceBulletinAmount();
		partAmount.setApprovedQty(BigDecimal.valueOf(100));
		partAmount.setApprovedAmount(BigDecimal.valueOf(1500));
		partAmount.setApprovedTotalAmount(BigDecimal.valueOf(1500));
		part.setPartAmount(partAmount);
		part.setServiceBulletinProcedure(serviceBulletinProcedure);
		
		parts = new ArrayList<ServiceBulletinProcedurePart>(1);
		parts.add(part);
		serviceBulletinProcedure.setParts(parts);

	}

	private void prepareLabor() {
		labor = new ServiceBulletinProcedureLabor();
		labor.setLaborCode("Labor123");
		labor.setLaborCode("ABC200");
		labor.setLaborType("Inshop");
		labor.setLaborUom("Hour");
		labor.setLaborReference("Lbrref123");
		labor.setName("Labor Name");
		labor.setDescription("Labor Description");

		LaborHour laborHour = new LaborHour();
		laborHour.setId(66L);
		labor.setLaborHour(laborHour);

		ServiceBulletinAmount laborAmount = new ServiceBulletinAmount();
		laborAmount.setApprovedQty(BigDecimal.valueOf(50));
		laborAmount.setApprovedAmount(BigDecimal.valueOf(2500));
		laborAmount.setApprovedTotalAmount(BigDecimal.valueOf(2500));
		labor.setLaborAmount(laborAmount);
		labor.setServiceBulletinProcedure(serviceBulletinProcedure);

		labors = new ArrayList<ServiceBulletinProcedureLabor>();
		labors.add(labor);
		
		serviceBulletinProcedure.setLabors(labors);

	}

	private void prepareServiceBulletinProcedureIntls() {

		serviceBulletinProcedureIntl = new ServiceBulletinProcedureIntl();
		serviceBulletinProcedureIntl.setServiceBulletinProcedure(serviceBulletinProcedure);
		serviceBulletinProcedureIntl.setProcedureName("procedure Name");
		serviceBulletinProcedureIntl.setProcedureDescription("procedure Description");
		serviceBulletinProcedureIntl.setCauseDescription("cause Description");
		serviceBulletinProcedureIntl.setCorrectiveActionDescription("correctiveAction Description");
		serviceBulletinProcedureIntl.setLocale(getLocal());
		serviceBulletinProcedureIntls = new ArrayList<ServiceBulletinProcedureIntl>(1);
		serviceBulletinProcedureIntls.add(serviceBulletinProcedureIntl);
		
		serviceBulletinProcedureIntl.setServiceBulletinProcedure(serviceBulletinProcedure);
		serviceBulletinProcedure.setProcedureIntl(serviceBulletinProcedureIntls);

	}

	private Locale getLocal() {
		Locale locale = new Locale();
		locale.setId(Long.valueOf(1));
		locale.setLanguageCode("eng");
		locale.setCountryCode("USA");
		return locale;
	}

	private void serviceBulletinIntl() {
		serviceBulletinIntl = new ServiceBulletinIntl();
		serviceBulletinIntl.setServiceBulletin(serviceBulletin);
		serviceBulletinIntl.setName("Campaign Name");
		serviceBulletinIntl.setDescription("Campaign description");
		serviceBulletinIntl.setLocale(getLocal());
		serviceBulletinIntls = new ArrayList<ServiceBulletinIntl>(1);
		serviceBulletinIntls.add(serviceBulletinIntl);
		serviceBulletin.setBulletinIntl(serviceBulletinIntls);
	}

	@Test
	public void updateServiceBulletin() {
		try {
			createServiceBulletin();
			persist(serviceBulletin);
			serviceBulletin.setBulletinStatus("PENDING");
			persist(serviceBulletin);
			ServiceBulletin dbServiceBulletin = jdbcTemplate.queryForObject(SERVICE_ENTITY_QUERY, new Object[] { serviceBulletin.getId() },
					new ServiceBulletinRowMapper());
			assertTrue(dbServiceBulletin != null && dbServiceBulletin.getId() != null);
			assertTrue("PENDING".equals(dbServiceBulletin.getBulletinStatus()));

		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}

	private class ServiceBulletinRowMapper implements RowMapper<ServiceBulletin> {

		@Override
		public ServiceBulletin mapRow(ResultSet rs, int rowNum) throws SQLException {
			ServiceBulletin serviceBulletin = new ServiceBulletin();
			serviceBulletin.setId(rs.getLong("id"));
			serviceBulletin.setBulletinCode(rs.getString("blltn_code"));
			serviceBulletin.setBulletinType(rs.getString("blltn_type"));
			serviceBulletin.setBulletinSubType(rs.getString("blltn_sub_type"));
			serviceBulletin.setBulletinStatus(rs.getString("blltn_status"));
			return serviceBulletin;
		}

	}

	private void prepareServiceBulletin() {
		serviceBulletin = new ServiceBulletin();
		serviceBulletin.setBulletinCode("SBL123");
		serviceBulletin.setBulletinType("Campaign");
		serviceBulletin.setBulletinSubType("Campaign Sub Type");
		serviceBulletin.setBulletinStatus("DRAFT");
	}

	private void persist(ServiceBulletin serviceBulletin) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(serviceBulletin);
		tx.commit();
	}

	private void prepareAudits() {
		audit = new ServiceBulletinAudit();
		audit.setServiceBulletin(serviceBulletin);
		audit.setStatusCode("DRAFT");
		audit.setStatusDate(MizeDateTime.now());
		audit.setStatusBy(779L);
		audits = new ArrayList<ServiceBulletinAudit>();
		audits.add(audit);
		serviceBulletin.setAudits(audits);
	}

	private void prepareMessages() {
		message = new ServiceBulletinMessage();
		message.setServiceBulletin(serviceBulletin);
		message.setMessageSeverity(5);
		message.setMessageValue("Invalid Address Type");
		message.setMessageId(462L);
		message.setMessageUiReference("Address");
		message.setMessageField("address_type");
		messages = new ArrayList<ServiceBulletinMessage>();
		messages.add(message);
		serviceBulletin.setMessages(messages);
	}

	private void prepareComments() {
		comment = new ServiceBulletinComment();
		comment.setServiceBulletin(serviceBulletin);
		EntityComment entityComment = new EntityComment();
		entityComment.setComments("Creating draft claim");
		entityComment.setCreatedBy(779L);
		entityComment.setCreatedDate(MizeDateTime.now());
		entityComment.setUpdatedBy(779L);
		entityComment.setUpdatedDate(MizeDateTime.now());
		entityComment.setCommentType("Internal");
		comment.setEntityComment(entityComment);
		comments = new ArrayList<ServiceBulletinComment>();
		comments.add(comment);
		serviceBulletin.setComments(comments);
	}

	private void prepareAttachments() {
		attachment = new ServiceBulletinAttachment();
		attachment.setServiceBulletin(serviceBulletin);
		EntityAttachment entityAttachment = new EntityAttachment();
		entityAttachment.setType("Image");
		entityAttachment.setName("MachineInternal.jpg");
		entityAttachment.setUrl("http://amazon.s3.com/image/MachineInternal.jpg");
		entityAttachment.setCreatedBy(779L);
		entityAttachment.setCreatedDate(MizeDateTime.now());
		entityAttachment.setUpdatedBy(779L);
		entityAttachment.setUpdatedDate(MizeDateTime.now());
		attachment.setEntityAttachment(entityAttachment);
		attachments = new ArrayList<ServiceBulletinAttachment>();
		attachments.add(attachment);
		serviceBulletin.setAttachments(attachments);
	}

	private void prepareRespBusinessUnit() {
		rbu = new ServiceBulletinRespBusinessUnit();
		rbu.setServiceBulletin(serviceBulletin);
		BusinessEntity requesterBe = new BusinessEntity();
		requesterBe.setId(961L);
		rbu.setBusinessEntity(requesterBe);
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
		rbu.setAddress(entityAddress);
		serviceBulletin.setRespBusinessUnit(rbu);
	}

	public String getJsonNotNullString(Object object) {
		MizeObjectMapper notNullMapper = MizeObjectMapper.getInstance();
		notNullMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		notNullMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		try {
			return notNullMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
