package com.mize.domain.appmsg;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.test.util.JPATest;
public class AppMessageTest  {

	private static final String APPMESSAGE_QUERY = "select * from application_messages where id =?";
	private static final String APPMESSAGE_INTL_QUERY = "select * from application_messages_intl where message_id =?";
	EntityManager entityManager;
	EntityTransaction tx;
	BusinessEntity tenant;
	AppMessage appMessage = null;
	AppMessage dbAppMessage = null;
	
	@Before
	public void setUp() throws Exception {
		/*entityManager = getEntityManager();
		tenant = findExistingBE(entityManager);*/
	}
	@Test
	public void test(){
		
	}
	/*@SuppressWarnings("unused")
	private void persist() {
		tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(appMessage);
		tx.commit();
	}
	@SuppressWarnings("unused")
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
		appMessage.setCreatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		appMessage.setUpdatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
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
		appMessageIntl.setCreatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
		appMessageIntl.setUpdatedDate(MizeDateTime.getInstance("dd/MM/yyyy HH:mm:ss",DateTimeZone.UTC));
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
			appMessage.setCreatedDate(MizeDateTimeUtils.toMizeDateTime(rs.getTimestamp("created_date")));
			appMessage.setUpdatedDate(MizeDateTimeUtils.toMizeDateTime(rs.getTimestamp("updated_date")));
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
			appMessageIntl.setCreatedDate(MizeDateTimeUtils.toMizeDateTime(rs.getTimestamp("created_date")));
			appMessageIntl.setUpdatedDate(MizeDateTimeUtils.toMizeDateTime(rs.getTimestamp("updated_date")));
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
	
	@Test
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
	}
	
	@Test
	public void retreiveAppMessageTest() {
		appMessage = new AppMessage();
		appMessage.setId(300L);
		AppMessage dbAppMessage = retrieveAppMessage();
		assertTrue(dbAppMessage != null && dbAppMessage.getId() != null);
	}*/
	
	public void tearDown() throws Exception {
		/*try {
			if (appMessage != null) {
				tx.begin();
				entityManager.remove(appMessage);
				entityManager.remove(tenant);
				tx.commit();
			}
			entityManager.close();
		} catch (Throwable th) {
			th.printStackTrace();
		}*/
	}

}
