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
public class ProductSerialCommentTest extends JPATest {
	private static final String PRODUCT_SERIAL_COMMENT_QUERY = "select * from prod_serial_comment where id = ?";
	EntityManager entityManager;
	ProductSerialComment prodSerialComment = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		prodSerialComment = productSerialCommentToBeSaved();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(prodSerialComment.getId() != null){
			prodSerialComment = entityManager.merge(prodSerialComment);
		}else{
			entityManager.persist(prodSerialComment);
		}
		tx.commit();
	}

	public ProductSerialComment findExistingProductSerialComment(EntityManager entityManager) {
		return entityManager.find(ProductSerialComment.class, new Long(101000));
	}
	
	@Test
	public void test() {
		try {
			List<ProductSerialComment>  be = jdbcTemplate.query(PRODUCT_SERIAL_COMMENT_QUERY, new Object[]{prodSerialComment.getId()}, new ProductSerialCommentRowMapper());
			if(!Formatter.isEmpty(be)){
				ProductSerialComment beList = be.get(0);
				assertTrue(prodSerialComment.getId().equals(beList.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class ProductSerialCommentRowMapper implements RowMapper<ProductSerialComment> {
		@Override
		public ProductSerialComment mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductSerialComment ps = new ProductSerialComment();
			ps.setId(rs.getLong("id"));
			ps.setProductSerial(new ProductSerial());
			ps.getProductSerial().setId(rs.getLong("prod_srl_id"));
			ps.setComment(new EntityComment());
			ps.getComment().setId(rs.getLong("comment_id"));
			return ps;
		}
	}
	
	private ProductSerialComment productSerialCommentToBeSaved() {
		ProductSerialComment prodSerialComment = new ProductSerialComment();
		prodSerialComment.setId(101000L);
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
		prodSerialComment.setProductSerial(prodSerial);
		prodSerialComment.setComment(new EntityComment());
		prodSerialComment.getComment().setId(101000L);
		prodSerialComment.getComment().setCommentType("SERIAL_COMMENT");
		prodSerialComment.getComment().setComments("Domain unit Test");
		
		return prodSerialComment;
	}
		
}
