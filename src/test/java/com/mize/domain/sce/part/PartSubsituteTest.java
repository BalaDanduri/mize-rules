package com.mize.domain.sce.part;

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

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.part.Part;
import com.mize.domain.part.PartSubstitute;
import com.mize.domain.product.PartSubstituteComment;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.MizeDateTime;

@ContextConfiguration(locations={"/test-context.xml"})
public class PartSubsituteTest extends JPATest {
	
	private static final String PART_SUBSITUTE_QUERY = "select * from part_substitute where id = ?";
	private static final String PART_SUBSITUTE_COMMENT_QUERY = "select * from part_substitute_comment where part_substitute_id=?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity businessEntity;
	BusinessEntity tenant;
	PartTest partTest = new PartTest();
	Part originalPart = null;
	Part substitutedPart =null;
	PartSubstitute partSubstitute = null;
	PartSubstitute dbPartSubstitute = null;
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
	}

	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(partSubstitute);
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
			originalPart = partTest.partObjectToSave();
			entityManager.persist(originalPart);
			substitutedPart =partTest.partObjectToSave();
			entityManager.persist(substitutedPart);
			tx.commit();
		}
	}
	
	private void createPartSubstitute(){
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			partSubstitute = partSubsituteObjectTobeSaved();
			setPartSubsituteComments(partSubstitute);
			entityManager.persist(partSubstitute);
			tx.commit();
	}
	}
		private PartSubstitute partSubsituteObjectTobeSaved() {
			PartSubstitute partSubstitute = new PartSubstitute();
			partSubstitute.setOriginalPart(originalPart);
			partSubstitute.setSubstitutedPart(substitutedPart);
			partSubstitute.setFamilyCode("KW001");
			partSubstitute.setCode("admin"+System.currentTimeMillis());
			partSubstitute.setCreatedBy(776L);
			partSubstitute.setCreatedDate(MizeDateTime.now());
			partSubstitute.setEndDate(MizeDateTime.now());
			partSubstitute.setDate(MizeDateTime.now());
			partSubstitute.setSequenceNo(1);
			partSubstitute.setUpdatedBy(776l);
			
			return partSubstitute;
		}
		private void setPartSubsituteComments(PartSubstitute partSubstitute)
		{
			List<PartSubstituteComment> comments = new ArrayList<PartSubstituteComment>();
			PartSubstituteComment partSubstituteComment = new PartSubstituteComment();
			EntityComment comment =createEntityComment();
			partSubstituteComment.setPartSubstitute(partSubstitute);
			partSubstituteComment.setComment(comment);
			comments.add(partSubstituteComment);
			partSubstitute.setComments(comments);
			
		}
		public class PartSubsituteRowMapper implements RowMapper<PartSubstitute>{

			@Override
			public PartSubstitute mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				PartSubstitute partSubstitute = new PartSubstitute();
				partSubstitute.setId(rs.getLong("id"));
				Part part= new Part();
				part.setId(rs.getLong("old_part_id"));
				partSubstitute.setOriginalPart(part);
				Part new_part = new Part();
				new_part.setId(rs.getLong("new_part_id"));
				partSubstitute.setSubstitutedPart(new_part);
				partSubstitute.setFamilyCode(rs.getString("family_code"));
				partSubstitute.setCode(rs.getString("substitute_code"));
				partSubstitute.setCreatedBy(rs.getLong("created_by"));
				partSubstitute.setCreatedDate(Formatter.toMizeDateTime(rs.getTimestamp("created_date")));
				partSubstitute.setEndDate(Formatter.toMizeDateTime(rs.getTimestamp("end_date")));
				partSubstitute.setDate(Formatter.toMizeDateTime(rs.getTimestamp("substitute_date")));
				partSubstitute.setSequenceNo(rs.getInt("sequence_no"));
				partSubstitute.setUpdatedBy(rs.getLong("updated_by"));
				
				return partSubstitute;
			}
			
		}
		public class PartSubCommentRowMapper implements RowMapper<PartSubstituteComment>{

			@Override
			public PartSubstituteComment mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				PartSubstituteComment partSubstituteComment = new PartSubstituteComment();
				partSubstituteComment.setId(rs.getLong("id"));
				EntityComment comment =new EntityComment();
				comment.setId(rs.getLong("comment_id"));
				PartSubstitute partSubstitute = new PartSubstitute();
				partSubstitute.setId(rs.getLong("part_substitute_id"));
				partSubstituteComment.setPartSubstitute(partSubstitute);
				partSubstituteComment.setComment(comment);
				
				return partSubstituteComment;
			}
			
		}
		private PartSubstitute retrievePartSubsitutte(){
			dbPartSubstitute = jdbcTemplate.queryForObject(PART_SUBSITUTE_QUERY, new Object[]{partSubstitute.getId()}, new PartSubsituteRowMapper());
			if(dbPartSubstitute != null){
				List<PartSubstituteComment> partSubstituteComments = jdbcTemplate.query(PART_SUBSITUTE_COMMENT_QUERY, new Object[]{dbPartSubstitute.getId()}, new PartSubCommentRowMapper());
				dbPartSubstitute.setComments(partSubstituteComments);
			}
			return dbPartSubstitute;
			
		}
		
		@Test
		public void savePartSubsituteTest(){
			createPartSubstitute();
			try{
				if(partSubstitute!= null)
				{
					dbPartSubstitute = retrievePartSubsitutte();
					if(dbPartSubstitute != null){
						assertTrue(partSubstitute.getId()!=null);
						assertTrue(dbPartSubstitute.getId()!=null);
						assertTrue(compare(partSubstitute, dbPartSubstitute));
					}
					
				}tearDown();
			}catch(Throwable th){
				th.printStackTrace();
				fail("Got Exception");
			}
		}
		@Test
		public void updatePartSubsituteTest(){
			createPartSubstitute();
			try{
				if(partSubstitute!= null){
					partSubstitute.setCode("adminTest"+System.currentTimeMillis());
					partSubstitute.setFamilyCode("KW002");
					persist();
					dbPartSubstitute = retrievePartSubsitutte();
					if(dbPartSubstitute != null){
						assertTrue(partSubstitute.getId()!=null);
						assertTrue(dbPartSubstitute.getId()!=null);
						assertTrue(compare(partSubstitute, dbPartSubstitute));
					}
				}tearDown();
			}catch(Throwable th){
				th.printStackTrace();
				fail("Got Exception");
			}
		}
		public void tearDown() throws Exception {
			try {
				if (partSubstitute != null) {
					tx.begin();
					entityManager.remove(partSubstitute);
					entityManager.remove(originalPart);
					entityManager.remove(substitutedPart);
					entityManager.remove(businessEntity);
					entityManager.remove(tenant);
					tx.commit();
				}
				entityManager.close();
			} catch (Throwable th) {
				th.printStackTrace();
			}
		}
		private boolean compare(PartSubstitute partSubstitute ,PartSubstitute dbPartSubstitute){
			if(partSubstitute == null && dbPartSubstitute == null){
				return true;
			}
			if(partSubstitute == null  ){
				if(dbPartSubstitute != null){
					return false;
				}
			}else if(partSubstitute!=null ){
				if(dbPartSubstitute == null){
					return false;
				}
			}
			if(!partSubstitute.getId().equals(dbPartSubstitute.getId())){
				return false;
			}
			if(!partSubstitute.getCode().equals(dbPartSubstitute.getCode())){
				return false;
			}
			return true;
		}
}

	
