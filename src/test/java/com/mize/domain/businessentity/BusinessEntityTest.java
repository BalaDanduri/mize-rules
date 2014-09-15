package com.mize.domain.businessentity;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.common.Country;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class BusinessEntityTest extends JPATest {
	private static final String BUSINESS_ENTITY_QUERY = "select * from business_entity where id = ?";
	private static final String BUSINESS_ENTITY_BRAND_QUERY = "select * from business_entity_brand where id =?";
	private static final String BUSINESS_ENTITY_ADDRESS_QUERY = "select * from business_entity_address where id =?";
	private static final String BUSINESS_ENTITY_CONTACT_QUERY = "select * from business_entity_contact where id =?";
	private static final String BUSINESS_ENTITY_INTL_QUERY = "select * from business_entity_intl where id =?";
	
	EntityManager entityManager;
	BusinessEntity businessEntity = null;
		BusinessEntityBrand businessBrand;
	BusinessEntityAddress beAddress;
	BusinessEntityContact beContact;
	BusinessEntity dbBusinessEntity;
	EntityTransaction tx;
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		//businessEntity = businessEntityObjectTobeSaved(businessEntity);
		businessEntity = createBusinessEntity("dealer");
		
		
		}

	public void persist()
	{

		tx = entityManager.getTransaction();
     tx.begin();
		
		if(businessEntity.getId() != null){
			businessEntity = entityManager.merge(businessEntity);
		}else{
			entityManager.persist(businessEntity);
		}
		tx.commit();
	
	}
	
	public BusinessEntity findExistingBusinessEntity(EntityManager entityManager) {
		return entityManager.find(BusinessEntity.class, new Long(961));
	}
	
	@Test
	public void saveBusinessEntitytest() {
		try {
			/*List<BusinessEntity>  be = jdbcTemplate.query(BUSINESS_ENTITY_QUERY, new Object[]{businessEntity.getId()}, new BusinessEntityRowMapper());
			if(!Formatter.isEmpty(be)){
				BusinessEntity beList = be.get(0);
				
				assertTrue(businessEntity.getId().equals(beList.getId()));
		
			}*/
			persist();
			dbBusinessEntity = retrievBusinessEntity();
			assertTrue(dbBusinessEntity.equals(businessEntity));
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	 
	
	private class BusinessEntityRowMapper implements RowMapper<BusinessEntity> {
		@Override
		public BusinessEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			businessEntity = new BusinessEntity();
			businessEntity.setId(rs.getLong("id"));
			businessEntity.setCode(rs.getString("code"));
			businessEntity.setTypeCode(rs.getString("type_code"));
			businessEntity.setSubTypeCode(rs.getString("sub_type_code"));
			businessEntity.setIsActive(rs.getString("active_indicator"));
			businessEntity.setCurrencyCode(rs.getString("currency_code"));
			businessEntity.setLogo(rs.getString("logo"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			businessEntity.setTenant(tenant);
			BusinessEntity parentBe = new BusinessEntity();
			parentBe.setId(rs.getLong("parent_be_id"));
			businessEntity.setParentBE(parentBe);
			return businessEntity;
		}
	}
	
	private class BusinessEntityIntlRowMapper implements RowMapper<BusinessEntityIntl>
	{

		@Override
		public BusinessEntityIntl mapRow(ResultSet rs, int arg1)
				throws SQLException {
			BusinessEntityIntl beIntl = new BusinessEntityIntl();
			beIntl.setName(rs.getString("be_name"));
			beIntl.setFirstName(rs.getString("be_first_name"));
			beIntl.setLastName(rs.getString("be_last_name"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("id"));
			beIntl.setBusinessEntity(tenant);
			Locale locale = new Locale();
			locale.setId(rs.getLong("id"));
			beIntl.setLocale(locale);
			
			return beIntl;
		}
		
	}
	
	
	private class BusinessEntityBrandRowMapper implements RowMapper<BusinessEntityBrand>
	{

		@Override
		public BusinessEntityBrand mapRow(ResultSet rs, int arg1)
				throws SQLException {
			businessEntity = new BusinessEntity();
			businessEntity.setId(rs.getLong("id"));
			 businessBrand = new BusinessEntityBrand();
			businessBrand.setIsActive(rs.getString("is_active"));
			
			businessBrand.setBusinessEntity(businessEntity);
			return businessBrand;
		}
		
	}
	
	private class BusinessEntityAddressRowMapper implements RowMapper<BusinessEntityAddress>
	{

		@Override
		public BusinessEntityAddress mapRow(ResultSet rs, int arg1)
				throws SQLException {
			
			 beAddress = new BusinessEntityAddress();
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("id"));
			beAddress.setBusinessEntity(tenant);
			EntityAddress eAddress = new EntityAddress();
			eAddress.setAddress1(rs.getString("address_1"));
			eAddress.setAddress2(rs.getString("address_2"));
			eAddress.setCity(rs.getString("city"));
			Country country = new Country();
			country.setId(rs.getLong("id"));
			eAddress.setCountry(country);
			eAddress.setEmail(rs.getString("email"));
			
			beAddress.setEntityAddress(eAddress);
			beAddress.setIsPreferred(rs.getString("is_preferred"));
			return beAddress;
		}
		
	}
	
	private class BusinessContactRowMapper implements RowMapper<BusinessEntityContact>
	{

		@Override
		public BusinessEntityContact mapRow(ResultSet rs, int arg1)
				throws SQLException {
			beContact = new BusinessEntityContact();
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("id"));
			beContact.setBusinessEntity(tenant);
		/*	beContact.setContactType(rs.getString("contact_type"));
			beContact.setDepartment(rs.getString("department"));
			beContact.setFirstName(rs.getString("first_name"));*/
			
			return beContact;
		}
		
	}
	
	public BusinessEntity retrievBusinessEntity() {
		BusinessEntity dbBusinessEntity = new BusinessEntity();
		dbBusinessEntity = jdbcTemplate.queryForObject(BUSINESS_ENTITY_QUERY,
				new Object[] { businessEntity.getId() }, new BusinessEntityRowMapper());

		if(dbBusinessEntity!=null){
		List<BusinessEntityAddress> businessAddress = jdbcTemplate.query(BUSINESS_ENTITY_ADDRESS_QUERY,
				new Object[] { businessEntity.getId() }, new BusinessEntityAddressRowMapper());
		dbBusinessEntity.setAddresses(businessAddress);
	     
	     List<BusinessEntityIntl> businessEntityIntl = jdbcTemplate.query(BUSINESS_ENTITY_INTL_QUERY,
					new Object[] { businessEntity.getId() }, new BusinessEntityIntlRowMapper());
	     dbBusinessEntity.setIntl(businessEntityIntl);
		
		     List<BusinessEntityBrand> businessEntityBrand = jdbcTemplate.query(BUSINESS_ENTITY_BRAND_QUERY,
						new Object[] { businessEntity.getId() }, new BusinessEntityBrandRowMapper());
		     dbBusinessEntity.setBeBrand(businessEntityBrand);
			     
			     List<BusinessEntityContact> businessEntityContact = jdbcTemplate.query(BUSINESS_ENTITY_CONTACT_QUERY,
							new Object[] { businessEntity.getId() }, new BusinessContactRowMapper());
			     dbBusinessEntity.setBeContact(businessEntityContact);
				
			
		}
		return dbBusinessEntity;
	}
	@Test
	public void updateBusinessEntityTest() {
		try {
			persist();
			businessEntity.setCode("type2");
			//beContact = businessEntity.getBeContact().get(0);
			//beContact.setCreatedBy(234L);
			persist();
			dbBusinessEntity = retrievBusinessEntity();
			assertTrue(dbBusinessEntity != null && dbBusinessEntity.getId() != null);
			assertTrue(dbBusinessEntity.equals(businessEntity));
			tearDown();
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}

	public BusinessEntity retrieveBusinessEntityForDelete() {
		List<BusinessEntity> dbEntitys = jdbcTemplate.query(BUSINESS_ENTITY_QUERY,new Object[] { businessEntity.getId() }, new BusinessEntityRowMapper());
		if(!Formatter.isEmpty(dbEntitys)){
			dbBusinessEntity =  dbEntitys.get(0);
		}
		if(dbBusinessEntity!=null){
		List<BusinessEntityContact> contactList = jdbcTemplate.query(BUSINESS_ENTITY_CONTACT_QUERY,
				new Object[] { businessEntity.getId() }, new BusinessContactRowMapper());
		dbBusinessEntity.setBeContact(contactList);
		}
		return dbBusinessEntity;
	}

	
	@Test
	public void deleteBusinessEntity() throws Throwable
	{
		try{
			persist();
			tx.begin();
			entityManager.remove(businessEntity);
			tx.commit();
			dbBusinessEntity=  retrieveBusinessEntityForDelete();		/*assertTrue("Object deleted",(!dbLaborHour.equals(laborHour)));*/
			assertNull(dbBusinessEntity);
			System.out.println(getJsonResponse(businessEntity));
			System.out.println(getJsonResponse(dbBusinessEntity));
		}catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	public void tearDown() {
		try
		{
		if (businessEntity!= null) {
			//tx = entityManager.getTransaction();
			tx.begin();
			businessEntity = entityManager.find(BusinessEntity.class,businessEntity.getId());
			entityManager.remove(businessEntity);
			tx.commit();
		}
		entityManager.close();
		}
		catch(Exception e)
		{
			fail("Got Exception");
		}
	}

	
}
