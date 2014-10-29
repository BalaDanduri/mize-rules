package com.mize.domain.entityparameter;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations = { "/test-context.xml" })
public class EntityParameterTest extends JPATest{
	
	private static final String ENTITY_PARAM_QUERY = "select * from entity_parameter where id = ?";
	private static final String ENTITY_PARAM_ATT_QUERY = "select * from entity_parameter_attribute where parameter_id = ?";
	private static final String ENTITY_PARAM_COMMENT = "select * from  entity_parameter_comment where parameter_id = ?"; 
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity businessEntity;
	BusinessEntity tenant;
	EntityParameter entityParameter = null;
	EntityParameter dbEntityParameter = null;
	
	

	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
	}
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(entityParameter);
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
	private void createEntityParameter() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			entityParameter=entityParamObjectToSave();
			setEntityParamAttributes(entityParameter);
			setEntityParamComment(entityParameter);
			entityManager.persist(entityParameter);
			tx.commit();
		}

	}

	private EntityParameter entityParamObjectToSave() {
		EntityParameter entityParameter=new EntityParameter();
		entityParameter.setTenant(tenant);
		entityParameter.setType("OrderTypeAndLocation");
		entityParameter.setCode("Stock");
		entityParameter.setStartDate(Formatter.toMizeDateTime(DateTime.now()));
		entityParameter.setEndDate(Formatter.toMizeDateTime(DateTime.now().plusMonths(2)));
		entityParameter.setCreatedDate(Formatter.toMizeDateTime(DateTime.now()));
		entityParameter.setUpdatedDate(Formatter.toMizeDateTime(DateTime.now().plusMonths(2)));
		entityParameter.setUpdatedBy(779L);
		entityParameter.setCreatedBy(779L);
		entityParameter.setBeId(businessEntity.getId());

		return entityParameter;
	}
	private void setEntityParamAttributes(EntityParameter entityParameter){
		List<EntityParameterAttribute> attributes = new ArrayList<EntityParameterAttribute>();
		EntityParameterAttribute entityAttribute = new EntityParameterAttribute();
		entityAttribute.setEntityParameter(entityParameter);
		entityAttribute.setCode("ShippingMethod");
		entityAttribute.setValue("Express");
		attributes.add(entityAttribute);
		entityParameter.setAttributes(attributes);
		
	}
	private void setEntityParamComment(EntityParameter entityParameter){
		List<EntityParameterComment> comments = new ArrayList<EntityParameterComment>();
		EntityParameterComment entityParameterComment = new EntityParameterComment();
		entityParameterComment.setEntityParameter(entityParameter);
		
		EntityComment comment = new EntityComment();
		comment.setCommentType("External");
		comment.setComments("test");
		entityManager.persist(comment);
		
		entityParameterComment.setEntityComment(comment);
		comments.add(entityParameterComment);
		entityParameter.setComments(comments);	
	}
	
	private class EntityParameterRowMapper implements RowMapper<EntityParameter> {

		@Override
		public EntityParameter mapRow(ResultSet rs, int rowNum) throws SQLException {
			EntityParameter entityParameter = new EntityParameter();
			entityParameter.setId(rs.getLong("id"));
			BusinessEntity dbTenant = new BusinessEntity();
			dbTenant.setId(rs.getLong("tenant_id"));
			entityParameter.setTenant(dbTenant);
			entityParameter.setType(rs.getString("entity_type"));
			entityParameter.setCode(rs.getString("entity_code"));
			entityParameter.setStartDate(Formatter.toMizeDateTime(rs.getTimestamp("start_date")));
			entityParameter.setEndDate(Formatter.toMizeDateTime(rs.getTimestamp("end_date")));
			entityParameter.setCreatedDate(Formatter.toMizeDateTime(rs.getTimestamp("created_date")));
			entityParameter.setUpdatedDate(Formatter.toMizeDateTime(rs.getTimestamp("updated_date")));
			entityParameter.setUpdatedBy(rs.getLong("updated_by"));
			entityParameter.setCreatedBy(rs.getLong("created_by"));
			entityParameter.setBeId(rs.getLong("entity_be_id"));
			
			return entityParameter;
		}

	}
	
	private class EntityParamAttributeRowMapper implements RowMapper<EntityParameterAttribute>{

		@Override
		public EntityParameterAttribute mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			EntityParameterAttribute entityAttribute = new EntityParameterAttribute();
			entityAttribute.setId(rs.getLong("id"));
			
			EntityParameter entityParameter= new EntityParameter();
			entityParameter.setId(rs.getLong("parameter_id"));
			
			entityAttribute.setEntityParameter(entityParameter);
			entityAttribute.setCode(rs.getString("attribute_code"));
			entityAttribute.setValue(rs.getString("attribute_value"));
			return entityAttribute;
		}
		
	}
	private class EntityParamCommentRowMapper implements RowMapper<EntityParameterComment>{

		@Override
		public EntityParameterComment mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			EntityParameterComment entityParameterComment = new EntityParameterComment();
			entityParameterComment.setId(rs.getLong("id"));

			EntityParameter entityParameter= new EntityParameter();
			entityParameter.setId(rs.getLong("parameter_id"));
			entityParameterComment.setEntityParameter(entityParameter);
			EntityComment comment = new EntityComment();
			comment.setId(rs.getLong("comment_id"));
			entityParameterComment.setEntityComment(comment);
			
			
			return entityParameterComment;
		}
		
	}
	private EntityParameter retrieveEntityParam(){
		dbEntityParameter=jdbcTemplate.queryForObject(ENTITY_PARAM_QUERY,new Object[]{entityParameter.getId()}, new EntityParameterRowMapper());
		
		if(dbEntityParameter != null){
			List<EntityParameterAttribute> entityParameterAttributes=jdbcTemplate.query(ENTITY_PARAM_ATT_QUERY, new Object[]{dbEntityParameter.getId()}, new EntityParamAttributeRowMapper());
			dbEntityParameter.setAttributes(entityParameterAttributes);
		}
		if(dbEntityParameter != null){
			List<EntityParameterComment> entityParameterComments = jdbcTemplate.query(ENTITY_PARAM_COMMENT, new Object[]{dbEntityParameter.getId()}, new EntityParamCommentRowMapper());
			dbEntityParameter.setComments(entityParameterComments);
		}
		
		return dbEntityParameter;
		
	}
	@Test
	public void saveEntityParamObjectTest() {
		createEntityParameter();
		try{
			if(entityParameter != null){
				dbEntityParameter=retrieveEntityParam();
				if(dbEntityParameter!=null){
					assertTrue(compare(entityParameter,dbEntityParameter));
					//assertTrue(dbEntityParameter.equals(entityParameter));
				}
				assertTrue(entityParameter.getId() != null);
			}
			tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
			
		}
	}
	
	@Test
	public void updateEntityParamObjectTest(){
		createEntityParameter();
		try{
			if(entityParameter != null){
				entityParameter.setCode("ONStock");
				entityParameter.setType("OrderType");
				persist();
				dbEntityParameter=retrieveEntityParam();
				if(dbEntityParameter!=null){
					assertTrue(compare(entityParameter,dbEntityParameter));					
				}
			}
			tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}

	
	private boolean compare(EntityParameter entityParameter ,EntityParameter dbEntityParameter){
		if(entityParameter == null && dbEntityParameter == null){
			return true;
		}
		if(entityParameter == null  ){
			if(dbEntityParameter != null){
				return false;
			}
		}else if(entityParameter!=null ){
			if(dbEntityParameter == null){
				return false;
			}
		}
		if(!entityParameter.getId().equals(dbEntityParameter.getId())){
			return false;
		}
		if(!entityParameter.getCode().equals(dbEntityParameter.getCode())){
			return false;
		}
		return true;
	}
	
	public void tearDown() throws Exception {
		try {
			if (entityParameter != null) {
				tx.begin();
				entityManager.remove(entityParameter);
				entityManager.remove(businessEntity);
				entityManager.remove(tenant);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
}
