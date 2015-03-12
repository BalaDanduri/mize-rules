package com.mize.domain.util;

import java.sql.Timestamp;

import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mize.domain.auth.User;
import com.mize.domain.datetime.Date;
import com.mize.domain.datetime.DateTime;
//import org.joda.time.DateTime;

@Component
public class DateTimeUtils {
	//MizeDateTime to MizeDate and vice versa
	public static DateTimeFormatter  DB_DATE_TIME_FORMAT;
	private static MizeApplicationProperties mizeApplicationProperties;
	
	@Autowired
	public void setMizeApplicationProperties(MizeApplicationProperties mizeApplicationProperties) {
		DateTimeUtils.mizeApplicationProperties = mizeApplicationProperties;
	}

	public static DateTimeZone getTimeZone(){		
		return DateTimeZone.forID(mizeApplicationProperties.getDefaultTimeZone());
	}
	
	public static String getDateTimeFormat(){
		return mizeApplicationProperties.getDefaultDateTimeFormat();
	}
	
	public static String getDateFormat(){
		return mizeApplicationProperties.getDefaultDateFormat();
	}
	
	public static Date currentDate(){		
		return Date.getInstance(getDateFormat(), getTimeZone());
	}
	
	public static DateTime currentDateTime(){		
		return DateTime.getInstance(getDateTimeFormat(), getTimeZone());
	}

	public static DateTime currentDateTime(DateTimeZone dateTimeZone){		
		return DateTime.getInstance(getDateTimeFormat(), dateTimeZone);
	}
	
	public static DateTime currentDateTime(String dateTimeZone){		
		return DateTime.getInstance(getDateTimeFormat(), DateTimeZone.forID(dateTimeZone));
	}
	
	public static Date currentDate(String dateTimeZone){		
		return Date.getInstance(getDateFormat(), DateTimeZone.forID(dateTimeZone));
	}
	
	public static Date currentDate(DateTimeZone dateTimeZone){		
		return Date.getInstance(getDateFormat(), dateTimeZone);
	}
	
	public static DateTimeZone getDefaultDateTimeZone(){
		return mizeApplicationProperties.getDefaultDateTimeZone();
	}
	
	public static DateTimeZone getUserTimeZone(String userTimeZone){
		return DateTimeZone.forID(userTimeZone);
	}
	
	public static String getDefaultTimeZone() {
		return mizeApplicationProperties.getDefaultTimeZone();
	}
	
	public static String getDBDateTime(DateTime dateTime){
		return (dateTime == null ? null : getDBDateTime(dateTime.getBaseValue()));
	}
	
	public static String getDBDateTime(Date date){
		return (date == null ? null : getDBDateTime(date.getBaseValue()));
	}
	
	public static String getDBDateTime(org.joda.time.DateTime dateTime){
		return (dateTime == null ? null : dateTime.toString(mizeApplicationProperties.getDBDateTimeFormatter()));
	}
	
	public static String getDateAsString(Timestamp timestamp){
		return (timestamp == null ? null : new org.joda.time.DateTime(timestamp).toString(mizeApplicationProperties.getAppDateTimeFormatter()));
	}
	
	public static String getDateTimeAsString(Timestamp timestamp){
		return (timestamp == null ? null : new org.joda.time.DateTime(timestamp).toString(mizeApplicationProperties.getAppDateTimeFormatter()));
	}
	
	public static String getMizeDateAsString(Timestamp timestamp){
		return (timestamp == null ? null : new org.joda.time.DateTime(timestamp).toString(mizeApplicationProperties.getAppDateFormatter()));
	}
	public static DateTime getDateTime(Timestamp timestamp){
		String datetime =  getDateTimeAsString(timestamp);
		return DateTime.getInstance(datetime,getDateTimeFormat(),getDefaultDateTimeZone());
	}
	
	public static Date toDate(Timestamp timestamp){
		Date date = null;
		if(timestamp != null){
			String dateStr =  getDateAsString(timestamp);
			date = Date.getInstance(dateStr, getDateFormat());
		}
		return date;
	}
	
	public static DateTime toDateTime(Timestamp timestamp){
		DateTime dateTime = null;
		if(timestamp != null){
			String datetime =  getDateTimeAsString(timestamp);
			dateTime = DateTime.getInstance(datetime,getDateTimeFormat(),getDefaultDateTimeZone());
		}
		return dateTime;
	}
	
	public static String formattedDate(Date date, User user) {
		return formattedDate(date, user, true);
	}
	
	public static String formattedDate(DateTime dateTime, User user) {
		return formattedDate(dateTime, user, true);
	}
	
