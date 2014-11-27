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

import com.mize.domain.businessentity.BusinessEntity;

import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class WorkQueueTest extends JPATest{

	private static final String WORK_QUEUE_QUERY = "select * from work_queue where id=?";
	private static final String WORK_QUEUE_AUTH_QUERY = "select * from work_queue_auth where id=?";
	EntityManager entityManager;
	BusinessEntity tenant;
	BusinessEntity businessEntity;
	EntityTransaction tx;
	WorkQueue workQueue;
	WorkQueue  dbWorkQueue;
	
	
	@Before
	public void setUp() throws Exception {
		try{
			entityManager = getEntityManager();
			createMasterData();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void persist()
	{
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(workQueue);	
		tx.commit();
	}
	
	private void createMasterData() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			tenant = createTenant();
			entityManager.persist(tenant);
			businessEntity = createBusinessEntity("dealer");
			businessEntity.setTenant(tenant);
			entityManager.persist(businessEntity);
			tx.commit();
		}
	}
	
	private void createWorkQueueObject() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			workQueue = getWorkQueueObjectToBeSaved();
			getWorkQueueAuthObjectToSave(workQueue);
			
			entityManager.persist(workQueue);
			tx.commit();
		}

	}
	
	
	public WorkQueue getWorkQueueObjectToBeSaved() {
		
		workQueue = new WorkQueue();
		workQueue.setCode("Testings");
		workQueue.setName("sirisha");
		workQueue.setDesc("labor");
		workQueue.setIsActive("y");
		workQueue.setTenant(tenant);
		return workQueue;
	}

	private WorkQueue getWorkQueueAuthObjectToSave(WorkQueue workQueue) {
		
		WorkQueueAuth workQueueAuth = new WorkQueueAuth();
		workQueue.getId();
		workQueueAuth.setWorkQueue(workQueue);
		workQueueAuth.setAuthType("company");
		List<WorkQueueAuth>	workList = new ArrayList<WorkQueueAuth>();
		workList.add(workQueueAuth);
		workQueue.setWorkQueueAuths(workList);
		return workQueue;
	}
	
	public class WorkQueueRowMapper implements RowMapper<WorkQueue>
	{

		@Override
		public WorkQueue mapRow(ResultSet rs, int arg1) throws SQLException {
	
			WorkQueue workQ = new WorkQueue();
			workQ.setId(rs.getLong("id"));
			workQ.setCode(rs.getString("code"));
			workQ.setName(rs.getString("name"));
			workQ.setDesc(rs.getString("description"));
			workQ.setIsActive(rs.getString("is_active"));
			BusinessEntity tenant =new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			workQ.setTenant(tenant);
			return workQ;
		}
		
	}
	
	public class WorkQueueAuthRowMapper implements RowMapper<WorkQueueAuth>
	{

		@Override
		public WorkQueueAuth mapRow(ResultSet rs, int arg1)
				throws SQLException {
			
			WorkQueueAuth workAuth = new WorkQueueAuth();
			workAuth.setId(rs.getLong("id"));
			workAuth.setAuthType(rs.getString("auth_type"));
			WorkQueue workQueue = new WorkQueue();
			workQueue.setId(rs.getLong("work_queue_id"));
			workAuth.setWorkQueue(workQueue);
			return workAuth;
		}
		
	}
	
	private WorkQueue retrieveWorkQueue() {
		dbWorkQueue= new WorkQueue();
		dbWorkQueue = jdbcTemplate.queryForObject(WORK_QUEUE_QUERY,
				new Object[] { workQueue.getId() }, new WorkQueueRowMapper());	
		
		if(dbWorkQueue !=null){
			List<WorkQueueAuth> workQList = jdbcTemplate.query(WORK_QUEUE_AUTH_QUERY,
					new Object[] {workQueue.getId() }, new WorkQueueAuthRowMapper());
			dbWorkQueue.setWorkQueueAuths(workQList);
			}
		return dbWorkQueue;
	}

	@Test
	public void saveWorkQueueTest() throws Throwable {
		try
		{
			createWorkQueueObject();
			dbWorkQueue = retrieveWorkQueue();
			assertTrue(dbWorkQueue.getCode().equals(workQueue.getCode()));
			tearDown();
		}
		catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	

	@Test
	public void updateWorkQueueTest() throws Throwable {
		try
		{
			createWorkQueueObject();
			workQueue.setCode("updated code");
			persist();
			dbWorkQueue = retrieveWorkQueue();
			assertTrue(dbWorkQueue.getCode().equals(workQueue.getCode()));
			tearDown();
		}
		catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	public void tearDown() throws Exception {
		if (workQueue != null) {
			tx.begin();
			entityManager.remove(workQueue);
			entityManager.remove(businessEntity);
			entityManager.remove(tenant);
			tx.commit();
		}
		entityManager.close();
	
	}

	

}
