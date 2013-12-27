package com.mize.domain.partsorder;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.auth.User;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.Locale;
import com.mize.domain.partsorder.PartsOrder;
import com.mize.domain.partsorder.PartsOrderAmount;
import com.mize.domain.partsorder.PartsOrderComment;
import com.mize.domain.partsorder.PartsOrderPart;
import com.mize.domain.partsorder.PartsOrderPayment;
import com.mize.domain.partsorder.PartsOrderRequester;
import com.mize.domain.partsorder.PartsOrderShipment;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.user.UserBE;
import com.mize.domain.util.Formatter;


@ContextConfiguration(locations={"/test-context.xml"})
public class PartsOrderTest extends JPATest {
	private static final String SERVICE_ENTITY_QUERY = "select * from parts_order where id = ?";
	EntityManager entityManager = null;
	PartsOrder partsOrder = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		partsOrder = findById(1l,PartsOrder.class,entityManager);
		this.partsOrder = getPartsOrderOjectToSave(partsOrder);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(partsOrder.getId() == null){
			entityManager.persist(partsOrder);	
		}else{
			partsOrder = entityManager.merge(partsOrder);
		}		
		tx.commit();
	}

	@Test
	public void test() {
		try {
			List<PartsOrder> partsOrders = jdbcTemplate.query(SERVICE_ENTITY_QUERY, new Object[]{partsOrder.getId()}, new PartsOrderRowMapper());
			if(!Formatter.isEmpty(partsOrders)){
				PartsOrder order = partsOrders.get(0);
				assertTrue(partsOrder.getId().equals(order.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class PartsOrderRowMapper implements RowMapper<PartsOrder> {
		@Override
		public PartsOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
			PartsOrder order = new PartsOrder();
			order.setId(rs.getLong("id"));
			BusinessEntity be = new BusinessEntity();
			be.setId(rs.getLong("tenant_id"));
			order.setCode(rs.getString("order_code"));
			order.setStatus(rs.getString("order_status"));
			Locale locale = new Locale();
			locale.setId(rs.getLong("locale_id"));
			order.setLocale(locale);
			order.setCurrencyCode(rs.getString("currency_code"));			
			return order;
		}
	}
	
	
	private PartsOrder getPartsOrderOjectToSave(PartsOrder order) {
		if(order == null){
			order = new PartsOrder();
		}
		order.setStatus(PartsOrder.Status.Draft.toString());
		order.setLocale(new Locale(1l));
		order.setCurrencyCode("Dollar");
		order.setRequestType("Back_Order");
		PartsOrderRequester requester = new PartsOrderRequester();
		BusinessEntity businessEntity = new BusinessEntity();
		businessEntity.setId(961L);
		User user = new User();
		user.setId(785l);
		UserBE be = new UserBE();
		//be.setBeId(961l);
		be.setBe(businessEntity);
		user.setUserBe(be);
		businessEntity = entityManager.find(BusinessEntity.class, businessEntity.getId());
		requester.setBusinessEntity(businessEntity);
		EntityAddress address = new EntityAddress();
		address.setAddress1("test1");
		address.setAddress2("test2");
		//requester.setAddress(address);
		order.setRequester(requester);
		
		
		PartsOrderPart part = new PartsOrderPart();
		part.setCode("9152413200");
		part.setType("starndar");
		part.setSerialNumber("1111");
		PartsOrderAmount seAmount = new PartsOrderAmount();
		seAmount.setRequestedAmount(BigDecimal.valueOf(300));
		seAmount.setAdjustedAmount(BigDecimal.valueOf(301));
		seAmount.setRequestedQuantity(BigDecimal.valueOf(20));
		part.setAmount(seAmount);
		order.getParts().add(part);
		PartsOrderComment comment = new PartsOrderComment(PartsOrderComment.Type.Internal.toString(),"test");
		order.getComments().add(comment);
		PartsOrderShipment shipment = new PartsOrderShipment();		
		shipment.setBusinessEntity(businessEntity);
		shipment.setPriority("high");
		PartsOrderPayment payment = new PartsOrderPayment();
		payment.setBusinessEntity(businessEntity);
		payment.setMethod("credit card");
		
		return order;
	}

}
