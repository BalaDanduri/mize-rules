package com.mize.domain.sce.part;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.servicelocator.BusinessEntity;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class PartTest extends JPATest  {
	
	private static String PART_QUERY = "select * from part where id = ?";
	private static String PART_ATT_QUERY = "select * from part_attribute where id = ?";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	EntityManager entityManager = null;
	Part part = null;
	PartAttribute partAttribute = null;

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		BusinessEntity be = findExistingBE(entityManager);
		part = getPartObjectToSave(be);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(part);
		tx.commit();
	}

	
	@SuppressWarnings("rawtypes")
	@Test
	public void test() {
		try {
		
			// test that catalog is created in db and is equal to same
			List<Part>  parts = jdbcTemplate.query(PART_QUERY, new Object[]{part.getId()}, new PartRowMapper());	
			Query query = entityManager.createQuery("from Part");
			List parts2 =query.getResultList();
			List<Part>  parts1 = jdbcTemplate.query("select * from part", new Object[]{}, new PartRowMapper());	
			
			if (parts == null || parts.size() == 0) {
				fail("Found Nothing");
			}
			for(Part p : parts1){
				assertNotNull(p);
			}
			for (Iterator iterator = parts2.iterator(); iterator.hasNext();) {
				Part p = (Part) iterator.next();
				assertNotNull(p);
				if(p!=null){
					if(p.getPartAttributes()!=null){
						for(PartAttribute pa : p.getPartAttributes()){
							assertNotNull(pa);
						}
					}
					if(p.getPartPrices()!=null){
						for(PartPrice pp: p.getPartPrices()){
							assertNotNull(pp);
						}
					}
					if(p.getPartIntl()!=null){
						for(PartIntl pintl : p.getPartIntl()){
							assertNotNull(pintl);
						}
					}
				}
			}
			Part partFromDB = parts.get(0);			
			assertTrue(part.getId().equals(partFromDB.getId()));
			assertTrue(part.getTenant().getId().equals(partFromDB.getTenant().getId()));
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}

	private Part getPartObjectToSave(BusinessEntity be) {
		Part part = new Part(be,"partcode3","partType","Y","N","N",null,null,null,null,null,null);
		return part ;
	}

	
	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}
	
	private class PartRowMapper implements RowMapper<Part>{

		@Override
		public Part mapRow(ResultSet resultSet, int arg1)
				throws SQLException {
			Part part = new Part();
			part.setId(resultSet.getLong("id"));
			part.setIsActive(resultSet.getString("is_active"));
			part.setType(resultSet.getString("part_type"));
            part.setIsSerialized(resultSet.getString("is_serialized"));
            part.setIsReturnable(resultSet.getString("is_returnable"));
            part.setUom(resultSet.getString("uom"));
			BusinessEntity be = new BusinessEntity();
			be.setId(resultSet.getLong("tenant_id"));					
			part.setTenant(be);
			return part;
		}
	}

	
	@Test
	public void testPartAttribute(){
	    partAttribute = createPartAttributeObjectToSave(part);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(partAttribute);
		tx.commit();
		assertNotNull(partAttribute.getId());
		List<PartAttribute> partAttributes = jdbcTemplate.query(PART_ATT_QUERY, new Object[]{partAttribute.getId()}, new PartAttributeRowMapper());	
		if(!Formatter.isEmpty(partAttributes)){
			PartAttribute partAttribute1 = partAttributes.get(0);
			assertTrue(partAttribute1.getId().equals(partAttribute.getId()));
			assertTrue(partAttribute1.getAttributeCode().equals(partAttribute.getAttributeCode()));
		}
	}
	
	
	@Test
	public void testPartAttribute1(){
	    partAttribute = createPartAttributeObjectToSave(null);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(partAttribute);
		tx.commit();
		assertNotNull(partAttribute.getId());
		List<PartAttribute> partAttributes = jdbcTemplate.query(PART_ATT_QUERY, new Object[]{partAttribute.getId()}, new PartAttributeRowMapper());	
		if(!Formatter.isEmpty(partAttributes)){
			PartAttribute partAttribute1 = partAttributes.get(0);
			assertTrue(partAttribute1.getId().equals(partAttribute.getId()));
			assertTrue(partAttribute1.getAttributeCode().equals(partAttribute.getAttributeCode()));
		}
	}

	private PartAttribute createPartAttributeObjectToSave(Part part) {
	   PartAttribute partAttribute = new PartAttribute(part, "attributCode3", "attributeValue3", "Standard");
	  return partAttribute;
	}
	
	private class PartAttributeRowMapper implements RowMapper<PartAttribute>{

		@Override
		public PartAttribute mapRow(ResultSet rs, int rowNum)throws SQLException {
			 PartAttribute partAttribute = new PartAttribute();
			 partAttribute.setId(rs.getLong("id"));
			 partAttribute.setAttributeCode(rs.getString("attribute_code"));
			 partAttribute.setAttributeUOM(rs.getString("attribute_uom"));
			 partAttribute.setAttributeValue(rs.getString("attribute_value"));
			 Part part = new Part();
			 part.setId(rs.getLong("part_id"));
			 partAttribute.setPart(part);
			return partAttribute;
		}
		
	}
	
}
