package com.mize.domain.form;

import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class FormInstanceTest extends JPATest {
	
	private static final String FORM_INSTANCE_QUERY = "select * from form_instance where id = ?";
	
	FormInstance formInstance = null;
	FormDefinition formDef = null;
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
		formDef = findExistingFormDefinition(entityManager);
		formInstance = createFormInstance(formDef);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(formInstance);
		tx.commit();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFormInstance() {
		try {
			jdbcTemplate.queryForObject(FORM_INSTANCE_QUERY, new FormInstanceRowMapper(), new Object[]{formInstance.getId()});
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got Exception");
		}
		
	}
	
	class FormInstanceRowMapper implements RowMapper<FormInstance> {

		@Override
		public FormInstance mapRow(ResultSet rs, int arg1) throws SQLException {
			FormInstance formInstance = new FormInstance();
			formInstance.setId(rs.getLong("id"));
			formInstance.setFormInstanceData(rs.getString("form_instance_data"));
			FormDefinition formDef= new FormDefinition();
			formDef.setId(rs.getLong("form_defn_id"));
			formInstance.setFormDefinition(formDef);
			return formInstance;
		}
		
	}
	
	private FormInstance createFormInstance(FormDefinition formDef) {
		FormInstance formInstance = new FormInstance(formDef, "Form Data");
		return formInstance;
	}

}
