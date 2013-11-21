package com.mize.domain.businessEntity;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import com.mize.domain.common.Country;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.State;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class BusinessEntityTest extends JPATest {
	private static final String BUSINESS_ENTITY_QUERY = "select * from business_entity where id = ?";
	EntityManager entityManager;
	BusinessEntity businessEntity = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		businessEntity = findExistingBusinessEntity(entityManager);
		this.businessEntity = businessEntityObjectTobeSaved(businessEntity);
		EntityTransaction tx = entityManager.getTransaction();
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
	public void test() {
		try {
			List<BusinessEntity>  be = jdbcTemplate.query(BUSINESS_ENTITY_QUERY, new Object[]{businessEntity.getId()}, new BusinessEntityRowMapper());
			if(!Formatter.isEmpty(be)){
				BusinessEntity beList = be.get(0);
				assertTrue(businessEntity.getId().equals(beList.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class BusinessEntityRowMapper implements RowMapper<BusinessEntity> {
		@Override
		public BusinessEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			BusinessEntity be = new BusinessEntity();
			be.setId(rs.getLong("id"));
			be.setCode(rs.getString("code"));
			be.setTypeCode(rs.getString("type_code"));
			be.setSubTypeCode(rs.getString("sub_type_code"));
			be.setIsActive(rs.getString("active_indicator"));
			be.setCurrencyCode(rs.getString("currency_code"));
			be.setLogo(rs.getString("logo"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			be.setTenant(tenant);
			BusinessEntity parentBe = new BusinessEntity();
			parentBe.setId(rs.getLong("parent_be_id"));
			be.setParentBE(parentBe);
			return be;
		}
	}
	
	private BusinessEntity businessEntityObjectTobeSaved(BusinessEntity businessEntity) {
		BusinessEntity be = new BusinessEntity();
		be.setId(961l);
		be.setTypeCode("dealer");
		be.setCode("10C00101P");
		be.setIsActive("Y");
		be.setLogo("be.jpg");
		be.setCurrencyCode("USA");
		be.setSubTypeCode("subType");
		BusinessEntity tenant = new BusinessEntity();
		tenant.setId(962l);
		be.setTenant(tenant);
		BusinessEntity parentBe = new BusinessEntity();
		parentBe.setId(963l);
		be.setParentBE(parentBe);
		
		List<BusinessEntityAddress> addressList = new ArrayList<BusinessEntityAddress>();
		EntityAddress address = findObjectFromDB(EntityAddress.class , 1l);
		address.setType("Office");
		address.setAddress1("address1");
		address.setAddress2("address2");
		address.setAddress3("address3");
		address.setCity("Hyd");
		address.setEmail("test@m-ize.com");
		address.setZip("29292929");
		address.setZipExt("67676767");
		State state = new State();
		state.setId(1l);
		state.setCode("AL");
		address.setState(state);
		Country country = new Country();
		country.setId(1l);
		country.setCode("US");
		address.setCountry(country);
		BusinessEntityAddress address2 = new BusinessEntityAddress();
		address2.setBusinessEntity(be);
		address2.setEntityAddress(address);
		address2.setBusinessEntity(be);
		addressList.add(address2);
		address2.setLocale(findLocaleObjectFromDB());
		address2.setState(findStateObjectFromDB());
		address2.setCountry(findCountryObjectFromDB());
		be.setAddresses(addressList);
		
		List<BusinessEntityIntl> intlList = new ArrayList<BusinessEntityIntl>();
		BusinessEntityIntl intl = findExistingBusinessEntityIntl(entityManager);
		intl.setBusinessEntity(be);
		intl.setLocale(findLocaleObjectFromDB());
		intl.setName("TestIntl");
		intl.setDescription("IntlDescription");
		intlList.add(intl);
		be.setIntl(intlList);
		
		BusinessEntityGeo entityGeo = new BusinessEntityGeo();
		entityGeo.setBusinessEntityAddress(address2);
		entityGeo.setLatitude(345.0);
		entityGeo.setLongitude(634.0);
		address2.setEntityGeo(entityGeo);
		return be;
	}
	
	
}
