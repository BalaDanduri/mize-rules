package com.mize.domain.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import com.mize.domain.common.Locale;
import com.mize.domain.servicelocator.BusinessEntity;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class FormDefinitionTest extends JPATest {
	
	private static final String FORM_DEF_QUERY = "select * from form_defn where id = ? ";
	
	FormTemplateDefinition formTemplateDefinition = null;
	EntityManager entityManager = null;
	FormDefinition formDef = null;
	BusinessEntity tenant = null;
	Locale locale = null;

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
		locale = new Locale();
		
		formDef = new FormDefinition();
		formDef.setFormTemplateDefinition(formTemplateDefinition);
		formDef.setTenant(tenant);
		locale.setId(1L);
		formDef.setLocale(locale);
		formDef.setFormCode("FORM123");
		formDef.setFormName("Test Form");
		formDef.setIsActive("Y");
		formDef.setStartDate(Formatter.date(DateTime.now().toString("MM-dd-yyy")));
		formDef.setEndDate(Formatter.date(DateTime.now().plusYears(1).toString("MM-dd-yyy")));
		formDef.setStatusCode("DRAFT");
		formDef.setVersionNumber(BigDecimal.valueOf(1.0));
		formDef.setCreatedDate(DateTime.now());
		formDef.setUpdatedDate(DateTime.now());
		formDef.setCreatedBy(Long.valueOf(779));
		formDef.setUpdatedBy(Long.valueOf(779));
		formDef.setFormDefinitionData("formDefinitionData");
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(formDef);            
        tx.commit();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}

		
	@Test
	public void testFormDefinition() {
		try {				
           FormDefinition formDefDB =  jdbcTemplate.queryForObject(FORM_DEF_QUERY, new FormDefRowMapper(), new Object[]{formDef.getId()});
           assertEquals(formDef, formDefDB);
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
			formDef.setFormName(rs.getString("form_name"));
			formDef.setStatusCode(rs.getString("status_code"));
			formDef.setIsActive(rs.getString("is_active"));
			Locale locale = new Locale();
			locale.setId(rs.getLong("locale_id"));
			formDef.setLocale(locale);
			BusinessEntity tenant =  new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			formDef.setTenant(tenant);
			FormTemplateDefinition ftdef = new FormTemplateDefinition();
			ftdef.setId(rs.getLong("template_defn_id"));
			formDef.setFormTemplateDefinition(ftdef);
			formDef.setStartDate(Formatter.dateTime(rs.getTimestamp("start_date")));
			formDef.setEndDate(Formatter.dateTime(rs.getTimestamp("end_date")));
			formDef.setFormDefinitionData(rs.getString("form_defn_data"));
			formDef.setCreatedDate(Formatter.dateTime(rs.getTimestamp("created_date")));
			formDef.setUpdatedDate(Formatter.dateTime(rs.getTimestamp("updated_date")));
			formDef.setCreatedBy(rs.getLong("created_by"));
			formDef.setUpdatedBy(rs.getLong("updated_by"));
			formDef.setVersionNumber(rs.getBigDecimal("version_number"));
			return formDef;
		}
		
	}
	

}
