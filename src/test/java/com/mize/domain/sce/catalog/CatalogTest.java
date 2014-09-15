package com.mize.domain.sce.catalog;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.catalog.Catalog;
import com.mize.domain.catalog.CatalogEntry;
import com.mize.domain.catalog.CatalogEntryIntl;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class CatalogTest extends JPATest {
	
	private static String CATALOG_QUERY = "select * from catalog where id = ?";
	private static String CATALOG_ENTRY_QUERY = "select * from catalog_entry where catalog_id=?";
	private static String CATALOG_ENTRY_INTL_QUERY = "select * from catalog_entry_intl where catalog_entry_id = ?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity tenant;
	Catalog catalog = null;
	Catalog dbCatalog = null;
	CatalogEntry catalogEntry = null;
	CatalogEntryIntl catalogEntryIntl = null;
	
	
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		createMasterData();
	}
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(catalog);
		tx.commit();
	}

	
	private void createMasterData() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			tenant = createTenant();
			entityManager.persist(tenant);
			tx.commit();
		}
	}
	private void createCatalog() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			catalog = catlogObjectTosave();
			createCatalogEntry(catalog);
			entityManager.persist(catalog);
			tx.commit();
		}
	}
	private Catalog catlogObjectTosave() {
		Catalog catalog = new Catalog();
		catalog.setTenant(tenant);
		catalog.setCatalogCode("CL"+System.currentTimeMillis());
		catalog.setCatalogType("Test");
		catalog.setIsActive("Y");
		catalog.setCatalogName("InspectionType");
		catalog.setCreatedBy(796L);
		catalog.setCreatedDate(DateTime.now());
		catalog.setUpdatedBy(796L);
		catalog.setUpdatedDate(DateTime.now());
		return catalog;
	}
	private void createCatalogEntry(Catalog catalog){
		catalogEntry = new CatalogEntry();
		List<CatalogEntry> catalogEntrys =  new ArrayList<CatalogEntry>();
		catalogEntry.setCatalog(catalog);
		catalogEntry.setItemCode("Pre-Delivery");
		catalogEntry.setIsActive("Y");
		catalogEntry.setCreatedDate(DateTime.now());
		catalogEntry.setUpdatedDate(DateTime.now());
		catalogEntry.setCreatedBy(769l);
		catalogEntry.setUpdatedBy(769l);
		catalogEntry.setIsDefault("Y");
		catalogEntry.setOrderSequence(1l);
		createCatalogEntryIntl(catalogEntry);
		catalogEntrys.add(catalogEntry);
		catalog.setCatalogEntry(catalogEntrys);
		
	}
	private void createCatalogEntryIntl(CatalogEntry catalogEntry){
		
		catalogEntryIntl = new CatalogEntryIntl();
		List<CatalogEntryIntl> catalogEntryIntls = new ArrayList<CatalogEntryIntl>();
		
		catalogEntryIntl.setCatalogEntry(catalogEntry);
		Locale locale= findLocaleObjectFromDB();
		catalogEntryIntl.setLocale(locale);
		catalogEntryIntl.setItemName("Pre-Delivery");
		catalogEntryIntl.setItemDescription("Pre-Delivery");
		catalogEntryIntl.setCreatedBy(796l);
		catalogEntryIntl.setUpdatedBy(796l);
		catalogEntryIntl.setCreatedDate(DateTime.now());
		catalogEntryIntl.setUpdatedDate(DateTime.now());
		catalogEntryIntls.add(catalogEntryIntl);
		catalogEntry.setCatalogEntryIntl(catalogEntryIntls);
		
	}
	public class CatalogEntryRowMapper implements RowMapper<CatalogEntry>{

		@Override
		public CatalogEntry mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CatalogEntry catalogEntry = new CatalogEntry();
			Catalog catalog = new Catalog();
			catalog.setId(rs.getLong("catalog_id"));
			catalogEntry.setCatalog(catalog);
			catalogEntry.setItemCode(rs.getString("item_code"));
			catalogEntry.setIsActive(rs.getString("is_active"));
			catalogEntry.setCreatedDate(Formatter.dateTime(rs.getTimestamp("created_date")));
			catalogEntry.setUpdatedDate(Formatter.dateTime(rs.getTimestamp("updated_date")));
			catalogEntry.setCreatedBy(rs.getLong("created_by"));
			catalogEntry.setUpdatedBy(rs.getLong("updated_by"));
			catalogEntry.setIsDefault(rs.getString("is_default"));
			catalogEntry.setOrderSequence(rs.getLong("order_sequence"));
			
			return catalogEntry;
		}
		
	}
	
	public class CatalogRowMapper implements RowMapper<Catalog>{

		@Override
		public Catalog mapRow(ResultSet rs, int rowNum) throws SQLException {
			Catalog catalog = new Catalog();
			catalog.setId(rs.getLong("id"));
			catalog.setCatalogCode(rs.getString("catalog_code"));
			catalog.setCatalogType(rs.getString("catalog_type"));
			catalog.setIsActive(rs.getString("is_active"));
			catalog.setCatalogName(rs.getString("catalog_name"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));					
			catalog.setTenant(tenant);
			catalog.setCreatedBy(rs.getLong("created_by"));
			catalog.setUpdatedBy(rs.getLong("updated_by"));
			catalog.setUpdatedDate(Formatter.dateTime(rs.getTimestamp("updated_date")));
			catalog.setCreatedDate(Formatter.dateTime(rs.getTimestamp("created_date")));
			return catalog;
		
		}
		
	}
	public class CatalogEntryIntlRowMapper implements RowMapper<CatalogEntryIntl>{

		@Override
		public CatalogEntryIntl mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			CatalogEntryIntl catalogEntryIntl = new CatalogEntryIntl();
			
			CatalogEntry catalogEntry = new CatalogEntry();
			catalogEntry.setId(rs.getLong("catalog_entry_id"));
			catalogEntryIntl.setCatalogEntry(catalogEntry);
			Locale locale= new Locale();
			locale.setId(rs.getLong("locale_id"));
			catalogEntryIntl.setLocale(locale);
			catalogEntryIntl.setItemName(rs.getString("item_name"));
			catalogEntryIntl.setItemDescription(rs.getString("item_description"));
			catalogEntryIntl.setCreatedBy(rs.getLong("created_by"));
			catalogEntryIntl.setUpdatedBy(rs.getLong("updated_by"));
			catalogEntryIntl.setCreatedDate(Formatter.dateTime(rs.getTimestamp("created_date")));
			catalogEntryIntl.setUpdatedDate(Formatter.dateTime(rs.getTimestamp("updated_date")));
			
			return catalogEntryIntl;
		}
		
	}
	
	public Catalog retrievCatalog(){
		dbCatalog = jdbcTemplate.queryForObject(CATALOG_QUERY, new Object[]{catalog.getId()}, new CatalogRowMapper());
		if(dbCatalog != null){
			List<CatalogEntry> catalogEntries = jdbcTemplate.query(CATALOG_ENTRY_QUERY, new Object[]{dbCatalog.getId()}, new CatalogEntryRowMapper());
			if(catalogEntries !=null){
				List<CatalogEntryIntl> intls = jdbcTemplate.query(CATALOG_ENTRY_INTL_QUERY, new Object[]{catalogEntry.getId()}, new CatalogEntryIntlRowMapper());
				catalogEntry.setCatalogEntryIntl(intls);
				dbCatalog.setCatalogEntry(catalogEntries);
			}
			
			dbCatalog.setCatalogEntry(catalogEntries);
		}
		return dbCatalog;
	}
	
	@Test
	public void saveCatalogTest(){
		
		createCatalog();
		try{
		if(catalog != null){
			dbCatalog = retrievCatalog();
			if(dbCatalog!= null){
				assertTrue(catalog.getId()!= null);
				assertTrue(dbCatalog.getId()!=null);
						
			}
		}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}
	
	@Test
	public void updateCatalogTest(){
		createCatalog();
		try{
		if(catalog != null){
			catalog.setCatalogName("Mize");
			catalog.setCatalogType("Inshop");
			persist();
			dbCatalog = retrievCatalog();
			if(dbCatalog!= null){
				assertTrue(catalog.getId()!= null);
				assertTrue(dbCatalog.getId()!=null);
						
			}
		}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
		
	}
	
	public void tearDown() throws Exception {
		try {
			if (catalog != null) {
				tx = entityManager.getTransaction();
				tx.begin();
				entityManager.remove(catalogEntryIntl);
				entityManager.remove(catalog);
				entityManager.remove(tenant);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
	
	
}

