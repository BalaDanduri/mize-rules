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
	private static final DateTimeFormatter DB_DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	public static final String DATE_TIME_FORMAT = "MM-dd-yyyy HH:mm:ss";
	public static final String DATE_FORMAT = "MM-dd-yyyy";
	
	private String dateTimeFormat;
	private String dateTimeValue;
	private DateTime dateTime;
	private DateTimeZone dateTimeZone;
	private String timeZone;
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
	
	public MizeDateTime(String dateTimeValue,DateTimeFormatter dateTimeFormat){
		this(dateTimeValue, dateTimeFormat, DateTimeZone.UTC);
	}
	
	public MizeDateTime(String dateTimeValue,DateTimeFormatter dateTimeFormat,DateTimeZone dateTimeZone){
		try{		
			this.dateTimeValue = checkAndAppendTime(dateTimeValue);
			this.dateTimeFormat = dateTimeFormat.toString();
			this.dateTime = DateTime.parse(dateTimeValue,dateTimeFormat.withZone(dateTimeZone));	
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	public static MizeDateTime getInstance(String dateTimeValue,String dateTimeFormat,DateTimeZone dateTimeZone){
		return new MizeDateTime(dateTimeValue,dateTimeFormat, dateTimeZone);
	}
	
	public static MizeDateTime getInstance(String dateTimeValue,String dateTimeFormat){
		return new MizeDateTime(dateTimeValue,dateTimeFormat);
	}
	
	protected MizeDateTime(String dateTimeValue,String dateTimeFormat) {		
		this(dateTimeValue, dateTimeFormat, DateTimeZone.UTC);
	}
	
	protected MizeDateTime(String dateTimeValue,String dateTimeFormat,DateTimeZone dateTimeZone) {		
		try{		
			this.dateTimeValue = checkAndAppendTime(dateTimeValue);
			this.dateTimeFormat = dateTimeFormat;
			this.dateTime = DateTime.parse(this.dateTimeValue,DateTimeFormat.forPattern(dateTimeFormat).withZone(dateTimeZone));
			this.dateTimeZone = dateTimeZone;
			this.timeZone = dateTimeZone.getID();
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	protected MizeDateTime(String dateTimeValue,String dateTimeFormat,DateTimeZone dateTimeZone,DateTime dateTime) {		
		try{		
			this.dateTimeValue = checkAndAppendTime(dateTimeValue);
			this.dateTimeFormat = dateTimeFormat;
			this.dateTime = dateTime;
			this.dateTimeZone = dateTimeZone;
			this.timeZone = dateTimeZone.getID();
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

	public MizeDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
		this.isValid = true;
	}
	
	protected MizeDateTime(long millis, DateTimeZone timeZone) {
		this.dateTime = new DateTime(millis,timeZone);		
		this.dateTimeZone = timeZone;
		this.timeZone = this.dateTimeZone.getID();
		this.dateTimeFormat = DATE_TIME_FORMAT;
		this.dateTimeValue = getNewDateTimeValue(this.dateTime);
		this.isValid = true;
	}
	
	public MizeDateTime() {
		this.dateTime = new DateTime(DateTimeZone.UTC);
		this.dateTimeFormat = DATE_TIME_FORMAT;
		this.dateTimeZone = this.dateTime.getZone();
		this.timeZone = this.dateTimeZone.getID();
		this.dateTimeValue = getNewDateTimeValue(this.dateTime);
		this.isValid = true;
	}	
	
	public int compareTo(MizeDateTime mizeDateTime) {
		return dateTime.compareTo(mizeDateTime.getDateTime());
	}
	
	public long getMillis() {
		return dateTime.getMillis();
	}
	
	/*protected MizeDateTime(long millis) {
		dateTime = new DateTime(millis);
		isValid = true;
	}*/
	public MizeDateTime(long millis) {
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
		DateTime dt = this.dateTime.plusDays(days);
		return new MizeDateTime(getNewDateTimeValue(dt), this.dateTimeFormat, this.dateTimeZone,dt);
	}
	public MizeDateTime plusWeeks(int weeks){
		dateTime.plusWeeks(weeks);
		return this;
	}
	
	public MizeDateTime minusMonths(int months){
		DateTime dt = this.dateTime.minusMonths(months);
		return new MizeDateTime(getNewDateTimeValue(dt), this.dateTimeFormat, this.dateTimeZone,dt);
	}
	
	public MizeDateTime plusMonths(int months){
		DateTime dt = this.dateTime.plusMonths(months);
		return new MizeDateTime(getNewDateTimeValue(dt), this.dateTimeFormat, this.dateTimeZone,dt);
	}
	
	public MizeDateTime addYears(int years){
		DateTime dt = this.dateTime.plusYears(years);
		return new MizeDateTime(getNewDateTimeValue(dt), this.dateTimeFormat, this.dateTimeZone,dt);
	}
	
	public MizeDateTime minusHours(int hours){
		if (hours == 0) {
            return this;
        }
		dateTime.minusHours(hours);
		return this;
	}
	public MizeDateTime minusMillis(int millis){
		if(millis ==0){
			return this;
		}
		dateTime.minusMillis(millis);
		return this;
	}
	public MizeDateTime minusYears(int years){
		DateTime dt = this.dateTime.minusYears(years);
		return new MizeDateTime(getNewDateTimeValue(dt), this.dateTimeFormat, this.dateTimeZone,dt);
	}
	
	public MizeDateTime minusDays(int days){
		DateTime dt = this.dateTime.minusDays(days);
		return new MizeDateTime(getNewDateTimeValue(dt), this.dateTimeFormat, this.dateTimeZone,dt);
	}
	
	public MizeDateTime previousDay(){
		DateTime dt = this.dateTime.minusDays(1);
		return new MizeDateTime(getNewDateTimeValue(dt), this.dateTimeFormat, this.dateTimeZone,dt);
	}	
	
	private String getNewDateTimeValue(DateTime dt){
		String dtv = toString(this.dateTimeFormat, dateTimeZone, dt);
		return dtv;
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
	
	public DateTimeZone getDateTimeZone() {
		return dateTimeZone;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public boolean isValid() {
		return isValid;
	}
	
	/*public String toDBDateTime(){		
		return this.dateTime.toString(DB_DATE_TIME_FORMAT);
	}
	
	public String toString(String dateFormat){		
		return toString(dateFormat, DateTimeZone.UTC);
	}
	
	public String toString(String dateFormat, DateTimeZone dateTimeZone){		
		return DateTimeFormat.forPattern(dateFormat).withZone(dateTimeZone).print(this.dateTime);
	}*/
	
	public String toString(String dateFormat, DateTimeZone dateTimeZone, DateTime dateTime){	
		if(dateTimeZone != null){
			return DateTimeFormat.forPattern(dateFormat).withZone(dateTimeZone).print(dateTime);
		}else{
			return DateTimeFormat.forPattern(dateFormat).print(dateTime);
		}
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
		return new MizeDateTime(dateTime.getMillis(),dateTime.getZone());
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
		return toString(dateFormat, DateTimeZone.UTC);
	}
	
	public String toString(String dateFormat, DateTimeZone dateTimeZone){		
		return DateTimeFormat.forPattern(dateFormat).print(this.dateTime);
	}
	
}
