package com.mize.domain.product;

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

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class ProductToCategoryTest extends JPATest {
	private static final String PRODUCT_CATEGORY_QUERY = "select * from prod_to_cat where id = ?";
	EntityManager entityManager;
	ProductToCategory prodToCategory = null;
	ProductToCategory dbProdToCategory = null;
	BusinessEntity tenant ;
	BusinessEntity businessEntity;
	EntityTransaction tx;
	Product product;
	ProductCategory productCategory;
	
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
		tx = entityManager.getTransaction();
		tx.begin();
		product = productObjectToSave(tenant, businessEntity, entityManager);
		entityManager.persist(product);
		productCategory = findById(8455l, ProductCategory.class, entityManager);
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
	
	
	private void createProductToCat() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			prodToCategory = ProductToCategoryToBeSaved();
			
			entityManager.persist(prodToCategory);
			tx.commit();
		}

	}
	
	private ProductToCategory ProductToCategoryToBeSaved() {
		
		ProductToCategory category = new ProductToCategory();
		category.setProduct(product);
		category.setProductCategory(productCategory);
		return category;
	}
	
	class ProductToCategoryRowMapper implements RowMapper<ProductToCategory> {
		public ProductToCategory mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			ProductToCategory category = new ProductToCategory();
			category.setId(resultSet.getLong("id"));
			Product product = new Product();
			product.setId(resultSet.getLong("prod_id"));
			category.setProduct(product);
			ProductCategory prodCategory = new ProductCategory();
			prodCategory.setId(resultSet.getLong("prod_cat_id"));
			category.setProductCategory(prodCategory);
			return category;
		}
	}
	
	public ProductToCategory retrievProdToCat(){
		dbProdToCategory = jdbcTemplate.queryForObject(PRODUCT_CATEGORY_QUERY, new Object[]{prodToCategory.getId()}, new ProductToCategoryRowMapper());
		
		return dbProdToCategory;
	}
	
	@Test
	public void saveProdToCatTest(){
		createProductToCat();
		try{
		if(prodToCategory != null){
			if(dbProdToCategory != null){
				assertTrue(prodToCategory.getId()!=null);
				assertTrue(dbProdToCategory.getId()!=null);
			}
		}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}

	
	private void tearDown() {
		try{
		if(prodToCategory != null){
			tx.begin();
			entityManager.remove(prodToCategory);
			entityManager.remove(product);
			entityManager.remove(businessEntity);
			entityManager.remove(tenant);
			tx.commit();
		}
		entityManager.close();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}
	
	
		
}
