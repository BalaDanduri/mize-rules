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

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class ProductSerialTest extends JPATest {
	private static final String PRODUCT_SERIAL_QUERY = "select * from prod_serial where id = ?";
	EntityManager entityManager;
	ProductSerial prodSerial = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		prodSerial = productSerialToBeSaved();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(prodSerial.getId() != null){
			prodSerial = entityManager.merge(prodSerial);
		}else{
			entityManager.persist(prodSerial);
		}
		tx.commit();
	}

	public ProductSerial findExistingProductSerial(EntityManager entityManager) {
		return entityManager.find(ProductSerial.class, new Long(101000));
	}
	
	@Test
	public void testSaveProductSerial() {
		try {
			List<ProductSerial>  be = jdbcTemplate.query(PRODUCT_SERIAL_QUERY, new Object[]{prodSerial.getId()}, new ProductSerialRowMapper());
			if(!Formatter.isEmpty(be)){
				ProductSerial beList = be.get(0);
				assertTrue(prodSerial.getId().equals(beList.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class ProductSerialRowMapper implements RowMapper<ProductSerial> {
		@Override
		public ProductSerial mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductSerial ps = new ProductSerial();
			ps.setId(rs.getLong("id"));
			ps.setProduct(new Product());
			ps.getProduct().setId(rs.getLong("prod_id"));
			ps.setSerialNumber(rs.getString("prod_srl_no"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			ps.setTenant(tenant);
			BusinessEntity deliveryBE = new BusinessEntity();
			deliveryBE.setId(rs.getLong("ship_be_id"));
			ps.setShippedBusinessEntity(deliveryBE);
			return ps;
		}
	}
	
	private ProductSerial productSerialToBeSaved() {
		ProductSerial prodSerial = new ProductSerial();
		prodSerial.setId(101001L);
		prodSerial.setTenant(new BusinessEntity());
		prodSerial.getTenant().setId(101000L);
		prodSerial.setProduct(new Product());
		prodSerial.getProduct().setId(101000L);
		ProductSource prodSource = new ProductSource();
		prodSource.setId(1L);
		prodSource.setProductId(101000L);
		prodSource.setSourceId(2L);
		prodSource.setSourceProductId("TEST_SOURCE_ID");
		prodSerial.getProduct().setProductSource(prodSource);
		prodSerial.setShippedBusinessEntity(new BusinessEntity());
		prodSerial.getShippedBusinessEntity().setId(101000L);
		ProductSerialComment comment = new ProductSerialComment();
		EntityComment ec = new EntityComment(EntityComment.Type.Internal.toString(),"test comments");
		comment.setComment(ec);
		comment.setProductSerial(prodSerial);
		prodSerial.getComments().add(comment);
		return prodSerial;
	}
		
}
