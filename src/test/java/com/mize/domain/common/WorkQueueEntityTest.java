package com.mize.domain.common;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class WorkQueueEntityTest extends JPATest{

	private static final String WORK_QUEUE_ENTITY_QUERY = "select * from work_queue_entity where id=?";
	EntityManager entityManager;
	BusinessEntity tenant;
	BusinessEntity businessEntity;
	EntityTransaction tx;
	WorkQueueEntity workQEntity;
	WorkQueueTest workQTest  = new WorkQueueTest();
	WorkQueue workQueue;
	WorkQueueEntity dbWorkQEntity;
	
	@Before
	public void setUp() throws Exception {
		try{
		entityManager = getEntityManager();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	public void persist()
	{
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(workQEntity);	
		tx.commit();
	}

	
	private void createWorkQueueEntityObject() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			workQEntity = getWorkQueueEntityObjectToBeSaved(workQEntity);			
			entityManager.persist(workQEntity);
			tx.commit();
		}

	}
	private WorkQueueEntity getWorkQueueEntityObjectToBeSaved(
			WorkQueueEntity workQEntity) {
		workQEntity = new WorkQueueEntity();
		workQEntity.setEntityCode("MIZE");
		workQEntity.setEntityType("TYPE7");
		workQueue = findById(386L, WorkQueue.class, entityManager);
		workQEntity.setWorkQueue(workQueue);
		return workQEntity;
	}
	

	public class WorkQueueEntityRowMapper implements RowMapper<WorkQueueEntity>
	{

		@Override
		public WorkQueueEntity mapRow(ResultSet rs, int arg1)
				throws SQLException {
			WorkQueueEntity workEntity = new WorkQueueEntity();
			workEntity.setId(rs.getLong("id"));
			workEntity.setEntityCode(rs.getString("entity_code"));
			workEntity.setEntityType(rs.getString("entity_type"));
			WorkQueue workQ = new WorkQueue();
			workQ.setId(rs.getLong("work_queue_id"));
			workEntity.setWorkQueue(workQueue);
			return workEntity;
		}
		
	}

	private WorkQueueEntity retrieveWorkQueueEntity() {
		dbWorkQEntity= new WorkQueueEntity();
		dbWorkQEntity = jdbcTemplate.queryForObject(WORK_QUEUE_ENTITY_QUERY,
				new Object[] { workQEntity.getId() }, new WorkQueueEntityRowMapper());	
		
		
		return dbWorkQEntity;
	}
	
	@Test
	public void saveWorkQueueEntityTest() throws Throwable {
		try
		{
			createWorkQueueEntityObject();
			dbWorkQEntity = retrieveWorkQueueEntity();
			assertTrue(dbWorkQEntity.equals(workQEntity));
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
			createWorkQueueEntityObject();
			workQEntity.setEntityType("updated now");
			persist();
			dbWorkQEntity = retrieveWorkQueueEntity();
			assertTrue(dbWorkQEntity.equals(workQEntity));
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
			entityManager.remove(workQEntity);
			tx.commit();
		}
		entityManager.close();
	
	}

	
}
