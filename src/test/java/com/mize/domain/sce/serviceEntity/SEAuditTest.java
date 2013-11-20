package com.mize.domain.sce.serviceEntity;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.serviceentity.SEAudit;
import com.mize.domain.serviceentity.ServiceEntity;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class SEAuditTest extends JPATest{
	private static final String SE_AUDIT_QUERY = "select * from service_entity_audit where id = ?";
	EntityManager entityManager = null;
	SEAudit sEAudit = null;
	ServiceEntity serviceEntity = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		sEAudit = findExistingSEAudit(entityManager);
		this.sEAudit = getSEAuditObjectToSave(sEAudit);
		EntityTransaction tx =entityManager.getTransaction();
		tx.begin();
		entityManager.persist(sEAudit);
		tx.commit();
	}

	@Test
	public void test() {
		try {
			List<SEAudit> audits = jdbcTemplate.query(SE_AUDIT_QUERY, new Object[]{sEAudit.getId()}, new SEAuditRowMapper());
			if(!Formatter.isEmpty(audits)){
				SEAudit sEAudits = audits.get(0);
				assertTrue(sEAudit.getId().equals(sEAudits.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class SEAuditRowMapper implements RowMapper<SEAudit> {
		@Override
		public SEAudit mapRow(ResultSet rs, int rowNum) throws SQLException {
			SEAudit sEAudit = new SEAudit();
			sEAudit.setId(rs.getLong("id"));
			sEAudit.setEntityId(rs.getLong("entity_id"));
			sEAudit.setStatusBy(rs.getLong("status_by"));
			sEAudit.setStatusCode(rs.getString("status_code"));
			sEAudit.setStatusDate(Formatter.dateTime(rs.getTimestamp("status_date")));
			return sEAudit;
		}
	}
	
	private SEAudit getSEAuditObjectToSave(SEAudit sEAudit) {
		SEAudit audit = new SEAudit(Long.valueOf(12),serviceEntity,"statusCode",null,Long.valueOf(801),"raghu");
		return audit;
	}
}

