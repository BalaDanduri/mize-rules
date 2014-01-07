package com.mize.domain.product;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.test.util.JPATest;


@ContextConfiguration(locations={"/test-context.xml"})
public class ProductRegistrationTest  extends JPATest {

	EntityManager entityManager;
	ProductRegistration productRegistration;
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		productRegistration = getProductRegistrationObject();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(productRegistration.getId() != null){
			productRegistration = entityManager.merge(productRegistration);
		}else{
			entityManager.persist(productRegistration);
		}
		tx.commit();
	}
	
	private ProductRegistration getProductRegistrationObject() {
		productRegistration = new ProductRegistration();
		BusinessEntity be = new BusinessEntity();
		be.setId(961L);
		productRegistration.setCustomer(be);
		productRegistration.setTenant(be);
		productRegistration.setInvoiceBusinessEntity(be);
		productRegistration.setCustomerDeliveryDate(DateTime.now());
		productRegistration.setPurchasePrice(new BigDecimal(200.00));
		productRegistration.setRegistrationType("STORE");
		productRegistration.setStatusCode("Active");
		productRegistration.setCustomerDeliveryDate(DateTime.now().plusDays(3));
		productRegistration.setWarrantyExpiryDate(DateTime.now().plusMonths(24));
		ProductSerial serial = new ProductSerial();
		serial.setId(11l);
		productRegistration.setProductSerial(serial);
		/*EntityAddress customerAddress = new EntityAddress();
		customerAddress.setId(476L);
		productRegistration.setCustomerAddress(customerAddress);*/
		return productRegistration;
	}
	
	public ProductSerial productSerialToBeSaved() {
		ProductSerial prodSerial = new ProductSerial();
		prodSerial.setId(101001L);
		prodSerial.setTenant(new BusinessEntity());
		prodSerial.getTenant().setId(961L);
		prodSerial.setProduct(new Product());
		prodSerial.getProduct().setId(101000L);
		ProductSource prodSource = new ProductSource();
		prodSource.setId(1L);
		prodSource.setProductId(101000L);
		prodSource.setSourceId(2L);
		prodSource.setSourceProductId("TEST_SOURCE_ID");
		prodSerial.getProduct().setProductSource(prodSource);
		prodSerial.setDeliveryBE(new BusinessEntity());
		prodSerial.getDeliveryBE().setId(101000L);
		ProductSerialComment comment = new ProductSerialComment();
		EntityComment ec = new EntityComment(EntityComment.Type.Internal.toString(),"test comments");
		comment.setComment(ec);
		comment.setProductSerial(prodSerial);
		prodSerial.getComments().add(comment);
		return prodSerial;
	}
	
	@Test
	public void test(){
		assertNotNull(productRegistration);
	}
	
	@After
	public void tearDown(){
		entityManager.remove(productRegistration);
		entityManager.close();
	}
	
}
