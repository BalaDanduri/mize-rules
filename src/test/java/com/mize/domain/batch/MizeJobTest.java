package com.mize.domain.batch;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

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
import com.mize.domain.util.MizeDateTime;

@ContextConfiguration(locations={"/test-context.xml"})
public class MizeJobTest extends JPATest {

	private static final String MIZE_JOB_QUERY = "select * from mize_job where id = ?";

	EntityManager entityManager = null;
	MizeJob mizeJob = null;
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

		mizeJob = new MizeJob();
		mizeJob.setTenant(tenant);
		populateAuditFields(mizeJob);
		mizeJob.setJobCode("TestMizeJob001");
		mizeJob.setJobName("Test Mize Job 001");
		mizeJob.setJobDescription("Desc: Test Mize Job 001");
		mizeJob.setIsActive("Y");
		
		List<MizeJobParameter> jobParameters = new ArrayList<MizeJobParameter>();
		MizeJobParameter jobParameter = new MizeJobParameter();
		populateAuditFields(jobParameter);
		jobParameter.setParmName("sortKey");
		jobParameter.setParmType("String");
		jobParameter.setParmValue("instance_id");
		jobParameter.setJob(mizeJob);
		jobParameters.add(jobParameter);
		
		jobParameter = new MizeJobParameter();
		populateAuditFields(jobParameter);
		jobParameter.setParmName("selectClause");
		jobParameter.setParmType("String");
		jobParameter.setParmValue("select job_id");
		jobParameter.setJob(mizeJob);
		jobParameters.add(jobParameter);
		mizeJob.setJobParameters(jobParameters);

		entityManager.getTransaction().begin();
		entityManager.persist(mizeJob);
		entityManager.getTransaction().commit();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.getTransaction().begin();
		entityManager.remove(mizeJob);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Test
	public void test() {
		try {
			MizeJob mizeJobDB = jdbcTemplate.queryForObject(MIZE_JOB_QUERY, new MizeJobRowMapper(), new Object[] { mizeJob.getId() });
			assertTrue(mizeJob.getId().equals(mizeJobDB.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got Exception");
			throw e;
		}
	}

	class MizeJobRowMapper implements RowMapper<MizeJob> {
		@Override
		public MizeJob mapRow(ResultSet rs, int arg1) throws SQLException {
			MizeJob mizeJob = new MizeJob();
			mizeJob.setId(rs.getLong("id"));
			mizeJob.setJobCode(rs.getString("job_code"));
			mizeJob.setJobName(rs.getString("job_name"));
			mizeJob.setJobDescription(rs.getString("job_description"));
			mizeJob.setIsActive(rs.getString("is_active"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			mizeJob.setTenant(tenant);
			return mizeJob;
		}
	}
	
	private void populateAuditFields(MizeSceEntity entity) {
		MizeDateTime dateTime = MizeDateTime.now();
		entity.setCreatedDate(dateTime);
		entity.setUpdatedDate(dateTime);
		entity.setCreatedBy(Long.valueOf(1162));
		entity.setUpdatedBy(Long.valueOf(1162));
	}

}
