package com.mize.domain.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;

public class MizeDateTime implements IMizeDate, Comparable<MizeDateTime>, Cloneable{
	
	private static final long serialVersionUID = 7257173124058180557L;
	
	private String dateTimeFormat;
	private String dateTimeValue;
	private DateTime dateTime;
	private DateTimeZone dateTimeZone;
	private boolean isValid;
	
	@Deprecated
	public static MizeDateTime now(){
		return new MizeDateTime();
	}
	
	@Deprecated
	public static MizeDateTime getInstance(){
		return new MizeDateTime();
	}
		
	public static MizeDateTime getInstance(String dateTimeValue,String dateTimeFormat){
		return getInstance(dateTimeValue,dateTimeFormat,MizeDateTimeUtils.getDefaultDateTimeZone());
	}
	
	public static MizeDateTime getInstance(String dateTimeFormat,DateTimeZone dateTimeZone){
		return new MizeDateTime(dateTimeFormat,dateTimeZone);
	}
			
	public static MizeDateTime getInstance(String dateTimeValue,String dateTimeFormat, DateTimeZone userTimeZone){
		return new MizeDateTime(dateTimeValue,dateTimeFormat,MizeDateTimeUtils.getDefaultDateTimeZone(),userTimeZone);
	}
	
	private MizeDateTime(String dateTimeValue,String dateTimeFormat,DateTimeZone dateTimeZone,DateTimeZone userTimeZone) {		
		try{		
			this.dateTimeValue = checkAndAppendTime(dateTimeValue);
			if(dateTimeFormat == null){
				dateTimeFormat = MizeDateTimeUtils.getDateTimeFormat();
			}
			this.dateTimeFormat = dateTimeFormat;
			this.dateTime = DateTime.parse(this.dateTimeValue,DateTimeFormat.forPattern(dateTimeFormat).withZone(userTimeZone));
			this.dateTime = this.dateTime.toDateTime(dateTimeZone);
			this.dateTimeZone = dateTimeZone;
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	protected MizeDateTime(String dateTimeFormat,DateTimeZone dateTimeZone) {		
		try{		
			this.dateTimeFormat = dateTimeFormat;
			this.dateTimeZone = dateTimeZone;
			this.dateTime = new DateTime(dateTimeZone);
			this.dateTimeValue = DateTimeFormat.forPattern(dateTimeFormat).print(this.dateTime);
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
		this.dateTimeZone = dateTime.getZone();
	}
	
	public static MizeDateTime getInstance(long millis, DateTimeZone dateTimeZone) {
		return new MizeDateTime(millis, dateTimeZone);
	}
	
	public static MizeDateTime getInstance(long millis) {
		return new MizeDateTime(millis, MizeDateTimeUtils.getDefaultDateTimeZone());
	}
	
	protected MizeDateTime(long millis, DateTimeZone dateTimeZone) {
		this.dateTime = new DateTime(millis,dateTimeZone);	
		this.dateTimeZone = dateTimeZone;
		this.dateTimeFormat = MizeDateTimeUtils.getDateTimeFormat();
		this.dateTimeValue = toString(this.dateTimeFormat,this.dateTimeZone);
		this.isValid = true;
	}
	
	public MizeDateTime() {
		this.dateTime = new DateTime(MizeDateTimeUtils.getDefaultDateTimeZone());
		this.dateTimeFormat = MizeDateTimeUtils.getDateTimeFormat();
		this.dateTimeZone = this.dateTime.getZone();
		this.dateTimeValue = toString(this.dateTimeFormat,this.dateTimeZone);
		this.isValid = true;
	}	
	
	public int compareTo(MizeDateTime mizeDateTime) {
		return dateTime.compareTo(mizeDateTime.getDateTime());
	}
	
	public long getMillis() {
		return dateTime.getMillis();
	}
	
	public MizeDateTime subtractTime(long millis) {
		long currentTimeInMillis = dateTime.getMillis();
		if (millis > currentTimeInMillis) {
			return null;
		} else {
			createNewMizeDateTime(new DateTime(currentTimeInMillis - millis));
		}
		return null;
	}
	
	public MizeDateTime createNewMizeDateTime(DateTime dateTime){
		MizeDateTime mizeDateTime = new MizeDateTime(dateTime);
		mizeDateTime.dateTime = dateTime;
		mizeDateTime.dateTimeFormat = this.dateTimeFormat;
		mizeDateTime.dateTimeValue = toString(this.dateTimeFormat,this.dateTimeZone);
		mizeDateTime.dateTimeZone = this.dateTimeZone;
		mizeDateTime.isValid = this.isValid;
		return mizeDateTime;
	}
	
	public MizeDateTime nextDay(){
		this.dateTime.plusDays(1);
		return this;
	}
	
	public MizeDateTime plusDays(int days){
		return createNewMizeDateTime(this.dateTime.plusDays(days));
	}
	public MizeDateTime plusWeeks(int weeks){
		return createNewMizeDateTime(this.dateTime.plusWeeks(weeks));
	}
	
	public MizeDateTime minusMonths(int months){
		return createNewMizeDateTime(this.dateTime.minusMonths(months));
	}
	
	public MizeDateTime plusMonths(int months){
		return createNewMizeDateTime(this.dateTime.plusMonths(months));
	}
	
	public MizeDateTime addYears(int years){
		return createNewMizeDateTime(this.dateTime.plusYears(years));
	}
	
	public MizeDateTime minusHours(int hours){
		if (hours == 0) {
            return this;
        }
		return createNewMizeDateTime(this.dateTime.minusHours(hours));
	}
	public MizeDateTime minusMillis(int millis){
		if(millis ==0){
			return this;
		}
		return createNewMizeDateTime(this.dateTime.minusMillis(millis));
	}
	public MizeDateTime minusYears(int years){
		return createNewMizeDateTime(this.dateTime.minusYears(years));
	}
	
	public MizeDateTime minusDays(int days){
		return createNewMizeDateTime(this.dateTime.minusDays(days));
	}
	
	public MizeDateTime minusMinutes(int minutes){
		return createNewMizeDateTime(this.dateTime.minusMinutes(minutes));
	}
	
	public MizeDateTime plusMinutes(int minutes){
		return createNewMizeDateTime(this.dateTime.plusMinutes(minutes));
	}
	
	public MizeDateTime previousDay(){
		return createNewMizeDateTime(this.dateTime.minusDays(1));
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
	
	public void setDateTime(DateTime dateTime) {
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
		return createNewMizeDateTime(this.dateTime);
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
		if(this.isValid && mizeDateTime.isValid){
			return this.dateTime.equals(mizeDateTime.getDateTime());
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
