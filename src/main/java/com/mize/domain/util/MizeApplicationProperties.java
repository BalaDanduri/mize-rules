package com.mize.domain.util;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.InitializingBean;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MizeApplicationProperties implements InitializingBean {	
	
	public final static String DEF_DATE_FORMAT = "MM/dd/yyyy";
	public final static String DEF_TIME_FORMAT = "HH:mm:ss";
	public static final String LOGIN_TYPE_LOGIN_ID = "loginId";
	public static final String LOGIN_TYPE_EMAIL = "email"; 
	
	@JsonIgnore
	private DateTimeZone dateTimeZone;	
	@JsonIgnore
	public DateTimeFormatter  DB_DATE_TIME_FORMAT;
	@JsonIgnore
	public DateTimeFormatter  DB_DATE_FORMAT;
	@JsonIgnore
	public DateTimeFormatter  APP_DATE_TIME_FORMAT;
	@JsonIgnore
	public DateTimeFormatter  APP_DATE_FORMAT;
	
	private final Map<String, String> properties = new HashMap<String, String>();
	private Map<String, String> clientProperties = new HashMap<String, String>();
	private Map<String, String> serverProperties = new HashMap<String, String>();	
	
	
	@JsonIgnore
	public Map<String, String> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, String> properties) {
		if(this.properties != null) {
			this.properties.putAll(properties);
		}
	}	 
	
	public Map<String, String> getClientProperties() {
		return clientProperties;
	}	
	
	public void setClientProperties(Map<String, String> clientProperties) {
		this.clientProperties = clientProperties;
	}
	
	@JsonIgnore
	public Map<String, String> getServerProperties() {
		return serverProperties;
	}

	public void setServerProperties(Map<String, String> serverProperties) {
		this.serverProperties = serverProperties;
	}	

	@JsonIgnore
	public Integer getDefaultPageSize() {		
		if(getPropertyValue("pageSize") != null) {
			return  Integer.valueOf(getPropertyValue("pageSize"));
		}else {
			return null;
		}
	}
	
	@JsonIgnore
	public Integer getDefaultMaxRecordsCount() {
		if(getPropertyValue("recordCount") != null) {
			return Integer.valueOf(getPropertyValue("recordCount"));
		}else {
			return null;
		}
	}	
	
	@JsonIgnore
	public Long getDefaultLocaleId() {
		if(getPropertyValue("defaultLocaleId") != null) {
			return  Long.valueOf(getPropertyValue("defaultLocaleId"));
		}else {
			return null;
		}
	}	
	
	@JsonIgnore
	public String getDefaultTenantCode() {		
		return getPropertyValue("defaultTenantCode");		
	}	
	
	@JsonIgnore
	public String getDefaultCurrencyCode() {
		return getPropertyValue("defaultCurrencyCode");		
	}	
	
	@JsonIgnore
	public String getDeviceFolder() {
		return getPropertyValue("deviceFolder");
	}
	
	@JsonIgnore
	public String getLoginType() {
		return getPropertyValue("loginType");		
	}
	
	@JsonIgnore
	public boolean isLoginById() {		
		return Formatter.equalIgnoreCase(LOGIN_TYPE_LOGIN_ID, getLoginType()); 
	}
	
	@JsonIgnore
	public boolean isLoginByEmail() {
		return Formatter.equalIgnoreCase(LOGIN_TYPE_EMAIL, getLoginType()); 
	}
	
	@JsonIgnore
	public String getDefaultTimeZone() {
		return getPropertyValue("defaultTimeZone");		
	}
	
	@JsonIgnore
	public String getDefaultEndDate() {
		return getPropertyValue("defaultEndDate");		
	}	
	
	@JsonIgnore
	public String getCreatedByUser() {
		return getPropertyValue("createdByUser");		
	}
	
	@JsonIgnore
	public boolean isAuditByUserName(){
		return !"loginId".equalsIgnoreCase(getCreatedByUser());
	}
	
	@JsonIgnore
	public String getDefaultDateTimeFormat() {
		return getPropertyValue("defaultDateTimeFormat");		
	}
	
	@JsonIgnore
	public String getDefaultDateFormat() {
		return getPropertyValue("defaultDateFormat");		
	}
	
	@JsonIgnore
	public DateTimeZone getDefaultDateTimeZone(){
		dateTimeZone = DateTimeZone.forID(getDefaultTimeZone());		
		return dateTimeZone;
	}
	
	@JsonIgnore
	public String getDefaultDBDateTimeFormat() {
		return getPropertyValue("defaultDBDateTimeFormat");		
	}
	
	@JsonIgnore
	public DateTimeFormatter getDBDateTimeFormatter() {
		DB_DATE_TIME_FORMAT = DateTimeFormat.forPattern(getDefaultDBDateTimeFormat());
		return DB_DATE_TIME_FORMAT;
	}
	
	@JsonIgnore
	public DateTimeFormatter getDBDateFormatter() {
		DB_DATE_FORMAT = DateTimeFormat.forPattern(getDefaultDBDateFormat());
		return DB_DATE_FORMAT;
	}

	@JsonIgnore
	public String getDefaultDBDateFormat() {
		return getPropertyValue("defaultDBDateFormat");				
	}
	
	@JsonIgnore
	public DateTimeFormatter getAppDateFormatter() {
		APP_DATE_FORMAT = DateTimeFormat.forPattern(getDefaultDateFormat());
		return APP_DATE_FORMAT;
	}
	
	@JsonIgnore
	public DateTimeFormatter getAppDateTimeFormatter() {
		APP_DATE_TIME_FORMAT = DateTimeFormat.forPattern(getDefaultDateTimeFormat());
		return APP_DATE_TIME_FORMAT;
	}
	
	@JsonIgnore
	public boolean isIndexProductListSolr() {		
		if(getPropertyValue("indexProductListSolr") != null) {
			return Boolean.valueOf(getPropertyValue("indexProductListSolr"));
		}else {
			return false;
		}
	}
	
	@JsonIgnore
	public String getGooglePrivateKey() {
		return getPropertyValue("googlePrivateKey");
		
	}
	
	@JsonIgnore
	public String getGoogleChannelName() {
		return getPropertyValue("googleChannelName");
	}	
	
	@JsonIgnore
	public String getGoogleClientId() {
		return getPropertyValue("googleClientId");		
	}
	
	@JsonIgnore
	public boolean isUseGoogleLicensedKey() {		
		if(getPropertyValue("useGoogleLicensedKey") != null) {
			return Boolean.valueOf(getPropertyValue("useGoogleLicensedKey"));
		}else {
			return false;
		}
	}
	
	@JsonIgnore
	public String getEnvironment() {
		return getPropertyValue("environment");		
	}
	
	@JsonIgnore
	public Long getEntityLockTime() {
		if(getPropertyValue("entityLockTime") != null) {
			return Long.valueOf(getPropertyValue("entityLockTime"));
		}else {
			return null;
		}
	}
	
	@JsonIgnore
	public String getGoogleAPIURL() {
		return getPropertyValue("googleAPIURL");
	}
	
	@JsonIgnore
	public String getGeoCodeURL() {
		return getPropertyValue("geoCodeURL");
	}
	
	@JsonIgnore
	public String getDistanceGeoURL() {
		return getPropertyValue("distanceGeoURL");
	}
	
	@JsonIgnore
	public String getGoogleAPIdefaultKey() {
		return getPropertyValue("googleAPIdefaultKey");
	}
	
	@JsonIgnore
	public String getDefaultSearchRadius() {
		return getPropertyValue("defaultSearchRadius");
	}
	
	@JsonIgnore
	public String getDefaultcharEncoding() {
		return getPropertyValue("defaultcharEncoding");
	}

	@Override
	@JsonIgnore
	public void afterPropertiesSet() throws Exception {
		properties.putAll(serverProperties);
		properties.putAll(clientProperties);		
	}
	
	private String getPropertyValue(String propertyName) {		
		return properties.get(propertyName);
	}
	
	
}
