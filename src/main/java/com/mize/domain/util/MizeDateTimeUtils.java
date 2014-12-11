package com.mize.domain.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;

public class MizeDateTimeUtils {
	
	public static final DateTimeFormatter  DB_DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
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
		return (dateTime == null ? null : dateTime.toString(DB_DATE_TIME_FORMAT));
	}

}