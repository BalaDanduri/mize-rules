package com.mize.domain.util;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MizeDateTime implements Serializable, Comparable<MizeDateTime>{
	
	private static final long serialVersionUID = 7257173124058180557L;
	private static final String DEF_DATE_FORMAT = "MM/dd/yyyy";	
	private static final String DEF_END_DATE = "12/31/9999";	
	public static final DateTimeFormatter  DB_DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	
	private String dateFormatt;
	private String dateValue;
	private DateTime dateTime;
	private boolean isValid;
	
	public String getDateFormatt() {
		return dateFormatt;
	}
	public void setDateFormatt(String dateFormatt) {
		this.dateFormatt = dateFormatt;
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
	
	public MizeDateTime getInstance(){
		return new MizeDateTime();
	}
	
	protected MizeDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
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
	
	static {
		DateTimeFormatter simpleDateFormat = DateTimeFormat.forPattern(DEF_DATE_FORMAT);
		DateTime.parse(DEF_END_DATE);
		@SuppressWarnings("unused")
		DateTime time = DateTime.parse(DEF_END_DATE,simpleDateFormat);
	}
	
	public MizeDateTime defaultEndDate(){
		DateTimeFormatter simpleDateFormat = DateTimeFormat.forPattern(DEF_DATE_FORMAT);
		DateTime.parse(DEF_END_DATE);
		DateTime dateTime = DateTime.parse(DEF_END_DATE,simpleDateFormat);
		return new MizeDateTime(dateTime);
	}
	
	public MizeDateTime defaultEndDate(String dateFormatt){
		DateTimeFormatter simpleDateFormat = DateTimeFormat.forPattern(dateFormatt);
		DateTime.parse(DEF_END_DATE);
		DateTime dateTime = DateTime.parse(DEF_END_DATE,simpleDateFormat);
		return new MizeDateTime(dateTime);
	}
	
	public MizeDateTime nextDay(){
		this.dateTime.plusDays(1);
		return this;
	}
	
	public MizeDateTime addDays(int days){
		dateTime.plusDays(days);
		return this;
	}
	
	public MizeDateTime substractMonths(int months){
		dateTime.minusMonths(months);
		return this;
	}
	
	public MizeDateTime addMonths(int months){
		dateTime.plusMonths(months);
		return this;
	}
	
	public MizeDateTime addYears(int years){
		dateTime.plusYears(years);
		return this;
	}
	
	public MizeDateTime substractYears(int years){
		dateTime.minusYears(years);
		return this;
	}
	
	public MizeDateTime substractDays(int days){
		dateTime.minusDays(days);
		return this;
	}
	
	public MizeDateTime previousDay(){
		this.dateTime.minusDays(1);
		return this;
	}	
	
	public boolean equals(MizeDateTime mizeDateTime){
		return this.dateTime.equals(mizeDateTime.getDateTime());
	}
	
	public String toDBDateTime(){		
		return this.dateTime.toString(DB_DATE_TIME_FORMAT);
	}
	
}
