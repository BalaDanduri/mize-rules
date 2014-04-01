package com.mize.domain.sce.part;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.part.Part;
import com.mize.domain.part.PickList;
import com.mize.domain.part.PickListComment;
import com.mize.domain.part.PickListItem;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class PickListTest extends JPATest {
	private static final String PICKLIST_QUERY = "select * from picklist where id = ?";
	private static final String PICKLIST_ITEM_QUERY = "select * from picklist_item where id = ?";
	EntityManager entityManager = null;
	PickList pickList = null;
	PickListItem pickListItem =null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		BusinessEntity be = findExistingBE(entityManager);
		pickList = getPickListObjectToSave(be);
		EntityTransaction tx =entityManager.getTransaction();
		tx.begin();
		entityManager.persist(pickList);
		tx.commit();
	}
	

	@Test
	public void test() {
		try {
			List<PickList>  pickLists = jdbcTemplate.query(PICKLIST_QUERY, new Object[]{pickList.getId()}, new PickListRowMapper());	
			if(!Formatter.isEmpty(pickLists)){
				PickList pick = pickLists.get(0);
				assertTrue(pickList.getId().equals(pick.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}

	@Test
	public void testPickListItem(){
	    pickListItem = createPickListItem(pickList);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(pickListItem);
		assertNotNull(pickListItem.getId());
		tx.commit();
		
		List<PickListItem>  pickListItems = jdbcTemplate.query(PICKLIST_ITEM_QUERY, new Object[]{pickListItem.getId()}, new PickListItemRowMapper());
		if(!Formatter.isEmpty(pickListItems)){
			PickListItem pickListItem1 = pickListItems.get(0);
			assertTrue(pickListItem.getId().equals(pickListItem1.getId()));
		}
		
	}
	
	private PickListItem createPickListItem(PickList pickList) {
		Part part =entityManager.find(Part.class, new Long(101));
		PickListItem pickListItem = new PickListItem(part,pickList,new BigDecimal(100.00));
		return pickListItem;
		
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
			pickList.setCreatedDate(Formatter.dateTime(rs.getTimestamp("created_date")));
			pickList.setUpdatedDate(Formatter.dateTime("updated_date"));
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
	
	private PickList getPickListObjectToSave(BusinessEntity be) {
		
		PickList pickList = new PickList();
		pickList.setCode("pickListcode");
		pickList.setType("Standard");
		pickList.setIsActive("Y");
		BusinessEntity tenant = new BusinessEntity();
		tenant.setCode("10C000100P");
		be = new BusinessEntity();
		be.setTypeCode("dealer");
		be.setCode("10C00100P");
		pickList.setPickListLocation(be);
		pickList.setTenant(tenant);
		Part part = new Part();
		part.setCode("Keer111");
		pickListItem = new PickListItem(part, pickList, BigDecimal.valueOf(100));
		List<PickListItem> items = new ArrayList<PickListItem>();
		items.add(pickListItem);
		pickList.setListItems(items);
		List<PickListComment> comtsList = new ArrayList<PickListComment>();
		PickListComment comment = new PickListComment();
		EntityComment entityComment = new EntityComment();
		entityComment.setComments("100-TEST-COMMENTS");
		entityComment.setCommentType("Internal");
		comment.setComment(entityComment);
		comtsList.add(comment);
		pickList.setComments(comtsList);
		
		return pickList;
	}
}
