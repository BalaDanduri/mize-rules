package com.mize.domain.datetime;

import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;

import com.mize.domain.util.MizeDateTimeUtils;

public class DateTime implements IDateTime, Comparable<DateTime>, Cloneable{
	
	private static final long serialVersionUID = 7257173124058180557L;
	private String dateTimeFormat;
	private String dateTimeValue;
	private org.joda.time.DateTime dateTime;
	private DateTimeZone dateTimeZone;
	private boolean isValid;
	
	@Deprecated
	public static DateTime now(){
		return new DateTime();
	}
	
	@Deprecated
	public static DateTime getInstance(){
		return new DateTime();
	}
		
	public static DateTime getInstance(String dateTimeValue,String dateTimeFormat){
		return getInstance(dateTimeValue,dateTimeFormat,MizeDateTimeUtils.getDefaultDateTimeZone());
	}
	
	public static DateTime getInstance(String dateTimeFormat,DateTimeZone dateTimeZone){
		return new DateTime(dateTimeFormat,dateTimeZone);
	}
			
	public static DateTime getInstance(String dateTimeValue,String dateTimeFormat, DateTimeZone userTimeZone){
		return new DateTime(dateTimeValue,dateTimeFormat,MizeDateTimeUtils.getDefaultDateTimeZone(),userTimeZone);
	}
	
