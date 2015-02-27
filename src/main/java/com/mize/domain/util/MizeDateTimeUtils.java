package com.mize.domain.util;

import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mize.domain.auth.User;

@Component
public class MizeDateTimeUtils {
	//MizeDateTime to MizeDate and vice versa
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
	
	public static com.mize.domain.datetime.DateTime currentDate(){		
		return com.mize.domain.datetime.DateTime.getInstance(getDateFormat(), getTimeZone());
	}
	
	public static com.mize.domain.datetime.DateTime currentDateTime(){		
		return com.mize.domain.datetime.DateTime.getInstance(getDateTimeFormat(), getTimeZone());
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
	
	public static String formattedMizeDate(MizeDateTime mizeDateTime, User user) {
		return formattedMizeDate(mizeDateTime, user, true);
	}
	
	public static String formattedMizeDate(MizeDateTime mizeDateTime, User user, boolean fallback) {
		String dateFormat = getUserDateFormat(user, fallback);
		return mizeDateTime.toString(dateFormat, null);
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
	
	public static String formattedMizeDate(MizeDate mizeDate, User user, boolean fallback) {
		String dateFormat = getUserDateFormat(user, fallback);
		return mizeDate.toString(dateFormat, null);
	}
	
	public static String formattedMizeDateTime(MizeDateTime mizeDateTime, User user) {
		return formattedMizeDateTime(mizeDateTime, user, true);
	}
	
	public static String formattedMizeDateTime(MizeDateTime mizeDateTime, User user, boolean fallback) {
		String dateTimeFormat = getUserDateTimeFormat(user, fallback);
		String dateTimeZone = getUserDateTimeZone(user, fallback);
		return mizeDateTime.toString(dateTimeFormat, DateTimeZone.forID(dateTimeZone));
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
	
	public static MizeDate getDefaultEndDate() {
		MizeDate endDate = null;
		if (Formatter.isNotNull(mizeApplicationProperties.getDefaultEndDate())) {
			endDate = MizeDate.getInstance(mizeApplicationProperties.getDefaultEndDate(), getDateFormat());
		}
		return endDate;
	}
	
	public static String getDBEndDateTime(MizeDateTime mizeDateTime){	
		if(mizeDateTime != null && mizeDateTime.getDateTime() != null){
			return getDBDateTime(toEndDateTime(mizeDateTime));
		}else{
			return null;
		}
	}
	
	public static MizeDateTime toEndDateTime(MizeDateTime mizeDateTime){	
		if(mizeDateTime != null && mizeDateTime.getDateTime() != null){
			DateTime endDate = mizeDateTime.getDateTime().withTime(23, 59, 59, 999);
			if(mizeDateTime.getDateTimeFormat() == null){
				mizeDateTime.setDateTimeFormat(mizeApplicationProperties.getDefaultDateTimeFormat());
			}
			MizeDateTime endMizeDateTime = mizeDateTime.createNewMizeDateTime(endDate);
			return endMizeDateTime;
		}else{
			return null;
		}
	}
	
	public static MizeDate toEndDate(MizeDate mizeDate){	
		if(mizeDate != null && mizeDate.getDateTime() != null){
			DateTime endDate = mizeDate.getDateTime().withTime(23, 59, 59, 999);
			if(mizeDate.getDateFormat() == null){
				mizeDate.setDateFormat(mizeApplicationProperties.getDefaultDateFormat());
			}
			MizeDate endMizeDate = mizeDate.createNewMizeDate(endDate);
			return endMizeDate;
		}else{
			return null;
		}
	}
	
	public static MizeDateTime toStartDateTime(MizeDateTime mizeDateTime){	
		if(mizeDateTime != null && mizeDateTime.getDateTime() != null){
			DateTime endDate = mizeDateTime.getDateTime().withTime(0, 0, 0, 0);
			if(mizeDateTime.getDateTimeFormat() == null){
				mizeDateTime.setDateTimeFormat(mizeApplicationProperties.getDefaultDateTimeFormat());
			}
			MizeDateTime endMizeDateTime = mizeDateTime.createNewMizeDateTime(endDate);
			return endMizeDateTime;
		}else{
			return null;
		}
	}
	
	public static MizeDate toStartDate(MizeDate mizeDate){	
		if(mizeDate != null && mizeDate.getDateTime() != null){
			DateTime endDate = mizeDate.getDateTime().withTime(0, 0, 0, 0);
			if(mizeDate.getDateFormat() == null){
				mizeDate.setDateFormat(mizeApplicationProperties.getDefaultDateFormat());
			}
			MizeDate endMizeDate = mizeDate.createNewMizeDate(endDate);
			return endMizeDate;
		}else{
			return null;
		}
	}

}
