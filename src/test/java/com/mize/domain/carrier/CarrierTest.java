package com.mize.domain.carrier;

import static org.junit.Assert.assertNull;
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

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;


@ContextConfiguration(locations = { "/test-context.xml" })
public class CarrierTest extends JPATest{
	
	
	private static final String CARRIER_QUERY = "select * from carrier where id = ?";
	private static final String CARRIER_INTL_QUERY = "select * from carrier_intl where carrier_id = ?";
	
	EntityManager entityManager;
	EntityTransaction tx;
	Carrier carrier = null;
	Carrier dbCarrier = null;
	CarrierIntl intl = null;
	List<CarrierIntl> intls;
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		carrier = carrierObjectToBeSaved(carrier);
	}
	
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(carrier);
		tx.commit();
	}
	
	private void createCarrier() {
		carrier = carrierObjectToBeSaved(carrier);
		persist();
	}
	
	private class CarrierRowMapper implements RowMapper<Carrier> {
		@Override
		public Carrier mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Carrier carrier = new Carrier();
			
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(resultSet.getLong("tenant_id"));
			
			carrier.setId(resultSet.getLong("id"));
			carrier.setTenant(tenant);
			carrier.setCarrierCode(resultSet.getString("carrier_code"));
			carrier.setWebsiteUrl(resultSet.getString("website_url"));
			carrier.setTrackingUrl(resultSet.getString("tracking_url"));
			carrier.setCreatedBy(resultSet.getLong("created_by"));
			carrier.setUpdatedBy(resultSet.getLong("updated_by"));
			
			return carrier;
		}
	} 
	
	private class CarrierIntlRowMapper implements RowMapper<CarrierIntl> {
		@Override
		public CarrierIntl mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			CarrierIntl carrierIntl = new CarrierIntl();
			
			Carrier carrier = new Carrier();
			carrier.setId(resultSet.getLong("id"));
			
			carrierIntl.setCarrier(carrier);
			carrierIntl.setCarrierName(resultSet.getString("carrier_name"));
			carrierIntl.setCarrierDesc(resultSet.getString("carrier_description"));
			
			Locale locale = new Locale();
			locale.setId(resultSet.getLong("locale_id"));
			carrierIntl.setLocale(locale);
			
			return carrierIntl;
		}
	}
	
	private Carrier carrierObjectToBeSaved(Carrier carrier) { 
		Carrier carrierNew = new Carrier();
		
		BusinessEntity beEntity = new BusinessEntity();
		beEntity.setId(8914L);
		
		carrierNew.setTenant(beEntity);
		carrierNew.setCarrierCode("Carrier_"+ System.currentTimeMillis());
		carrierNew.setWebsiteUrl("www.google.com");
		carrierNew.setTrackingUrl("www.google.com");
		carrierNew.setCreatedBy(20L);
		carrierNew.setUpdatedBy(20L);
		
		intls = new ArrayList<CarrierIntl>();
		intl = new CarrierIntl();
		
		intl.setCarrier(carrierNew);
		intl.setCarrierName("Carrier One");
		intl.setCarrierDesc("Carrier Description");
		Locale locale = new Locale();
		locale.setId(1L);
		
		intl.setLocale(locale);
		
		intls.add(intl);
		
		carrierNew.setIntls(intls);
		
		return carrierNew;
	}
	
	private Carrier retrieveCarrier() {
		List<Carrier> dbCarriers = jdbcTemplate.query(CARRIER_QUERY, new Object[] {carrier.getId()}, new CarrierRowMapper());
		if(!Formatter.isEmpty(dbCarriers)) {
			dbCarrier = dbCarriers.get(0);
			if(dbCarrier != null) {
				List<CarrierIntl> intlList =  jdbcTemplate.query(CARRIER_INTL_QUERY,  new Object[] {dbCarrier.getId()}, new CarrierIntlRowMapper());
				dbCarrier.setIntls(intlList);
			}
		}
		return dbCarrier;
	}
	
	
	@Test
	public void testSave() throws Throwable {
		persist();
		try{
			dbCarrier = retrieveCarrier();
			if (dbCarrier != null){
				assertTrue(dbCarrier.equals(carrier));
				System.out.println(getJsonResponse(carrier));
				System.out.println(getJsonResponse(dbCarrier));
				tearDown();
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	@Test
	public void testUpdate() throws Throwable {
		try{
			createCarrier();
			carrier.setWebsiteUrl("www.yahoo.com");
			persist();
			dbCarrier = retrieveCarrier();
			assertTrue(carrier.equals(dbCarrier));
			
			System.out.println(carrier);
			System.out.println(dbCarrier);
			tearDown();
		} catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	@Test
	public void testDelete() throws Throwable {
		try {
			createCarrier();
			tx.begin();
			entityManager.remove(carrier);
			tx.commit();
			dbCarrier = retrieveCarrier();
			assertNull(dbCarrier);
			System.out.println(getJsonResponse(dbCarrier));
			System.out.println(getJsonResponse(carrier));
		} catch(Throwable th) {
			th.printStackTrace();
			tearDown();
			fail("Got Exception");
			throw th;
		}
	}
	
	public void tearDown() throws Exception {
		if(carrier != null){
			tx.begin();
			entityManager.remove(carrier);
			tx.commit();
		}
		entityManager.close();
	}

}
