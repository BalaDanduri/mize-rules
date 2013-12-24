package com.mize.domain.common;

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

import com.mize.domain.product.ProductSerial;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class EntityCommentTest extends JPATest {
	private static final String ENTITY_COMMENT_QUERY = "select * from entity_comment where id = ?";
	EntityManager entityManager;
	EntityComment comment = null;
	
	@Before
	public void setUp(){
		entityManager = getEntityManager();
		comment = commentToBeSaved();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(comment.getId() != null){
			comment = entityManager.merge(comment);
		}else{
			entityManager.persist(comment);
		}
		tx.commit();
	}

	public ProductSerial findExistingProductSerial(EntityManager entityManager) {
		return entityManager.find(ProductSerial.class, new Long(101000));
	}
	
	@Test
	public void test() {
		try {
			List<EntityComment>  be = jdbcTemplate.query(ENTITY_COMMENT_QUERY, new Object[]{comment.getId()}, new ProductSerialRowMapper());
			if(!Formatter.isEmpty(be)){
				EntityComment beList = be.get(0);
				assertTrue(comment.getId().equals(beList.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}
	
	private class ProductSerialRowMapper implements RowMapper<EntityComment> {
		@Override
		public EntityComment mapRow(ResultSet rs, int rowNum) throws SQLException {
			EntityComment entityComment = new EntityComment();
			entityComment.setId(rs.getLong("id"));
			entityComment.setCommentType(rs.getString("comment_type"));
			entityComment.setComments(rs.getString("comments"));
			return entityComment;
		}
	}
	
	private EntityComment commentToBeSaved() {
		EntityComment comment = new EntityComment();
		comment.setId(101001L);
		comment.setCommentType("PROD_COMMENT");
		comment.setComments("Testing the comments");
		return comment;
	}
		
}
