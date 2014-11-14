package com.mize.domain.common;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.test.util.JPATest;
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
			offline.setEntityType(rs.getString("entity_type"));
			offline.setEntityCode(rs.getString("entity_code"));
			return offline;
		}
	}
	
	private EntityOffline entityToBeSaved() {
		EntityOffline entity = new EntityOffline();
		entity.setEntityType("#INSP#" + System.currentTimeMillis());
		entity.setEntityCode("InspectionForm");
		return entity;
	}
		
}
