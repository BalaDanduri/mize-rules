package com.mize.domain.util;

import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;

import com.mize.domain.auth.User;

public class MizeDateTimeUtils {
	
	public static DateTimeFormatter  DB_DATE_TIME_FORMAT;
	private static MizeApplicationProperties mizeApplicationProperties;
	
	@Autowired
	public void setMizeApplicationProperties(MizeApplicationProperties mizeApplicationProperties) {
		MizeDateTimeUtils.mizeApplicationProperties = mizeApplicationProperties;
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

	public static MizeDateTime currentMizeDateTime(){		
		return MizeDateTime.getInstance(getDateTimeFormat(), getTimeZone());
	}
	
	public static MizeDate currentMizeDate(){		
		return MizeDate.getInstance(getDateFormat(),getTimeZone());
	}

	public static MizeDateTime currentMizeDateTime(DateTimeZone dateTimeZone){		
		return MizeDateTime.getInstance(getDateTimeFormat(), dateTimeZone);
	}
	
	public static MizeDateTime currentMizeDateTime(String dateTimeZone){		
		return MizeDateTime.getInstance(getDateTimeFormat(), DateTimeZone.forID(dateTimeZone));
	}
	
	public static MizeDate currentMizeDate(String dateTimeZone){		
		return MizeDate.getInstance(getDateFormat(), DateTimeZone.forID(dateTimeZone));
	}
	
	public static MizeDate currentMizeDate(DateTimeZone dateTimeZone){		
		return MizeDate.getInstance(getDateFormat(), dateTimeZone);
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
	
	public static String getDBDateTime(MizeDateTime mizeDateTime){
		return (mizeDateTime == null ? null : getDBDateTime(mizeDateTime.getDateTime()));
	}
	
	public static String getDBDateTime(MizeDate mizeDate){
		return (mizeDate == null ? null : getDBDateTime(mizeDate.getDateTime()));
	}
	
	public static String getDBDateTime(DateTime dateTime){
		return (dateTime == null ? null : dateTime.toString(mizeApplicationProperties.getDBDateTimeFormatter()));
	}
	
	public static String getMizeDateTimeAsString(Timestamp timestamp){
		return (timestamp == null ? null : new DateTime(timestamp).toString(mizeApplicationProperties.getAppDateTimeFormatter()));
	}
	
	public static String getMizeDateAsString(Timestamp timestamp){
		return (timestamp == null ? null : new DateTime(timestamp).toString(mizeApplicationProperties.getAppDateFormatter()));
	}
	public static MizeDateTime getMizeDateTime(Timestamp timestamp){
		String datetime =  getMizeDateTimeAsString(timestamp);
		return MizeDateTime.getInstance(datetime,getDateTimeFormat(),getDefaultDateTimeZone());
	}
	
	public static MizeDate toMizeDate(Timestamp timestamp){
		MizeDate mizeDate = null;
		if(timestamp != null){
			String date =  getMizeDateAsString(timestamp);
			mizeDate = MizeDate.getInstance(date, getDateFormat());
		}
		return mizeDate;
	}
	
	public static MizeDateTime toMizeDateTime(Timestamp timestamp){
		MizeDateTime mizeDateTime = null;
		if(timestamp != null){
			String datetime =  getMizeDateTimeAsString(timestamp);
			mizeDateTime = MizeDateTime.getInstance(datetime,getDateTimeFormat(),getDefaultDateTimeZone());
		}
		return mizeDateTime;
	}
	
	public static String formattedMizeDate(MizeDate mizeDate, User user) {
		return formattedMizeDate(mizeDate, user, true);
	}
	
	public static String formattedMizeDate(MizeDate mizeDate, User user, boolean fallback) {
		String dateFormat = null;
		if(user!=null && user.getUserProfile()!=null && user.getUserProfile().getUserPreference()!=null && user.getUserProfile().getUserPreference().getDateFormat()!=null){
			dateFormat = user.getUserProfile().getUserPreference().getDateFormat();
		}
		if(Formatter.isNull(dateFormat) && fallback){
			dateFormat = getDateTimeFormat();
		}
		return mizeDate.toString(dateFormat, null);
	}
	
	public static String formattedMizeDateTime(MizeDateTime mizeDateTime, User user) {
		return formattedMizeDateTime(mizeDateTime, user, true);
	}
	
	public static String formattedMizeDateTime(MizeDateTime mizeDateTime, User user, boolean fallback) {
		String dateTimeFormat = null;
		String dateTimeZone = null;
		if(user!=null && user.getUserProfile()!=null && user.getUserProfile().getTimezone() != null){
			dateTimeZone = user.getUserProfile().getTimezone();
		}
		if(user!=null && user.getUserProfile()!=null && user.getUserProfile().getUserPreference()!=null && user.getUserProfile().getUserPreference().getDateTimeFormat()!=null){
			dateTimeFormat = user.getUserProfile().getUserPreference().getDateTimeFormat();
		}
		if(Formatter.isNull(dateTimeFormat) && fallback){
			dateTimeFormat = getDateTimeFormat();
		}
		if(Formatter.isNull(dateTimeZone) && fallback){
			dateTimeZone = getDefaultTimeZone();
		}
		return mizeDateTime.toString(dateTimeFormat, DateTimeZone.forID(dateTimeZone));
	}
	
	public static MizeDate getDefaultEndDate() {
		MizeDate endDate = null;
		if (Formatter.isNotNull(mizeApplicationProperties.getDefaultEndDate())) {
			endDate = MizeDate.getInstance(mizeApplicationProperties.getDefaultEndDate(), getDateFormat());
		}
		return endDate;
	}

}
