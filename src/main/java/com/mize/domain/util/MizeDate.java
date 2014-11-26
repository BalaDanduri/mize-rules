package com.mize.domain.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class MizeDate implements IMizeDate, Comparable<MizeDate>, Cloneable{
	
	private static final long serialVersionUID = 7257173124058180557L;
	private static final String DEF_DATE_FORMAT = "MM/dd/yyyy";	
	private static final String DEF_END_DATE = "12/31/9999";	
	public static final DateTimeFormatter  DB_DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	
	private String dateFormat;
	private String dateValue;
	private DateTime dateTime;
	private boolean isValid;
		
	public static MizeDate now(){
		return new MizeDate();
	}
	
	@Deprecated
	public static MizeDate getInstance(){
		return new MizeDate();
	}
	
	public static MizeDate getInstance(DateTime dateTime){
		return new MizeDate(dateTime);
	}
	
	public static MizeDate getInstance(long millis, DateTimeZone timeZone){
		return new MizeDate(millis, timeZone);
	}
	
	public static MizeDate getInstance(String dateValue,String dateFormat){
		return new MizeDate(dateValue,dateFormat);
	}
	
	public static MizeDate getInstance(String dateFormat){
		return new MizeDate(dateFormat);
	}
	
	protected MizeDate(String dateValue,String dateFormat) {		
		try{		
			this.dateValue = dateValue;
			this.dateFormat = dateFormat;
			this.dateTime = DateTime.parse(dateValue,DateTimeFormat.forPattern(dateFormat));	
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	protected MizeDate(String dateFormat) {		
		try{		
			this.dateFormat = dateFormat;
			this.dateTime = DateTime.parse(dateValue,DateTimeFormat.forPattern(dateFormat));
			this.dateValue = DateTimeFormat.forPattern(dateFormat).print(this.dateTime);
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	protected MizeDate(DateTime dateTime) {
		this.dateTime = dateTime;
		this.isValid = true;
	}
	
	protected MizeDate(long millis, DateTimeZone timeZone) {
		this.dateTime = new DateTime(millis,timeZone);
		this.isValid = true;
	}
	
	protected MizeDate() {
		this.dateTime = new DateTime();
		this.isValid = true;
	}	
	
	public int compareTo(MizeDate mizeDateTime) {
		return dateTime.compareTo(mizeDateTime.getDateTime());
	}
	
	public Object clone() {
		return new MizeDate(dateTime.getMillis());
	}
	
	public long getMillis() {
		return dateTime.getMillis();
	}
	
	protected MizeDate(long millis) {
		dateTime = new DateTime(millis);
		isValid = true;
	}
	
	public MizeDate addTime(long addTimeInMillis) {
		long newTimeinMillis = dateTime.getMillis() + addTimeInMillis;
		return new MizeDate(newTimeinMillis);
	}

	public MizeDate subtractTime(long millis) {
		long currentTimeInMillis = dateTime.getMillis();
		if (millis > currentTimeInMillis) {
			return null;
		} else {
			return new MizeDate(currentTimeInMillis - millis);
		}
	}
		
	public MizeDate defaultEndDate(){
		DateTimeFormatter simpleDateFormat = DateTimeFormat.forPattern(DEF_DATE_FORMAT);
		DateTime.parse(DEF_END_DATE);
		DateTime dateTime = DateTime.parse(DEF_END_DATE,simpleDateFormat);
		return new MizeDate(dateTime);
	}
	
	public MizeDate defaultEndDate(String dateFormat){
		DateTimeFormatter simpleDateFormat = DateTimeFormat.forPattern(dateFormat);
		DateTime.parse(DEF_END_DATE);
		DateTime dateTime = DateTime.parse(DEF_END_DATE,simpleDateFormat);
		return new MizeDate(dateTime);
	}
	
	public MizeDate nextDay(){
		this.dateTime.plusDays(1);
		return this;
	}
	
	public MizeDate plusDays(int days){
		dateTime.plusDays(days);
		return this;
	}
	
	public MizeDate minusMonths(int months){
		dateTime.minusMonths(months);
		return this;
	}
	
	public MizeDate plusMonths(int months){
		dateTime.plusMonths(months);
		return this;
	}
	
	public MizeDate addYears(int years){
		dateTime.plusYears(years);
		return this;
	}
	
	public MizeDate minusYears(int years){
		dateTime.minusYears(years);
		return this;
	}
	
	public MizeDate minusDays(int days){
		dateTime.minusDays(days);
		return this;
	}
	
	public MizeDate previousDay(){
		this.dateTime.minusDays(1);
		return this;
	}	
	
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
	public DateTime getDateTime() {
		return dateTime;
	}
	
	public boolean isValid() {
		return isValid;
	}

	public boolean equals(Object object){
		MizeDate mizeDateTime = (MizeDate)object;
		if(this.isValid && mizeDateTime.isValid){
			return this.dateTime.equals(mizeDateTime.getDateTime());
		}else{
			return true;
		}
	}
	
	public String toDBDateTime(){		
		return this.dateTime.toString(DB_DATE_TIME_FORMAT);
	}
	
	public String toString(String dateFormat){		
		return DateTimeFormat.forPattern(dateFormat).print(this.dateTime);
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
