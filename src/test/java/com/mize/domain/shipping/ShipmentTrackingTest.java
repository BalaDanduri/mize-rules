package com.mize.domain.shipping;

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

import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;

import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityComment;
import com.mize.domain.test.util.JPATest;


@ContextConfiguration(locations={"/test-context.xml"})
public class ShipmentTrackingTest extends JPATest {
	EntityManager entityManager;
	ShipmentTracking tracking = null;
	ShipmentTracking dbTrackingData = null;
	EntityTransaction tx;
	private static final String SHIPMENT_TRACKING_QUERY = "select * from shipment_tracking where id=?";
	BusinessEntity businessEntity = null;
	@Before
	public void setUp(){
		try{
			entityManager = getEntityManager();
			tx = entityManager.getTransaction();
			//tracking = findById(1l,ShipmentTracking.class,entityManager);
			 
			 tx.begin();
			 businessEntity = createBusinessEntity("dealer");
			 entityManager.persist(businessEntity);
			 entityManager.flush();
			 tx.commit();
			this.tracking = getShipmentTrackingTestOjectToSave(tracking);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void persist()
	{
		tx.begin();
		if(tracking.getId() == null){
			entityManager.persist(tracking);	
		}else{
			tracking = entityManager.merge(tracking);
		}		
		tx.commit();
	}
	
	

	private ShipmentTracking getShipmentTrackingTestOjectToSave(ShipmentTracking tracking) {
		if(tracking == null){
			tracking = new ShipmentTracking();
		}
		tracking.setAccountNumber("12345");
		tracking.setCarrier("Air");
		tracking.setMethod("courier");
		User user = createUser();
		tracking.setUser(user);
		tracking.setEntityCode("ADGC123");
		
		getShipmentCommentToBeSaved(tracking);
		
		getShipmentPartyObjectToBeSaved(tracking);
		
		getShipmentPackageObjectToBeSaved(tracking);
		return tracking;
	}
	private void getShipmentPackageObjectToBeSaved(ShipmentTracking tracking) {
		List<ShipmentPackage> packageList = new ArrayList<ShipmentPackage>();
		ShipmentPackage shipmentPackage = new ShipmentPackage();
		ShipmentPackageAttribute shipmentPackageAttribute = new ShipmentPackageAttribute();
		List<ShipmentPackageAttribute> packageAttributeList = new ArrayList<ShipmentPackageAttribute>();
		shipmentPackage.setNumber("two");
		shipmentPackage.setShipmentLabel("kkp");
		shipmentPackage.setHandlingAmount(BigDecimal.valueOf(2100));
		shipmentPackage.setTotalAmount(BigDecimal.valueOf(5600));

		shipmentPackageAttribute.setCode("childAttribute");
		shipmentPackageAttribute.setUom("qwer");
		packageAttributeList.add(shipmentPackageAttribute);
		shipmentPackage.setAttributes(packageAttributeList);
		
		packageList.add(shipmentPackage);
		tracking.setPackages(packageList);
	}
	private void getShipmentPartyObjectToBeSaved(ShipmentTracking tracking) {
		List<ShipmentParty> shipmentPartyList = new ArrayList<ShipmentParty>();
		ShipmentParty shipmentParty = new ShipmentParty();
		shipmentParty.setBusinessEntity(businessEntity);
		EntityAddress eAddress = createEntityAddress();
		shipmentParty.setAddress(eAddress);
		shipmentParty.setCode("IFSC");
		shipmentParty.setContactName("sirisha");
		shipmentParty.setFirstName("kokne");
		shipmentPartyList.add(shipmentParty);
		
		tracking.setParties(shipmentPartyList);
	}
	private void getShipmentCommentToBeSaved(ShipmentTracking tracking) {
		List<ShipmentComment> commentList = new ArrayList<ShipmentComment>();
		ShipmentComment shipmentComment = new ShipmentComment();
		EntityComment eComment = createEntityComment();
		shipmentComment.setComment(eComment);
		shipmentComment.setShipmentTracking(tracking);
		commentList.add(shipmentComment);
		tracking.setComments(commentList);
	}
	
	public class ShipmentTrackingRowMapper implements RowMapper<ShipmentTracking>
	{

		@Override
		public ShipmentTracking mapRow(ResultSet rs, int arg1)
				throws SQLException {
			
		ShipmentTracking shipment = new ShipmentTracking();
		shipment.setId(rs.getLong("id"));
		tracking.setAccountNumber(rs.getString("shipment_account_number"));
		tracking.setCarrier(rs.getString("shipment_carrier"));
		tracking.setMethod(rs.getString("shipment_method"));
		User user = new User();
		user.setId(rs.getLong("id"));
		tracking.setUser(user);
		tracking.setEntityCode(rs.getString("entity_code"));
		
			return tracking;
		}
		
	}


	public ShipmentTracking retrievShipmentTracking() {
		dbTrackingData= new ShipmentTracking();
		dbTrackingData = jdbcTemplate.queryForObject(SHIPMENT_TRACKING_QUERY,
				new Object[] { tracking.getId() }, new ShipmentTrackingRowMapper());
		return dbTrackingData;
	}
	
	@Test
	public void testSaveShipmentTracking() {
		try {
			
			persist();
			dbTrackingData=retrievShipmentTracking();
			assertTrue(tracking.equals(dbTrackingData));
			tearDown();
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	@Test
	public void testUpdateShipmentTracking() {
		try {
			
			persist();
			tracking.setAccountNumber("updatednum");
			dbTrackingData=retrievShipmentTracking();
			assertTrue(tracking.equals(dbTrackingData));
			tearDown();
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	public void tearDown()
	{
		if (tracking != null) {
			tx.begin();
			entityManager.remove(tracking);
			tx.commit();
		}
		entityManager.close();
	}
	}
	

