package com.mize.domain.sce.catalog;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mize.domain.common.Locale;
import com.mize.domain.servicelocator.BusinessEntity;

public class CatalogIntlTest extends JPATest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	Catalog catalog = null;
	CatalogIntl catalogIntl = null;
	EntityManager entityManager = null;
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		BusinessEntity be = findExistingBEtoBeusedwiththecatalogastenantid();
		catalog = createCatalogObjectToBeSavedInDB(be);		
		Locale locale = findLocaleObjectFromDBToBeUsedForCatalogIntl();			
		catalogIntl = createCatalogIntlObjectToBeSavedinDB(catalog, locale);
		setCatalogIntlIntoCatalog(catalog, catalogIntl);
		
		//save catalog
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(catalog);
		tx.commit();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}

	@Test
	public void basicCatalogAndCatalogIntlRelationshipTest() {
		try {
			Catalog catalogFromDB = entityManager.find(Catalog.class, new Long(1));
			CatalogIntl catalogIntlfromDB = (CatalogIntl) entityManager.find(CatalogIntl.class, new Long(1));		
			// catalog after find should be equals to previous one
			assertTrue(catalog.equals(catalogFromDB));
			assertTrue(catalogIntlfromDB.equals(catalogIntl));
			List<CatalogIntl> catalognames =  catalogFromDB.getCatalogIntl();
			assertNotNull(catalognames);
			assertTrue(catalognames.get(0).equals(catalogIntlfromDB));
		} catch (Throwable th) {
			th.printStackTrace();
			fail();
			throw th;
		}
	}

	private void setCatalogIntlIntoCatalog(Catalog catalog,
			CatalogIntl catalogIntl) {
		List<CatalogIntl> list = new ArrayList<CatalogIntl>();
		list.add(catalogIntl);
		catalog.setCatalogIntl(list);
	}

	private CatalogIntl createCatalogIntlObjectToBeSavedinDB(Catalog catalog,
			Locale locale) {
		CatalogIntl catalogIntl = new CatalogIntl(catalog, locale,"Test", "Test description");
		return catalogIntl;
	}

	private Catalog createCatalogObjectToBeSavedInDB(BusinessEntity be) {
		Catalog catalog = new Catalog(be, "ABC", "Test", "Y", null);
		return catalog;
	}

}
