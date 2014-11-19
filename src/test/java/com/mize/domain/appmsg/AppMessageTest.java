package com.mize.domain.appmsg;

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
public class AppMessageTest extends JPATest {

	private static final String APPMESSAGE_QUERY = "select * from application_messages where id =?";
	private static final String APPMESSAGE_INTL_QUERY = "select * from application_messages_intl where message_id =?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity tenant;
	AppMessage appMessage = null;
	AppMessage dbAppMessage = null;
	
	@Before
	public void setUp() throws Exception {
		entityManager = getEntityManager();
		tenant = findExistingBE(entityManager);
	}
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(appMessage);
		tx.commit();
	}
	private void createAppMessage() {
		if (entityManager != null) {
			tx = entityManager.getTransaction();
			tx.begin();
			appMessage = appMessageObjectToSave();
			setAppMessageIntl(appMessage);
			entityManager.persist(appMessage);
			tx.commit();
		}

	}
	private AppMessage appMessageObjectToSave() {
		AppMessage appMessage = new AppMessage();
		appMessage.setCode("PO0001");
		appMessage.setSeverity(5);
		appMessage.setCreatedBy(796L);
		appMessage.setUpdatedBy(796l);
		appMessage.setCreatedDate(MizeDateTime.now());
		appMessage.setUpdatedDate(MizeDateTime.now());
		appMessage.setMsgType("validation");
		appMessage.setTenant(tenant);
		appMessage.setIsActive("Y");
		return appMessage;
	}
	private void setAppMessageIntl(AppMessage appMessage)
	{
		AppMessageIntl appMessageIntl = new AppMessageIntl();
		List<AppMessageIntl> intls = new ArrayList<AppMessageIntl>();
		Locale locale = findLocaleObjectFromDB();
		appMessageIntl.setLocale(locale);
		appMessageIntl.setAppMessage(appMessage);
		appMessageIntl.setCreatedBy(796L);
		appMessageIntl.setUpdatedBy(796L);
		appMessageIntl.setCreatedDate(MizeDateTime.now());
		appMessageIntl.setUpdatedDate(MizeDateTime.now());
		appMessageIntl.setShortDesc("Valid Location # is required");
		appMessageIntl.setLongDesc("Valid Location # is required");
		intls.add(appMessageIntl);
		appMessage.setIntls(intls);
		
	}
	
	public class AppMessageRowMapper implements RowMapper<AppMessage>{

		@Override
		public AppMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
			AppMessage appMessage = new AppMessage();
			appMessage.setId(rs.getLong("id"));
			appMessage.setCode(rs.getString("message_code"));
			appMessage.setSeverity(rs.getInt("message_severity"));
			appMessage.setCreatedBy(rs.getLong("created_by"));
			appMessage.setUpdatedBy(rs.getLong("updated_by"));
			appMessage.setCreatedDate(Formatter.toMizeDateTime(rs.getTimestamp("created_date")));
			appMessage.setUpdatedDate(Formatter.toMizeDateTime(rs.getTimestamp("updated_date")));
			appMessage.setMsgType(rs.getString("message_type"));
			BusinessEntity tenant = new BusinessEntity();
			tenant.setId(rs.getLong("tenant_id"));
			appMessage.setTenant(tenant);
			appMessage.setIsActive(rs.getString("is_active"));
			return appMessage;
		}
		
	}
	public class AppMessageIntlRowMapper implements RowMapper<AppMessageIntl>{

		@Override
		public AppMessageIntl mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			AppMessageIntl appMessageIntl = new AppMessageIntl();
			appMessageIntl.setId(rs.getLong("id"));
			Locale locale = new Locale();
			locale.setId(rs.getLong("locale_id"));
			appMessageIntl.setLocale(locale);
			AppMessage appMessage = new AppMessage();
			appMessage.setId(rs.getLong("message_id"));
			appMessageIntl.setAppMessage(appMessage);
			appMessageIntl.setCreatedBy(rs.getLong("created_by"));
			appMessageIntl.setUpdatedBy(rs.getLong("updated_by"));
			appMessageIntl.setCreatedDate(Formatter.toMizeDateTime(rs.getTimestamp("created_date")));
			appMessageIntl.setUpdatedDate(Formatter.toMizeDateTime(rs.getTimestamp("updated_date")));
			appMessageIntl.setShortDesc(rs.getString("short_description"));
			appMessageIntl.setLongDesc(rs.getString("long_description"));	
			return appMessageIntl;
		}
		
	}
	public AppMessage retrieveAppMessage(){
		dbAppMessage = jdbcTemplate.queryForObject(APPMESSAGE_QUERY, new Object[]{appMessage.getId()}, new AppMessageRowMapper());
		if(dbAppMessage != null){
			List<AppMessageIntl> intls = jdbcTemplate.query(APPMESSAGE_INTL_QUERY, new Object[]{dbAppMessage.getId()}, new AppMessageIntlRowMapper());
			dbAppMessage.setIntls(intls);
		}
		return dbAppMessage;
	}
	
	/*@Test
	public void saveAppMessageTest(){
		createAppMessage();
		try{
			if(appMessage != null){
				dbAppMessage = retrieveAppMessage();
				if(dbAppMessage != null){
					assertTrue(appMessage.getId()!=null);
					assertTrue(dbAppMessage.getId()!=null);
				}
			}tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}
	@Test
	public void updateAppMessageTest()
	{
		createAppMessage();
		try{
			if(appMessage != null){
				appMessage.setCode("Testing");
				appMessage.setMsgType("validation Testing");
				persist();
				dbAppMessage = retrieveAppMessage();
				if(dbAppMessage != null){
					assertTrue(appMessage.getId()!=null);
					assertTrue(dbAppMessage.getId()!=null);
				}
			}
			tearDown();
		}catch(Throwable th){
			th.printStackTrace();
			fail("Got Exception");
		}
	}*/
	
	@Test
	public void retreiveAppMessageTest() {
		appMessage = new AppMessage();
		appMessage.setId(300L);
		AppMessage dbAppMessage = retrieveAppMessage();
		assertTrue(dbAppMessage != null && dbAppMessage.getId() != null);
	}
	
	public void tearDown() throws Exception {
		try {
			if (appMessage != null) {
				tx.begin();
				entityManager.remove(appMessage);
				entityManager.remove(tenant);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}

}