	public static String formattedDate(DateTime dateTime, User user, boolean fallback) {
		String dateFormat = getUserDateFormat(user, fallback);
		return dateTime.toString(dateFormat, null);
	}

	public static String getUserDateFormat(User user, boolean fallback) {
		String dateFormat = null;
		if(user!=null && user.getUserProfile()!=null && user.getUserProfile().getUserPreference()!=null && user.getUserProfile().getUserPreference().getDateFormat()!=null){
			dateFormat = user.getUserProfile().getUserPreference().getDateFormat();
		}
		if(Formatter.isNull(dateFormat) && fallback){
			dateFormat = getDateFormat();
		}
		return dateFormat;
	}
	
	public static String formattedDate(Date date, User user, boolean fallback) {
		String dateFormat = getUserDateFormat(user, fallback);
		return date.toString(dateFormat, null);
	}
	
	public static String formattedDateTime(DateTime dateTime, User user) {
		return formattedDateTime(dateTime, user, true);
	}
	
	public static String formattedDateTime(DateTime dateTime, User user, boolean fallback) {
		String dateTimeFormat = getUserDateTimeFormat(user, fallback);
		String dateTimeZone = getUserDateTimeZone(user, fallback);
		return dateTime.toString(dateTimeFormat, DateTimeZone.forID(dateTimeZone));
	}
	
	public static String getUserDateTimeZone(User user, boolean fallback) {
		String dateTimeZone = null;
		if(user != null && user.getUserProfile() != null && user.getUserProfile().getTimezone() != null){
			dateTimeZone = user.getUserProfile().getTimezone();
		}
		if(Formatter.isNull(dateTimeZone) && fallback){
			dateTimeZone = getDefaultTimeZone();
		}
		return dateTimeZone;
	}
	
	public static String getUserDateTimeFormat(User user, boolean fallback) {
		String dateTimeFormat = null;
		if(user != null && user.getUserProfile() != null && user.getUserProfile().getUserPreference() != null && user.getUserProfile().getUserPreference().getDateTimeFormat() != null){
			dateTimeFormat = user.getUserProfile().getUserPreference().getDateTimeFormat();
		}
		if(Formatter.isNull(dateTimeFormat) && fallback){
			dateTimeFormat = getDateTimeFormat();
		}
		return dateTimeFormat;
	}
	
	public static Date getDefaultEndDate() {
		Date endDate = null;
		if (Formatter.isNotNull(mizeApplicationProperties.getDefaultEndDate())) {
			endDate = Date.getInstance(mizeApplicationProperties.getDefaultEndDate(), getDateFormat());
		}
		return endDate;
	}
	
	public static String getDBEndDateTime(DateTime dateTime){	
		if(dateTime != null && dateTime.getBaseValue() != null){
			return getDBDateTime(toEndDateTime(dateTime));
		}else{
			return null;
		}
	}
	
	public static DateTime toEndDateTime(DateTime dateTime){	
		if(dateTime != null && dateTime.getBaseValue() != null){
			org.joda.time.DateTime endDate = dateTime.getBaseValue().withTime(23, 59, 59, 999);
			if(dateTime.getDateTimeFormat() == null){
				dateTime.setDateTimeFormat(mizeApplicationProperties.getDefaultDateTimeFormat());
			}
			return dateTime.createNewDateTime(endDate);
		}else{
			return null;
		}
	}
	
	public static Date toEndDate(Date date){	
		if(date != null && date.getBaseValue() != null){
			org.joda.time.DateTime endDate = date.getBaseValue().withTime(23, 59, 59, 999);
			if(date.getDateFormat() == null){
				date.setDateFormat(mizeApplicationProperties.getDefaultDateFormat());
			}
			return date.createNewDate(endDate);
		}else{
			return null;
		}
	}
	
	public static DateTime toStartDateTime(DateTime dateTime){	
		if(dateTime != null && dateTime.getBaseValue() != null){
			org.joda.time.DateTime endDate = dateTime.getBaseValue().withTime(0, 0, 0, 0);
			if(dateTime.getDateTimeFormat() == null){
				dateTime.setDateTimeFormat(mizeApplicationProperties.getDefaultDateTimeFormat());
			}
			return dateTime.createNewDateTime(endDate);
		}else{
			return null;
		}
	}
	
	public static Date toStartDate(Date date){	
		if(date != null && date.getBaseValue() != null){
			org.joda.time.DateTime endDate = date.getBaseValue().withTime(0, 0, 0, 0);
			if(date.getDateFormat() == null){
				date.setDateFormat(mizeApplicationProperties.getDefaultDateFormat());
			}
			return date.createNewDate(endDate);
		}else{
			return null;
		}
	}

}
