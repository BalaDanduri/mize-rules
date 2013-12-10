package com.mize.domain.sce.part;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;


import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.part.Part;
import com.mize.domain.part.PartSubstitute;
import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class PartSubsituteTest extends JPATest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	EntityManager entityManager = null;
	Part originalPart = null;
	Part substitutedPart =null;
	

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		BusinessEntity be =  findExistingBE(entityManager);
		originalPart = getPartObjectToSave(be ,"code001");
		substitutedPart = getPartObjectToSave(be ,"code002");
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(originalPart);
		entityManager.persist(substitutedPart);
		tx.commit();
	}
	
	private Part getPartObjectToSave(BusinessEntity be, String partCode) {
		Part part = new Part(be,partCode,"partType","Y","N","N",null,null,null,null,null);
		return part ;
	}
	
	
	@Test
	public void savePartSubsitute() {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		PartSubstitute partSubstitute = new PartSubstitute();
		partSubstitute.setCode("SubCode");
		partSubstitute.setComments("Test Comments");
		partSubstitute.setDate(DateTime.now());
		partSubstitute.setOriginalPart(originalPart);
		partSubstitute.setFamilyCode("KW001");
		partSubstitute.setSubstitutedPart(substitutedPart);
		partSubstitute.setCreatedDate(DateTime.now());
		partSubstitute.setUpdatedDate(DateTime.now());
		entityManager.persist(partSubstitute);
		tx.commit();
		assertNotNull(partSubstitute.getId());
	}
}
