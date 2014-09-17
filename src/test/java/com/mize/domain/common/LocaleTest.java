package com.mize.domain.common;

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

import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class LocaleTest extends JPATest{

	private static final String LOCALE_QUERY = "select * from locale where locale_id=?";
	EntityManager entityManager;
	EntityTransaction tx;
	Locale locale;
	Locale dbLocale;
	
	@Before
	public void setUp() throws Exception {
		try{
			entityManager = getEntityManager();
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	public void persist()
	{
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(locale);	
		tx.commit();
	}

	private void createLocaleObject() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			locale = getLocaleObjectToBeSaved();			
			entityManager.persist(locale);
			tx.commit();
		}

	}
	
	
	private Locale getLocaleObjectToBeSaved() {

locale = new Locale();
locale.setCountryCode("IND");
locale.setIsActive("y");
locale.setLanguageCode("ENG");
locale.setName("english");

		return locale;
	}

	public class LocaleRowMapper implements RowMapper<Locale>
	{

		@Override
		public Locale mapRow(ResultSet rs, int arg1) throws SQLException {

        Locale local = new Locale();
        local.setId(rs.getLong("locale_id"));
        local.setCountryCode(rs.getString("country_code"));
        local.setIsActive(rs.getString("is_active"));
        local.setLanguageCode(rs.getString("language_code"));
        local.setName(rs.getString("locale_name"));
			return local;
		}
		
	}
	
	private Locale retrieveLocale() {
		dbLocale= new Locale();
		dbLocale = jdbcTemplate.queryForObject(LOCALE_QUERY,
				new Object[] { locale.getId() }, new LocaleRowMapper());	
		return dbLocale;
	}
	
	@Test
	public void saveLocaleTest() throws Throwable {
		try
		{
			createLocaleObject();
			dbLocale = retrieveLocale();
			assertTrue(dbLocale.equals(locale));
			tearDown();
		}
		catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	

	@Test
	public void updateWorkQueueTest() throws Throwable {
		try
		{
			createLocaleObject();
			locale.setCountryCode("USA");
			persist();
			dbLocale = retrieveLocale();
			assertTrue(dbLocale.equals(locale));
			tearDown();
		}
		catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	
	public void tearDown() throws Exception {
		if (locale != null) {
			tx.begin();
			entityManager.remove(locale);
			tx.commit();
		}
		entityManager.close();
	}

	
}
