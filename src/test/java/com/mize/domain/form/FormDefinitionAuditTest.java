package com.mize.domain.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class FormDefinitionAuditTest extends JPATest {	
	
	private static final String FORM_DEFINITION_AUDIT_QUERY = "select * from form_defn_audit where id = ?";
	
	EntityManager entityManager = null;
	FormDefinition formDef = null;
	FormDefinitionAudit formDefAudit = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		formDef = findExistingFormDefinition(entityManager);
		formDefAudit = createFormDefAudit(formDef);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(formDefAudit);
		tx.commit();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}

	@Test
	public void testFormDefinitionAudit() {
		try {
			FormDefinitionAudit formDefAuditDB = jdbcTemplate.queryForObject(FORM_DEFINITION_AUDIT_QUERY, new FormDefAuditRowMapper(), new Object[]{formDefAudit.getId()});
			assertEquals(formDefAudit, formDefAuditDB);
		} catch(Exception e) {
			e.printStackTrace();
			fail("Got exception");
		}
		
	}
	
	private FormDefinitionAudit createFormDefAudit(FormDefinition formDef) {
		FormDefinitionAudit audit = new FormDefinitionAudit(formDef, formDef.getStatusCode(), Formatter.dateTime(DateTime.now().toString("MM-dd-yyyy HH:mm:ss")), 779L);
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
			audit.setStatusDate(Formatter.dateTime(rs.getTimestamp("status_date")));
			return audit;
		}
		
	}

}
