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

import com.mize.domain.common.Locale;

public class CatalogEntryIntlTest extends JPATest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	EntityManager entityManager = null;
	CatalogEntryIntl catalogEntryIntl = null;

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		CatalogEntry ce = findExistingCatalogEntry(entityManager);
		Locale locale = findLocaleObjectFromDBToBeUsedForCatalogIntl();
		catalogEntryIntl = createCatalogEntryIntlObjectToBeSavedInDB(ce,locale);		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(catalogEntryIntl);
		tx.commit();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}

	@Test
	public void test() {
		try {		
			CatalogEntryIntl catalogEntryIntlFromDB = (CatalogEntryIntl) entityManager.find(CatalogEntryIntl.class, new Long(1));
			assertTrue(catalogEntryIntl.equals(catalogEntryIntlFromDB));
		} catch (Throwable th) {
			th.printStackTrace();
			fail();
			throw th;
		}
	}

	private CatalogEntryIntl createCatalogEntryIntlObjectToBeSavedInDB(CatalogEntry ce, Locale locale) {		
		CatalogEntryIntl catalogEntryIntl = new CatalogEntryIntl(ce, "ItemName", "ItemDesc", locale);
		catalogEntryIntl.setCreatedDate(DateTime.now());
		catalogEntryIntl.setUpdatedDate(DateTime.now());
		catalogEntryIntl.setCreatedBy(1L);
		catalogEntryIntl.setUpdatedBy(1L);
		return catalogEntryIntl;
	}

}
