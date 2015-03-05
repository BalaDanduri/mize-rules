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

import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations = { "/test-context.xml" })
public class GroupTest extends JPATest {/*

	
	private static final String GROUP_QUERY = "select * from groups where id=?";
	private static final String GROUP_ROLE_MAPPING_QUERY = "select * from groups_to_role where group_id=?";
	private static final String USER_GROUP_QUERY = "select * from user_to_groups where group_id=?";
	EntityManager entityManager;
	Group group=null;
	EntityTransaction tx;
	Group dbGroup=null;
	List<GroupRoleMapping> groupsToBeRoled;
	GroupRoleMapping groups;
	Role role;
	List<Role> rList;
	BusinessEntity businessEntity;
	UserGroup userGroup=null;
	List<UserGroup> userGroupList;
	BusinessEntity tenant;
	User user ;
	
   
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
		group = saveGroupObject();
	}
	
	public void createMasterData(){
		tx = entityManager.getTransaction();
		tx.begin();
		tenant = createTenant();
		role = createRole();
		user = createUser();
		entityManager.persist(tenant);
		entityManager.persist(role);
		entityManager.persist(user);
		tx.commit();
	}
	
	
	private void persist()
	{
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(group);
		tx.commit();
	}
	private void createGroup() {
		group = saveGroupObject();
		persist();
	}
	
	private Group saveGroupObject()
	{

		Group new_group = new Group();
		new_group.setOwner(tenant);
		new_group.setName("Test Admin Group");
		new_group.setCode("TA" + System.currentTimeMillis());
		new_group.setActive("Y");
		new_group.setDescription("Test Admin Group Desc");
		
		groupsToBeRoled = new ArrayList<GroupRoleMapping>();
		groups = new GroupRoleMapping();
		groups.setGroup(new_group);
		groups.setActive("y");
		
		groups.setRole(role);
		groupsToBeRoled.add(groups);
		new_group.setGroupsToRole(groupsToBeRoled);
		
		userGroupList=new ArrayList<UserGroup>();
		userGroup = new UserGroup();
		
		userGroup.setUser(user);
		//group.getId();
		userGroup.setGroup(new_group);
		userGroupList.add(userGroup);
		
		new_group.setUserGroups(userGroupList);
		
		return new_group;
		
	}
	
	public Group retrievGroup() {
		dbGroup = jdbcTemplate.queryForObject(GROUP_QUERY,
				new Object[] { group.getId() }, new GroupRowMapper());

		if(dbGroup!=null){
		List<GroupRoleMapping> groupList = jdbcTemplate.query(GROUP_ROLE_MAPPING_QUERY,
				new Object[] { dbGroup.getId() }, new GroupRoleMappingRowMapper());
		dbGroup.setGroupsToRole(groupList);
		}
		if(dbGroup!=null){
			List<UserGroup> userGroups = jdbcTemplate.query(USER_GROUP_QUERY,new Object[]{dbGroup.getId()},new UserGroupRowMapper());
			dbGroup.setUserGroups(userGroups);
		}
		return dbGroup;
     }
	
	
	
	public Group retrievGroups() {
		List<Group> dbGroups = jdbcTemplate.query(GROUP_QUERY,new Object[] { group.getId() }, new GroupRowMapper());
		if(!Formatter.isEmpty(dbGroups)){
			dbGroup =  dbGroups.get(0);
		}
		return dbGroup;
	}

	private class GroupRowMapper implements RowMapper<Group> {

		
		public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
			Group group=new Group();
			BusinessEntity tenant=new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			
			group.setId(rs.getLong("id"));
			group.setName(rs.getString("group_name"));
			group.setDescription(rs.getString("description"));
			group.setCode(rs.getString("code"));
			group.setActive(rs.getString("active_indicator"));
			group.setOwner(tenant);
			
		return group;
		}
		
		
		
	}
	
private class GroupRoleMappingRowMapper implements RowMapper<GroupRoleMapping> {

		
		public GroupRoleMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
			Group group=new Group();
			GroupRoleMapping groupRole = new GroupRoleMapping();
			group.setId(rs.getLong("id"));
			groupRole.setGroup(group);
			groupRole.setActive(rs.getString("active_indicator"));
			 role = createRole();
			 role.setId(rs.getLong("id"));
			 groupRole.setRole(role);
		return groupRole;
		}
		
		
		
	}

	
	private class UserGroupRowMapper implements RowMapper<UserGroup>
	{

	
		public UserGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserGroup userGroup=new UserGroup();
			User user=new User();
			user.setId(rs.getLong("id"));
			userGroup.setUser(user);
			
			Group group=new Group();
			group.setId(rs.getLong("id"));
			userGroup.setGroup(group);
			return userGroup;
		}
		
	}
	
	@Test
	public void saveGroup() throws Throwable {
		persist();
		try {
			dbGroup = retrievGroup();
			if (dbGroup != null) {

				assertTrue(dbGroup.getCode().equals(group.getCode()));
				System.out.println(getJsonResponse(group));
				System.out.println(getJsonResponse(dbGroup));
				tearDown();
			}
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}

	@Test
	public void updateGroup() throws Throwable {
		try {
			createGroup();
			group.setCode("new code");
			group.setDescription("Updated desc");
			persist();
			System.out.println(getJsonResponse(group));
			dbGroup = retrievGroup();
			assertTrue(dbGroup != null && dbGroup.getId() != null);
			assertTrue(dbGroup.getCode().equals(group.getCode()));
			tearDown();
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	@Test
	public void deleteGroup() throws Throwable {
		try{
			createGroup();
			//tx.begin();
			//entityManager.remove(group);
			tearDown();
			dbGroup=retrievGroups();
			assertNull(dbGroup);
			System.out.println(getJsonResponse(group));
			
		}catch (Throwable th) {
			th.printStackTrace();
			tearDown();
			fail("Got Exception");
			throw th;
		}
			
	}
	public void tearDown() throws Exception {
		
		if (group != null) {
			tx.begin();
			entityManager.remove(group);
			entityManager.remove(user);
			entityManager.remove(tenant);
			tx.commit();
		}
		if(role !=null){
			tx.begin();
			role = entityManager.merge(role);
			entityManager.remove(role);
			tx.commit();
		}
		entityManager.close();
	}

	public Role createRole(){
		Role role = new Role();
		role.setName("Test_Admin_Save");
		role.setDescription("Test Admin - Save");
		role.setCode("RL"+System.currentTimeMillis());
		role.setActive("Y");
		role.setCreatedBy(1l);
		role.setUpdatedBy(1l);
		return role;
	}
*/}
