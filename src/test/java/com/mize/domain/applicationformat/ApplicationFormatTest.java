package com.mize.domain.applicationformat;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations = { "/test-context.xml" })
public class ApplicationFormatTest  extends JPATest{

	EntityManager entityManager;
	ApplicationFormat appFormat = null;
	ApplicationFormat applicationFormatDB = null;
	EntityTransaction tx;
	private static final String APPLICATION_QUERY = "select * from application_formats where id = ?";
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		appFormat = applicationFormatObjectTobeSaved(appFormat);
	}
	
	public  void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(appFormat);
		tx.commit();
		
	}
	
	public ApplicationFormat applicationFormatObjectTobeSaved(ApplicationFormat applicationFormat) {
		ApplicationFormat appFormat = new ApplicationFormat();
		BusinessEntity beEntity = new BusinessEntity();
		beEntity.setId(7624L);
//		appFormat.setTenant(beEntity);
		appFormat.setFormatType("USA");
		appFormat.setFormatValue("MM-DD-YYYY");
		appFormat.setCreatedBy(12L);
		appFormat.setUpdatedBy(12L);
		Locale locale = new Locale();
		locale.setId(1L);
		appFormat.setLocale(locale);

		return appFormat;
	}

	public ApplicationFormat retrieveApplicationFormat() {
		applicationFormatDB = jdbcTemplate.queryForObject(APPLICATION_QUERY,
				new Object[] { appFormat.getId() }, new ApplicationFormatRowMapper());

		return applicationFormatDB;
	}

	private class ApplicationFormatRowMapper implements RowMapper<ApplicationFormat> {
		public ApplicationFormat mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			ApplicationFormat appFormat = new ApplicationFormat();
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(resultSet.getLong("tenant_id"));

			appFormat.setId(resultSet.getLong("id"));
			//appFormat.setTenant(tenant);
			appFormat.setFormatType(resultSet.getString("format_type"));
			appFormat.setFormatValue(resultSet.getString("format_value"));
			appFormat.setCreatedBy(resultSet.getLong("created_by"));
			appFormat.setUpdatedBy(resultSet.getLong("updated_by"));
			return appFormat;
		}

	}

	
	@Test
	public void saveApplicationFormat() throws Throwable {
		persist();
		try {
				assertTrue(appFormat != null);
				System.out.println(getJsonResponse(appFormat));
//				tearDown();
			}
		catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	@Test
	public void retrieveAppFormat() throws Throwable {
		persist();
		try {
			    applicationFormatDB = retrieveApplicationFormat();
				assertTrue(applicationFormatDB != null);
				System.out.println(getJsonResponse(applicationFormatDB));
//				tearDown();
			}
		catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}

}
