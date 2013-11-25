package com.mize.domain.test;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.common.Country;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class CountryTest extends JPATest {

	private static String Country_QUERY = "select * from country where id = ?";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	EntityManager entityManager = null;
	Country country = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		country = (Country) find(Country.class, new Long(1));
	}
	
	@Test
	public void test(){
		List<Country> countries = jdbcTemplate.query(Country_QUERY, new Object[]{ new Long(1) }, new CountryRowMapper() );
		if(!Formatter.isEmpty(countries)){
			Country country1  = countries.get(0);
			assertEquals(country.getCode(),country1.getCode());
		}
		
	}
	
	private class CountryRowMapper implements RowMapper<Country>{

		@Override
		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
			Country country = new Country();
			country.setId(rs.getLong("id"));
			country.setCode(rs.getString("code"));
			country.setCode3(rs.getString("code3"));
			return country;
		}
	}
	
}
