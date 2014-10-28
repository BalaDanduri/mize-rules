package com.mize.domain.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class MizeDateTime implements IMizeDate, Comparable<MizeDateTime>, Cloneable{
	
	private static final long serialVersionUID = 7257173124058180557L;
	private static final String DEF_DATE_FORMAT = "MM/dd/yyyy";	
	private static final String DEF_END_DATE = "12/31/9999";	
	public static final DateTimeFormatter  DB_DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	
	private String dateTimeFormat;
	private String dateTimeValue;
	private DateTime dateTime;
	private boolean isValid;
		
	public static MizeDateTime now(){
		return new MizeDateTime();
	}
	
	public static MizeDateTime getInstance(){
		return new MizeDateTime();
	}
	
	public static MizeDateTime getInstance(DateTime dateTime){
		return new MizeDateTime(dateTime);
	}
	
	public static MizeDateTime getInstance(long millis, DateTimeZone timeZone){
		return new MizeDateTime(millis, timeZone);
	}
	
	public static MizeDateTime getInstance(String dateTimeValue,String dateTimeFormat){
		return new MizeDateTime(dateTimeValue,dateTimeFormat);
	}
	
	protected MizeDateTime(String dateTimeValue,String dateTimeFormat) {		
		try{		
			this.dateTimeValue = checkAndAppendTime(dateTimeValue);
			this.dateTimeFormat = dateTimeFormat;
			this.dateTime = DateTime.parse(dateTimeValue,DateTimeFormat.forPattern(dateTimeFormat));	
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

	protected MizeDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
		this.isValid = true;
	}
	
	protected MizeDateTime(long millis, DateTimeZone timeZone) {
		this.dateTime = new DateTime(millis,timeZone);
		this.isValid = true;
	}
	
	protected MizeDateTime() {
		this.dateTime = new DateTime();
		this.isValid = true;
	}	
	
	public int compareTo(MizeDateTime mizeDateTime) {
		return dateTime.compareTo(mizeDateTime.getDateTime());
	}
	
	public Object clone() {
		return new MizeDateTime(dateTime.getMillis());
	}
	
	public long getMillis() {
		return dateTime.getMillis();
	}
	
	protected MizeDateTime(long millis) {
		dateTime = new DateTime(millis);
		isValid = true;
	}
	
	public MizeDateTime addTime(long addTimeInMillis) {
		long newTimeinMillis = dateTime.getMillis() + addTimeInMillis;
		return new MizeDateTime(newTimeinMillis);
	}

	public MizeDateTime subtractTime(long millis) {
		long currentTimeInMillis = dateTime.getMillis();
		if (millis > currentTimeInMillis) {
			return null;
		} else {
			return new MizeDateTime(currentTimeInMillis - millis);
		}
	}
		
	public MizeDateTime defaultEndDate(){
		DateTimeFormatter simpleDateFormat = DateTimeFormat.forPattern(DEF_DATE_FORMAT);
		DateTime.parse(DEF_END_DATE);
		DateTime dateTime = DateTime.parse(DEF_END_DATE,simpleDateFormat);
		return new MizeDateTime(dateTime);
	}
	
	public MizeDateTime defaultEndDate(String dateTimeFormat){
		DateTimeFormatter simpleDateFormat = DateTimeFormat.forPattern(dateTimeFormat);
		DateTime.parse(DEF_END_DATE);
		DateTime dateTime = DateTime.parse(DEF_END_DATE,simpleDateFormat);
		return new MizeDateTime(dateTime);
	}
	
	public MizeDateTime nextDay(){
		this.dateTime.plusDays(1);
		return this;
	}
	
	public MizeDateTime plusDays(int days){
		dateTime.plusDays(days);
		return this;
	}
	
	public MizeDateTime minusMonths(int months){
		dateTime.minusMonths(months);
		return this;
	}
	
	public MizeDateTime plusMonths(int months){
		dateTime.plusMonths(months);
		return this;
	}
	
	public MizeDateTime addYears(int years){
		dateTime.plusYears(years);
		return this;
	}
	
	public MizeDateTime minusYears(int years){
		dateTime.minusYears(years);
		return this;
	}
	
	public MizeDateTime minusDays(int days){
		dateTime.minusDays(days);
		return this;
	}
	
	public MizeDateTime previousDay(){
		this.dateTime.minusDays(1);
		return this;
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
	public DateTime getDateTime() {
		return dateTime;
	}
	
	public boolean isValid() {
		return isValid;
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
		MizeDateTime mizeDateTime = (MizeDateTime)object;
		return this.dateTime.equals(mizeDateTime.getDateTime());
	}
	
	public String toDBDateTime(){		
		return this.dateTime.toString(DB_DATE_TIME_FORMAT);
	}
	
	public String toString(String dateFormat){		
		return DateTimeFormat.forPattern(dateFormat).print(this.dateTime);
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
	
}
