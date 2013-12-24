package com.mize.domain.common;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.auth.User;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.user.UserAddress;
import com.mize.domain.user.UserProfile;

@ContextConfiguration(locations={"/test-context.xml"})
public class UserTest extends JPATest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	EntityManager entityManager = null;
	
	User user =null;
	UserProfile userProfile =null;
	
	@Before
	public void setUp() throws Exception {
			entityManager = getEntityManager();
			user = new User();
			user.setName("Surya");
			user.setEmail("surya@m-ize.com");
			user.setLastLogin(DateTime.now());
			user.setActive(true);
			user.setEmailValidated(true);
			user.setReferralId(1L);
		 
		 	userProfile=new UserProfile();
			userProfile.setFirstName("Surya");
			userProfile.setMiddleName("Prakash");
			userProfile.setLastName("M");
			userProfile.setProfileName("Surya Prakash");
			userProfile.setGender(Gender.valueOf("F"));
			userProfile.setPhoneHome("0401234567");
			userProfile.setPhoneWork("9492418417");
			userProfile.setEmailOptOut("Y");
			userProfile.setBirthdate(DateTime.now());
			
			UserAddress address=new UserAddress();
			address.setAddress1("adress1");
			address.setAddress2("adress2");
			address.setAddress3("adress3");
			address.setUser(user);
			
			userProfile.getAddresses().add(address);
			userProfile.setUser(user);
			
			user.setUserProfile(userProfile);
	}
	
	@Test
	public void test(){
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		 entityManager.persist(user);
		tx.commit();	
		assertNotNull(user.getId());
	}
	
	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}

}
