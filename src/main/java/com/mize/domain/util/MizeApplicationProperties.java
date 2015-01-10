package com.mize.domain.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private DateTimeZone dateTimeZone;
	private String defaultDBDateTimeFormat;
	private String defaultDBDateFormat;
	@JsonIgnore
	public DateTimeFormatter  DB_DATE_TIME_FORMAT;
	@JsonIgnore
	public DateTimeFormatter  DB_DATE_FORMAT;
	@JsonIgnore
	public DateTimeFormatter  APP_DATE_TIME_FORMAT;
	@JsonIgnore
	public DateTimeFormatter  APP_DATE_FORMAT;
	
	public boolean indexProductListSolr;
	private String environment;
	private Long entityLockTime;
	
	private String googlePrivateKey;
	private String googleChannelName;
	private String googleClientId;
	private boolean useGoogleLicensedKey;
	private String googleAPIURL;
	private String geoCodeURL;
	private String distanceGeoURL;
	private String googleAPIdefaultKey;
	private String defaultSearchRadius;
	private String defaultcharEncoding;
	
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
		this.dateTimeZone = DateTimeZone.forID(defaultTimeZone);
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
		APP_DATE_TIME_FORMAT = DateTimeFormat.forPattern(defaultDateTimeFormat);
		this.defaultDateTimeFormat = defaultDateTimeFormat;
	}

	public String getDefaultDateFormat() {
		return defaultDateFormat;
	}

	public void setDefaultDateFormat(String defaultDateFormat) {
		APP_DATE_FORMAT = DateTimeFormat.forPattern(defaultDateFormat);
		this.defaultDateFormat = defaultDateFormat;
	}
	@JsonIgnore
	public DateTimeZone getDefaultDateTimeZone(){
		return dateTimeZone;
	}

	public String getDefaultDBDateTimeFormat() {
		return defaultDBDateTimeFormat;
	}

	public void setDefaultDBDateTimeFormat(String defaultDBDateTimeFormat) {
		DB_DATE_TIME_FORMAT = DateTimeFormat.forPattern(defaultDBDateTimeFormat);
		this.defaultDBDateTimeFormat = defaultDBDateTimeFormat;
	}
	@JsonIgnore
	public DateTimeFormatter getDBDateTimeFormatter() {
		return DB_DATE_TIME_FORMAT;
	}
	@JsonIgnore
	public DateTimeFormatter getDBDateFormatter() {
		return DB_DATE_FORMAT;
	}

	public String getDefaultDBDateFormat() {
		return defaultDBDateFormat;
	}

	public void setDefaultDBDateFormat(String defaultDBDateFormat) {
		DB_DATE_FORMAT = DateTimeFormat.forPattern(defaultDBDateFormat);
		this.defaultDBDateFormat = defaultDBDateFormat;
	}
	@JsonIgnore
	public DateTimeFormatter getAppDateFormatter() {
		return APP_DATE_FORMAT;
	}
	@JsonIgnore
	public DateTimeFormatter getAppDateTimeFormatter() {
		return APP_DATE_TIME_FORMAT;
	}
	
	public boolean isIndexProductListSolr() {
		return indexProductListSolr;
	}

	public void setIndexProductListSolr(boolean indexProductListSolr) {
		this.indexProductListSolr = indexProductListSolr;
	}
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public Long getEntityLockTime() {
		return entityLockTime;
	}

	public void setEntityLockTime(Long entityLockTime) {
		this.entityLockTime = entityLockTime;
	}
	
	@JsonIgnore
	public String getGooglePrivateKey() {
		return googlePrivateKey;
	}

	public void setGooglePrivateKey(String googlePrivateKey) {
		this.googlePrivateKey = googlePrivateKey;
	}

	public String getGoogleChannelName() {
		return googleChannelName;
	}

	public void setGoogleChannelName(String googleChannelName) {
		this.googleChannelName = googleChannelName;
	}

	public String getGoogleClientId() {
		return googleClientId;
	}

	public void setGoogleClientId(String googleClientId) {
		this.googleClientId = googleClientId;
	}

	public boolean isUseGoogleLicensedKey() {
		return useGoogleLicensedKey;
	}

	public void setUseGoogleLicensedKey(boolean useGoogleLicensedKey) {
		this.useGoogleLicensedKey = useGoogleLicensedKey;
	}
		
	public String getGoogleAPIURL() {
		return googleAPIURL;
	}

	public void setGoogleAPIURL(String googleAPIURL) {
		this.googleAPIURL = googleAPIURL;
	}

	public String getGeoCodeURL() {
		return geoCodeURL;
	}

	public void setGeoCodeURL(String geoCodeURL) {
		this.geoCodeURL = geoCodeURL;
	}

	public String getDistanceGeoURL() {
		return distanceGeoURL;
	}

	public void setDistanceGeoURL(String distanceGeoURL) {
		this.distanceGeoURL = distanceGeoURL;
	}

	public String getGoogleAPIdefaultKey() {
		return googleAPIdefaultKey;
	}

	public void setGoogleAPIdefaultKey(String googleAPIdefaultKey) {
		this.googleAPIdefaultKey = googleAPIdefaultKey;
	}

	public String getDefaultSearchRadius() {
		return defaultSearchRadius;
	}

	public void setDefaultSearchRadius(String defaultSearchRadius) {
		this.defaultSearchRadius = defaultSearchRadius;
	}

	public String getDefaultcharEncoding() {
		return defaultcharEncoding;
	}

	public void setDefaultcharEncoding(String defaultcharEncoding) {
		this.defaultcharEncoding = defaultcharEncoding;
	}

		
}
