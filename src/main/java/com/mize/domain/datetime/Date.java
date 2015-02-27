package com.mize.domain.datetime;

import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;

import com.mize.domain.util.MizeDateTimeUtils;

public class Date implements IDateTime, Comparable<Date>, Cloneable{
	
	private static final long serialVersionUID = 7257173124058180557L;
	private String dateFormat;
	private String dateValue;
	private org.joda.time.DateTime dateTime;
	private DateTimeZone dateTimeZone;
	private boolean isValid;
	
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public String getDateValue() {
		return dateValue;
	}
	public void setDateValue(String dateValue) {
		this.dateValue = dateValue;
	}
	public org.joda.time.DateTime getDateTime() {
		return dateTime;
	}
	
	public boolean isValid() {
		return isValid;
	}
	public DateTimeZone getDateTimeZone() {
		return dateTimeZone;
	}
	
	@Deprecated
	public static Date now(){
		return new Date();
	}
	
	@Deprecated
	public static Date getInstance(){
		return new Date();
	}
	
	public static Date getInstance(org.joda.time.DateTime dateTime){
		if(dateTime != null){
			return new Date(dateTime);
		}else{
			return null;
		}
		
	}
	
	public static Date getInstance(String dateValue,String dateFormat,DateTimeZone timeZone){
		return new Date(dateValue,dateFormat,timeZone);
	}
	
	public static Date getInstance(String dateValue,String dateFormat){
		return getInstance(dateValue,dateFormat, MizeDateTimeUtils.getDefaultDateTimeZone());
	}
		
	public static Date getInstance(String dateFormat, DateTimeZone timeZone){
		return new Date(dateFormat,timeZone);
	}
	
	protected Date(String dateValue,String dateFormat,DateTimeZone timeZone) {		
		try{		
			this.dateValue = dateValue;
			this.dateFormat = dateFormat;
			this.dateTime = org.joda.time.DateTime.parse(dateValue,DateTimeFormat.forPattern(dateFormat).withZone(timeZone));	
			this.dateTimeZone = timeZone;
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	public Date(String dateFormat, DateTimeZone timeZone) {		
		this(dateFormat, timeZone,null);
	}
	
	public Date(String dateFormat, DateTimeZone timeZone, Long millis) {		
		try{		
			this.dateFormat = dateFormat;
			if(millis == null || millis.longValue() == 0){
				this.dateTime = new org.joda.time.DateTime(org.joda.time.DateTime.now().getMillis(),timeZone);
			}else{
				this.dateTime = new org.joda.time.DateTime(millis,timeZone);
			}
			this.dateValue = DateTimeFormat.forPattern(dateFormat).print(this.dateTime);
			this.dateTime = org.joda.time.DateTime.parse(this.dateValue,DateTimeFormat.forPattern(dateFormat).withZone(timeZone));	
			this.dateTimeZone = timeZone;
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	public Date(org.joda.time.DateTime dateTime) {
		this.dateTime = dateTime;
		this.isValid = true;
	}
		
	public Date() {
		this.dateTime = new org.joda.time.DateTime();
		this.isValid = true;
		this.dateTimeZone = DateTimeZone.getDefault();				
	}	
	
	public int compareTo(Date mizeDateTime) {
		return dateTime.compareTo(mizeDateTime.getDateTime());
	}
	
	public Date(long millis) {
		this(MizeDateTimeUtils.getDateFormat(),MizeDateTimeUtils.getDefaultDateTimeZone(), millis);
	}
		
	public static Date getInstance(long millis) {
		return getInstance(millis, MizeDateTimeUtils.getDefaultDateTimeZone());
	}
	
	public static Date getInstance(long millis, DateTimeZone dateTimeZone) {
		return new Date(MizeDateTimeUtils.getDateFormat(), dateTimeZone, millis);
	}

	public Date nextDay(){
		return createNewMizeDate(this.dateTime.plusDays(1));
	}
	
	public Date plusDays(int days){
		return createNewMizeDate(this.dateTime.plusDays(days));
	}
	
	public Date minusMonths(int months){
		return createNewMizeDate(this.dateTime.minusMonths(months));
	}
	
	public Date plusMonths(int months){
		return createNewMizeDate(this.dateTime.plusMonths(months));
	}
	
	public Date addYears(int years){
		return createNewMizeDate(this.dateTime.plusYears(years));
	}
	
	public Date minusYears(int years){
		return createNewMizeDate(this.dateTime.minusYears(years));
	}
	
	public Date minusDays(int days){
		return createNewMizeDate(this.dateTime.minusDays(days));
	}
	
	public Date previousDay(){
		return createNewMizeDate(this.dateTime.minusDays(1));
	}	
	
	public Date createNewMizeDate(org.joda.time.DateTime dateTime){
		Date mizeDate = new Date(dateTime);
		mizeDate.dateTime = dateTime;
		mizeDate.dateFormat = this.dateFormat;
		mizeDate.dateValue = toString(this.dateFormat,this.dateTimeZone);
		mizeDate.dateTimeZone = this.dateTimeZone;
		mizeDate.isValid = this.isValid;
		return mizeDate;
	}
	
	public boolean equals(Object object){
		Date mizeDateTime = (Date)object;
		if(this.isValid && mizeDateTime.isValid){
			return this.dateTime.equals(mizeDateTime.getDateTime());
		}else{
			return true;
		}
	}
	
	public String toString(String dateFormat, DateTimeZone dateTimeZone){	
		if(dateTimeZone == null){
			return DateTimeFormat.forPattern(dateFormat).print(this.dateTime);
		}else{
			return DateTimeFormat.forPattern(dateFormat).withZone(dateTimeZone).print(this.dateTime);
		}
	}
	
	public Object clone() {
		return new Date(dateTime.getMillis());
	}
	
	public long getMillis() {
		return dateTime.getMillis();
	}
	
	@Override
	public String toString() {
		if(this.dateTime != null){
			return ISODateTimeFormat.dateTime().print(this.dateTime);
		}else{
			return this.dateValue;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateFormat == null) ? 0 : dateFormat.hashCode());
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result
				+ ((dateValue == null) ? 0 : dateValue.hashCode());
		return result;
	}
	
}
