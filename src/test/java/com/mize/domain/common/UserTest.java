package com.mize.domain.common;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.auth.LinkedAccount;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.user.Group;
import com.mize.domain.user.UserAddress;
import com.mize.domain.user.UserBE;
import com.mize.domain.user.UserGroup;
import com.mize.domain.user.UserProfile;
import com.mize.domain.user.UserProfilePrivacy;

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
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		user = prepareUser();
	}
	
	@Test
	public void test(){
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(user);
		tx.commit();
		assertNotNull(user.getId());
	}
	
	@Test
	public void testUserRetrieve(){
		User user = entityManager.find(User.class, 1l);
		assertNotNull(user.getId());
	}
	
	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}
	
	@Test
	//@Transactional	//It is creating issue w.r.t LOCAL and DEV contexts.
	public void testGetLinkedAccounts() {
		try {
			Long userId = 1L;
			userId = 961L;
			
			UserBE userBe = new UserBE();
			
			BusinessEntity businessEntity = (BusinessEntity)find(BusinessEntity.class, userId);
			userBe.setBe(businessEntity);
			user.setUserBe(userBe);
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(user);
			tx.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			fail("Got Exception");
		}		
	}
	
	public User prepareUser(){
		Long userId = 1L;
		userId = 961L;
		
		user = new User();
		user.setName("Surya");
		user.setEmail("surya@m-ize.com");
		user.setLastLogin(DateTime.now());
		user.setActive(true);
		user.setEmailValidated(true);
		user.setReferralId(1L);
		user.setTenantId(12L);
		user.setCreatedBy(userId);
		user.setCreatedDate(DateTime.now());
		user.setUpdatedBy(userId);
		user.setUpdatedDate(DateTime.now());
		
	 	UserProfile userProfile=new UserProfile();
		userProfile.setFirstName("Surya");
		userProfile.setMiddleName("Prakash");
		userProfile.setLastName("M");
		userProfile.setProfileName("Surya Prakash");
		userProfile.setGender(Gender.valueOf("F"));
		userProfile.setPhoneHome("0401234567");
		userProfile.setPhoneWork("9492418417");
		userProfile.setEmailOptOut("Y");
		userProfile.setBirthdate(DateTime.now());
		
		UserProfilePrivacy privacy = new UserProfilePrivacy();
		privacy.setBirthDate(1L);
		privacy.setActivity(2L);
		privacy.setDisplayBirthYear("Y");
		privacy.setGender(1L);
		privacy.setUser(user);
		privacy.setWant(40L);
		userProfile.setPrivacy(privacy);
		userProfile.setUser(user);
		user.setPrivacy(privacy);
		
		UserAddress address=new UserAddress();
		address.setAddress1("adress1");
		address.setAddress2("adress2");
		address.setAddress3("adress3");
		address.setUser(user);
		
		/*EntityAddress entityAddress = new EntityAddress();
		entityAddress.setAddress1("ea_address1");
		entityAddress.setType("Default");
		entityAddress.setUserAddress(address);
		List<EntityAddress> entityAddresses = new ArrayList<EntityAddress>();
		entityAddresses.add(entityAddress);
		
		address.setEntityAddresses(entityAddresses);*/
		userProfile.getAddresses().add(address);
		userProfile.setUser(user);
		
		user.setUserProfile(userProfile);
		
		UserBE userBe = new UserBE();  
        userBe.setUser(user);
        
        BusinessEntity be = (BusinessEntity)find(BusinessEntity.class, userId);
        //be.setTypeCode("dealer");
        userBe.setBe(be);
        user.setUserBe(userBe);
        
        LinkedAccount linkedAccount = new LinkedAccount();
        linkedAccount.setProviderUserId("providerUserId");
        linkedAccount.setUser(user);
        List<LinkedAccount> linkedAccounts = new ArrayList<LinkedAccount>();
        user.setLinkedAccounts(linkedAccounts);
        
        
        UserGroup userGroup = new UserGroup();
        Group group = new Group();
        group.setName("Group1");
        userGroup.setGroup(group);
        userGroup.setUser(user);
        
        List<UserGroup> userGroups = new ArrayList<UserGroup>();
        userGroups.add(userGroup);
        user.setUserGroups(userGroups);
        group.setUserGroups(userGroups);
        
        return user;
		
	}

}
