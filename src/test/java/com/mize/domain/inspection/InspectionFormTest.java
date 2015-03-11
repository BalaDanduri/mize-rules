package com.mize.domain.inspection;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.EntityContact;
import com.mize.domain.common.EntityErrorMessage;
import com.mize.domain.common.State;
import com.mize.domain.datetime.Date;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.form.FormDefinition;
import com.mize.domain.form.FormInstance;
import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class InspectionFormTest extends JPATest {

	private static String INSPECTION_FORM_QUERY = "select * from insp_form where id = ?";
	EntityManager entityManager;
	InspectionForm inspectionForm;
	InspectionFormAudit audit;
	List<InspectionFormAudit> audits;
	InspectionFormMessage message;
	List<InspectionFormMessage> messages;
	InspectionFormComment comment;
	List<InspectionFormComment> comments;
	InspectionFormRequestor requester;
	InspectionFormEquipment equipment;
	List<InspectionFormEquipment> equipments;
	InspectionFormEquipmentAttribute attribute;
	List<InspectionFormEquipmentAttribute> attributes;
	InspectionFormEquipmentOwner owner;
	InspectionForm dbInspectionForm;
	
	@Before
	public void setUp() {
		entityManager = getEntityManager();
	}
	
	@After
	public void tearDown() {
		if(inspectionForm != null) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(inspectionForm);
			tx.commit();
		}
		entityManager.close();
	}
	
	@Test
	public void saveInspectionForm(){
		try {
			prepareInspectionForm();
			prepareComments();
			prepareAudits();
			prepareMessages();
			prepareRequester();
			prepareInpsectionFormEquipments();
			System.out.println(getJsonResponse(inspectionForm));
			persist();
			dbInspectionForm = jdbcTemplate.queryForObject(INSPECTION_FORM_QUERY, new Object[]{inspectionForm.getId()},new InspectionFormRowMapper());
			assertTrue(dbInspectionForm != null && dbInspectionForm.getId() != null);
			System.out.println(getJsonResponse(inspectionForm));
		}catch(Throwable th) {
			th.printStackTrace();
			tearDown();
			fail("Got Exception");
			
		}
	}
	
	@Test
	public void updateServiceEntity() {
		try {
			createInspectioinForm();
			inspectionForm.setInspectionStatus("Pending");
			persist();
			dbInspectionForm = jdbcTemplate.queryForObject(INSPECTION_FORM_QUERY, new Object[]{inspectionForm.getId()},new InspectionFormRowMapper());
			assertTrue(dbInspectionForm != null && dbInspectionForm.getId() != null);
			assertTrue("Pending".equals(dbInspectionForm.getInspectionStatus()));
		}catch(Throwable th) {
			th.printStackTrace();
			tearDown();
			fail("Got Exception");
			throw th;
		}
	}
	
	
	private void createInspectioinForm() {
		prepareInspectionForm();
		persist();
	}
	
	
	class InspectionFormRowMapper implements RowMapper<InspectionForm>{

		@Override
		public InspectionForm mapRow(ResultSet rs, int rowNum)throws SQLException {
			InspectionForm dbInspectionForm = new InspectionForm();
			dbInspectionForm.setId(rs.getLong("id"));
			dbInspectionForm.setInspectionCode(rs.getString("insp_code"));
			dbInspectionForm.setInspectionType(rs.getString("insp_type"));
			dbInspectionForm.setInspectedBy(rs.getString("inspected_by"));
			dbInspectionForm.setInspectionStatus(rs.getString("insp_status"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			dbInspectionForm.setTenant(tenant);
			dbInspectionForm.setInspectionReference(rs.getString("insp_reference"));
			return dbInspectionForm;
		}
		
	}
	
	private void prepareInpsectionFormEquipments() {
		equipment = new InspectionFormEquipment();
		equipment.setEquipmentId(System.currentTimeMillis());
		equipment.setEquipmentBrand("Trimble");
		equipment.setEquipmentCategory("Constructions");
		equipment.setEquipmentType("Product");
		equipment.setEquipmentModel("SCS900");
		equipment.setEquipmentSerial("SRL_"+System.currentTimeMillis());
		equipment.setEquipmentDescription("CrusieController");
		equipment.setEquipmentName("Crusier Controller");
		equipment.setEquipmentCode("SCS_"+System.currentTimeMillis());
		equipment.setInspectionForm(inspectionForm);
		equipment.setEquipmentReference("Tri-"+System.currentTimeMillis());
		prepareEquipmentAttribute();
		prepareEquipmentOwner();
		equipments = new ArrayList<InspectionFormEquipment>();
		equipments.add(equipment);
		inspectionForm.setInspectionEquipments(equipments);
	}

	private void prepareEquipmentOwner() {
		owner = new InspectionFormEquipmentOwner();
		owner.setCode("Mize Dealer");
		owner.setTypeCode("dealer");
		owner.setTypeCode("MD-"+System.currentTimeMillis());
		owner.setName("Dealer Admin");
		owner.setFirstName("Dealer");
		owner.setLastName("Admin");
		owner.setMiddleInitial("M-ize");
		owner.setOwnerReference("M-ize_"+System.currentTimeMillis());
		owner.setOwnerAddress(getAddress());
		owner.setOwnerContact(getContact());
		equipment.setEquipmentOwner(owner);
		owner.setInspectionFormEquipment(equipment);
		
	}

	private EntityContact getContact() {
		EntityContact contact = new EntityContact();
		contact.setIsPrimary("Y");
		contact.setFirstName("Dealer");
		contact.setLastName("Admin");
		contact.setDepartment("Warehouse");
		contact.setEmail("dealerAdmin@mize.com");
		contact.setAlternatePhone("3329-8654-333");
		contact.setContactType("Shipping");
		return contact;
	}

	private EntityAddress getAddress() {
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
		return entityAddress;
	}

	private void prepareEquipmentAttribute() {
		attribute = new InspectionFormEquipmentAttribute();
		attribute.setAttributeCode("AT_"+System.currentTimeMillis());
		attribute.setAttributeDataType("String");
		attribute.setAttributeValue("VL_"+System.currentTimeMillis());
		attribute.setAttributeUom("Quantity");
		attribute.setInspectionFormEquipment(equipment);
		attributes = new ArrayList<InspectionFormEquipmentAttribute>();
		attributes.add(attribute);
		equipment.setEquipmentAttributes(attributes);
	}

	private void persist() {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(inspectionForm);
		entityManager.flush();
		tx.commit();
	}
	
	private void prepareInspectionForm() {
		inspectionForm = new InspectionForm();
		inspectionForm.setInspectionCode("FRM-"+System.currentTimeMillis());
		inspectionForm.setInspectionType("pre-delivery");
		inspectionForm.setInspectedBy("FI--"+System.currentTimeMillis());
		inspectionForm.setInspectionStatus("Draft");
		inspectionForm.setInspectedBy("FRM"+System.currentTimeMillis());
		inspectionForm.setCreatedBy(776l);
		inspectionForm.setUpdatedBy(776l);
		inspectionForm.setCreatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		inspectionForm.setUpdatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		inspectionForm.setFormInstance(getFormInstance());
		inspectionForm.setTenant(getTenant());
		inspectionForm.setLocale(findLocaleObjectFromDB());
		inspectionForm.setInspectionDate(Date.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		inspectionForm.setInspectionReference("FRM-#"+System.currentTimeMillis());
		
	}

	private BusinessEntity getTenant() {
		return entityManager.find(BusinessEntity.class, 7624L);
	}

	private FormInstance getFormInstance() {
		FormInstance formInstance = new FormInstance();
		formInstance.setFormInstanceData("ABC");
		formInstance.setFormDefinition(getFormDefinition());
		return formInstance;
	}

	private FormDefinition getFormDefinition() {
		return entityManager.find(FormDefinition.class, 130L);
	}

	private void prepareComments() {
		comment = new InspectionFormComment();
		comment.setInspectionForm(inspectionForm);
		EntityComment entityComment = new EntityComment();
		entityComment.setComments("Creating draft claim");
		entityComment.setCreatedBy(779L);
		entityComment.setCreatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		entityComment.setUpdatedBy(779L);
		entityComment.setUpdatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		entityComment.setCommentType("Internal");
		comment.setEntityComment(entityComment);
		comments = new ArrayList<InspectionFormComment>();
		comments.add(comment);
		inspectionForm.setComments(comments);
	}
	
	private void prepareAudits() {
		audit = new InspectionFormAudit();
		audit.setInspectionForm(inspectionForm);
		audit.setStatusCode("DRAFT");
		audit.setStatusDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		audit.setStatusBy(779L);	
		audits = new ArrayList<InspectionFormAudit>();
		audits.add(audit);
		inspectionForm.setAudits(audits);
	}
	
	private void prepareMessages() {
		message = new InspectionFormMessage();
		message.setInspectionForm(inspectionForm);
		EntityErrorMessage errorMessage = new EntityErrorMessage();
		errorMessage.setSeverity(5);
		errorMessage.setValue("Invalid Address Type");
		errorMessage.setUiReference("Address");
		errorMessage.setField("address_type");
		message.setEntityErrorMessage(errorMessage);
		messages = new ArrayList<InspectionFormMessage>();
		messages.add(message);
		inspectionForm.setMessages(messages);
	}
	
	private void prepareRequester() {
		requester = new InspectionFormRequestor();
		requester.setInspectionForm(inspectionForm);
		requester.setRequestorId(961l);
		requester.setCode("Mize Dealer");
		requester.setTypeCode("dealer");
		requester.setTypeCode("MD-"+System.currentTimeMillis());
		requester.setName("Dealer Admin");
		requester.setFirstName("Dealer");
		requester.setLastName("Admin");
		requester.setMiddleInitial("M-ize");
		requester.setRequestorReference("Rqstr-Mize_"+System.currentTimeMillis());
		requester.setRequestorAddress(getAddress());
		requester.setRequestorContact(getContact());
		inspectionForm.setRequestor(requester);
	}
	
	
}
