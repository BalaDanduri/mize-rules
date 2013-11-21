package com.mize.domain.sce.catalog;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.catalog.CatalogEntry;
import com.mize.domain.catalog.CatalogEntryIntl;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;

@ContextConfiguration(locations={"/test-context.xml"})
public class CatalogEntryIntlTest extends JPATest {
	
	private static String CATALOG_ENTRY_INTL_QUERY = "select * from catalog_entry_intl where id = ?";
	
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
		Locale locale = findLocaleObjectFromDB();
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
			List<CatalogEntryIntl> entryIntlList = jdbcTemplate.query(CATALOG_ENTRY_INTL_QUERY, new Object[]{catalogEntryIntl.getId()}, new RowMapper<CatalogEntryIntl>() {
				@Override
				public CatalogEntryIntl mapRow(ResultSet resultSet, int arg1)
						throws SQLException {
					CatalogEntryIntl catalogEntryIntl = new CatalogEntryIntl();
					catalogEntryIntl.setId(resultSet.getLong("id"));
					catalogEntryIntl.setItemName(resultSet.getString("item_name"));
					catalogEntryIntl.setItemDescription(resultSet.getString("item_desc"));
					CatalogEntry catalogEntry = new CatalogEntry();
					catalogEntry.setId(resultSet.getLong("catalog_entry_id"));
					catalogEntryIntl.setCatalogEntry(catalogEntry);
					Locale locale = new Locale();
					locale.setId(resultSet.getLong("locale_id"));
					catalogEntryIntl.setLocale(locale);
					return catalogEntryIntl;
				}
				
			});
			if (entryIntlList == null || entryIntlList.size() == 0) {
				fail("Found Nothing");
			}
			CatalogEntryIntl catalogEntryIntlFromDB = entryIntlList.get(0);
			assertTrue(catalogEntryIntl.getId().equals(catalogEntryIntlFromDB.getId()));
			assertTrue(catalogEntryIntl.getItemName().equals(catalogEntryIntlFromDB.getItemName()));
			assertTrue(catalogEntryIntl.getItemDescription().equals(catalogEntryIntlFromDB.getItemDescription()));
			assertTrue(catalogEntryIntl.getCatalogEntry().getId().equals(catalogEntryIntlFromDB.getCatalogEntry().getId()));
			assertTrue(catalogEntryIntl.getLocale().getId().equals(catalogEntryIntlFromDB.getLocale().getId()));
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
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
