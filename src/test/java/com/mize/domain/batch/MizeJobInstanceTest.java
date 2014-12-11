package com.mize.domain.batch;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.joda.time.DateTimeZone;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.MizeDateTime;

@ContextConfiguration(locations={"/test-context.xml"})
public class MizeJobInstanceTest extends JPATest {

	private static final String MIZE_JOB_INSTANCE_QUERY = "select * from mize_job_instance where id = ?";

	EntityManager entityManager = null;
	MizeJobInstance jobInstance = null;
	BusinessEntity tenant = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		tenant = findExistingBE(entityManager);

		jobInstance = new MizeJobInstance();
		jobInstance.setTenant(tenant);
		populateAuditFields(jobInstance);
		
		MizeJob mizeJob = entityManager.find(MizeJob.class, 2L);
		
		jobInstance.setJob(mizeJob);
		jobInstance.setInstanceCode("TestMizeJobInst001");
		jobInstance.setInstanceName("Test Mize Job Inst 001");
		jobInstance.setNextRunTime(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		jobInstance.setJobStatus("RUNNING");
		jobInstance.setIsActive("Y");
		
		MizeJobSchedule schedule = new MizeJobSchedule();
		populateAuditFields(schedule);
		schedule.setJobInstance(jobInstance);
		schedule.setExpr("0 15 10 ? * *");
		jobInstance.setSchedule(schedule);

		entityManager.getTransaction().begin();
		entityManager.persist(jobInstance);
		entityManager.getTransaction().commit();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.getTransaction().begin();
		entityManager.remove(jobInstance);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Test
	public void test() {
		try {
			MizeJobInstance jobInstanceDB = jdbcTemplate.queryForObject(MIZE_JOB_INSTANCE_QUERY, new MizeJobRowMapper(), new Object[] { jobInstance.getId() });
			//assertEquals(jobInstance, jobInstanceDB);
			assertTrue(jobInstance.getId().equals(jobInstanceDB.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got Exception");
			throw e;
		}
	}

	class MizeJobRowMapper implements RowMapper<MizeJobInstance> {
		@Override
		public MizeJobInstance mapRow(ResultSet rs, int arg1) throws SQLException {
			MizeJobInstance jobInstance = new MizeJobInstance();
			jobInstance.setId(rs.getLong("id"));
			jobInstance.setInstanceCode(rs.getString("instance_code"));
			jobInstance.setInstanceName(rs.getString("instance_name"));
			jobInstance.setLastRunTime(Formatter.toMizeDateTime(rs.getTimestamp("last_run")));
			jobInstance.setNextRunTime(Formatter.toMizeDateTime(rs.getTimestamp("next_run")));
			jobInstance.setJobStatus(rs.getString("job_status"));
			jobInstance.setIsActive(rs.getString("is_active"));
			return jobInstance;
		}
	}
	
	private void populateAuditFields(MizeSceEntity entity) {
		entity.setCreatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		entity.setUpdatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		entity.setCreatedBy(Long.valueOf(779));
		entity.setUpdatedBy(Long.valueOf(779));
	}

}
