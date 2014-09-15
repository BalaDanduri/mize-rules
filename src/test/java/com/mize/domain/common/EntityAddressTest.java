package com.mize.domain.common;

import static org.junit.Assert.*;

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

import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class EntityAddressTest extends JPATest{

	private static final String ENTITY_ADDRESS_QUERY = "select * from entity_address where id=?";
	private static final String ENTITY_ADDRESS_PHONE_QUERY = "select * from entity_address_phone where entity_address_id=?";
	EntityAddress entityAddress;
	EntityManager entityManager;
	EntityTransaction tx;
	EntityAddress dbEntityAddressData;
	
	

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
		entityManager.persist(entityAddress);	
		tx.commit();
	}
	
	private void createEntityAddressObject() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			entityAddress = getEntityAddressTestObjectToSave(entityAddress);
			getEntityPhoneObjectToBeSaved(entityAddress);
			
			entityManager.persist(entityAddress);
			tx.commit();
		}

	}
	

	private EntityAddress getEntityAddressTestObjectToSave(
			EntityAddress entityAddress2) {
		
		entityAddress = new EntityAddress();
		entityAddress.setAddress1("hyderabad");
		entityAddress.setAddress2("secunderabad");
		entityAddress.setCity("hyderabad");
		Country country =findCountryObjectFromDB();
		entityAddress.setCountry(country);		
		return entityAddress;
	}

	private void getEntityPhoneObjectToBeSaved(EntityAddress entity) {
		EntityAddressPhone entityPhone = new EntityAddressPhone();
		List<EntityAddressPhone> entityPhoneList = new ArrayList<EntityAddressPhone>(); 
		entityPhone.setAddress(entityAddress);
		entityPhone.setPhoneExt("020");
		entityPhone.setPhoneType("landline");
		entityPhoneList.add(entityPhone);
		entityAddress.setAddressPhones(entityPhoneList);
	}
	
		

	public class EntityAddressRowMapper implements RowMapper<EntityAddress>
	{

		@Override
		public EntityAddress mapRow(ResultSet rs, int arg1)
				throws SQLException {
			
		EntityAddress eAddress = new EntityAddress();
		eAddress.setId(rs.getLong("id"));
		eAddress.setAddress1(rs.getString("address_1"));
		eAddress.setAddress2(rs.getString("address_2"));
		eAddress.setCity(rs.getString("city"));
		Country country = new Country();
		country.setId(rs.getLong("country_id"));
		eAddress.setCountry(country);
		
			return eAddress;
		}
		
	}
	
	public class EntityAddressPhoneRowMapper implements RowMapper<EntityAddressPhone>
	{

		@Override
		public EntityAddressPhone mapRow(ResultSet rs, int arg1)
				throws SQLException {
			
			EntityAddressPhone entityPhone = new EntityAddressPhone();
			entityPhone.setId(rs.getLong("id"));
			entityPhone.setPhoneExt(rs.getString("phone_ext"));
			entityPhone.setPhoneType(rs.getString("phone_type"));
			EntityAddress eAddress = new EntityAddress();
			eAddress.setId(rs.getLong("entity_address_id"));
			entityPhone.setAddress(eAddress);
			return entityPhone;
		}
		
	}

	private EntityAddress retrieveEntityAddress() {
		dbEntityAddressData= new EntityAddress();
		dbEntityAddressData = jdbcTemplate.queryForObject(ENTITY_ADDRESS_QUERY,
				new Object[] { entityAddress.getId() }, new EntityAddressRowMapper());	
		
		if(dbEntityAddressData!=null){
			List<EntityAddressPhone> phoneList = jdbcTemplate.query(ENTITY_ADDRESS_PHONE_QUERY,
					new Object[] { dbEntityAddressData.getId() }, new EntityAddressPhoneRowMapper());
			dbEntityAddressData.setAddressPhones(phoneList);
			}
		return dbEntityAddressData;
	}

	
	@Test
	public void saveEntityAddressTest() throws Throwable {
		try
		{
			createEntityAddressObject();
			dbEntityAddressData = retrieveEntityAddress();
			assertTrue(dbEntityAddressData.getId()!=null);
			tearDown();
		}
		catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	

	@Test
	public void updateEntityAddressTest() throws Throwable {
		try
		{
			createEntityAddressObject();
			entityAddress.setAddress1("updatedAddress");
			persist();
			dbEntityAddressData = retrieveEntityAddress();
			assertTrue(dbEntityAddressData.getId()!=null);
			tearDown();
		}
		catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	public void tearDown() throws Exception {
		if (entityAddress != null) {
			tx.begin();
			entityManager.remove(entityAddress);
			tx.commit();
		}
		entityManager.close();
	}
	
}
