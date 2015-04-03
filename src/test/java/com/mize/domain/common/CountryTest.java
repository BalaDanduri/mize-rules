package com.mize.domain.common;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.test.util.JPATest;
@ContextConfiguration(locations={"/test-context.xml"})
public class CountryTest extends JPATest{

	private static final String COUNTRY_QUERY = "select * from country where country_id=?";
	EntityManager entityManager = null;
	EntityTransaction tx;
	Country country;
	Country dbCountry;
	State state;
	State state2;
	StateIntl stateIntl;
	CountryIntl countryIntl;
	BusinessEntity tenant = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		/*entityManager = getEntityManager();
		tx = entityManager.getTransaction();
		country = getCountryOjectToSave(country);*/
	}

	public void persist()
	{
		/*tx.begin();
		if(country.getId() == null){
			entityManager.persist(country);	
			entityManager.flush();
		}else{
			country = entityManager.merge(country);
		}	
		tx.commit();*/
	}
	
	private Country getCountryOjectToSave(Country country) {
		country = new Country();
		country.setCode3("AUS");
		country.setCode("AU");
		country.setIsActive("Y");
		tenant  = findExistingBE(entityManager);
		getCountryIntlToBeSaved(country);
		getStateObjectNotToBeSaved(country);
		return country;
	}
	

    private void getCountryIntlToBeSaved(Country country) {
    	
 	   List<CountryIntl> countryIntlList = new ArrayList<CountryIntl>();
 	   countryIntl = new CountryIntl();
 	   Locale locale = findLocaleObjectFromDB();
 	   countryIntl.setLocale(locale);
 	   countryIntl.setCountry(country);
 	   countryIntl.setName("testCountryIntl");
 	   countryIntl.setDescription("testCountryIntlDescription");
 	   countryIntlList.add(countryIntl);
 	   country.setIntls(countryIntlList);
	}

    private void getStateObjectNotToBeSaved(Country country) {
		state2 = new State();
		List<State> stateList = new ArrayList<State>();
		state2.setCode("MEL");
		stateList.add(state);
		state2.setCountry(country);
		country.setStates(stateList);
		getStateIntlObjectToBeSaved(state2);
	}
    

    private void getStateIntlObjectToBeSaved(State state) {
    	List<StateIntl> stateIntlList = new ArrayList<StateIntl>();
		stateIntl = new StateIntl();
		Locale locale = findLocaleObjectFromDB();
		stateIntl.setLocale(locale);
		stateIntl.setState(state);
		stateIntl.setName("testStateIntl");
		stateIntl.setDescription("testStateIntlDescription");
		stateIntlList.add(stateIntl);
		state.setIntls(stateIntlList);
	}
	
   public class CountryRowMapper implements RowMapper<Country>
   {

	@Override
	public Country mapRow(ResultSet rs, int arg1) throws SQLException {
		Country contry = new Country();
		contry.setId(rs.getLong("country_id"));
		contry.setCode3(rs.getString("country_code_3"));
		contry.setCode(rs.getString("country_code"));
		return contry;
	}
	   
   }


	/*private Country retrieveCountry() {
		
		dbCountry = jdbcTemplate.queryForObject(COUNTRY_QUERY,
				new Object[] { country.getId() }, new CountryRowMapper());	
		
		return dbCountry;
	}*/
	
	
	/*@Test
	public void testSaveCountry() {
		try
		{
		persist();
		dbCountry = retrieveCountry();
		assertTrue(dbCountry.getCode().equals(country.getCode()));
		tearDown();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		fail(e.toString());
		}
	}*/
	
	
	public void tearDown() throws Exception {
		/*if(countryIntl!=null) {
			tx.begin();
			entityManager.remove(countryIntl);
			tx.commit();			
		}
		if(stateIntl!=null) {
			tx.begin();
			entityManager.remove(stateIntl);
			tx.commit();			
		}
		if(state!=null ){
			tx.begin();
			entityManager.remove(state);
			tx.commit();
		}
		if (country != null) {
			tx.begin();
			entityManager.remove(country);
			tx.commit();
		}
		entityManager.close();*/
	}

}
