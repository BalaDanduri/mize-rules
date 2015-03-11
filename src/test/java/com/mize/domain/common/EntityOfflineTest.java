package com.mize.domain.common;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTimeZone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.DateTimeUtils;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class EntityOfflineTest extends JPATest {
	private static final String ENTITY_OFFLINE_QUERY = "select * from entity_offline where id = ?";
	EntityManager entityManager;
	EntityOffline entityOffline = null;
	EntityTransaction tx = null;
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		entityOffline = entityToBeSaved();
		tx = entityManager.getTransaction();
		tx.begin();
		if(entityOffline.getId() != null){
			entityOffline = entityManager.merge(entityOffline);
		}else{
			entityManager.persist(entityOffline);
		}
		tx.commit();
	}

	
	
	@Test
	public void test() {
		try {
			List<EntityOffline>  offlines = jdbcTemplate.query(ENTITY_OFFLINE_QUERY, new Object[]{entityOffline.getId()}, new EntityOfflineRowMapper());
			if(!Formatter.isEmpty(offlines)){
				EntityOffline offline = offlines.get(0);
				assertTrue(entityOffline.getId().equals(offline.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	
	@After
	public void tearDown(){
		if(entityOffline !=null && Formatter.longValue(entityOffline.getId())>0){
			if(entityManager !=null ){
				tx = entityManager.getTransaction();
				tx.begin();
				entityManager.remove(entityOffline);
				tx.commit();
			}
		}
	}
	
	private class EntityOfflineRowMapper implements RowMapper<EntityOffline> {
		@Override
		public EntityOffline mapRow(ResultSet rs, int rowNum) throws SQLException {
			EntityOffline offline = new EntityOffline();
			offline.setId(rs.getLong("id"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			offline.setEntityId(rs.getLong("entity_id"));
			offline.setEntityType(rs.getString("entity_type"));
			offline.setEntityCode(rs.getString("entity_code"));
			offline.setCreatedDate(DateTimeUtils.toDateTime(rs.getTimestamp("created_date")));
			offline.setUpdatedDate(DateTimeUtils.toDateTime(rs.getTimestamp("updated_date")));
			offline.setUpdatedByUser(rs.getString("updated_by_user"));
			offline.setCreatedByUser(rs.getString("created_by_user"));
			return offline;
		}
	}
	
	private EntityOffline entityToBeSaved() {
		EntityOffline entity = new EntityOffline();
		BusinessEntity tenant = new BusinessEntity();
		tenant.setId(7624L);
		entity.setTenant(tenant);
		entity.setEntityId(543L);
		entity.setEntityType("#INSP#" + System.currentTimeMillis());
		entity.setEntityCode("InspectionForm");
		entity.setCreatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		entity.setUpdatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		entity.setUpdatedByUser("shivasheguri@m-ize.com");
		entity.setCreatedByUser("shivasheguri@m-ize.com");
		return entity;
	}
		
}
