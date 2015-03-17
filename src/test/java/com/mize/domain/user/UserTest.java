package com.mize.domain.user;

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

import com.mize.domain.auth.LinkedAccount;
import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Country;
import com.mize.domain.common.Gender;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.DateTimeUtils;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations = { "/test-context.xml" })
public class UserTest extends JPATest {

	private static final String USER_QUERY = "select * from users where id=?";
	private static final String USER_PROFILE_QUERY = "select * from user_profile where user_id=?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity businessEntity;
	BusinessEntity tenant;
	User user = null;
	User dbUser = null;
	Group group = null;

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();

	}

	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(user);
		tx.commit();
	}

	private User retrievUser() {
		List<User> users = jdbcTemplate.query(USER_QUERY,
				new Object[] { user.getId() }, new UserRowMapper());
		if (!Formatter.isEmpty(users)) {
			dbUser = users.get(0);
		}
		if (dbUser != null) {
			UserProfile userProfile = jdbcTemplate.queryForObject(
					USER_PROFILE_QUERY, new Object[] { dbUser.getId() },
					new UserProfileRowMapper());
			dbUser.setUserProfile(userProfile);
		}
		return dbUser;
	}

	public User retrievUsers() {
		List<User> dbUsers = jdbcTemplate.query(USER_QUERY,
				new Object[] { user.getId() }, new UserRowMapper());
		if (!Formatter.isEmpty(dbUsers)) {
			dbUser = dbUsers.get(0);
		}
		return dbUser;
	}

	private class UserRowMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User user = new User();
			user.setId(rs.getLong("id"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setLastLogin(DateTimeUtils.toDateTime(rs.getTimestamp("last_login")));
			user.setCreatedDate(DateTimeUtils.toDateTime(rs
					.getTimestamp("created_date")));

			return user;

		}

	}

	private class UserProfileRowMapper implements RowMapper<UserProfile> {

		public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserProfile userProfile = new UserProfile();
			User user = new User();
			user.setId(rs.getLong("id"));
			userProfile.setEmailOptOut(rs.getString("email_opt_out"));
			userProfile.setFirstName(rs.getString("first_name"));
			userProfile.setLastName(rs.getString("last_name"));
			userProfile
					.setBirthdate(new DateTime(Formatter.date2((rs.getDate("birth_day")))));
			userProfile.setGender(Gender.getGender(rs.getString("gender")));

			userProfile.setUser(user);
			return userProfile;
		}

	}

	private void createUserData() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			user = createUser();
			setUserAddress(user);
			setLinkedAccounts(user);
			setUserToGroup(user);
			setUserToBrand(user);
			entityManager.persist(user);
			tx.commit();
		}

	}

	private void createMasterData() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			tenant = createTenant();
			entityManager.persist(tenant);
			// tx.commit()
			businessEntity = createBusinessEntity("dealer");
			businessEntity.setTenant(tenant);
			entityManager.persist(businessEntity);
			tx.commit();
		}
	}

	public void setLinkedAccounts(User user) {
		List<LinkedAccount> linkedAccounts = new ArrayList<LinkedAccount>();
		LinkedAccount linkAccount = new LinkedAccount();
		String password = "Abcd1234";
		linkAccount.setPassword(password);
		linkAccount.setProviderUserId(password);
		linkedAccounts.add(linkAccount);
		user.setLinkedAccounts(linkedAccounts);
	}

	public Group createGroup() {
		/*Group group = new Group();
		group.setOwner(tenant);
		group.setName("Test Admin Group");
		group.setCode("TA" + System.currentTimeMillis());
		group.setActive("Y");
		group.setDescription("Test Admin Group Desc");*/

		return null;
	}

	public void setUserToGroup(User user) {
		List<UserGroup> userGroups = new ArrayList<UserGroup>();
		UserGroup userGroup = new UserGroup();
		userGroup.setUser(user);
		group = createGroup();
		//entityManager.persist(group);
		userGroup.setGroup(group);
		userGroups.add(userGroup);
		user.setUserGroups(userGroups);
	}

	public void setUserAddress(User user) {
		List<UserAddress> addresses = new ArrayList<UserAddress>();
		UserAddress userAddress = new UserAddress();
		userAddress.setUser(user);
		userAddress.setType("PermanentAddress");
		userAddress.setName("Mize");
		userAddress.setCity("Hyderabad");

		Country country = findCountryObjectFromDB();
		userAddress.setCountry(country);
		addresses.add(userAddress);
		user.setAddresses(addresses);

	}
	public void setUserToBrand(User user){
		List<UserBrandMapping> userBrandMapping = new ArrayList<UserBrandMapping>();
		UserBrandMapping userBrand = new UserBrandMapping();
		userBrand.setUser(user);
		Brand brand=findBrandObjectFromDB();
		userBrand.setBrand(brand);
		userBrand.setIsActive("Y");
		userBrandMapping.add(userBrand);
		user.setUserBrandMapping(userBrandMapping);
		
	}

	@Test
	public void saveUserObject() throws Throwable {
		createUserData();
		try {
			if (user != null) {
				dbUser = retrievUser();

				assertTrue(user.getId() != null);
				// assertTrue(user.equals(dbUser));
			}
			tearDown();
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}

	}

	@Test
	public void updateUserObject() throws Throwable {
		createUserData();
		try {
			if (user != null) {
				user.setEmail("Testadmin" + System.currentTimeMillis()
						+ "@mize.com");
				user.setName("MizeTest");
				persist();
				System.out.println(getJsonResponse(user));
				dbUser = retrievUser();
				assertTrue(dbUser != null && dbUser.getId() != null);
				// assertTrue(dbUser.equals(user));

				assertTrue(user.getName().equals("MizeTest"));
			}
			tearDown();
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}

	@Test
	public void deleteUserObject() throws Throwable {
		createUserData();
		try {
			if (user != null) {
				tearDown();
				dbUser = retrievUsers();
				assertNull(dbUser);
			}
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}

	public void tearDown() throws Exception {
		try {
			if (user != null) {
				tx.begin();
				entityManager.remove(user);
				entityManager.remove(tenant);
				entityManager.remove(businessEntity);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
}