	private DateTime(String dateTimeValue,String dateTimeFormat,DateTimeZone dateTimeZone,DateTimeZone userTimeZone) {		
		try{		
			this.dateTimeValue = checkAndAppendTime(dateTimeValue);
			if(dateTimeFormat == null){
				dateTimeFormat = MizeDateTimeUtils.getDateTimeFormat();
			}
			this.dateTimeFormat = dateTimeFormat;
			this.dateTime = org.joda.time.DateTime.parse(this.dateTimeValue,DateTimeFormat.forPattern(dateTimeFormat).withZone(userTimeZone));
			this.dateTime = this.dateTime.toDateTime(dateTimeZone);
			this.dateTimeZone = dateTimeZone;
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	protected DateTime(String dateTimeFormat,DateTimeZone dateTimeZone) {		
		try{		
			this.dateTimeFormat = dateTimeFormat;
			this.dateTimeZone = dateTimeZone;
			this.dateTime = new org.joda.time.DateTime(dateTimeZone);
			this.dateTimeValue = DateTimeFormat.forPattern(dateTimeFormat).print(this.dateTime);
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	protected DateTime(String dateTimeValue,String dateTimeFormat,DateTimeZone dateTimeZone,org.joda.time.DateTime dateTime) {		
		try{		
			this.dateTimeValue = checkAndAppendTime(dateTimeValue);
			this.dateTimeFormat = dateTimeFormat;
			this.dateTime = dateTime;
			this.dateTimeZone = dateTimeZone;
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	private String checkAndAppendTime(String dateTimeValue) {
		dateTimeValue = dateTimeValue.trim();
		String arr[] = dateTimeValue.split(" ");
		if(arr.length == 1){
			dateTimeValue = dateTimeValue+" 00:00:00";
		}
		return dateTimeValue;
	}

	public DateTime(org.joda.time.DateTime dateTime) {
		this.dateTime = dateTime;
		this.isValid = true;
		this.dateTimeZone = dateTime.getZone();
	}
	
	public static DateTime getInstance(long millis, DateTimeZone dateTimeZone) {
		return new DateTime(millis, dateTimeZone);
	}
	
	public static DateTime getInstance(long millis) {
		return new DateTime(millis, MizeDateTimeUtils.getDefaultDateTimeZone());
	}
	
	protected DateTime(long millis, DateTimeZone dateTimeZone) {
		this.dateTime = new org.joda.time.DateTime(millis,dateTimeZone);	
		this.dateTimeZone = dateTimeZone;
		this.dateTimeFormat = MizeDateTimeUtils.getDateTimeFormat();
		this.dateTimeValue = toString(this.dateTimeFormat,this.dateTimeZone);
		this.isValid = true;
	}
	
	public DateTime() {
		this.dateTime = new org.joda.time.DateTime(MizeDateTimeUtils.getDefaultDateTimeZone());
		this.dateTimeFormat = MizeDateTimeUtils.getDateTimeFormat();
		this.dateTimeZone = this.dateTime.getZone();
		this.dateTimeValue = toString(this.dateTimeFormat,this.dateTimeZone);
		this.isValid = true;
	}	
	
	public int compareTo(DateTime dateTime) {
		return this.dateTime.compareTo(dateTime.getDateTime());
	}
	
	public long getMillis() {
		return dateTime.getMillis();
	}
	
	public DateTime subtractTime(long millis) {
		long currentTimeInMillis = dateTime.getMillis();
		if (millis > currentTimeInMillis) {
			return null;
		} else {
			createNewDateTime(new org.joda.time.DateTime(currentTimeInMillis - millis));
		}
		return null;
	}
	
	public DateTime createNewDateTime(org.joda.time.DateTime dateTime){
		DateTime dateTimeValue = new DateTime(dateTime);
		dateTimeValue.dateTime = dateTime;
		dateTimeValue.dateTimeFormat = this.dateTimeFormat;
		dateTimeValue.dateTimeValue = toString(this.dateTimeFormat,this.dateTimeZone);
		dateTimeValue.dateTimeZone = this.dateTimeZone;
		dateTimeValue.isValid = this.isValid;
		return dateTimeValue;
	}
	
	public DateTime nextDay(){
		this.dateTime.plusDays(1);
		return this;
	}
	
	public DateTime plusDays(int days){
		return createNewDateTime(this.dateTime.plusDays(days));
	}
	public DateTime plusWeeks(int weeks){
		return createNewDateTime(this.dateTime.plusWeeks(weeks));
	}
	
	public DateTime minusMonths(int months){
		return createNewDateTime(this.dateTime.minusMonths(months));
	}
	
	public DateTime plusMonths(int months){
		return createNewDateTime(this.dateTime.plusMonths(months));
	}
	
	public DateTime addYears(int years){
		return createNewDateTime(this.dateTime.plusYears(years));
	}
	
	public DateTime minusHours(int hours){
		if (hours == 0) {
            return this;
        }
		return createNewDateTime(this.dateTime.minusHours(hours));
	}
	public DateTime minusMillis(int millis){
		if(millis ==0){
			return this;
		}
		return createNewDateTime(this.dateTime.minusMillis(millis));
	}
	public DateTime minusYears(int years){
		return createNewDateTime(this.dateTime.minusYears(years));
	}
	
	public DateTime minusDays(int days){
		return createNewDateTime(this.dateTime.minusDays(days));
	}
	
	public DateTime minusMinutes(int minutes){
		return createNewDateTime(this.dateTime.minusMinutes(minutes));
	}
	
	public DateTime plusMinutes(int minutes){
		return createNewDateTime(this.dateTime.plusMinutes(minutes));
	}
	
	public DateTime previousDay(){
		return createNewDateTime(this.dateTime.minusDays(1));
	}	
	
	public String getDateTimeFormat() {
		return dateTimeFormat;
	}
	
	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}
	
	public String getDateTimeValue() {
		return dateTimeValue;
	}
	
	public void setDateTimeValue(String dateTimeValue) {
		this.dateTimeValue = dateTimeValue;
	}
	
	public org.joda.time.DateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(org.joda.time.DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public DateTimeZone getDateTimeZone() {
		return dateTimeZone;
	}

	public boolean isValid() {
		return isValid;
	}
		
	@Override
	public String toString() {
		// use default time format to print
		if(this.dateTime != null){
			return ISODateTimeFormat.dateTime().print(this.dateTime);
		}else{
			return this.dateTimeValue;
		}
	}
	
	public Object clone() {
		return createNewDateTime(this.dateTime);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateTimeFormat == null) ? 0 : dateTimeFormat.hashCode());
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result
				+ ((dateTimeValue == null) ? 0 : dateTimeValue.hashCode());
		return result;
	}

	public boolean equals(Object object){
		DateTime other = (DateTime)object;
		if(this.isValid && other.isValid){
			return this.dateTime.equals(other.getDateTime());
		}else{
			return true;
		}
	}
		
	public String toString(String dateTimeFormat, DateTimeZone dateTimeZone){	
		if(dateTimeZone == null){
			return DateTimeFormat.forPattern(dateTimeFormat).print(this.dateTime);
		}else{
			return DateTimeFormat.forPattern(dateTimeFormat).withZone(dateTimeZone).print(this.dateTime);
		}
	}
	
}
