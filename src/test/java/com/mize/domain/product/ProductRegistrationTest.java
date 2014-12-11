package com.mize.domain.product;

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
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityComment;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.MizeDate;


@ContextConfiguration(locations={"/test-context.xml"})
public class ProductRegistrationTest  extends JPATest {
	
	private static final String PROD_REG_QUERY = "select * from prod_regn where prod_regn_id =?";
	private static final String PROD_REG_COMMENT_QUERY = "select * from prod_regn_comment where prod_regn_id=?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity businessEntity;
	BusinessEntity tenant;
	ProductRegistration productRegistration;
	ProductSerialTest productSerialTest = new ProductSerialTest();
	ProductSerial productSerial = null;
	ProductRegistration dbProdReg = null;
	EntityAddress entityAddress = null;
	
	
	
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
	}
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(productRegistration);
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
			productSerial= productSerialTest.productSerialObjectToSave(businessEntity, tenant);
			entityManager.persist(productSerial);
			entityAddress=createEntityAddress();
			entityManager.persist(entityAddress);
			tx.commit();
		}
	}
	
	private void createProductRegistration() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			productRegistration = productRegistrationObjectToSave();
			createProdRegComment(productRegistration);
			entityManager.persist(productRegistration);
			tx.commit();
		}

	}
	private ProductRegistration productRegistrationObjectToSave() {
		ProductRegistration productRegistration = new ProductRegistration();
		productRegistration.setTenant(tenant);
		productRegistration.setProductSerial(productSerial);
		productRegistration.setStatusCode("Active");
		productRegistration.setRegistrationType("STORE");
		productRegistration.setCustomer(businessEntity);
		productRegistration.setInvoiceBusinessEntity(businessEntity);
		productRegistration.setCustomerDeliveryDate(MizeDate.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		productRegistration.setPurchasePrice(new BigDecimal(200.00));
		productRegistration.setCustomerDeliveryDate(MizeDate.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC).plusDays(3));
		productRegistration.setWarrantyExpiryDate(MizeDate.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC).plusMonths(24));
		productRegistration.setCustomerAddress(entityAddress);
		return productRegistration;
		
	}
	private void createProdRegComment(ProductRegistration productRegistration){
		List<ProductRegistrationComment> comments = new ArrayList<ProductRegistrationComment>();
		ProductRegistrationComment prodRegComment = new ProductRegistrationComment();
		prodRegComment.setProductRegistration(productRegistration);
		EntityComment comment= createEntityComment();
		prodRegComment.setComment(comment);
		comments.add(prodRegComment);
		productRegistration.setComments(comments);
		
	}
	
	public class ProdRegRowMapper implements RowMapper<ProductRegistration>{

		@Override
		public ProductRegistration mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ProductRegistration productRegistration = new ProductRegistration();
			productRegistration.setId(rs.getLong("prod_regn_id"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			productRegistration.setTenant(tenant);
			ProductSerial prodSerial = new ProductSerial();
			prodSerial.setId(rs.getLong("prod_serial_id"));
			productRegistration.setProductSerial(prodSerial);
			productRegistration.setStatusCode(rs.getString("status_code"));
			productRegistration.setRegistrationType(rs.getString("regn_type"));
			BusinessEntity businessEntity = new BusinessEntity();
			businessEntity.setId(rs.getLong("cust_be_id"));
			productRegistration.setCustomer(businessEntity);
			BusinessEntity be= new BusinessEntity();
			be.setId(rs.getLong("invoice_be_id"));
			productRegistration.setInvoiceBusinessEntity(be);
			productRegistration.setCustomerDeliveryDate(Formatter.toMizeDate(rs.getTimestamp("cust_delivery_date")));
			productRegistration.setPurchasePrice(rs.getBigDecimal("purchase_price"));
			productRegistration.setWarrantyExpiryDate(Formatter.toMizeDate(rs.getTimestamp("warranty_expiry_date")));
			
			EntityAddress customerAddress = new EntityAddress();
			customerAddress.setId(rs.getLong("cust_address_id"));
			productRegistration.setCustomerAddress(customerAddress);
			return productRegistration;
		
		}
		
	}
	
	public class ProdRegCommentRowMapper implements RowMapper<ProductRegistrationComment>{

		@Override
		public ProductRegistrationComment mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ProductRegistrationComment prodRegComment = new ProductRegistrationComment();
			prodRegComment.setId(rs.getLong("id"));
			ProductRegistration prodReg = new ProductRegistration();
			prodReg.setId(rs.getLong("prod_regn_id"));
			prodRegComment.setProductRegistration(prodReg);
			EntityComment comment = new EntityComment();
			comment.setId(rs.getLong("comment_id"));
			prodRegComment.setComment(comment);
			return prodRegComment;
		}
		
	}
	public ProductRegistration retrieveProdReg(){
		dbProdReg = jdbcTemplate.queryForObject(PROD_REG_QUERY, new Object[]{ productRegistration.getId()}, new ProdRegRowMapper());
		if(dbProdReg !=null){
			List<ProductRegistrationComment> productRegistrationComments= jdbcTemplate.query(PROD_REG_COMMENT_QUERY, new Object[]{dbProdReg.getId()}, new ProdRegCommentRowMapper());
			dbProdReg.setComments(productRegistrationComments);
		}
		return dbProdReg;
	}
	
	
	@Test
	public void saveProdRegTest(){
		createProductRegistration();
		try{
			if(productRegistration != null){
				dbProdReg = retrieveProdReg();
				if(dbProdReg != null){
					assertTrue(productRegistration.getId()!=null);
					assertTrue(dbProdReg.getId()!= null);
					assertTrue(compare(productRegistration,dbProdReg));
				}
			}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
		
	}
	@Test
	public void updateProdTest(){
		createProductRegistration();
		try{
			if(productRegistration != null){
				productRegistration.setStatusCode("admin"+System.currentTimeMillis());
				productRegistration.setRegistrationType("New");
				persist();
				dbProdReg = retrieveProdReg();
				if(dbProdReg != null){
					assertTrue(productRegistration.getId()!=null);
					assertTrue(dbProdReg.getId()!= null);
					assertTrue(compare(productRegistration,dbProdReg));
				}
			}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
		
	}
	public void tearDown() throws Exception {
		try {
			if (productRegistration != null) {
				tx.begin();
				entityManager.remove(productRegistration);
				entityManager.remove(productSerial);
				entityManager.remove(businessEntity);
				entityManager.remove(tenant);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
	private boolean compare(ProductRegistration productRegistration ,ProductRegistration dbProdReg){
		if(productRegistration == null && dbProdReg == null){
			return true;
		}
		if(productRegistration == null  ){
			if(dbProdReg != null){
				return false;
			}
		}else if(productRegistration!=null ){
			if(dbProdReg == null){
				return false;
			}
		}
		if(!productRegistration.getId().equals(dbProdReg.getId())){
			return false;
		}
		if(!productRegistration.getRegistrationType().equals(dbProdReg.getRegistrationType())){
			return false;
		}
		return true;
	}
	
}
