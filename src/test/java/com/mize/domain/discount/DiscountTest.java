package com.mize.domain.discount;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class DiscountTest  extends JPATest {
	EntityManager entityManager;
	Discount discount = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		discount = discountObjectTobeSaved(discount);
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(discount.getId() != null){
			discount = entityManager.merge(discount);
		}else{
			entityManager.persist(discount);
		}
		tx.commit();
	}
	
	private Discount discountObjectTobeSaved(Discount discount) {
		Discount disCnt = new Discount();
		BusinessEntity beEntity = new BusinessEntity();
		beEntity.setId(961L);
		disCnt.setTenant(beEntity);
		disCnt.setDiscountNumber("TEST NUMBER 001");
		disCnt.setMinimumQuantity(BigDecimal.valueOf(5));
		disCnt.setMaximumQuantity(BigDecimal.valueOf(10));
		disCnt.setOrderType("LINE");
		disCnt.setCreatedDate(DateTime.now());
		disCnt.setUpdatedDate(DateTime.now());
		disCnt.setStartDate(DateTime.now());
		disCnt.setEndDate(DateTime.now());
		disCnt.setCreatedBy(disCnt.getId());
		disCnt.setUpdatedBy(disCnt.getId());
		disCnt.setOrderBusinessEntity(beEntity);
		
		List<DiscountComment> comtsList = new ArrayList<DiscountComment>();
		DiscountComment comment = new DiscountComment();
		
		comment.setDiscount(disCnt);
		EntityComment entityComment = new EntityComment();
		entityComment.setComments("Test Coments..");
		entityComment.setCommentType("Internal");
		comment.setEntityComment(entityComment);
		comtsList.add(comment);
		
		disCnt.setComments(comtsList);
		
		return disCnt;
	}
	
	@Test
	public void test() {
		try{
			assertTrue(discount.getId()!=null);
			assert(discount.getId()!=null);
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}

}
