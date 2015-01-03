package com.mize.domain.labor;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations = { "/test-context.xml" })
public class LaborHourTest extends JPATest {

	private static final String LABOR_QUERY = "select * from labor_hour where id = ?";
	private static final String LABOR_INTL_QUERY = "select * from labor_hour_intl where labor_hour_id = ?";
	EntityManager entityManager;
	LaborHour laborHour = null;
	LaborHourIntl lIntl = null;
	LaborHour dbLaborHour = null;
	EntityTransaction tx;
	List<LaborHourIntl> intls;

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		laborHour = laborHourObjectTobeSaved(laborHour);

	}

	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(laborHour);
		tx.commit();
	}

	private LaborHour laborHourObjectTobeSaved(LaborHour laborHour) {
		LaborHour lHour = new LaborHour();
		BusinessEntity beEntity = new BusinessEntity();
		beEntity.setId(8914L);
		lHour.setTenant(beEntity);
		lHour.setCode("code8");
		lHour.setType("Type7");
		lHour.setHours(BigDecimal.valueOf(300));
		lHour.setCreatedBy(12L);
		lHour.setUpdatedBy(12L);

		intls = new ArrayList<LaborHourIntl>();
		lIntl = new LaborHourIntl();

		lIntl.setLaborHour(lHour);
		lIntl.setDescription("Labor Description");
		Locale locale = new Locale();
		locale.setId(1L);

		lIntl.setLocale(locale);
		intls.add(lIntl);

		lHour.setIntls(intls);

		return lHour;

	}

	public LaborHour retrievLabour() {
		dbLaborHour = jdbcTemplate.queryForObject(LABOR_QUERY,
				new Object[] { laborHour.getId() }, new LaborRowMapper());

		if(dbLaborHour!=null){
		List<LaborHourIntl> intlList = jdbcTemplate.query(LABOR_INTL_QUERY,
				new Object[] { dbLaborHour.getId() }, new LaborIntlRowMapper());
		dbLaborHour.setIntls(intlList);
		}
		return dbLaborHour;
	}

	public LaborHour retrievLabours() {
		List<LaborHour> dbLaborHours = jdbcTemplate.query(LABOR_QUERY,new Object[] { laborHour.getId() }, new LaborRowMapper());
		if(!Formatter.isEmpty(dbLaborHours)){
			dbLaborHour =  dbLaborHours.get(0);
		}
		if(dbLaborHour!=null){
		List<LaborHourIntl> intlList = jdbcTemplate.query(LABOR_INTL_QUERY,
				new Object[] { dbLaborHour.getId() }, new LaborIntlRowMapper());
		dbLaborHour.setIntls(intlList);
		}
		return dbLaborHour;
	}

	
	private void createLaborHour() {
		laborHour = laborHourObjectTobeSaved(laborHour);
		persist();
	}

	private class LaborRowMapper implements RowMapper<LaborHour> {
		public LaborHour mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			LaborHour labourHour = new LaborHour();
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(resultSet.getLong("tenant_id"));

			labourHour.setId(resultSet.getLong("id"));
			labourHour.setTenant(tenant);
			labourHour.setType(resultSet.getString("labor_type"));
			labourHour.setCode(resultSet.getString("labor_code"));
			labourHour.setHours(resultSet.getBigDecimal("labor_hours"));
			labourHour.setCreatedBy(resultSet.getLong("created_by"));
			labourHour.setUpdatedBy(resultSet.getLong("updated_by"));

			return labourHour;
		}

	}

	private class LaborIntlRowMapper implements RowMapper<LaborHourIntl> {

		@Override
		public LaborHourIntl mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			LaborHourIntl laborHourIntl = new LaborHourIntl();
			LaborHour laborHour = new LaborHour();
			laborHour.setId(rs.getLong("id"));
			laborHourIntl.setLaborHour(laborHour);
			laborHourIntl.setDescription(rs.getString("labor_description"));
			Locale locale = new Locale();
			locale.setId(rs.getLong("locale_id"));
			laborHourIntl.setLocale(locale);
			return laborHourIntl;
		}

	}

	@Test
	public void saveLaborTest() throws Throwable {
		persist();
		try {
			dbLaborHour = retrievLabour();
			if (dbLaborHour != null) {

				assertTrue(dbLaborHour.getId().equals(laborHour.getId()));
				System.out.println(getJsonResponse(laborHour));
				System.out.println(getJsonResponse(dbLaborHour));
				tearDown();
			}
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}

	@Test
	public void updateLaborTest() {
		try {
			createLaborHour();
			laborHour.setCode("code10");
			lIntl = laborHour.getIntls().get(0);
			lIntl.setDescription("Updated desc");
			persist();
			dbLaborHour = retrievLabour();
			assertTrue(dbLaborHour != null && dbLaborHour.getId() != null);
			assertTrue(dbLaborHour.getId().equals(laborHour.getId()));
			tearDown();
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	@Test
	public void deleteLaborTest() throws Throwable
	{
		try{
			createLaborHour();
			tx.begin();
			entityManager.remove(laborHour);
			tx.commit();
			dbLaborHour=  retrievLabours();
			/*assertTrue("Object deleted",(!dbLaborHour.equals(laborHour)));*/
			assertNull(dbLaborHour);
			System.out.println(getJsonResponse(laborHour));
			System.out.println(getJsonResponse(dbLaborHour));
		}catch (Throwable th) {
			th.printStackTrace();
			tearDown();
			fail("Got Exception");
			throw th;
		}
	}

	
	public void tearDown() {
		if (laborHour != null) {
			//tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(laborHour);
			tx.commit();
		}
		entityManager.close();
	}
}
