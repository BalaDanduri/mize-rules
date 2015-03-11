package com.mize.domain.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTimeZone;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.datetime.Date;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.DateTimeUtils;

@ContextConfiguration(locations={"/test-context.xml"})
public class FormDefinitionTest extends JPATest {
	
	private static final String FORM_DEF_QUERY = "select * from form_defn where id = ? ";
	
	FormTemplateDefinition formTemplateDefinition = null;
	EntityManager entityManager = null;
	FormDefinition formDef = null;
	BusinessEntity tenant = null;
	
	EntityTransaction tx ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		formTemplateDefinition = findExistingFormTemplateDef(entityManager);
		tenant = findExistingBE(entityManager);
		
		
		formDef=createFormDef();
		  tx = entityManager.getTransaction();
	        tx.begin();
	        entityManager.persist(formDef);            
	        tx.commit();
	}

	public FormDefinition createFormDef() {
		formDef = new FormDefinition();
		formDef.setFormTemplateDefinition(formTemplateDefinition);
		formDef.setTenant(tenant);
		formDef.setFormCode("FORM123");
		formDef.setIsActive("Y");
		formDef.setStartDate(Date.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		formDef.setEndDate(Date.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC).addYears(1));
		formDef.setStatusCode("DRAFT");
		formDef.setCreatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		formDef.setUpdatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		formDef.setCreatedBy(Long.valueOf(779));
		formDef.setUpdatedBy(Long.valueOf(779));
		formDef.setFormDefinitionData("formDefinitionData");
      
		return formDef;
	}

	@After
	public void tearDown() throws Exception {
		if(formDef!=null){
			tx.begin();
			entityManager.remove(formDef);
			tx.commit();
		}
		entityManager.close();
	}

		
	@Test
	public void testFormDefinition() {
		try {				
           FormDefinition formDefDB =  jdbcTemplate.queryForObject(FORM_DEF_QUERY, new FormDefRowMapper(), new Object[]{formDef.getId()});
           assertEquals(formDef.getId(), formDefDB.getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got Exception");
			throw e;
		}		
		
	}
	
	class FormDefRowMapper implements RowMapper<FormDefinition> {

		@Override
		public FormDefinition mapRow(ResultSet rs, int arg1) throws SQLException {
			FormDefinition formDef = new FormDefinition();
			formDef.setId(rs.getLong("id"));
			formDef.setFormCode(rs.getString("form_code"));
			formDef.setStatusCode(rs.getString("status_code"));
			formDef.setIsActive(rs.getString("is_active"));
			BusinessEntity tenant =  new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			formDef.setTenant(tenant);
			FormTemplateDefinition ftdef = new FormTemplateDefinition();
			ftdef.setId(rs.getLong("template_defn_id"));
			formDef.setFormTemplateDefinition(ftdef);
			formDef.setStartDate(DateTimeUtils.toDate(rs.getTimestamp("start_date")));
			formDef.setEndDate(DateTimeUtils.toDate(rs.getTimestamp("end_date")));
			formDef.setFormDefinitionData(rs.getString("form_defn_data"));
			formDef.setCreatedDate(DateTimeUtils.toDateTime(rs.getTimestamp("created_date")));
			formDef.setUpdatedDate(DateTimeUtils.toDateTime(rs.getTimestamp("updated_date")));
			formDef.setCreatedBy(rs.getLong("created_by"));
			formDef.setUpdatedBy(rs.getLong("updated_by"));
			return formDef;
		}
		
	}
	

}
