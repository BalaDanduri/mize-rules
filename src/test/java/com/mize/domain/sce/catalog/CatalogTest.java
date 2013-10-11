/**
 * 
 */
package com.mize.domain.sce.catalog;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

import com.mize.domain.servicelocator.BusinessEntity;

public class CatalogTest extends JPATest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	EntityManager entityManager = null;
	Catalog catalog = null;

	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		BusinessEntity be = findExistingBEtoBeusedwiththecatalogastenantid(entityManager);
		catalog = createCatalogObjectToBeSavedInDB(be);
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
	public void test() {
		try {
		// test that it is created in db and same
			Catalog catalogFromDB = (Catalog) entityManager.find(Catalog.class,
					new Long(1));
			assertTrue(catalog.equals(catalogFromDB));
		} catch (Throwable th) {
			th.printStackTrace();
			fail();
			throw th;
		}
	}

	private Catalog createCatalogObjectToBeSavedInDB(BusinessEntity be) {
		Catalog catalog = new Catalog(be, "ABC", "Test", "Y", null);
		return catalog;
	}
}
