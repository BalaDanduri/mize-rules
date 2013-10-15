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

@ContextConfiguration(locations={"/test-context.xml"})
public class CatalogEntryTest extends JPATest {
	
	private static String CATALOG_ENTRY_QUERY = "select * from catalog_entry where id = ?";
	
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
			
			List<CatalogEntry>  catalogEntries = jdbcTemplate.query(CATALOG_ENTRY_QUERY, new Object[]{catalogEntry.getId()}, new RowMapper<CatalogEntry> (){

				@Override
				public CatalogEntry mapRow(ResultSet resultSet, int arg1)
						throws SQLException {
					CatalogEntry catalogEntry = new CatalogEntry();
					catalogEntry.setId(resultSet.getLong("id"));
					catalogEntry.setItemCode(resultSet.getString("item_code"));					
					catalogEntry.setIsActive(resultSet.getString("is_active"));						
					Catalog catalog = new Catalog();
					catalog.setId(resultSet.getLong("catalog_id"));		
					catalogEntry.setCatalog(catalog);
					return catalogEntry;
				}
			});
			if (catalogEntries == null || catalogEntries.size() == 0) {
				fail("Found Nothing");
			}
			CatalogEntry catalogEntryFromDB = catalogEntries.get(0);
			assertTrue(catalogEntry.equals(catalogEntryFromDB));
		} catch (Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
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
