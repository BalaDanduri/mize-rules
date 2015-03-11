package com.mize.domain.discount;

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
import com.mize.domain.datetime.Date;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.DateTimeUtils;

@ContextConfiguration(locations={"/test-context.xml"})
public class DiscountTest  extends JPATest {
	
	private static final String DISCOUNT_QUERY = "select * from discount where id =?";
	private static final String DISCOUNT_COMMENT_QUERY = "select * from discount_comment where discount_id =?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity businessEntity;
	BusinessEntity tenant;
	Discount discount = null;
	Discount dbDiscount = null;
	
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
	}
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(discount);
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

	private void createDiscount() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			discount = discountObjectToSave();
			setDiscountComments(discount);
			entityManager.persist(discount);
			tx.commit();
		}

	}
	private Discount discountObjectToSave() {
		Discount discount = new Discount();
		discount.setTenant(tenant);
		discount.setDiscountNumber("testAdmin"+System.currentTimeMillis());
		discount.setMinimumQuantity(BigDecimal.valueOf(5));
		discount.setMaximumQuantity(BigDecimal.valueOf(10));
		discount.setOrderType("LINE");
		discount.setCreatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		discount.setUpdatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		discount.setStartDate(Date.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		discount.setEndDate(Date.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		discount.setCreatedBy(779l);
		discount.setUpdatedBy(779l);
		discount.setOrderBusinessEntity(businessEntity);
		
		return discount;
	}
	private void setDiscountComments(Discount discount){
		DiscountComment discountComment = new DiscountComment();
		List<DiscountComment> comments = new ArrayList<DiscountComment>();
		EntityComment comment = createEntityComment();
		discountComment.setEntityComment(comment);
		discountComment.setDiscount(discount);
		comments.add(discountComment);
		discount.setComments(comments);
		
	}
	
	public class DiscountRowMapper implements RowMapper<Discount>{

		@Override
		public Discount mapRow(ResultSet rs, int rowNum) throws SQLException {
			Discount discount = new Discount();
			discount.setId(rs.getLong("id"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			discount.setTenant(tenant);
			discount.setDiscountNumber(rs.getString("discount_number"));
			discount.setMinimumQuantity(rs.getBigDecimal("minimum_quantity"));
			discount.setMaximumQuantity(rs.getBigDecimal("maximum_quantity"));
			discount.setOrderType(rs.getString("order_type"));
			discount.setCreatedDate(DateTimeUtils.toDateTime(rs.getTimestamp("created_date")));
			discount.setUpdatedDate(DateTimeUtils.toDateTime(rs.getTimestamp("updated_date")));
			discount.setStartDate(DateTimeUtils.toDate(rs.getTimestamp("start_date")));
			discount.setEndDate(DateTimeUtils.toDate(rs.getTimestamp("end_date")));
			discount.setCreatedBy(rs.getLong("created_by"));
			discount.setUpdatedBy(rs.getLong("updated_by"));
			discount.setOrderBusinessEntity(businessEntity);
			return discount;
		}
		
	}
	
	public class DiscountCommentRowMapper implements RowMapper<DiscountComment> {

		@Override
		public DiscountComment mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			DiscountComment discountComment = new DiscountComment();
			discountComment.setId(rs.getLong("id"));
			EntityComment comment = new EntityComment();
			comment.setId(rs.getLong("comment_id"));
			discountComment.setEntityComment(comment);
			Discount discount = new Discount();
			discount.setId(rs.getLong("discount_id"));
			discountComment.setDiscount(discount);

			return discountComment;
		}

	}
	
	private Discount retrieveDiscount(){
		dbDiscount = jdbcTemplate.queryForObject(DISCOUNT_QUERY, new Object[]{discount.getId()},new DiscountRowMapper());
		if(dbDiscount != null){
			List<DiscountComment> comments = jdbcTemplate.query(DISCOUNT_COMMENT_QUERY, new Object[]{dbDiscount.getId()}, new DiscountCommentRowMapper());
			dbDiscount.setComments(comments);
		}
		return dbDiscount;
	}
	@Test
	public void saveDiscountTest(){
		createDiscount();
		try{
			if(discount != null){
				dbDiscount = retrieveDiscount();
				if(dbDiscount != null){
					assertTrue(dbDiscount.getId()!=null);
					assertTrue(discount.getId()!=null);
					assertTrue(compare(discount, dbDiscount));
				}
				tearDown();
			}else{
				fail("Something happened..");
			}
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
		
		
	}
	
	
	@Test
	public void updateDiscountTest(){
		createDiscount();
		try{
			if(discount != null){
				discount.setDiscountNumber("mizeAdmin"+System.currentTimeMillis());
				discount.setOrderType("Emergency");
				persist();
				dbDiscount = retrieveDiscount();
				if(dbDiscount != null){
					assertTrue(dbDiscount.getId()!=null);
					assertTrue(discount.getId()!=null);
					assertTrue(compare(discount, dbDiscount));
				}
			}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
		
	}
	
	public void tearDown() throws Exception {
		try {
			if (discount != null) {
				tx.begin();
				entityManager.remove(discount);
				entityManager.remove(businessEntity);
				entityManager.remove(tenant);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
	private boolean compare(Discount discount ,Discount dbDiscount){
		if(discount == null && dbDiscount == null){
			return true;
		}
		if(discount == null  ){
			if(dbDiscount != null){
				return false;
			}
		}else if(discount!=null ){
			if(dbDiscount == null){
				return false;
			}
		}
		if(!discount.getId().equals(dbDiscount.getId())){
			return false;
		}
		if(!discount.getOrderType().equals(dbDiscount.getOrderType())){
			return false;
		}
		return true;
	}
	
}
