package com.mize.domain.product;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class ProductCategoryTest extends JPATest {
	
	private static final String PRODUCT_CATEGORY_QYERY = "select * from prod_cat where prod_cat_id = ?";
	private static final String PROD_CAT_INTL_QUERY = "select * from prod_cat_intl where id = ?";
	EntityManager entityManager;
	EntityTransaction tx;
	ProductCategory prodCategory = null;
	ProductCategoryIntl intl = null;
	ProductCategory dbProdCategory = null;
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		prodCategory = productCategoryObjectToBeSaved(prodCategory);
		
	}
	
	private void persist(){
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(prodCategory);
		tx.commit();
	}
	
	
	private ProductCategory productCategoryObjectToBeSaved(ProductCategory prodCategory){
		prodCategory = new ProductCategory();
		BusinessEntity beEntity = new BusinessEntity();
		beEntity.setId(8914L);
		prodCategory.setTenant(beEntity);
		prodCategory.setName("Telivision");
		prodCategory.setPhotoLink("");
		
		ProductCategory parentCategory = new ProductCategory();
		parentCategory.setId(2L);
		prodCategory.setParent(parentCategory);
		
		prodCategory.setDepartment("TEST1");
		prodCategory.setLevel(2);
		prodCategory.setActive(1);
		prodCategory.setCategoryCode("Code1");
		
		return prodCategory;
	}
	
	public ProductCategory retrieveProductCategory(){
		dbProdCategory = jdbcTemplate.queryForObject(PRODUCT_CATEGORY_QYERY, 
				new Object[] { prodCategory.getId() }, new ProductCategoryRowMapper());
		if(dbProdCategory != null){
			List<ProductCategoryIntl> intls = jdbcTemplate.query(PROD_CAT_INTL_QUERY,
					new Object[] { dbProdCategory.getId() }, new ProductCategoryInltRowMapper());
			if(intls != null){
				dbProdCategory.setIntls(intls);
			}
		}
		return dbProdCategory;
	}
	
	private class ProductCategoryRowMapper implements RowMapper<ProductCategory>{
		public ProductCategory mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			ProductCategory productCategory = new ProductCategory();
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(resultSet.getLong("tenant_id"));
			productCategory.setId(resultSet.getLong("prod_cat_id"));
			
			prodCategory.setName(resultSet.getString("prod_cat_name"));
			prodCategory.setPhotoLink(resultSet.getString("prod_cat_link"));
			
			ProductCategory parentCategory = new ProductCategory();
			parentCategory.setId(resultSet.getLong("parent_prod_cat_id"));
			prodCategory.setParent(parentCategory);
			
			prodCategory.setDepartment(resultSet.getString("department"));
			prodCategory.setLevel(resultSet.getInt("cat_level"));
			prodCategory.setActive(resultSet.getInt("is_active"));
			prodCategory.setCategoryCode(resultSet.getString("prod_cat_code"));
			
			return productCategory;
		}
	}
	
	private class ProductCategoryInltRowMapper implements RowMapper<ProductCategoryIntl>{
		public ProductCategoryIntl mapRow(ResultSet resultSet, int rowNum)
				throws SQLException{
			ProductCategoryIntl intls = new ProductCategoryIntl();
			ProductCategory productCategory = new ProductCategory();
			productCategory.setId(resultSet.getLong("prod_cat_id"));
			intls.setProductCategory(productCategory);
			Locale locale = new Locale();
			locale.setId(resultSet.getLong("locale_id"));
			intls.setLocale(locale);
			intls.setName(resultSet.getString("prod_cat_name"));
			intls.setDescription(resultSet.getString("prod_cat_description"));
			return intls;
			
		}
	}

	private ProductCategory retrieveProdCatObject(){
		ProductCategory prodCat = null;
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("name", "Appliances");
	   List<ProductCategory> prodCats = getListFromDB("Select p from ProductCategory p where p.name =:name",parameters);
	   if(!Formatter.isEmpty(prodCats)){
		   prodCat = prodCats.get(0);
	   }
	   return prodCat;
	}
	
	
	@Test
	public void retrieveTest(){
		prodCategory = retrieveProdCatObject();
		try{
			if(prodCategory != null){
				assertTrue(prodCategory.getId() !=null);
			}
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}
	
	@Test
	public void saveProductCategory(){
		persist();
		try {
			dbProdCategory = retrieveProductCategory();
			if(dbProdCategory != null){
				assertTrue(dbProdCategory.getId().equals(prodCategory.getId()));
				System.out.println(getJsonResponse(prodCategory));
				System.out.println(getJsonResponse(dbProdCategory));
				tearDown();
			}
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			
		}
	}
	
	public void tearDown() {
		if (prodCategory != null) {
			//tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(prodCategory);
			tx.commit();
		}
		entityManager.close();
	}
		
}
