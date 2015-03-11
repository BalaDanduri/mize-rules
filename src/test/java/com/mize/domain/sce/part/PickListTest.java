package com.mize.domain.sce.part;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.part.Part;
import com.mize.domain.part.PickList;
import com.mize.domain.part.PickListComment;
import com.mize.domain.part.PickListItem;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.DateTimeUtils;

@ContextConfiguration(locations={"/test-context.xml"})
public class PickListTest extends JPATest {
	
	private static final String PICKLIST_QUERY = "select * from picklist where id = ?";
	private static final String PICKLIST_ITEM_QUERY = "select * from picklist_item where picklist_id = ?";
	private static final String PICKLIST_COMMENT = "select * from picklist_comment where picklist_id = ?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity businessEntity;
	BusinessEntity tenant;
	PartTest partTest = new PartTest();
	PickList pickList = null;
	Part part;
	PickList dbPickList = null;
	PickListItem pickListItem =null;
	
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
	}

	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(pickList);
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
			part = partTest.partObjectToSave();
			entityManager.persist(part);
			tx.commit();
		}
	}
	
	private void createPickList() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			pickList = createPartKitObject();
			setPickListItems(part,pickList);
			setPickListComments(pickList);
			entityManager.persist(pickList);
			tx.commit();

		}
	}

	private PickList createPartKitObject() {
		
		PickList pickList = new PickList();
		pickList.setCode("admin"+System.currentTimeMillis());
		pickList.setType("mizeInc");
		pickList.setIsActive("Y");
		pickList.setPickListLocation(businessEntity);
		pickList.setTenant(tenant);
		pickList.setCreatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		pickList.setUpdatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		pickList.setCreatedBy(776l);
		pickList.setUpdatedBy(776L);
		return pickList;
	}
	private void setPickListItems(Part part,PickList pickList){
		PickListItem pickListItem = new PickListItem();
		List<PickListItem> listItems = new ArrayList<PickListItem>();
		pickListItem.setPart(part);
		pickListItem.setPickList(pickList);
		pickListItem.setPartQty(BigDecimal.valueOf(2));
		listItems.add(pickListItem);
		pickList.setListItems(listItems);
		
	}
	private void setPickListComments(PickList pickList){
		PickListComment pickListComment = new PickListComment();
		List<PickListComment> comments = new ArrayList<PickListComment>();
		EntityComment comment = createEntityComment();
		pickListComment.setComment(comment);
		pickListComment.setPickList(pickList);
		comments.add(pickListComment);
		pickList.setComments(comments);
		
	}
	private class PickListRowMapper implements RowMapper<PickList>{

		@Override
		public PickList mapRow(ResultSet rs, int rowNum) throws SQLException {
			PickList pickList = new PickList();
			BusinessEntity be = new BusinessEntity();
			be.setId(rs.getLong("be_id"));
			pickList.setPickListLocation(be);
			pickList.setId(rs.getLong("id"));
			pickList.setIsActive(rs.getString("is_active"));
			pickList.setCode(rs.getString("picklist_code"));
			pickList.setType(rs.getString("picklist_type"));
			pickList.setCreatedBy(rs.getLong("created_by"));
			pickList.setUpdatedBy(rs.getLong("updated_by"));
			pickList.setCreatedDate(DateTimeUtils.toDateTime(rs.getTimestamp("created_date")));
			pickList.setUpdatedDate(DateTimeUtils.toDateTime(rs.getTimestamp("updated_date")));
			return pickList;
		}
	}
		
	private class PickListItemRowMapper implements RowMapper<PickListItem>{

		@Override
		public PickListItem mapRow(ResultSet rs, int rowNum)throws SQLException {
			PickListItem pickListItem = new PickListItem();
			pickListItem.setId(rs.getLong("id"));
			Part part = new Part();
			PickList pickList = new PickList();
			pickList.setId(rs.getLong("picklist_id"));
			part.setId(rs.getLong("part_id"));
			pickListItem.setPartQty(rs.getBigDecimal("part_qty"));
			pickListItem.setPart(part);
			pickListItem.setPickList(pickList);
			return pickListItem;
		}
		
	}
	private class PickListCommentRowMapper implements RowMapper<PickListComment>{

		@Override
		public PickListComment mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			PickListComment pickListComment = new PickListComment();
			EntityComment comment = new EntityComment();
			comment.setId(rs.getLong("id"));
			pickListComment.setComment(comment);
			PickList pickList = new PickList();
			pickList.setId(rs.getLong("picklist_id"));
			pickListComment.setPickList(pickList);	
			return pickListComment;
		}
		
	}
	private PickList retrievePickList(){
		dbPickList=jdbcTemplate.queryForObject(PICKLIST_QUERY,new Object[] { pickList.getId() }, new PickListRowMapper());
		if(dbPickList != null){
			List<PickListItem> pickListItems = jdbcTemplate.query(PICKLIST_ITEM_QUERY, new Object[] { dbPickList.getId() }, new PickListItemRowMapper());
			dbPickList.setListItems(pickListItems);
		}
		if(dbPickList != null){
			List<PickListComment> pickListComments = jdbcTemplate.query(PICKLIST_COMMENT, new Object[] { dbPickList.getId() }, new PickListCommentRowMapper());
			dbPickList.setComments(pickListComments);
		}
		
		return dbPickList;
	}
	
	@Test
	public void savePickListTest()
	{
		createPickList();
		try{
		
		if(pickList != null){
			dbPickList = retrievePickList();
			if(dbPickList != null){
				assertTrue(pickList.getId()!=null);
				assertTrue(compare(pickList, dbPickList));
			}
		}
		tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}
	
	@Test
	public void updatePickListTest()
	{
		createPickList();
		try{
			if(pickList != null){
				pickList.setCode("testAdmin"+System.currentTimeMillis());
				pickList.setType("Mize");
				persist();
				if(pickList!=null){
					dbPickList = retrievePickList();
					if(dbPickList != null){
						assertTrue(pickList.getId()!=null);
						assertTrue(compare(pickList, dbPickList));
					}
					
				}
			}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}
	public void tearDown() throws Exception {
		try {
			if (pickList != null) {
				tx.begin();
				entityManager.remove(pickList);
				entityManager.remove(part);
				entityManager.remove(businessEntity);
				entityManager.remove(tenant);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
	
	private boolean compare(PickList pickList ,PickList dbPickList){
		if(pickList == null && dbPickList == null){
			return true;
		}
		if(pickList == null  ){
			if(dbPickList != null){
				return false;
			}
		}else if(pickList!=null ){
			if(dbPickList == null){
				return false;
			}
		}
		if(!pickList.getId().equals(dbPickList.getId())){
			return false;
		}
		if(!pickList.getCode().equals(dbPickList.getCode())){
			return false;
		}
		return true;
	}
}
