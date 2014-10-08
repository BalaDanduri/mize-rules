package com.mize.domain.reason;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class ReasonTest extends JPATest {
	private static String REASON_QUERY = "select * from reason where id = ?";
	EntityManager entityManager;
	Reason reason;
    
	@Before
	public void setUp() {
		entityManager = getEntityManager();
	}
	
	@After
	public void tearDown() {
		if(reason != null) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(reason);
			tx.commit();
		}
		entityManager.close();
	}
	
	
	@Test
	public void saveReason() {
		try {
			prepareReason();
			
			persist();					
			Reason dbReason = jdbcTemplate.queryForObject(REASON_QUERY, new Object[]{reason.getId()}, new ReasonRowMapper());
			assertTrue(dbReason != null && dbReason.getId() != null);
		}catch(Throwable th) {
			th.printStackTrace();
			tearDown();
			fail("Got Exception");
			throw th;
		}
	}
	
	private void createReason() {
		prepareReason();
		persist();
	}
	
	//@Test
	public void updateServiceEntity() {
		try {
			createReason();			
			reason.setType("SRReopened");
			persist();
			Reason dbReason = jdbcTemplate.queryForObject(REASON_QUERY, new Object[]{reason.getId()}, new ReasonRowMapper());
			assertTrue(dbReason != null && dbReason.getId() != null);
			assertTrue("SRReopened".equals(dbReason.getType()));
			
		} catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class ReasonRowMapper implements RowMapper<Reason> {

		@Override
		public Reason mapRow(ResultSet rs, int rowNum)throws SQLException {
			Reason reason = new Reason();
			reason.setId(rs.getLong("id"));
			
			reason.setTenant(new BusinessEntity(rs.getLong("tenant_id")));
			reason.setCode(rs.getString("reason_code"));
			reason.setCategory(rs.getString("reason_category"));
			reason.setType(rs.getString("reason_type"));
			reason.setIsActive(rs.getString("is_active"));
			
			return reason;
		}
		
	}
	
	private void prepareReason() {
		reason = new Reason();
		reason.setTenant(new BusinessEntity(7624L));
		reason.setCode("RN0001");
		reason.setCategory("SR");
		reason.setType("SRCancelled");
		reason.setIsActive("Y");
		
		reason.setCreatedBy(779L);
		reason.setCreatedDate(DateTime.now());
		reason.setUpdatedBy(779L);
		reason.setUpdatedDate(DateTime.now());
		
		ReasonIntl reasonIntl1 = new ReasonIntl(reason,"Support Request Cancelled",new Locale(1L));
		ReasonIntl reasonIntl2 = new ReasonIntl(reason,"Support Request Cancelled CHN",new Locale(3L));
		List<ReasonIntl> reasonIntls = new ArrayList<ReasonIntl>();
		reasonIntls.add(reasonIntl1);
		reasonIntls.add(reasonIntl2);
		
		reason.setIntls(reasonIntls);
	}
	
		
	private void persist() {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(reason);
		tx.commit();
	}
	
	

}
