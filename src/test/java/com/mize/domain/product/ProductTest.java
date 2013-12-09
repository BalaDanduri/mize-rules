package com.mize.domain.product;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.brand.Brand;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class ProductTest extends JPATest {
	private static final String PRODUCT_QUERY = "select * from prod where prod_id = ?";
	EntityManager entityManager;
	Product product = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		product = ProductToBeSaved();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(product.getId() != null){
			product = entityManager.merge(product);
		}else{
			entityManager.persist(product);
		}
		tx.commit();
	}

	public Product findExistingProduct(EntityManager entityManager) {
		return entityManager.find(Product.class, new Long(101000));
	}
	
	@Test
	public void test() {
		try {
			List<Product>  be = jdbcTemplate.query(PRODUCT_QUERY, new Object[]{product.getId()}, new ProductRowMapper());
			if(!Formatter.isEmpty(be)){
				Product beList = be.get(0);
				assertTrue(product.getId().equals(beList.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class ProductRowMapper implements RowMapper<Product> {
		public Product mapRow(ResultSet resultSet, int rowNum)throws SQLException {
			Product product = new Product();
			product.setId(resultSet.getLong("prod_id"));
			product.setName(resultSet.getString("prod_name"));
			product.setImageLink(resultSet.getString("prod_image"));
			product.setShortDescription(resultSet.getString("prod_desc"));
			product.setUpc(resultSet.getString("upc"));
			product.setMpn(resultSet.getString("mfg_part_no"));
			product.setModel(resultSet.getString("model"));
			product.setQrCode(resultSet.getString("qr_code"));
			Brand brand = new Brand();
			brand.setId(resultSet.getLong("brand_id"));
			brand.setBrandName(resultSet.getString("brand_name"));			
			product.setReleaseDate(Formatter.dateTime(resultSet.getTimestamp("release_date")));
			product.setBrand(brand);
			return product;
		}
	}
	
	private Product ProductToBeSaved() {
		Product product = new Product();
		product.setId(1L);
		product.setTenant(new BusinessEntity());
		product.getTenant().setId(1L);
		product.setName("Testp");
		Brand brand = new Brand();
		brand.setId(1L);
		brand.setName("Test Brand");
		product.setBrand(brand);
		return product;
	}
		
}
