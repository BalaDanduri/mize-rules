package com.mize.domain.product;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.brand.Brand;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;


@ContextConfiguration(locations={"/test-context.xml"})
public class ProductTest extends JPATest {
	
	
	private static final String PRODUCT_QUERY = "select * from prod where prod_id = ?";
	private static final String PRODUCT_INTL_QUERY = "select * from prod_intl where prod_id=?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity businessEntity;
	BusinessEntity tenant;
	Product product = null;
	Product dbProduct = null;
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
	}
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(product);
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
	
	private void createProduct() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			product = productObjectToSave(tenant,businessEntity,entityManager);
			setproductIntls(product);
			entityManager.persist(product);
			tx.commit();
		}

	}
	/*public Product productObjectToSave() {
		Product product = new Product();
		product.setName("Testp");	
		Brand brand = findById(1l, Brand.class, entityManager);
		product.setBrand(brand);
		product.setTenant(tenant);
		product.setManufacturerBE((businessEntity));
		product.setCreatedDate(DateTime.now());
		product.setUpdatedDate(DateTime.now());
		product.setReleaseDate(DateTime.now());
		
		return product;

	}*/
	private void setproductIntls(Product product){
		ProductIntl productIntl = new ProductIntl();
		List<ProductIntl> productIntls = new ArrayList<ProductIntl>();
		productIntl.setProduct(product);
		Locale locale = findLocaleObjectFromDB();
		productIntl.setLocale(locale);
		productIntl.setName("mize");
		productIntls.add(productIntl);
		product.setProductIntl(productIntls);
	}
	private class ProductRowMapper implements RowMapper<Product> {
		public Product mapRow(ResultSet resultSet, int rowNum)throws SQLException {
			Product product = new Product();
			product.setId(resultSet.getLong("prod_id"));
			product.setName(resultSet.getString("prod_name"));
			Brand brand = new Brand();
			brand.setId(resultSet.getLong("brand_id"));
			brand.setBrandName(resultSet.getString("brand_name"));
			product.setBrand(brand);
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(resultSet.getLong("tenant_id"));
			product.setTenant(tenant);
			BusinessEntity be = new BusinessEntity();
			be.setId(resultSet.getLong("manufacturer_be_id"));
			product.setManufacturerBE(be);
			product.setCreatedDate(Formatter.toMizeDateTime(resultSet.getTimestamp("created_date")));
			product.setCreatedDate(Formatter.toMizeDateTime(resultSet.getTimestamp("updated_date")));				
			product.setReleaseDate(Formatter.toMizeDate(resultSet.getTimestamp("release_date")));
			
			return product;
		}
	}
	private class ProductIntlRowMapper implements RowMapper<ProductIntl>{

		@Override
		public ProductIntl mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductIntl productIntl = new ProductIntl();
			Product product = new Product();
			product.setId(rs.getLong("prod_id"));
			productIntl.setProduct(product);
			Locale locale = new Locale();
			locale.setId(rs.getLong("locale_id"));
			productIntl.setLocale(locale);
			productIntl.setName(rs.getString("prod_name"));

			return productIntl;
		}
		
	}
	public Product retrievProduct(){
		dbProduct = jdbcTemplate.queryForObject(PRODUCT_QUERY, new Object[]{product.getId()}, new ProductRowMapper());
		if(dbProduct !=null){
			List<ProductIntl> productIntls = jdbcTemplate.query(PRODUCT_INTL_QUERY, new Object[]{dbProduct.getId()}, new ProductIntlRowMapper());
			dbProduct.setProductIntl(productIntls);
		}
		return dbProduct;
	}
	
	
	@Test
	public void saveProductTest(){
		createProduct();
		try{
		if(product != null){
			dbProduct = retrievProduct();
			if (dbProduct !=null) {
				assertTrue(product.getId()!=null);
				assertTrue(dbProduct.getId()!=null);
				assertTrue(compare(product, dbProduct));
			}
		}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}
	
	@Test
	public void updateProductTest(){
		createProduct();
		try{
			if(product != null){
				product.setName("MizeProduct");
				persist();
				dbProduct = retrievProduct();
				if(dbProduct !=null){
					assertTrue(product.getId()!=null);
					assertTrue(dbProduct.getId()!=null);
					assertTrue(compare(product, dbProduct));
				}
			}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got exception");
		}
	}
	public void tearDown() throws Exception {
		try {
			if (product != null) {
				tx.begin();
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
	private boolean compare(Product product ,Product dbProduct){
		if(product == null && dbProduct == null){
			return true;
		}
		if(product == null  ){
			if(dbProduct != null){
				return false;
			}
		}else if(product!=null ){
			if(dbProduct == null){
				return false;
			}
		}
		if(!product.getId().equals(dbProduct.getId())){
			return false;
		}
		if(!product.getName().equals(dbProduct.getName())){
			return false;
		}
		return true;
	}

		
}
