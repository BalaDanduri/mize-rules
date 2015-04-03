package com.mize.domain.datetime;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.TypeDef;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;

import com.mize.domain.jpa.DateJPA;
import com.mize.domain.util.DateTimeUtils;

@XmlType(name="appDate")
@TypeDef(name = "date", defaultForType = Date.class, typeClass = DateJPA.class)
@MappedSuperclass
public class Date implements IDateTime, Comparable<Date>, Cloneable{
	
	private static final long serialVersionUID = 7257173124058180557L;
	private String dateFormat;
	private String dateValue;
	private org.joda.time.DateTime baseValue;
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
	public org.joda.time.DateTime getBaseValue() {
		return baseValue;
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	public boolean isInValid() {
		return !isValid();
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
	
	public static Date getInstance(org.joda.time.DateTime baseValue){
		if(baseValue != null){
			return new Date(baseValue);
		}else{
			return null;
		}
		
	}
	
	public static Date getInstance(String dateValue,String dateFormat,DateTimeZone timeZone){
		return new Date(dateValue,dateFormat,timeZone);
	}
	
	public static Date getInstance(String dateValue,String dateFormat){
		return getInstance(dateValue,dateFormat, DateTimeUtils.getDefaultDateTimeZone());
	}
		
	public static Date getInstance(String dateFormat, DateTimeZone timeZone){
		return new Date(dateFormat,timeZone);
	}
	
	protected Date(String dateValue,String dateFormat,DateTimeZone timeZone) {		
		try{		
			this.dateValue = dateValue;
			this.dateFormat = dateFormat;
			this.baseValue = org.joda.time.DateTime.parse(dateValue,DateTimeFormat.forPattern(dateFormat).withZone(timeZone));	
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
				this.baseValue = new org.joda.time.DateTime(org.joda.time.DateTime.now().getMillis(),timeZone);
			}else{
				this.baseValue = new org.joda.time.DateTime(millis,timeZone);
			}
			this.dateValue = DateTimeFormat.forPattern(dateFormat).print(this.baseValue);
			this.baseValue = org.joda.time.DateTime.parse(this.dateValue,DateTimeFormat.forPattern(dateFormat).withZone(timeZone));	
			this.dateTimeZone = timeZone;
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	public Date(org.joda.time.DateTime baseValue) {
		this.baseValue = baseValue;
		this.isValid = true;
		this.dateTimeZone = DateTimeZone.getDefault();	
	}
		
	public Date() {
		this(new org.joda.time.DateTime());				
	}	
	
	public int compareTo(Date date) {
		return baseValue.compareTo(date.baseValue);
	}
	
	public Date(long millis) {
		this(DateTimeUtils.getDateFormat(),DateTimeUtils.getDefaultDateTimeZone(), millis);
	}
		
	public static Date getInstance(long millis) {
		return getInstance(millis, DateTimeUtils.getDefaultDateTimeZone());
	}
	
	public static Date getInstance(long millis, DateTimeZone dateTimeZone) {
		return new Date(DateTimeUtils.getDateFormat(), dateTimeZone, millis);
	}

	public Date nextDay(){
		return createNewDate(this.baseValue.plusDays(1));
	}
	
	public Date plusDays(int days){
		return createNewDate(this.baseValue.plusDays(days));
	}
	
	public Date minusMonths(int months){
		return createNewDate(this.baseValue.minusMonths(months));
	}
	
	public Date plusMonths(int months){
		return createNewDate(this.baseValue.plusMonths(months));
	}
	
	public Date addYears(int years){
		return createNewDate(this.baseValue.plusYears(years));
	}
	
	public Date minusYears(int years){
		return createNewDate(this.baseValue.minusYears(years));
	}
	
	public Date minusDays(int days){
		return createNewDate(this.baseValue.minusDays(days));
	}
	
	public Date previousDay(){
		return createNewDate(this.baseValue.minusDays(1));
	}	
	
	public Date createNewDate(org.joda.time.DateTime baseValue){
		Date date = new Date(baseValue);
		date.baseValue = baseValue;
		date.dateFormat = this.dateFormat;
		date.dateValue = toString(this.dateFormat,this.dateTimeZone);
		date.dateTimeZone = this.dateTimeZone;
		date.isValid = this.isValid;
		return date;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Date){
			Date other = (Date)obj;
			if(this.baseValue == null && other.getBaseValue() == null){
				return true;
			}
			if(this.baseValue != null){
				return this.baseValue.equals(other.getBaseValue());
			}
		}
		return false;
	}
	
	public String toString(String dateFormat, DateTimeZone dateTimeZone){	
		if(dateTimeZone == null){
			return DateTimeFormat.forPattern(dateFormat).print(this.baseValue);
		}else{
			return DateTimeFormat.forPattern(dateFormat).withZone(dateTimeZone).print(this.baseValue);
		}
	}
	
	public Object clone() {
		return new Date(baseValue.getMillis());
	}
	
	public long getMillis() {
		return baseValue.getMillis();
	}
	
	@Override
	public String toString() {
		if(this.baseValue != null){
			return ISODateTimeFormat.dateTime().print(this.baseValue);
		}else{
			return this.dateValue;
		}
	}
	
	@Override
	public int hashCode() {
		return (baseValue == null) ? 0 : baseValue.hashCode();
	}
	
}
