package com.mize.domain.product;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
public class ProductSerialTest extends JPATest {
	
	private static final String PRODUCT_SERIAL_QUERY = "select * from prod_serial where id = ?";
	private static final String PROD_SERIAL_COMMENT_QUERY = "select * from prod_serial_comment where prod_srl_id =?";
	
	
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity businessEntity;
	BusinessEntity tenant;
	ProductSerial productSerial = null;
	ProductSerial dbProductSerial = null;
	
	Product product = null;
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
		
	}
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(productSerial);
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
			product =productObjectToSave(tenant, businessEntity, entityManager);
			entityManager.persist(product);
			tx.commit();
		}
	}
	
	private void createProductSerial() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			productSerial = productSerialObjectToSave(businessEntity,tenant);
			createProductSerialComment(productSerial);
			entityManager.persist(productSerial);
			tx.commit();
		}

	}
	public ProductSerial productSerialObjectToSave(BusinessEntity businessEntity,BusinessEntity tenant) {
		ProductSerial productSerial = new ProductSerial();
		productSerial.setTenant(tenant);
		productSerial.setProduct(product);
		productSerial.setSerialNumber("testAdmin"+System.currentTimeMillis());
		productSerial.setShippedBusinessEntity(businessEntity);
		productSerial.setBuildDate(Date.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		productSerial.setInvoiceBusinessEntity(businessEntity);
		productSerial.setCreatedBy(776l);
		productSerial.setCreatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		productSerial.setUpdatedBy(776L);
		productSerial.setUpdatedDate(DateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		productSerial.setIsValid("Y");
		
		return productSerial;
	}
	private void createProductSerialComment(ProductSerial productSerial){
		ProductSerialComment productSerialComment = new ProductSerialComment();
		List<ProductSerialComment> comments = new ArrayList<ProductSerialComment>();
		productSerialComment.setProductSerial(productSerial);
		EntityComment comment = createEntityComment();
		productSerialComment.setComment(comment);
		comments.add(productSerialComment);
		productSerial.setComments(comments);
		
	}
	
	private class ProdSerialCommentRowMapper implements RowMapper<ProductSerialComment>{

		@Override
		public ProductSerialComment mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ProductSerialComment productSerialComment = new ProductSerialComment();
			productSerialComment.setId(rs.getLong("id"));
			ProductSerial productSerial = new ProductSerial();
			productSerial.setId(rs.getLong("prod_srl_id"));
			productSerialComment.setProductSerial(productSerial);
			EntityComment comment = new EntityComment();
			comment.setId(rs.getLong("comment_id"));
			productSerialComment.setComment(comment);
			return productSerialComment;
		}
		
	}
	
	private class ProductSerialRowMapper implements RowMapper<ProductSerial> {
		@Override
		public ProductSerial mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductSerial prodSerial = new ProductSerial();
			prodSerial.setId(rs.getLong("id"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			prodSerial.setTenant(tenant);
			Product prod = new Product();
			prod.setId(rs.getLong("prod_id"));
			prodSerial.setProduct(prod);
			prodSerial.setSerialNumber(rs.getString("prod_srl_no"));
			BusinessEntity businessEntity = new BusinessEntity();
			businessEntity.setId(rs.getLong("ship_be_id"));
			prodSerial.setShippedBusinessEntity(businessEntity);
			prodSerial.setBuildDate(DateTimeUtils.toDate(rs.getTimestamp("build_date")));
			BusinessEntity invoiceBE = new BusinessEntity();
			invoiceBE.setId(rs.getLong("invoice_be_id"));
			prodSerial.setInvoiceBusinessEntity(invoiceBE);
			prodSerial.setCreatedBy(rs.getLong("created_by"));
			prodSerial.setUpdatedBy(rs.getLong("updated_by"));
			prodSerial.setCreatedDate(DateTimeUtils.toDateTime(rs.getTimestamp("created_date")));
			prodSerial.setUpdatedDate(DateTimeUtils.toDateTime(rs.getTimestamp("updated_date")));
			prodSerial.setIsValid(rs.getString("is_valid"));
			return prodSerial;
		}
	}
	public ProductSerial retrieveProdSerial(){
		dbProductSerial= jdbcTemplate.queryForObject(PRODUCT_SERIAL_QUERY, new Object[]{productSerial.getId()},new ProductSerialRowMapper());
		if(dbProductSerial != null){
			List<ProductSerialComment> productSerialComments = jdbcTemplate.query(PROD_SERIAL_COMMENT_QUERY, new Object[]{dbProductSerial.getId()}, new ProdSerialCommentRowMapper());
			dbProductSerial.setComments(productSerialComments);
		}
		return dbProductSerial;
	}
	
	@Test
	
	public void saveProductSerialTest(){
		createProductSerial();
		try{
			if(productSerial != null){
				dbProductSerial = retrieveProdSerial();
				if(dbProductSerial != null){
					assertTrue(productSerial.getId()!=null);
					assertTrue(dbProductSerial.getId()!=null);
					assertTrue(compare(productSerial, dbProductSerial));
				}
				
			}tearDown();
		}catch(Throwable th){
				th.printStackTrace();
				fail("Got Exception");
			}
		}
	
	@Test
	public void updateProductSerialTest(){
		createProductSerial();
		try{
			if(productSerial != null){
				productSerial.setSerialNumber("testAdmin"+System.currentTimeMillis());
				productSerial.setIsValid("N");
				persist();
				dbProductSerial = retrieveProdSerial();
				if(dbProductSerial !=null){
					assertTrue(productSerial.getId()!=null);
					assertTrue(dbProductSerial.getId()!=null);
					assertTrue(compare(productSerial, dbProductSerial));
				}
			}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}
		public void tearDown() throws Exception {
			try {
				if (productSerial != null) {
					tx.begin();
					entityManager.remove(productSerial);
					entityManager.remove(product);
					entityManager.remove(businessEntity);
					entityManager.remove(tenant);
					tx.commit();
				}
				entityManager.close();
			} catch (Throwable th) {
				th.printStackTrace();
			}
		}
		private boolean compare(ProductSerial productSerial ,ProductSerial dbProductSerial){
			if(productSerial == null && dbProductSerial == null){
				return true;
			}
			if(productSerial == null  ){
				if(dbProductSerial != null){
					return false;
				}
			}else if(productSerial!=null ){
				if(dbProductSerial == null){
					return false;
				}
			}
			if(!productSerial.getId().equals(dbProductSerial.getId())){
				return false;
			}
			if(!productSerial.getSerialNumber().equals(dbProductSerial.getSerialNumber())){
				return false;
			}
			return true;
		}
	

	
}
