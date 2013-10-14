package com.mize.domain.sce.catalog;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CatalogEntryTest extends JPATest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	EntityManager entityManager = null;
	CatalogEntry catalogEntry = null;

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		Catalog catalog = findExistingCatalog(entityManager);
		catalogEntry = createCatalogEntryObjectToBeSavedInDB(catalog);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(catalogEntry);
		tx.commit();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}

	@Test
	public void test() {
		try {		
			CatalogEntry catalogEntryFromDB = (CatalogEntry) entityManager.find(CatalogEntry.class,	catalogEntry.getId());
			assertTrue(catalogEntry.equals(catalogEntryFromDB));
		} catch (Throwable th) {
			th.printStackTrace();
			fail();
			throw th;
		}
	}

	private CatalogEntry createCatalogEntryObjectToBeSavedInDB(Catalog catalog) {
		CatalogEntry catalogEntry = new CatalogEntry(catalog, "ABC", "Y", null);		
		
		catalogEntry.setCreatedDate(DateTime.now());
		catalogEntry.setUpdatedDate(DateTime.now());
		catalogEntry.setCreatedBy(1L);
		catalogEntry.setUpdatedBy(1L);
		return catalogEntry;
	}
	
	

}
