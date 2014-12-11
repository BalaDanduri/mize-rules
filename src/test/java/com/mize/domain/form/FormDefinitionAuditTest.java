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

import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.MizeDateTime;

@ContextConfiguration(locations={"/test-context.xml"})
public class FormDefinitionAuditTest extends JPATest {	
	
	private static final String FORM_DEFINITION_AUDIT_QUERY = "select * from form_defn_audit where id = ?";
	
	EntityManager entityManager = null;
	FormDefinition formDef = null;
	FormDefinitionAudit formDefAudit = null;
	EntityTransaction tx ;
	FormDefinitionTest formDefTest = new FormDefinitionTest();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		tx = entityManager.getTransaction();
		tx.begin();
		formDef = formDefTest.createFormDef();
		entityManager.persist(formDef);
		formDefAudit = createFormDefAudit(formDef);
		
		entityManager.persist(formDefAudit);
		tx.commit();
	}

	@After
	public void tearDown() throws Exception {
		if(formDefAudit != null)
			tx.begin();
		
		entityManager.remove(formDefAudit);
		entityManager.remove(formDef);
		tx.commit();
		entityManager.close();
	}

	@Test
	public void testFormDefinitionAudit() {
		try {
			FormDefinitionAudit formDefAuditDB = jdbcTemplate.queryForObject(FORM_DEFINITION_AUDIT_QUERY, new FormDefAuditRowMapper(), new Object[]{formDefAudit.getId()});
			assertEquals(formDefAudit.getStatusCode(), formDefAuditDB.getStatusCode());
		} catch(Exception e) {
			e.printStackTrace();
			fail("Got exception");
		}
		
	}
	
	private FormDefinitionAudit createFormDefAudit(FormDefinition formDef) {
		FormDefinitionAudit audit = new FormDefinitionAudit(formDef, formDef.getStatusCode(), MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC), 779L,"Process");
		return audit;
	}
	
	class FormDefAuditRowMapper implements RowMapper<FormDefinitionAudit> {

		@Override
		public FormDefinitionAudit mapRow(ResultSet rs, int arg1) throws SQLException {
			FormDefinitionAudit audit = new FormDefinitionAudit();
			audit.setId(rs.getLong("id"));
			FormDefinition formDef = new FormDefinition();
			formDef.setId(rs.getLong("id"));
			audit.setFormDefinition(formDef);
			audit.setStatusBy(rs.getLong("status_by"));
			audit.setStatusCode(rs.getString("status_code"));
			audit.setStatusDate(Formatter.toMizeDateTime(rs.getTimestamp("status_date")));
			return audit;
		}
		
	}

}
