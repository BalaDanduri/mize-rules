package com.mize.domain.datetime;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.TypeDef;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;

import com.mize.domain.jpa.DateTimeJPA;
import com.mize.domain.util.DateTimeUtils;

@XmlType(name="appDateTime")
@TypeDef(name = "dateTime", defaultForType = DateTime.class, typeClass = DateTimeJPA.class)
@MappedSuperclass
public class DateTime implements IDateTime, Comparable<DateTime>, Cloneable{
	
	private static final long serialVersionUID = 7257173124058180557L;
	private String dateTimeFormat;
	private String dateTimeValue;
	private org.joda.time.DateTime baseValue;
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
		return getInstance(dateTimeValue,dateTimeFormat,DateTimeUtils.getDefaultDateTimeZone());
	}
	
	public static DateTime getInstance(String dateTimeFormat,DateTimeZone dateTimeZone){
		return new DateTime(dateTimeFormat,dateTimeZone);
	}
			
	public static DateTime getInstance(String dateTimeValue,String dateTimeFormat, DateTimeZone userTimeZone){
		return new DateTime(dateTimeValue,dateTimeFormat,DateTimeUtils.getDefaultDateTimeZone(),userTimeZone);
	}
	
	private DateTime(String dateTimeValue,String dateTimeFormat,DateTimeZone dateTimeZone,DateTimeZone userTimeZone) {		
		try{		
			this.dateTimeValue = checkAndAppendTime(dateTimeValue);
			if(dateTimeFormat == null){
				dateTimeFormat = DateTimeUtils.getDateTimeFormat();
			}
			this.dateTimeFormat = dateTimeFormat;
			this.baseValue = org.joda.time.DateTime.parse(this.dateTimeValue,DateTimeFormat.forPattern(dateTimeFormat).withZone(userTimeZone));
			this.baseValue = this.baseValue.toDateTime(dateTimeZone);
			this.dateTimeZone = dateTimeZone;
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	protected DateTime(String dateTimeFormat,DateTimeZone dateTimeZone) {		
		try{		
			this.dateTimeFormat = dateTimeFormat;
			this.dateTimeZone = dateTimeZone;
			this.baseValue = new org.joda.time.DateTime(dateTimeZone);
			this.dateTimeValue = DateTimeFormat.forPattern(dateTimeFormat).print(this.baseValue);
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	protected DateTime(String dateTimeValue,String dateTimeFormat,DateTimeZone dateTimeZone,org.joda.time.DateTime dateTime) {		
		try{		
			this.dateTimeValue = checkAndAppendTime(dateTimeValue);
			this.dateTimeFormat = dateTimeFormat;
			this.baseValue = dateTime;
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

	public DateTime(org.joda.time.DateTime baseValue) {
		this.baseValue = baseValue;
		this.isValid = true;
		this.dateTimeZone = baseValue.getZone();
	}
	
	public static DateTime getInstance(long millis, DateTimeZone dateTimeZone) {
		return new DateTime(millis, dateTimeZone);
	}
	
	public static DateTime getInstance(long millis) {
		return new DateTime(millis, DateTimeUtils.getDefaultDateTimeZone());
	}
	
	protected DateTime(long millis, DateTimeZone dateTimeZone) {
		this.baseValue = new org.joda.time.DateTime(millis,dateTimeZone);	
		this.dateTimeZone = dateTimeZone;
		this.dateTimeFormat = DateTimeUtils.getDateTimeFormat();
		this.dateTimeValue = toString(this.dateTimeFormat,this.dateTimeZone);
		this.isValid = true;
	}
	
	public DateTime() {
		this.baseValue = new org.joda.time.DateTime(DateTimeUtils.getDefaultDateTimeZone());
		this.dateTimeFormat = DateTimeUtils.getDateTimeFormat();
		this.dateTimeZone = this.baseValue.getZone();
		this.dateTimeValue = toString(this.dateTimeFormat,this.dateTimeZone);
		this.isValid = true;
	}	
	
	public int compareTo(DateTime dateTime) {
		if(this.baseValue == null && dateTime.baseValue == null){
			return 0;
		}
		if(this.baseValue != null){
			return this.baseValue.compareTo(dateTime.baseValue);
		}
		return 0;
	}
	
	public long getMillis() {
		return baseValue.getMillis();
	}
	
	public DateTime subtractTime(long millis) {
		long currentTimeInMillis = baseValue.getMillis();
		if (millis > currentTimeInMillis) {
			return null;
		} else {
			createNewDateTime(new org.joda.time.DateTime(currentTimeInMillis - millis));
		}
		return null;
	}
	
	public DateTime createNewDateTime(org.joda.time.DateTime baseValue){
		DateTime dateTimeValue = new DateTime(baseValue);
		dateTimeValue.baseValue = baseValue;
		dateTimeValue.dateTimeFormat = this.dateTimeFormat;
		dateTimeValue.dateTimeValue = toString(this.dateTimeFormat,this.dateTimeZone);
		dateTimeValue.dateTimeZone = this.dateTimeZone;
		dateTimeValue.isValid = this.isValid;
		return dateTimeValue;
	}
	
	public DateTime nextDay(){
		this.baseValue.plusDays(1);
		return this;
	}
	
	public DateTime plusDays(int days){
		return createNewDateTime(this.baseValue.plusDays(days));
	}
	public DateTime plusWeeks(int weeks){
		return createNewDateTime(this.baseValue.plusWeeks(weeks));
	}
	
	public DateTime minusMonths(int months){
		return createNewDateTime(this.baseValue.minusMonths(months));
	}
	
	public DateTime plusMonths(int months){
		return createNewDateTime(this.baseValue.plusMonths(months));
	}
	
	public DateTime addYears(int years){
		return createNewDateTime(this.baseValue.plusYears(years));
	}
	
	public DateTime minusHours(int hours){
		if (hours == 0) {
            return this;
        }
		return createNewDateTime(this.baseValue.minusHours(hours));
	}
	public DateTime minusMillis(int millis){
		if(millis ==0){
			return this;
		}
		return createNewDateTime(this.baseValue.minusMillis(millis));
	}
	public DateTime minusYears(int years){
		return createNewDateTime(this.baseValue.minusYears(years));
	}
	
	public DateTime minusDays(int days){
		return createNewDateTime(this.baseValue.minusDays(days));
	}
	
	public DateTime minusMinutes(int minutes){
		return createNewDateTime(this.baseValue.minusMinutes(minutes));
	}
	
	public DateTime plusMinutes(int minutes){
		return createNewDateTime(this.baseValue.plusMinutes(minutes));
	}
	
	public DateTime previousDay(){
		return createNewDateTime(this.baseValue.minusDays(1));
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
	
	public org.joda.time.DateTime getBaseValue() {
		return baseValue;
	}
	
	public void setBaseValue(org.joda.time.DateTime baseValue) {
		this.baseValue = baseValue;
	}

	public DateTimeZone getDateTimeZone() {
		return dateTimeZone;
	}

	public boolean isValid() {
		return isValid;
	}
	
	public boolean isInValid() {
		return !isValid();
	}
		
	@Override
	public String toString() {
		// use default time format to print
		if(this.baseValue != null){
			return ISODateTimeFormat.dateTime().print(this.baseValue);
		}else{
			return this.dateTimeValue;
		}
	}
	
	public Object clone() {
		return createNewDateTime(this.baseValue);
	}
	
	
	@Override
	public int hashCode() {
		return (baseValue == null) ? 0 : baseValue.hashCode();
	}

	public boolean equals(Object obj){
		if(obj instanceof DateTime){
			DateTime other = (DateTime)obj;
			if(this.baseValue == null && other.getBaseValue() == null){
				return true;
			}
			if(this.baseValue != null){
				return this.baseValue.equals(other.getBaseValue());
			}
		}
		return false;
	}
		
	public String toString(String dateTimeFormat, DateTimeZone dateTimeZone){	
		if(dateTimeZone == null){
			return DateTimeFormat.forPattern(dateTimeFormat).print(this.baseValue);
		}else{
			return DateTimeFormat.forPattern(dateTimeFormat).withZone(dateTimeZone).print(this.baseValue);
		}
	}
	
}
