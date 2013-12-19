package com.mize.domain.purchaseorder;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.user.UserBE;
import com.mize.domain.util.Formatter;


@ContextConfiguration(locations={"/test-context.xml"})
public class PurchaseOrderTest extends JPATest {
	private static final String SERVICE_ENTITY_QUERY = "select * from purchase_order where id = ?";
	EntityManager entityManager = null;
	PurchaseOrder  purchaseOrder = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		purchaseOrder = findById(1l,PurchaseOrder.class,entityManager);
		this.purchaseOrder = getPurchaseOrderOjectToSave(purchaseOrder);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(purchaseOrder.getId() == null){
			entityManager.persist(purchaseOrder);	
		}else{
			purchaseOrder = entityManager.merge(purchaseOrder);
		}		
		tx.commit();
	}

	@Test
	public void testSavePurchaseOrder() {
		try {
			List<PurchaseOrder> purchaseOrders = jdbcTemplate.query(SERVICE_ENTITY_QUERY, new Object[]{purchaseOrder.getId()}, new PurchaseOrderRowMapper());
			if(!Formatter.isEmpty(purchaseOrders)){
				PurchaseOrder order = purchaseOrders.get(0);
				assertTrue(purchaseOrder.getId().equals(order.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class PurchaseOrderRowMapper implements RowMapper<PurchaseOrder> {
		@Override
		public PurchaseOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
			PurchaseOrder order = new PurchaseOrder();
			order.setId(rs.getLong("id"));	
			return order;
		}
	}
	
	
	private PurchaseOrder getPurchaseOrderOjectToSave(PurchaseOrder order) {
		if(order == null){
			order = new PurchaseOrder();
			order.setNumber(System.currentTimeMillis()+"");
		}
		order.setStatus(PurchaseOrder.Status.Draft.toString());
		order.setLocale(new Locale(1l));
		order.setCurrencyCode("Dollar");
		order.setRequestType("Back_Order");
		PurchaseOrderRequester requester = new PurchaseOrderRequester();
		BusinessEntity businessEntity = new BusinessEntity();
		businessEntity.setId(961L);
		User user = new User();
		user.setId(785l);
		UserBE be = new UserBE();
		be.setBeId(961l);
		user.setUserBe(be);
		businessEntity = entityManager.find(BusinessEntity.class, businessEntity.getId());
		requester.setBusinessEntity(businessEntity);
		EntityAddress address = new EntityAddress();
		address.setAddress1("test1");
		address.setAddress2("test2");
		order.setRequester(requester);
		
		
		PurchaseOrderItem  item = new PurchaseOrderItem();
		item.setNumber("9152413200");
		item.setType("starndard");
		PurchaseOrderAmount seAmount = new PurchaseOrderAmount();
		seAmount.setRequestedAmount(BigDecimal.valueOf(300));
		seAmount.setAdjustedAmount(BigDecimal.valueOf(301));
		item.setAmount(seAmount);
		order.getOrderItems().add(item);
		PurchaseOrderComment comment = new PurchaseOrderComment(new EntityComment(EntityComment.Type.Internal.toString(),"test"));
		order.getComments().add(comment);	
		
		PurchaseOrderAudit audit = new PurchaseOrderAudit();
		audit.setStatusCode(order.getStatus());
		audit.setStatusDate(DateTime.now());
		audit.setStatusBy(1l);
		audit.setPurchaseOrder(order);
		order.getAudits().add(audit);
		
		PurchaseOrderAttachment attachment = new PurchaseOrderAttachment();
		attachment.getAttachment().setName("test");
		attachment.getAttachment().setType("jpg");
		attachment.setPurchaseOrder(order);
		order.getAttachments().add(attachment);
		PurchaseOrderMessage message = new PurchaseOrderMessage();
		message.getErrorMessage().setCode("0011");
		message.getErrorMessage().setField("name");
		message.getErrorMessage().setShortDescription("name is required");
		message.setPurchaseOrder(order);
		order.getMessages().add(message);
		return order;
	}

}
