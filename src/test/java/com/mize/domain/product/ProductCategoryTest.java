package com.mize.domain.product;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class ProductCategoryTest extends JPATest {
	private static final String PRODUCT_CATEGORY_QUERY = "select * from prod_cat where prod_cat_id = ?";
	EntityManager entityManager;
	ProductCategory prodCategory = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		prodCategory = ProductCategoryToBeSaved();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(prodCategory.getId() != null){
			prodCategory = entityManager.merge(prodCategory);
		}else{
			entityManager.persist(prodCategory);
		}
		tx.commit();
	}

	public ProductCategory findExistingProductCategory(EntityManager entityManager) {
		return entityManager.find(ProductCategory.class, new Long(101000));
	}
	
	@Test
	public void test() {
		try {
			List<ProductCategory>  be = jdbcTemplate.query(PRODUCT_CATEGORY_QUERY, new Object[]{prodCategory.getId()}, new ProductCategoryRowMapper());
			if(!Formatter.isEmpty(be)){
				ProductCategory beList = be.get(0);
				assertTrue(prodCategory.getId().equals(beList.getId()));
			} else {
				fail("Expected object to be returned");
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	class ProductCategoryRowMapper implements RowMapper<ProductCategory> {
		public ProductCategory mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			ProductCategory category = new ProductCategory();
			category.setId(resultSet.getLong("prod_cat_id"));
			category.setName(resultSet.getString("prod_cat_name"));
			ProductCategory parentCategory = new ProductCategory();
			parentCategory.setId(resultSet.getLong("parent_prod_cat_id"));
			category.setParent(parentCategory);
			category.setPhotoLink(resultSet.getString("prod_cat_link"));
			category.setActive(resultSet.getBoolean("is_active"));
			category.setDepartment(resultSet.getString("department"));			
			category.setChildren(new HashSet<ProductCategory>());
			return category;
		}
	}
	
	
	private ProductCategory ProductCategoryToBeSaved() {
		ProductCategory prodCategory = new ProductCategory();
		ProductCategory category = new ProductCategory();
		category.setId(2L);
		category.setName("Child Category of 1");
		ProductCategory parentCategory = new ProductCategory();
		parentCategory.setId(1L);
		category.setParent(parentCategory);
		category.setPhotoLink("test.com/1");
		category.setActive(1);
		category.setDepartment("TESTING");			
		return prodCategory;
	}
		
}
