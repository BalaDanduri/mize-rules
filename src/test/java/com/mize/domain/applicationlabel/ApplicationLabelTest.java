package com.mize.domain.applicationlabel;

import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.MizeDateTime;
@ContextConfiguration(locations={"/test-context.xml"})
public class ApplicationLabelTest extends JPATest{

	private static final String APPLABEL_QUERY = "select * from application_labels where id=?";
	private static final String APPLABEL_INTL_QUERY = "select * from application_labels_intl where label_id=?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity tenant;
	ApplicationLabel appLabel = null;
	ApplicationLabel dbAppLabel = null;
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		tenant = findExistingBE(entityManager);
	}
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(appLabel);
		tx.commit();
	}
	private void createAppLabel() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			appLabel = appLabelObjectToSave();
			setAppLabelIntl(appLabel);
			entityManager.persist(appLabel);
			tx.commit();
		}

	}
	private ApplicationLabel appLabelObjectToSave() {
		ApplicationLabel appLabel = new ApplicationLabel();
		appLabel.setTenant(tenant);
		appLabel.setCode("USR_DTLS");
		appLabel.setIsActive("Y");
		appLabel.setIsDefault("Y");
		appLabel.setCategory("application");
		appLabel.setCreatedBy(796L);
		appLabel.setUpdatedBy(796L);
		appLabel.setCreatedDate(MizeDateTime.now());
		appLabel.setUpdatedDate(MizeDateTime.now());
		return appLabel;
	}
	private void setAppLabelIntl(ApplicationLabel appLabel2) {
		ApplicationLabelIntl appLabelIntl = new ApplicationLabelIntl();
		List<ApplicationLabelIntl> intls = new ArrayList<ApplicationLabelIntl>();
		Locale locale = findLocaleObjectFromDB();
		appLabelIntl.setLocale(locale);
		appLabelIntl.setApplicationLabel(appLabel);
		appLabelIntl.setName("User Details");
		appLabelIntl.setDescription("Label Description");
		appLabelIntl.setCreatedBy(796L);
		appLabelIntl.setUpdatedBy(796L);
		appLabelIntl.setCreatedDate(MizeDateTime.now());
		appLabelIntl.setUpdatedDate(MizeDateTime.now());
		intls.add(appLabelIntl);
		appLabel.setIntls(intls);
		
	}
	public class AppLabelRowMapper implements RowMapper<ApplicationLabel>{

		@Override
		public ApplicationLabel mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ApplicationLabel appLabel = new ApplicationLabel();
			appLabel.setId(rs.getLong("id"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			appLabel.setTenant(tenant);
			appLabel.setCode(rs.getString("label_code"));
			appLabel.setCategory(rs.getString("label_category"));
			appLabel.setIsActive(rs.getString("is_active"));
			appLabel.setIsDefault(rs.getString("is_default"));
			appLabel.setCreatedBy(rs.getLong("created_by"));
			appLabel.setUpdatedBy(rs.getLong("updated_by"));
			appLabel.setCreatedDate(Formatter.toMizeDateTime(rs.getTimestamp("created_date")));
			appLabel.setUpdatedDate(Formatter.toMizeDateTime(rs.getTimestamp("updated_date")));	
			return appLabel;
		}	
	}
	public class AppLabelIntlRowMapper implements RowMapper<ApplicationLabelIntl>{

		@Override
		public ApplicationLabelIntl mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			ApplicationLabelIntl appLabelIntl = new ApplicationLabelIntl();
			Locale locale = new Locale();
			locale.setId(rs.getLong("locale_id"));
			appLabelIntl.setLocale(locale);
			ApplicationLabel appLabel = new ApplicationLabel();
			appLabel.setId(rs.getLong("label_id"));
			appLabelIntl.setApplicationLabel(appLabel);
			appLabelIntl.setName(rs.getString("label_name"));
			appLabelIntl.setDescription(rs.getString("label_description"));
			appLabelIntl.setCreatedBy(rs.getLong("created_by"));
			appLabelIntl.setUpdatedBy(rs.getLong("updated_by"));
			appLabelIntl.setCreatedDate(Formatter.toMizeDateTime(rs.getTimestamp("created_date")));
			appLabelIntl.setUpdatedDate(Formatter.toMizeDateTime(rs.getTimestamp("updated_date")));
			return appLabelIntl;
		}
		
	}
	public ApplicationLabel retrieveLabel(){
		dbAppLabel = jdbcTemplate.queryForObject(APPLABEL_QUERY, new Object[]{appLabel.getId()}, new AppLabelRowMapper());
		if(dbAppLabel !=null){
			List<ApplicationLabelIntl> intls = jdbcTemplate.query(APPLABEL_INTL_QUERY, new Object[]{dbAppLabel.getId()}, new AppLabelIntlRowMapper());
			dbAppLabel.setIntls(intls);
		}
		return dbAppLabel;
	}
	
	/*@Test
	public void saveAppLabelTest(){
		createAppLabel();
		try{
			if(appLabel != null){
				dbAppLabel = retrieveLabel();
				if(dbAppLabel != null){
					assertTrue(appLabel.getId()!=null);
					assertTrue(dbAppLabel.getId()!=null);
					
				}
			}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
		
	}
	@Test
	public void updateAppLabelTest(){
		createAppLabel();
		try{
			if(appLabel != null){
				appLabel.setCode("test");
				persist();
				dbAppLabel = retrieveLabel();
				if(dbAppLabel != null){
					assertTrue(appLabel.getId()!=null);
					assertTrue(dbAppLabel.getId()!=null);
					
				}
			}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
		
	}*/
	
	@Test
	public void retreiveAppLabelTest() {
		appLabel = new ApplicationLabel();
		appLabel.setId(300L);
		ApplicationLabel dbAppLabel = retrieveLabel();
		assertTrue(dbAppLabel != null && dbAppLabel.getId() != null);
	}
	
	public void tearDown() throws Exception {
		try {
			if (appLabel != null) {
				tx.begin();
				entityManager.remove(appLabel);
				entityManager.remove(tenant);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
	
}
