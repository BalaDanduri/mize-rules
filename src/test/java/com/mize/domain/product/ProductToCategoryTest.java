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
public class ProductToCategoryTest extends JPATest {
	private static final String PRODUCT_CATEGORY_QUERY = "select * from prod_to_cat where id = ?";
	EntityManager entityManager;
	ProductToCategory prodToCategory = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		prodToCategory = ProductToCategoryToBeSaved();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(prodToCategory.getId() != null){
			prodToCategory = entityManager.merge(prodToCategory);
		}else{
			entityManager.persist(prodToCategory);
		}
		tx.commit();
	}

	public ProductToCategory findExistingProductToCategory(EntityManager entityManager) {
		return entityManager.find(ProductToCategory.class, new Long(1));
	}
	
	@Test
	public void test() {
		try {
			List<ProductToCategory>  be = jdbcTemplate.query(PRODUCT_CATEGORY_QUERY, new Object[]{prodToCategory.getId()}, new ProductToCategoryRowMapper());
			if(!Formatter.isEmpty(be)){
				ProductToCategory beList = be.get(0);
				assertTrue(prodToCategory.getId().equals(beList.getId()));
			} else {
				fail("Expected object to be returned");
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
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
	
	
	private ProductToCategory ProductToCategoryToBeSaved() {
		ProductToCategory prodToCategory = new ProductToCategory();
		ProductToCategory category = new ProductToCategory();
		category.setId(1L);
		Product product = new Product();
		product.setId(1L);
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(1L);
		category.setProduct(product);
		category.setProductCategory(productCategory);
		return prodToCategory;
	}
		
}
