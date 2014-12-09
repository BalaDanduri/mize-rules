package com.mize.domain.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MizeApplicationProperties {
	
	private static final Map<String, String> propMap = new HashMap<String, String>();
	public final static String DEF_DATE_FORMAT = "MM/dd/yyyy";
	public final static String DEF_TIME_FORMAT = "HH:mm:ss";
	public static final String LOGIN_TYPE_LOGIN_ID = "loginId";
	public static final String LOGIN_TYPE_EMAIL = "email"; 
	
	private int pageSize;
	
	private int recordCount;
	
	private Long defaultLocaleId;
	
	private String defaultTenantCode;
	
	private String defaultCurrencyCode;
	private String defaultTimeZone;
	
	private String createdByUser;
	
	private String loginType;
	
	private String defaultEndDate;
	private String defaultDateTimeFormat;
	private String defaultDateFormat;
	
	public static void loadPropertiesIfRequired(){
		if(propMap == null || propMap.size() == 0){
			loadProperties();
		}
	}
	
	public static void loadProperties() {
		String path = null;
		try {
			Properties properties = new Properties();
			path = "application"+Formatter.makeNotNullString(System.getProperty("CONFIG_ENV"))+".properties";
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(path));
			for (String key : properties.stringPropertyNames()) {
				propMap.put(key, properties.getProperty(key));
			}
			System.out.println("Loaded Properties File "+path);
			//logger.info("Loaded Properties File "+path);
		} catch (Exception e) {
			e.printStackTrace();
			//logger.error("Failed to load peroperties", e);
			System.out.println("Failed to load peroperties "+path);
		}
	}
	
	public String getPropertyValue(String key){
		loadPropertiesIfRequired();
		if(propMap != null){
			return propMap.get(key);
		}
		return null;
	}
	
	public Long getPropertyValueAsLong(String key){
		loadPropertiesIfRequired();
		if(propMap != null && propMap.get(key) != null){
			return Formatter.longValue(propMap.get(key));
		}
		return null;
	}
	
	public Integer getPropertyValueAsInteger(String key){
		loadPropertiesIfRequired();
		if(propMap != null && propMap.get(key) != null){
			return Formatter.intValue(propMap.get(key));
		}
		return null;
	}

	public int getDefaultPageSize() {
		return pageSize;
	}
	
	public int getDefaultMaxRecordsCount() {
		return recordCount;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	
	public Long getDefaultLocaleId() {
		return defaultLocaleId;
	}

	public void setDefaultLocaleId(Long defaultLocaleId) {
		this.defaultLocaleId = defaultLocaleId;
	}

	public String getDefaultTenantCode() {
		return defaultTenantCode;
	}

	public void setDefaultTenantCode(String defaultTenantCode) {
		this.defaultTenantCode = defaultTenantCode;
	}
	
	public String getDefaultCurrencyCode() {
		return defaultCurrencyCode;
	}
	
	public void setDefaultCurrencyCode(String defaultCurrencyCode) {
		this.defaultCurrencyCode = defaultCurrencyCode;
	}
	
	
	public static String getDateFormatt(String countryCode){
		loadPropertiesIfRequired();
		String dateFormatt = DEF_DATE_FORMAT; 
		if(propMap != null && propMap.get(countryCode) != null){
			dateFormatt = propMap.get(countryCode);
		}
		return dateFormatt;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getLoginType() {
		return loginType;
	}
	
	public boolean isLoginById() {
		return Formatter.equalIgnoreCase(LOGIN_TYPE_LOGIN_ID, this.loginType); 
	}
	
	public boolean isLoginByEmail() {
		return Formatter.equalIgnoreCase(LOGIN_TYPE_EMAIL, this.loginType); 
	}
	
	public String getDefaultTimeZone() {
		return defaultTimeZone;
	}

	public void setDefaultTimeZone(String defaultTimeZone) {
		this.defaultTimeZone = defaultTimeZone;
	}

	public String getDefaultEndDate() {
		return defaultEndDate;
	}

	public void setDefaultEndDate(String defaultEndDate) {
		this.defaultEndDate = defaultEndDate;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	
	public boolean isAuditByUserName(){
		return !"loginId".equalsIgnoreCase(createdByUser);
	}

	public String getDefaultDateTimeFormat() {
		return defaultDateTimeFormat;
	}

	public void setDefaultDateTimeFormat(String defaultDateTimeFormat) {
		this.defaultDateTimeFormat = defaultDateTimeFormat;
	}

	public String getDefaultDateFormat() {
		return defaultDateFormat;
	}

	public void setDefaultDateFormat(String defaultDateFormat) {
		this.defaultDateFormat = defaultDateFormat;
	}
	
	
}
