package com.mize.domain.sce.catalog;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.catalog.Catalog;
import com.mize.domain.catalog.CatalogIntl;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;


@ContextConfiguration(locations={"/test-context.xml"})
public class CatalogIntlTest extends JPATest {
	
	private static String CATALOG_INTL_QUERY = "select * from catalog_intl where id = ?";

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

		catalog = findExistingCatalog(entityManager);
		Locale locale = findLocaleObjectFromDBToBeUsedForCatalogIntl();			
		catalogIntl = createCatalogIntlObjectToBeSavedinDB(catalog, locale);
		//save catalog
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(catalogIntl);
		tx.commit();
	}

	@After
	public void tearDown() throws Exception {
		entityManager.close();
	}

	@Test
	public void basicCatalogAndCatalogIntlRelationshipTest() {
		try {
			/*Catalog catalogFromDB = entityManager.find(Catalog.class, catalog.getId());
			CatalogIntl catalogIntlfromDB = (CatalogIntl) entityManager.find(CatalogIntl.class, new Long(1));*/
			List<CatalogIntl> intlList = jdbcTemplate.query(CATALOG_INTL_QUERY, new Object[]{catalogIntl.getId()}, new RowMapper<CatalogIntl>() {
				@Override
				public CatalogIntl mapRow(ResultSet resultSet, int arg1)
						throws SQLException {
					CatalogIntl intl = new CatalogIntl();
					intl.setId(resultSet.getLong("id"));
					intl.setCatalogName(resultSet.getString("catalog_name"));
					intl.setCatalogDescription(resultSet.getString("catalog_desc"));
					Catalog catalog = new Catalog();
					catalog.setId(resultSet.getLong("catalog_id"));
					intl.setCatalog(catalog);
					Locale locale = new Locale();
					locale.setId(resultSet.getLong("locale_id"));
					intl.setLocale(locale);
					return intl;
				}
				
			});
			// catalog after find should be equals to previous one

			if (intlList == null || intlList.size() == 0) {
				fail("Found Nothing");
			}
			CatalogIntl catalogIntlfromDB = intlList.get(0);
			assertTrue(catalogIntl.getId().equals(catalogIntlfromDB.getId()));
			assertTrue(catalogIntl.getCatalogName().equals(catalogIntlfromDB.getCatalogName()));
			assertTrue(catalogIntl.getCatalogDescription().equals(catalogIntlfromDB.getCatalogDescription()));
			assertTrue(catalogIntl.getLocale().getId().equals(catalogIntlfromDB.getLocale().getId()));
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}



	/*private void setCatalogIntlIntoCatalog(Catalog catalog,
			CatalogIntl catalogIntl) {
		List<CatalogIntl> list = new ArrayList<CatalogIntl>();
		list.add(catalogIntl);
		catalog.setCatalogIntl(list);
	}*/


	private CatalogIntl createCatalogIntlObjectToBeSavedinDB(Catalog catalog,
			Locale locale) {
		CatalogIntl catalogIntl = new CatalogIntl(catalog, locale,"Test", "Test description");
		return catalogIntl;
	}


	/*private Catalog createCatalogObjectToBeSavedInDB(BusinessEntity be) {
		Catalog catalog = new Catalog(be, "ABC", "Test", "Y", null);
		return catalog;
	}*/

}

