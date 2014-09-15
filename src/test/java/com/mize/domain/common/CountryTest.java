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

import com.mize.domain.test.util.JPATest;
@ContextConfiguration(locations={"/test-context.xml"})
public class CountryTest extends JPATest{

	private static final String COUNTRY_QUERY = "select * from country where country_id=?";
	EntityManager entityManager = null;
	EntityTransaction tx;
	Country country;
	Country dbCountry;

	
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
		country = getCountryOjectToSave(country);
	}

	public void persist()
	{
		tx.begin();
		if(country.getId() == null){
			entityManager.persist(country);	
		}else{
			country = entityManager.merge(country);
		}		
		tx.commit();
	}
	
	private Country getCountryOjectToSave(Country country) {
		// TODO Auto-generated method stub
		country = new Country();
		country.setName("AUSTRALIA");
		country.setCode3("AUS");
		country.setCode("AS");
		country.setCreatedBy(778L);
		
		getStateObjectToBeSaved(country);
		
		
		return country;
	}

	private void getStateObjectToBeSaved(Country country) {
		State state = new State();
		List<State> stateList = new ArrayList<State>();
		state.setCode("TS");
		state.setCountry(country);
		state.setName("TELANGANA");
		stateList.add(state);
		country.setStates(stateList);
	}

	
   public class CountryRowMapper implements RowMapper<Country>
   {

	@Override
	public Country mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Country contry = new Country();
		contry.setId(rs.getLong("country_id"));
		contry.setName(rs.getString("country_name"));
		contry.setCode3(rs.getString("country_code_3"));
		contry.setCode(rs.getString("country_code"));
		contry.setCreatedBy(rs.getLong("created_by"));
		return contry;
	}
	   
   }


	private Country retrieveCountry() {
		
		dbCountry = jdbcTemplate.queryForObject(COUNTRY_QUERY,
				new Object[] { country.getId() }, new CountryRowMapper());	
		
		return dbCountry;
	}
	
	
	@Test
	public void testSaveCountry() {
		try
		{
		persist();
		dbCountry = retrieveCountry();
		assertTrue(dbCountry.equals(country));
		tearDown();
		}
		catch(Exception e)
		{
		fail("Not yet implemented");
		}
	}
	
	
	public void tearDown() throws Exception {
		if (country != null) {
			tx.begin();
			entityManager.remove(country);
			tx.commit();
		}
		entityManager.close();
	}

}
