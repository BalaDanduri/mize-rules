package com.mize.domain.purchaseorder;

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
import com.mize.domain.common.EntityAttachment;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.Locale;
import com.mize.domain.shipping.ShipmentTracking;
import com.mize.domain.test.util.JPATest;




@ContextConfiguration(locations={"/test-context.xml"})
public class PurchaseOrderTest extends JPATest {
	private static final String SERVICE_ENTITY_QUERY = "select * from purchase_order where id = ?";
	PurchaseOrder  purchaseOrder;
	EntityManager entityManager;
	BusinessEntity tenant;
	BusinessEntity businessEntity;
	EntityTransaction tx;
	PurchaseOrder  dbPurchaseOrder;
	PurchaseOrderItem purchaseOrderItem;
	
	@Before
	public void setUp(){
		try{
			entityManager = getEntityManager();
			createMasterData();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void persist()
	{
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(purchaseOrder);	
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

	private void createPurchaseOrderObject() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			purchaseOrder = getPurchaseOrderObjectToBeSaved();
			getPurchaseOrderTrackingObjectToSave(purchaseOrder);
			getPurchaseOrderAuditObjectToBeSave(purchaseOrder);
			getPurchaseOrderAttachmentObjectToBeSaved(purchaseOrder);
			getPurchaseOrderCommentObjectToBeSaved(purchaseOrder);
			getPurchaseOrderMessageObjectToBeSaved(purchaseOrder);
			getPurchaseOrderItemObjectToBeSaved(purchaseOrder);
			
			entityManager.persist(purchaseOrder);
			tx.commit();
		}

	}
	private PurchaseOrder getPurchaseOrderObjectToBeSaved() {
		purchaseOrder = new PurchaseOrder();
		purchaseOrder.setTenant(tenant);
		purchaseOrder.setNumber("number1");
		purchaseOrder.setType("TYPE1");
		purchaseOrder.setRequestType("REQUEST1");
		purchaseOrder.setStatus("delivered");
		purchaseOrder.setCurrencyCode("dol");
		Locale locale = findById(1L, Locale.class, entityManager);
		purchaseOrder.setLocale(locale);
		PurchaseOrderAmount purchaseAmount = getPurchaseOrderAmount();
		purchaseOrder.setAmount(purchaseAmount);		
		return purchaseOrder;
	}

	private PurchaseOrder getPurchaseOrderMessageObjectToBeSaved(PurchaseOrder purchaseOrder) {
		PurchaseOrderMessage purchaseMessage = new PurchaseOrderMessage();
		List<PurchaseOrderMessage> messageList = new ArrayList<PurchaseOrderMessage>();
		purchaseMessage.setPurchaseOrder(purchaseOrder);
		purchaseMessage.setField("FIELD1");
		purchaseMessage.setSeverity(5);
		messageList.add(purchaseMessage);
		purchaseOrder.setMessages(messageList);
		return purchaseOrder;
	}

	private PurchaseOrder getPurchaseOrderCommentObjectToBeSaved(PurchaseOrder purchaseOrder) {

		PurchaseOrderComment purchaseComment = new PurchaseOrderComment();
		List<PurchaseOrderComment> commentList = new ArrayList<PurchaseOrderComment>();
		purchaseComment.setPurchaseOrder(purchaseOrder);
		EntityComment comment = createEntityComment();
		purchaseComment.setComment(comment);
		commentList.add(purchaseComment);
		purchaseOrder.setComments(commentList);

		return purchaseOrder;

	}

	private PurchaseOrder getPurchaseOrderAttachmentObjectToBeSaved(PurchaseOrder purchaseOrder) {

		PurchaseOrderAttachment purchaseAttachment = new PurchaseOrderAttachment();
		List<PurchaseOrderAttachment> attachmentList = new ArrayList<PurchaseOrderAttachment>();
		EntityAttachment attachment =  getAttachement();
		purchaseAttachment.setAttachment(attachment);
		purchaseAttachment.setPurchaseOrder(purchaseOrder);
		attachmentList.add(purchaseAttachment);
		purchaseOrder.setAttachments(attachmentList);
		return purchaseOrder;


	}

	private EntityAttachment getAttachement() {
		EntityAttachment entityAttachment = new EntityAttachment();
		entityAttachment.setName("Sys_" +System.currentTimeMillis());
		entityAttachment.setType("file");
		return entityAttachment;
	}

	private PurchaseOrder getPurchaseOrderAuditObjectToBeSave(PurchaseOrder purchaseOrder) {

		PurchaseOrderAudit purchaseAudit = new PurchaseOrderAudit();
		purchaseAudit.setStatusCode("code1");
		purchaseAudit.setPurchaseOrder(purchaseOrder);
		return purchaseOrder;


	}
	
	private PurchaseOrder getPurchaseOrderTrackingObjectToSave(PurchaseOrder purchaseOrder) {
		PurchaseOrderTracking purchaseTracking = new PurchaseOrderTracking();
		List<PurchaseOrderTracking> trackList = new ArrayList<PurchaseOrderTracking>();
		ShipmentTracking shipment = findById(110L, ShipmentTracking.class,entityManager);
		purchaseTracking.setShipment(shipment);
		purchaseTracking.setPurchaseOrder(purchaseOrder);
		trackList.add(purchaseTracking);
		purchaseOrder.setOrderTrackings(trackList);
		return purchaseOrder;

	}

	private PurchaseOrder getPurchaseOrderItemObjectToBeSaved(PurchaseOrder purchaseOrder) {
		 purchaseOrderItem = new PurchaseOrderItem();
		List<PurchaseOrderItem> itemList = new ArrayList<PurchaseOrderItem>();
		PurchaseOrderAmount amount =getPurchaseOrderAmount();
		purchaseOrderItem.setAmount(amount);
		purchaseOrderItem.setPurchaseOrder(purchaseOrder);
		purchaseOrderItem.setName("TAB");
		purchaseOrderItem.setOrderType("online");
		
		PurchaseOrderItemWarehourse purchaseWareHouse = new PurchaseOrderItemWarehourse();
		List<PurchaseOrderItemWarehourse> wareHouseList = new ArrayList<PurchaseOrderItemWarehourse>();
		purchaseWareHouse.setCode("CODE1");
		purchaseWareHouse.setName("WAREHOUSE");
		purchaseWareHouse.setStatus("delivered");
		purchaseWareHouse.setOrderItem(purchaseOrderItem);
		wareHouseList.add(purchaseWareHouse);
		purchaseOrderItem.setWarehourses(wareHouseList);
		
		itemList.add(purchaseOrderItem);
		purchaseOrder.setOrderItems(itemList);
		
		return purchaseOrder;
	}
	
	public PurchaseOrderAmount getPurchaseOrderAmount(){
		PurchaseOrderAmount amount = new PurchaseOrderAmount();
		amount.setAdjustedAmount(new BigDecimal(2));
		amount.setTotalAmount(new BigDecimal(3));
		amount.setTaxAmount(new BigDecimal(4));
		return amount;
	}
	
	public class PurchaseOrderRowMapper implements RowMapper<PurchaseOrder>
	{

		@Override
		public PurchaseOrder mapRow(ResultSet rs, int arg1)
				throws SQLException {
			PurchaseOrder purchase = new PurchaseOrder();
			purchase.setId(rs.getLong("id"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			purchase.setTenant(tenant);
			purchase.setNumber(rs.getString("order_number"));
			purchase.setType(rs.getString("order_type"));
			purchase.setRequestType(rs.getString("request_type"));
			purchase.setStatus(rs.getString("order_status"));
			purchase.setCurrencyCode(rs.getString("currency_code"));
			Locale locale = new Locale();
			locale.setId(rs.getLong("locale_id"));
			purchase.setLocale(locale);
			PurchaseOrderAmount purchaseAmount = new PurchaseOrderAmount();
			purchaseAmount.setId(rs.getLong("amount_id"));
			purchase.setAmount(purchaseAmount);
			
			return purchase;
		}
		
	}
	
	private PurchaseOrder retrievePurchaseOrder() {
		dbPurchaseOrder = new PurchaseOrder();
		dbPurchaseOrder = jdbcTemplate.queryForObject(SERVICE_ENTITY_QUERY,
				new Object[] { purchaseOrder.getId() }, new PurchaseOrderRowMapper());	
		
		/*if(dbWorkQueue !=null){
			List<WorkQueueAuth> workQList = jdbcTemplate.query(WORK_QUEUE_AUTH_QUERY,
					new Object[] {workQueue.getId() }, new WorkQueueAuthRowMapper());
			dbWorkQueue.setWorkQueueAuths(workQList);
			}*/
		return dbPurchaseOrder;
	}


	@Test
	public void SavePurchaseOrderTest() throws Throwable {
		try {
			createPurchaseOrderObject();
			dbPurchaseOrder = retrievePurchaseOrder();
			assertTrue(dbPurchaseOrder.getId().equals(purchaseOrder.getId()));
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
			createPurchaseOrderObject();
		    purchaseOrder.setNumber("updated");
			persist();
			dbPurchaseOrder = retrievePurchaseOrder();
			assertTrue(dbPurchaseOrder.getId().equals(purchaseOrder.getId()));
			tearDown();
		}
		catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	public void tearDown() throws Exception {
		if (purchaseOrder != null) {
			tx.begin();
			//entityManager.remove(purchaseOrderItem);
			entityManager.remove(purchaseOrder);
			entityManager.remove(businessEntity);
			entityManager.remove(tenant);
			tx.commit();
		}
		entityManager.close();
	
	}	

	
	
	
}
