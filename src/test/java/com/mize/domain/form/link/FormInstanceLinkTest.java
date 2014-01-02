package com.mize.domain.form.link;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.form.FormInstance;
import com.mize.domain.product.ProductSerial;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class FormInstanceLinkTest extends JPATest {
	
	private static final String FORM_INSTANCE_LINK_QUERY = "select * from form_instance_link where id = ?";
	
	FormInstanceLink formInstanceLink = null;
	EntityManager entityManager = null;
			

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();		
		formInstanceLink = getFormInstanceLink();
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(formInstanceLink.getId() == null){
			entityManager.persist(formInstanceLink);	
		}else{
			formInstanceLink = entityManager.merge(formInstanceLink);
		}		
		tx.commit();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFormInstanceLink() {
		try {
			FormInstanceLink formInstanceLinkDB =  jdbcTemplate.queryForObject(FORM_INSTANCE_LINK_QUERY, new FormInstanceLinkRowMapper(), new Object[]{formInstanceLink.getId()});
			assertTrue(formInstanceLink.getId().equals(formInstanceLinkDB.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got Exception");
		}
		
	}
	
	class FormInstanceLinkRowMapper implements RowMapper<FormInstanceLink> {

		@Override
		public FormInstanceLink mapRow(ResultSet rs, int arg1) throws SQLException {
			FormInstanceLink formInstanceLink = new FormInstanceLink();
			formInstanceLink.setId(rs.getLong("id"));			
			return formInstanceLink;
		}
		
	}
	
	
	private FormInstanceLink getFormInstanceLink() {
		FormInstanceLink formInstanceLink = new FormInstanceLink();
		formInstanceLink.setId(1L);
		
		FormInstance formInstance = entityManager.find(FormInstance.class, 1L);
		formInstanceLink.setFormInstance(formInstance);
		formInstanceLink.setLinkType("Pre-Delivery");
		formInstanceLink.setLinkDuration("1");
		formInstanceLink.setStatusCode("DRAFT");
		formInstanceLink.setReviewedBy("TEST");
		formInstanceLink.setReviewedDate(Formatter.date(DateTime.now().toString("MM-dd-yyy")));
		
		ProductSerial productSerial = entityManager.find(ProductSerial.class, 101000L);
		formInstanceLink.setProductSerial(productSerial);
		
		BusinessEntity businessEntity = entityManager.find(BusinessEntity.class, 101000L);
		formInstanceLink.setLinkBusinessEntity(businessEntity);
		
		FormInstanceLinkAudit formInstanceLinkAudit = new FormInstanceLinkAudit();
		formInstanceLinkAudit.setStatusCode("DRAFT");
		formInstanceLinkAudit.setStatusDate(Formatter.dateTime(DateTime.now().toString("MM-dd-yyyy HH:mm:ss")));
		formInstanceLinkAudit.setStatusBy(779L);
		formInstanceLinkAudit.setFormInstanceLink(formInstanceLink);
		
		List<FormInstanceLinkAudit> data = new ArrayList<FormInstanceLinkAudit>();
		data.add(formInstanceLinkAudit);
		formInstanceLink.setAudits(data);
		
		return formInstanceLink;
	}

}
