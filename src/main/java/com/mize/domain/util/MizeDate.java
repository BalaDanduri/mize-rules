package com.mize.domain.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;

public class MizeDate implements IMizeDate, Comparable<MizeDate>, Cloneable{
	
	private static final long serialVersionUID = 7257173124058180557L;
	private String dateFormat;
	private String dateValue;
	private DateTime dateTime;
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
	public DateTime getDateTime() {
		return dateTime;
	}
	
	public boolean isValid() {
		return isValid;
	}
	public DateTimeZone getDateTimeZone() {
		return dateTimeZone;
	}
	
	@Deprecated
	public static MizeDate now(){
		return new MizeDate();
	}
	
	@Deprecated
	public static MizeDate getInstance(){
		return new MizeDate();
	}
	
	public static MizeDate getInstance(DateTime dateTime){
		if(dateTime != null){
			return new MizeDate(dateTime);
		}else{
			return null;
		}
		
	}
	
	public static MizeDate getInstance(String dateValue,String dateFormat,DateTimeZone timeZone){
		return new MizeDate(dateValue,dateFormat,timeZone);
	}
	
	public static MizeDate getInstance(String dateValue,String dateFormat){
		return getInstance(dateValue,dateFormat, MizeDateTimeUtils.getDefaultDateTimeZone());
	}
		
	public static MizeDate getInstance(String dateFormat, DateTimeZone timeZone){
		return new MizeDate(dateFormat,timeZone);
	}
	
	protected MizeDate(String dateValue,String dateFormat,DateTimeZone timeZone) {		
		try{		
			this.dateValue = dateValue;
			this.dateFormat = dateFormat;
			this.dateTime = DateTime.parse(dateValue,DateTimeFormat.forPattern(dateFormat).withZone(timeZone));	
			this.dateTimeZone = timeZone;
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	protected MizeDate(String dateFormat, DateTimeZone timeZone) {		
		this(dateFormat, timeZone,null);
	}
	
	protected MizeDate(String dateFormat, DateTimeZone timeZone, Long millis) {		
		try{		
			this.dateFormat = dateFormat;
			if(millis == null || millis.longValue() == 0){
				this.dateTime = new DateTime(DateTime.now().getMillis(),timeZone);
			}else{
				this.dateTime = new DateTime(millis,timeZone);
			}
			this.dateValue = DateTimeFormat.forPattern(dateFormat).print(this.dateTime);
			this.dateTime = DateTime.parse(this.dateValue,DateTimeFormat.forPattern(dateFormat).withZone(timeZone));	
			this.dateTimeZone = timeZone;
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	protected MizeDate(DateTime dateTime) {
		this.dateTime = dateTime;
		this.isValid = true;
	}
		
		private MizeDate() {
		this.dateTime = new DateTime();
		this.isValid = true;
		this.dateTimeZone = DateTimeZone.getDefault();				
	}	
	
	public int compareTo(MizeDate mizeDateTime) {
		return dateTime.compareTo(mizeDateTime.getDateTime());
	}
	
	protected MizeDate(long millis) {
		this(MizeDateTimeUtils.getDateFormat(),MizeDateTimeUtils.getDefaultDateTimeZone(), millis);
	}
		
	protected static MizeDate getInstance(long millis) {
		return getInstance(millis, MizeDateTimeUtils.getDefaultDateTimeZone());
	}
	
	protected static MizeDate getInstance(long millis, DateTimeZone dateTimeZone) {
		return new MizeDate(MizeDateTimeUtils.getDateFormat(), dateTimeZone, millis);
	}

	public MizeDate nextDay(){
		return createNewMizeDate(this.dateTime.plusDays(1));
	}
	
	public MizeDate plusDays(int days){
		return createNewMizeDate(this.dateTime.plusDays(days));
	}
	
	public MizeDate minusMonths(int months){
		return createNewMizeDate(this.dateTime.minusMonths(months));
	}
	
	public MizeDate plusMonths(int months){
		return createNewMizeDate(this.dateTime.plusMonths(months));
	}
	
	public MizeDate addYears(int years){
		return createNewMizeDate(this.dateTime.plusYears(years));
	}
	
	public MizeDate minusYears(int years){
		return createNewMizeDate(this.dateTime.minusYears(years));
	}
	
	public MizeDate minusDays(int days){
		return createNewMizeDate(this.dateTime.minusDays(days));
	}
	
	public MizeDate previousDay(){
		return createNewMizeDate(this.dateTime.minusDays(1));
	}	
	
	public MizeDate createNewMizeDate(DateTime dateTime){
		MizeDate mizeDate = new MizeDate(dateTime);
		mizeDate.dateTime = dateTime;
		mizeDate.dateFormat = this.dateFormat;
		mizeDate.dateValue = toString(this.dateFormat,this.dateTimeZone);
		mizeDate.dateTimeZone = this.dateTimeZone;
		mizeDate.isValid = this.isValid;
		return mizeDate;
	}
	
	public boolean equals(Object object){
		MizeDate mizeDateTime = (MizeDate)object;
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
		return new MizeDate(dateTime.getMillis());
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
