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
public class WorkQueueEntityHistoryTest extends JPATest{

	private static final String WORK_QUEUE_ENTITY_HISTORY_QUERY = "select * from work_queue_entity_history where id=?";
	EntityManager entityManager;
	BusinessEntity tenant;
	BusinessEntity businessEntity;
	EntityTransaction tx;
	WorkQueue workQueue;
	WorkQueueEntityHistory workQHistory;
	WorkQueueEntityHistory  dbWorkQHistory;
	
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
	entityManager.persist(workQHistory);	
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

private void createWorkQueueHistoryObject() {
	if (entityManager != null) {
		tx = entityManager.getTransaction();
		tx.begin();
		workQHistory = getWorkQHistoryObjectToBeSaved();		
		entityManager.persist(workQHistory);
		tx.commit();
	}

}

	private WorkQueueEntityHistory getWorkQHistoryObjectToBeSaved() {
	
		workQHistory = new WorkQueueEntityHistory();
		workQHistory.setEntityCode("CODE123");
		workQHistory.setStatus("COMPLETED");
		workQueue = findById(386L, WorkQueue.class, entityManager);
		workQHistory.setWorkQueue(workQueue);
	
	return workQHistory;
}

	public class WorkQueueHistoryRoWMapper implements RowMapper<WorkQueueEntityHistory>
	{

		@Override
		public WorkQueueEntityHistory mapRow(ResultSet rs, int arg1)
				throws SQLException {
			WorkQueueEntityHistory workHistory = new WorkQueueEntityHistory();
			workHistory.setId(rs.getLong("id"));
			workHistory.setEntityCode(rs.getString("entity_code"));
			workHistory.setStatus(rs.getString("entity_status"));
			WorkQueue workQ = new WorkQueue();
			workQ.setId(rs.getLong("work_queue_id"));
			workHistory.setWorkQueue(workQ);
			return workHistory;
		}
		
	}
	
	private WorkQueueEntityHistory retrieveWorkQueueHistory() {
		dbWorkQHistory= new WorkQueueEntityHistory();
		dbWorkQHistory = jdbcTemplate.queryForObject(WORK_QUEUE_ENTITY_HISTORY_QUERY,
				new Object[] { workQHistory.getId() }, new WorkQueueHistoryRoWMapper());
		return dbWorkQHistory;	
		
	}

	@Test
	public void saveWorkQueueTest() throws Throwable {
		try
		{
			createWorkQueueHistoryObject();
			dbWorkQHistory = retrieveWorkQueueHistory();
			assertTrue(dbWorkQHistory.equals(workQHistory));
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
			createWorkQueueHistoryObject();
			workQHistory.setEntityCode("UPDATED CODE");
			persist();
			dbWorkQHistory = retrieveWorkQueueHistory();
			assertTrue(dbWorkQHistory.equals(workQHistory));
			tearDown();
		}
		catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	public void tearDown() throws Exception {
		if (workQHistory != null) {
			tx.begin();
			entityManager.remove(workQHistory);
			entityManager.remove(businessEntity);
			entityManager.remove(tenant);
			tx.commit();
		}
		entityManager.close();
	}

	

}
