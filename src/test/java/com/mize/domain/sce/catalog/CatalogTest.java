/**
 * 
 */
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

import com.mize.domain.servicelocator.BusinessEntity;

public class CatalogTest extends JPATest {
	
	private static String CATALOG_QUERY = "select * from catalog where id = ?";
	
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
		// test that catalog is created in db and is equal to same
			List<Catalog>  catalogs = jdbcTemplate.query(CATALOG_QUERY, new Object[]{catalog.getId()}, new RowMapper<Catalog> (){

				@Override
				public Catalog mapRow(ResultSet resultSet, int arg1)
						throws SQLException {
					Catalog catalog = new Catalog();
					catalog.setId(resultSet.getLong("id"));
					catalog.setCatalogCode(resultSet.getString("catalog_code"));
					catalog.setCatalogType(resultSet.getString("catalog_type"));
					catalog.setIsActive(resultSet.getString("is_active"));
					BusinessEntity be = new BusinessEntity();
					be.setId(resultSet.getLong("tenant_id"));					
					catalog.setTenant(be);
					return catalog;
				}
			});		
			Catalog catalogFromDB = catalogs.get(0);			
			assertTrue(catalog.getId().equals(catalogFromDB.getId()));
			assertTrue(catalog.getCatalogCode().equals(catalogFromDB.getCatalogCode()));
			assertTrue(catalog.getCatalogType().equals(catalogFromDB.getCatalogType()));
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

