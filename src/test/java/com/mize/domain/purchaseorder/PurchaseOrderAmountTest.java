package com.mize.domain.purchaseorder;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class PurchaseOrderAmountTest extends JPATest{

	private static final String PURCHASE_ORDER_AMOUNT_QUERY = "select * from purchase_order_amount where id=?";
	EntityManager entityManager;
	EntityTransaction tx;
	PurchaseOrderAmount purchaseOrderAmount;
	PurchaseOrderAmount dbPurchaseOrderAmount;
	
	@Before
	public void setUp() throws Exception {
		try{
			entityManager = getEntityManager();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void persist()
	{
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(purchaseOrderAmount);	
		tx.commit();
	}
	
	private void createPurchaseOrderAmountObject() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			purchaseOrderAmount = getPurchaseOrderAmountObjectToBeSaved();			
			entityManager.persist(purchaseOrderAmount);
			tx.commit();
		}

	}
	
	private PurchaseOrderAmount getPurchaseOrderAmountObjectToBeSaved() {
		
		purchaseOrderAmount = new PurchaseOrderAmount();
		purchaseOrderAmount.setRequestedAmount(Formatter.toBigDecimal(2.0D));
		purchaseOrderAmount.setDiscountAmount(Formatter.toBigDecimal(23.23D));
		purchaseOrderAmount.setHandlingAmount(Formatter.toBigDecimal(123.54D));
		purchaseOrderAmount.setShippingAmount(Formatter.toBigDecimal(70.12D));
		purchaseOrderAmount.setFreightAmount(Formatter.toBigDecimal(23.00D));
		
		return purchaseOrderAmount;
	}
	
	public class PurchaseOrderAmountRowMapper implements RowMapper<PurchaseOrderAmount>
	{

		@Override
		public PurchaseOrderAmount mapRow(ResultSet rs, int arg1)
				throws SQLException {
			PurchaseOrderAmount purchaseOrder = new PurchaseOrderAmount();
			purchaseOrder.setId(rs.getLong("id"));
			purchaseOrder.setRequestedAmount(rs.getBigDecimal("requested_amount"));
			purchaseOrder.setDiscountAmount(rs.getBigDecimal("discount_amount"));
			purchaseOrder.setHandlingAmount(rs.getBigDecimal("handling_amount"));
			purchaseOrder.setShippingAmount(rs.getBigDecimal("shipping_amount"));
			purchaseOrder.setFreightAmount(rs.getBigDecimal("freight_amount"));
			return purchaseOrder;
		}
		
	}

	private PurchaseOrderAmount retrievePurchaseOrderAmount() {
		dbPurchaseOrderAmount= new PurchaseOrderAmount();
		dbPurchaseOrderAmount = jdbcTemplate.queryForObject(PURCHASE_ORDER_AMOUNT_QUERY,
				new Object[] { purchaseOrderAmount.getId() }, new PurchaseOrderAmountRowMapper());	
		
	
		return dbPurchaseOrderAmount;
	}
	
	@Test
	public void savePurchaseOrderTest() throws Throwable {
		try
		{
			createPurchaseOrderAmountObject();
			dbPurchaseOrderAmount = retrievePurchaseOrderAmount();
			assertTrue(dbPurchaseOrderAmount.getId().equals(purchaseOrderAmount.getId()));
			tearDown();
		}
		catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	

	@Test
	public void updateWorkQueueTest() throws Throwable {
		try
		{
			createPurchaseOrderAmountObject();
			purchaseOrderAmount.setDiscountAmount(Formatter.toBigDecimal(10.00D));
			persist();
			dbPurchaseOrderAmount = retrievePurchaseOrderAmount();
			assertTrue(dbPurchaseOrderAmount.getId().equals(purchaseOrderAmount.getId()));
			tearDown();
		}
		catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	
	
	public void tearDown() throws Exception {
		if (purchaseOrderAmount != null) {
			tx.begin();
			entityManager.remove(purchaseOrderAmount);
			tx.commit();
		}
		entityManager.close();
	}


}
