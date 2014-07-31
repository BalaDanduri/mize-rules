package com.mize.domain.shipping;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.test.util.JPATest;


@ContextConfiguration(locations={"/test-context.xml"})
public class ShipmentTrackingTest extends JPATest {
	EntityManager entityManager = null;
	ShipmentTracking tracking = null;
	
	@Before
	public void setUp(){
		try{
			entityManager = getEntityManager();
			tracking = findById(1l,ShipmentTracking.class,entityManager);
			this.tracking = getShipmentTrackingTestOjectToSave(tracking);
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			if(tracking.getId() == null){
				entityManager.persist(tracking);	
			}else{
				tracking = entityManager.merge(tracking);
			}		
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private User getUser() {
		User user = new User();
		user.setId(902l);
		user.setEmail("baladanduri@m-ize.com");
		BusinessEntity tenant = new BusinessEntity();
		tenant.setId(7624l);
		user.setTenant(tenant);
		return user;
	}

	private ShipmentTracking getShipmentTrackingTestOjectToSave(ShipmentTracking tracking) {
		if(tracking == null){
			tracking = new ShipmentTracking();
		}
		tracking.setAccountNumber("12345");
		tracking.setCarrier("Air");
		tracking.setMethod("courier");
		tracking.setUser(getUser());
		return tracking;
	}

	
	@Test
	public void testSaveShipmentTracking() {
		try {
			assertTrue(tracking.getId() == null );
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
}
