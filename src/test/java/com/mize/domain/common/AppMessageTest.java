package com.mize.domain.common;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;

import com.mize.domain.appmsg.AppMessage;
import com.mize.domain.appmsg.AppMessageIntl;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.test.util.JPATest;
import com.mize.domain.util.Formatter;

@ContextConfiguration(locations={"/test-context.xml"})
public class AppMessageTest extends JPATest  {
	private static final String APP_MESSAGE_QUERY = "select * from application_messages where id = ?";
	EntityManager entityManager = null;
	AppMessage appMessage = null;
	List<AppMessageIntl> intls = new ArrayList<AppMessageIntl>();
	@Before
	public void setUp(){
		/*entityManager = getEntityManager();
		appMessage = getAppMessageOjectToSave(appMessage);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(appMessage.getId() == null){
			entityManager.persist(appMessage);	
		}else{
			appMessage = entityManager.merge(appMessage);
		}		
		tx.commit();*/
	}
	
	@After
	public void tearDown() throws Exception {
		//entityManager.close();
	}
	
	
	/*@Test
	public void testSaveAppMessage() {
		try {
			List<AppMessage> appMessages = jdbcTemplate.query(APP_MESSAGE_QUERY, new Object[]{appMessage.getId()}, new AppMessageRowMapper());
			if(!Formatter.isEmpty(appMessages)){
				AppMessage appMessageFromDb = appMessages.get(0);
				assertTrue(appMessageFromDb.getId().equals(appMessage.getId()));
			}
		}catch(Throwable th) {
			th.printStackTrace();
			fail("Got Exception");
			throw th;
		}
	}*/
	
	private class AppMessageRowMapper implements RowMapper<AppMessage> {
		@Override
		public AppMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
			AppMessage appMessage = new AppMessage();
			appMessage.setId(rs.getLong("id"));	
			return appMessage;
		}
	}
	

	private AppMessage getAppMessageOjectToSave(AppMessage appMessage) {
		if(appMessage == null){
			appMessage = new AppMessage();
		}
		appMessage.setCode("APPMSG003");
		appMessage.setMsgType("Error");
		appMessage.setSeverity(2);
		BusinessEntity tenant = new BusinessEntity();
		tenant.setId(7624L);
		tenant = entityManager.find(BusinessEntity.class, tenant.getId());
		appMessage.setTenant(tenant);
		
		if(appMessage.getIntls() != null){
		intls = appMessage.getIntls();
		}
		AppMessageIntl intl = new AppMessageIntl();
		intl.setAppMessage(appMessage);
		intl.setLocale(new Locale(1l));
		intl.setShortDesc("APPMSG003-Test");
		intl.setLongDesc("APPMSG003-Test");
		intls.add(intl);
		appMessage.setIntls(intls);
		return appMessage;
	}


}
