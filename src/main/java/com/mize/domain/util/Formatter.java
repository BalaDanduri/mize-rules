package com.mize.domain.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.mize.domain.common.PaginationPage;

public final class Formatter {
	public static final String EMPTY = "";
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final DateTimeFormatter  DATE_FORMAT = DateTimeFormat.forPattern("MM-dd-yyyy HH:mm:ss");
	public static final DateTimeFormatter  DATE_FORMAT1 = DateTimeFormat.forPattern("MM-dd-yyyy");
	public static final DateTimeFormatter  DATE_FORMAT3 = DateTimeFormat.forPattern("MM/dd/yyyy");
	public static final DateTimeFormatter  DB_DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	public static final DateTimeFormatter  DB_DATE_TIME_FORMAT1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss:SSS");
	public static final DateTimeFormatter  DATE_FORMAT2 = DateTimeFormat.forPattern("yyyy-MM-dd");
	public static final String LIKE = "%";
	private static final Pattern HTML_TAGS_PATTERN = Pattern.compile("<.+?>");
	private static final String HTML_COMMENTS_PATTERN = "(?s)<!--.*?-->";
	public static final String DATE_SEPARATE = "-";
	public static final String MORE_TEXT = "...";
	public static final Integer DEFAULT_LOCALE = 1;
	public static final String AMAZON_PRODUCT_FEATURES = "Amazon_Product_Features";
	public static final String SPECIFICATION_WIDTH = "Width";
	public static final String SPECIFICATION_DEPTH = "Depth";
	public static final String SPECIFICATION_HEIGHT = "Height";
	public static final String SPECIFICATION_LENGTH = "Length";
	public static final String SPECIFICATION_WEIGHT = "Weight";
	public static String UNIT_INCHES = "inches";
	public static String UNIT_POUNDS = "pounds";
	public static String NEW_LINE = "\n";
	public static String BR_LINE = "<br>";
	public static final Map<Integer, String> SPL_CHAR_MAP = new HashMap<Integer,String>();
	public static final List<String> amazonSpecList = new ArrayList<String>();
	
	private Formatter(){		
	}
	
	static{
		amazonSpecList.add(AMAZON_PRODUCT_FEATURES);
		amazonSpecList.add(SPECIFICATION_WIDTH);
		amazonSpecList.add(SPECIFICATION_DEPTH);
		amazonSpecList.add(SPECIFICATION_LENGTH);
		amazonSpecList.add(SPECIFICATION_WEIGHT);
		amazonSpecList.add(SPECIFICATION_HEIGHT);
		SPL_CHAR_MAP.put(153,"&trade;");
		SPL_CHAR_MAP.put(169,"&copy;");
		SPL_CHAR_MAP.put(174,"&reg;");
		SPL_CHAR_MAP.put(8482,"&trade;");		
	}
	
	public static int intValue(Integer intVal){
		int value = 0;
		if(intVal != null){
			value = intVal.intValue();
		}		
		return value;
	}
	
	public static long longValue(Long longVal){
		long value = 0;
		if(longVal != null){
			value = longVal.longValue();
		}		
		return value;
	}
	
	public static boolean isNull(Integer number){
		int value = 0;
		if(number != null){
			value = number.intValue();
		}		
		return value <= 0;
	}
	
	public static boolean isNull(Long number){
		long value = 0;
		if(number != null){
			value = number.longValue();
		}		
		return value <= 0;
	}
	
	public static boolean isNull(BigDecimal number){
		double value = 0;
		if(number != null){
			value = number.doubleValue();
		}		
		return value <= 0;
	}
	
	public static boolean isNotNull(Integer number){
		return !isNull(number);
	}
	
	public static boolean isNotNull(Long number){
		return !isNull(number);
	}
	
	public static boolean isNotNull(BigDecimal number){
		return !isNull(number);
	}
	
	public static double doubleValue(Double dValue){
		double value = 0.0;
		if(dValue != null){
			value = dValue.doubleValue();
		}		
		return value;
	}
	
	public static double doubleValue(String dValue){
		double value = 0.0;
		if(dValue != null){
			try{
				value = Double.valueOf(dValue);
			}catch(Exception e){}
		}		
		return value;
	}
	
	public static double doubleValue(BigDecimal decimal){
		double value = 0.0;
		if(decimal != null){
			value = decimal.doubleValue();
		}		
		return value;
	}
	
	public static int intValue(String intStr){
		int value = 0;
		try{
			value = Integer.parseInt(intStr);
		}catch(Exception e){			
		}
		return value;
	}
	
	public static long longValue(String intStr){
		long value = 0;
		try{
			value = Long.parseLong(intStr);
		}catch(Exception e){			
		}
		return value;
	}
	
	public static float getFloatValue(BigDecimal decimal){
		float value = 0;
		if(decimal != null){
			value = decimal.floatValue();
		}		
		return value;
	}
	
	public static String makeNotNullString(String str){
		return str == null?EMPTY:str.trim();
	}
	
	public static String notNullString(String str){
		return str == null?EMPTY:str.trim();
	}
	
	public static boolean isNull(String str){
		return (str == null || str.trim().length()==0);
	}
	
	public static boolean isNotNull(String str){
		return (!isNull(str));
	}
	
	public static boolean isNotNull(String val1,String val2){
		return (!isNull(val1) && !isNull(val1));
	}
	
	public static boolean isYorN(String str){
		if(str == null || !(YES.equalsIgnoreCase(str.trim()) || NO.equalsIgnoreCase(str.trim()))){
			return false;
		}
		return true;
	}
	
	public static boolean isY(String str){
		if(str != null && YES.equalsIgnoreCase(str.trim())){
			return true;
		}
		return false;
	}
	
	public static boolean isN(String str){
		if(str != null && NO.equalsIgnoreCase(str.trim())){
			return true;
		}
		return false;
	}
	
	public static boolean charToBoolean(char c) {
		return ((c == 'Y') || (c == 'y'));
	}
	
	public static boolean stringToBoolean(String str) {
		return (str == null || NO.equalsIgnoreCase(str) ? false: true);
	}	
	
	public static int getLength(String str){
		return (str == null ? 0: str.trim().length());
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Collection collection){
		return (collection == null || collection.isEmpty());
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Map map){
		return (map == null || map.isEmpty());
	}
	
	@Deprecated
	public static String getDateTime(DateTime dateTime){
		return (dateTime == null ? null : dateTime.toString(DATE_FORMAT));
	}
	
	public static String getDateTimeFormat(MizeDateTime mizeDateTime){
		return (mizeDateTime == null ? null : mizeDateTime.getDateTime().toString(DATE_FORMAT3));
	}
	
	public static String formStringInClause(List<String> list){
		StringBuffer sb = new StringBuffer(EMPTY);
		if(list == null)
			return sb.toString();
		for(int i = 0; i<list.size() ; i++){
			if(i ==0){
				sb.append("'").append(list.get(i)).append("'");
			}else{
				sb.append(",").append("'").append(list.get(i)).append("'");
			}
		}
		return sb.toString();		
	}
	
	public static String formStringInClause(Set<String> set){
		StringBuffer sb = new StringBuffer(EMPTY);
		if(set == null)
			return sb.toString();
		Iterator<String> ite = set.iterator();
		int count = 0;
		while(ite.hasNext()){
			if(count == 0){
				count++;
				sb.append("'").append(ite.next()).append("'");
			}else{
				sb.append(",").append("'").append(ite.next()).append("'");
			}			
		}
		return sb.toString();		
	}
	
	@SuppressWarnings("rawtypes")
	public static String formInClause(List list){
		StringBuffer sb = new StringBuffer(EMPTY);
		if(list == null)
			return sb.toString();
		for(int i = 0; i<list.size() ; i++){
			if(i ==0){
				sb.append(list.get(i));
			}else{
				sb.append(",").append(list.get(i));
			}
		}
		return sb.toString();		
	}
	
	public static double convertedPrice(BigInteger value){
		double val = Double.valueOf(0);
		if((val= doubleValue(value)) > 0)
			return val/100;
		return val;
	}
	
	public static double doubleValue(BigInteger value){
		return value == null ? Double.valueOf(0):value.doubleValue();	
	}
	
	@Deprecated
	public static DateTime dateTime(String dateTime){
		DateTime time = null;
		if(dateTime!= null){
			try{
				time = DateTime.parse(dateTime,DATE_FORMAT);
			}catch(Exception e){
			}
		}		
		return time;
	}
	
	@Deprecated
	public static DateTime dateTime(String dateTime, String format){
		DateTime time = null;
		if(dateTime!= null && format != null){
			try{
				DateTimeFormatter  FORMAT = DateTimeFormat.forPattern(format);
				if (dateTime.length() > format.length()) {
					dateTime = dateTime.substring(0, format.length());
				}
				time = DateTime.parse(dateTime,FORMAT);
			}catch(Exception e){
			}
		}		
		return time;
	}
	
	public static String trimLength(String input,int length){
		String result = null;
		try{
			result = input;
			if(input != null && input.trim().length() > length){
				result = input.trim().substring(0, length-1);
			}
		}catch(Exception e){			
		}
		return result;
	}

	@Deprecated
	public static DateTime date(String dateTime){
		DateTime time = null;
		if(dateTime!= null){
			try{
				time = DateTime.parse(dateTime,DATE_FORMAT1);
			}catch(Exception e){
			}
		}		
		return time;
	}
	
	public static DateTime date1(String dateTime){
		DateTime time = null;
		if(dateTime!= null){
			try{
				time = DateTime.parse(dateTime,DATE_FORMAT3);
			}catch(Exception e){
			}
		}		
		return time;
	}
	
	public static DateTime date2(Date date){
		DateTime time = null;
		if(date!= null){
			try{
				time = new DateTime(date.getTime());
			}catch(Exception e){
			}
		}		
		return time;
	}
	
	@Deprecated
	public static DateTime dateTime(Timestamp timestamp){
		DateTime time = null;
		if(timestamp!= null){
			time = new DateTime(timestamp);
		}
		return time;
	}

	public static String toLowerCase(String value){
		return value == null ? EMPTY : value.trim().toLowerCase();	
	}
	
	public static String toUpperCase(String value){
		return value == null ? EMPTY : value.trim().toUpperCase();	
	}
	

	public static BigInteger toBigInt(String value) {
		BigInteger returnValue = BigInteger.ZERO;
		if (value != null) {
			try {
				returnValue = new BigInteger(value);
			} catch(Exception e) {
				Float floatVal = new Float(value);
				returnValue = new BigInteger(String.valueOf(floatVal.intValue()+1));
			}
		}
		return returnValue;
	}
	
	public static BigDecimal toBigDecimal(String value) {
		BigDecimal returnValue = null;
		if (value != null && value.trim().length() > 0) {
			try {
				returnValue = new BigDecimal(value);
			} catch(Exception e) {
			}
		}
		return returnValue;
	}
	
	public static BigDecimal toBigDecimal(Double value) {
		BigDecimal returnValue = null;
		if (value != null) {
			try {
				returnValue = new BigDecimal(value);
			} catch(Exception e) {
			}
		}
		return returnValue;
	}
	
	public static BigInteger toBigInt(int value) {
		return value == 0 ? BigInteger.ZERO : new BigInteger(String.valueOf(value))  ;
	}
	
	public static int convertDollortoPennies(String value) {
		return value == null ? 0 : Integer.parseInt(value) * 100   ;
	}
	
	public static int convertPenniesDollorto(String value) {
		return value == null ? 0 : Integer.parseInt(value) / 100   ;
	}
	
	public static Double convertToByHundered(Double value) {
		return value == null ? 0 :value / 100   ;
	}

	public static String likeString(String value){		
		return LIKE+toUpperCase(value)+LIKE;
	}
	
	public static String likeStringStartsWith(String value){		
		return toUpperCase(value)+LIKE;
	}
	
	
	public static String removeHtml(String value){
		if(getLength(value) >0){
			try{
				value=value.replaceAll(HTML_COMMENTS_PATTERN, EMPTY);
				Matcher m = HTML_TAGS_PATTERN.matcher(value);
				value = m.replaceAll(EMPTY);
				value = value.replaceAll("  ",EMPTY);
			}catch(Exception e){
			}
		}	
		return value;
	}
	public static String getMonthAndDay(DateTime dateTime) {
		String date = null;
		if(dateTime != null){
			date = dateTime.getMonthOfYear()+DATE_SEPARATE+dateTime.getDayOfMonth();			
		}
		return date;
	}	
	
	static Map<String, String> uomConversionForAmazon = new HashMap<String, String>();
	static {
		uomConversionForAmazon.put("hundredths-pounds", "pounds");
		uomConversionForAmazon.put("hundredths-inches", "inches");
	}
	
	public static String convertUOM(String uom) {
		return uomConversionForAmazon.get(uom);
	}
	public static boolean isTrue(String val){
		return "True".equalsIgnoreCase(val);
	}
	public static Double formattedDouble(Double value){
		if(value == null){
			return null;
		}else{
			return Double.valueOf(new DecimalFormat("#.##").format(value));
		}
	}
	@SuppressWarnings("rawtypes")
	public static int size( Collection list){
		return (list == null ? 0:list.size());
	}
	@SuppressWarnings("rawtypes")
	public static int size( Map map){
		return (map == null ? 0:map.size());
	}
	
	public static boolean equal(Double var1,Double var2){
		return (doubleValue(var1) == doubleValue(var2));
	}
	
	public static boolean equal(BigDecimal var1,BigDecimal var2){
		return (doubleValue(var1) == doubleValue(var2));
	}
	
	public static boolean equal(Long var1,Long var2){
		return (longValue(var1) == longValue(var2));
	}
	
	public static boolean equal(Long var1,Integer var2){
		return (longValue(var1) == intValue(var2));
	}
	
	public static boolean equal(Integer var1,Integer var2){
		return (intValue(var1) == intValue(var2));
	}
	public static boolean equal(String var1,String var2){
		return (makeNotNullString(var1).equals(makeNotNullString(var2)));
	}
	public static boolean equalIgnoreCase(String var1,String var2){
		return (makeNotNullString(var1).equalsIgnoreCase(makeNotNullString(var2)));
	}
	@SuppressWarnings("rawtypes")
	public static boolean equalIgnoreCase(Enum var1,String var2){
		if(var1 == null){
			return false;
		}
		return (makeNotNullString(var1.toString()).equalsIgnoreCase(makeNotNullString(var2)));
	}
	public static String concat(Long var1,String var2){
		return longValue(var1)+makeNotNullString(var2);
	}
	public static String concat(Long var1,Long var2){
		return longValue(var1)+EMPTY+longValue(var2);
	}
	public static String concat(Long var1,Long var2,Long var3){
		return longValue(var1)+EMPTY+longValue(var2)+EMPTY+longValue(var3);
	}
	public static String concat(Long var1,Long var2 ,String var3){
		return longValue(var1)+EMPTY+longValue(var2)+makeNotNullString(var3);
	}
	public static int daysDiff(DateTime time1 , DateTime time2){
		if(time1 != null && time2 != null){
			return time1.compareTo(time2);
		}
		return 0;		
	}
	public static int daysDiff(MizeDateTime time1,MizeDateTime time2){
		if(time1 != null && time2 != null){
			return time1.compareTo(time2);
		}
		return 0;	
	}
	public static int daysDiff(MizeDate time1,MizeDate time2){
		if(time1 != null && time2 != null){
			return time1.compareTo(time2);
		}
		return 0;	
	}
	public static int daysBetween(DateTime startDate , DateTime endDate){
		if(startDate != null && endDate != null){
			return Days.daysBetween(startDate, endDate).getDays();
		}
		return 0;		
	}
	
	public static int daysBetween(MizeDateTime startDate , MizeDateTime endDate){
		if(startDate != null && endDate != null){
			return Days.daysBetween(startDate.getDateTime(), endDate.getDateTime()).getDays();
		}
		return 0;		
	}
	
	public static int daysBetween(MizeDate startDate , MizeDate endDate){
		if(startDate != null && endDate != null){
			return Days.daysBetween(startDate.getDateTime(), endDate.getDateTime()).getDays();
		}
		return 0;		
	}
	
	public static int hoursBetween(DateTime startDate , DateTime endDate){
		if(startDate != null && endDate != null){
			return Hours.hoursBetween(startDate, endDate).getHours();
		}
		return 0;		
	}
	
	public static int minutesBetween(DateTime startDate , DateTime endDate){
		if(startDate != null && endDate != null){
			return Minutes.minutesBetween(startDate, endDate).getMinutes();
		}
		return 0;		
	}
	
	public static int secondsBetween(DateTime startDate , DateTime endDate){
		if(startDate != null && endDate != null){
			return Seconds.secondsBetween(startDate, endDate).getSeconds();
		}
		return 0;		
	}
	
	public static String toString(Integer intVal){
		if(intVal == null){
			return EMPTY;
		}else {
			return EMPTY+intValue(intVal);
		}
	}
	public static String toString(Long longVal){
		if(longVal == null){
			return EMPTY;
		}else {
			return EMPTY+longValue(longVal);
		}
	}
	
	public static String toString(Double doubleVal){
		if(doubleVal == null){
			return EMPTY;
		}else {
			return EMPTY+doubleValue(doubleVal);
		}
	}
	
	public static String toString(BigDecimal bigDecimal){
		if(bigDecimal == null){
			return EMPTY;
		}else {
			return EMPTY+bigDecimal.doubleValue();
		}
	}
	
	public static String getTime(DateTime dateTime){
		String time = EMPTY;
		if(dateTime != null){			
			String hours = dateTime.getHourOfDay() < 10 ? "0"+dateTime.getHourOfDay() : ""+dateTime.getHourOfDay() ;
			String minutes = dateTime.getMinuteOfHour() < 10 ? "0"+dateTime.getMinuteOfHour() : ""+dateTime.getMinuteOfHour() ;
			String seconds = dateTime.getSecondOfMinute() < 10 ? "0"+dateTime.getSecondOfMinute() : ""+dateTime.getSecondOfMinute() ;		
			time = hours+":"+minutes+":"+seconds+ (dateTime.getHourOfDay() > 12 ? " PM" : " AM");
		}
		return time;
	}
	
	public static String getDisplayDate(DateTime dateTime){
		String time = EMPTY;
		if(dateTime != null){	
			time = getDateTime(dateTime)+(dateTime.getHourOfDay() > 12 ? " PM" : " AM");
		}
		return time;
	}
	
	
	public static int calculatePageSize(String pagesize) {
		int pageSize = Formatter.intValue(pagesize) == 0 ? 10: Formatter.intValue(pagesize);
		return pageSize;
	}
	
	public static int calculatePageSize(Integer pagesize) {
		int pageSize = Formatter.intValue(pagesize) == 0 ? 10: Formatter.intValue(pagesize);
		return pageSize;
	}
	
	public static int calculatePageNumber(String pageIndex) {
		int pageNumber = Formatter.intValue(pageIndex) == 0 ?  1 : Formatter.intValue(pageIndex)  ;
		return pageNumber;
	}
	
	public static int calculatePageNumber(Integer pageIndex) {
		int pageNumber = Formatter.intValue(pageIndex) == 0 ?  1 : Formatter.intValue(pageIndex);
		return pageNumber;
	}
	
	public static int calculateAvailablePages(int totalavailabeRows, int pageSize) {
		int avialablePage = totalavailabeRows/pageSize;
		if (totalavailabeRows > pageSize * avialablePage) {
			 avialablePage++;
		}
	   return avialablePage;
	}	
	
	public static String getNewLineString(String input1,Object input2){
		StringBuilder builder = new StringBuilder();
		builder.append(makeNotNullString(input1)+": ");
		if(input2 != null){
			if(input2 instanceof String){
				builder.append(makeNotNullString((String)input2));
			}
			if(input2 instanceof Long){
				builder.append(longValue((Long)input2));
			}
			if(input2 instanceof Integer){
				builder.append(intValue((Integer)input2));
			}
		}
		builder.append(NEW_LINE);
		return builder.toString();
	}	
	
	public static int compareDates(DateTime startTime,DateTime endTime){
		if(startTime != null && endTime != null){
			return startTime.compareTo(endTime);
		}
		return 0;
	}
	
	public static int compareDates(MizeDateTime startTime,MizeDateTime endTime){
		if(startTime != null && startTime.getDateTime() != null && endTime != null && endTime.getDateTime() != null){
			return startTime.compareTo(endTime);
		}
		return 0;
	}
	
	public static int compareDates(MizeDate startTime,MizeDate endTime){
		if(startTime != null && startTime.getDateTime() != null && endTime != null && endTime.getDateTime() != null){
			return startTime.compareTo(endTime);
		}
		return 0;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void populatePagination(PaginationPage page, int pageNo){
		if(pageNo <= 0){
			pageNo = 1;
		}
		if(page.getPageItems() == null){
			page.setPageItems(new ArrayList());
		}
		int pageSize = PaginationPage.DEFAULT_PAGE_SIZE;
		int pageCount = page.getPageItems().size() / pageSize;
		if (page.getPageItems().size() > pageSize * pageCount) {
			pageCount++;
		}
		int startIndex = (pageNo-1) *pageSize;
		int endIndex = (pageNo) *pageSize;
		if(endIndex > page.getPageItems().size()){
			endIndex = page.getPageItems().size();
		}
		List subpages = new ArrayList();
		try{
			subpages = page.getPageItems().subList(startIndex, endIndex);
		}catch(Exception e){			
		}
		page.setPageNumber(pageNo);
		page.setPagesAvailable(pageCount);
		page.setRowsAvailable(page.getPageItems().size());
		page.setPageItems(subpages);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void populatePagination(PaginationPage page, int pageNo,int totalPages){
		int pageSize = PaginationPage.DEFAULT_PAGE_SIZE;
		if(pageNo <= 0){
			pageNo = 1;
		}
		if(page.getPageItems() == null){
			page.setPageItems(new ArrayList());
		}
		int pageCount = page.getPageItems().size() / pageSize;
		if (page.getPageItems().size() > pageSize * pageCount) {
			pageCount++;
		}		
		page.setPageNumber(pageNo);
		page.setPagesAvailable(pageCount);
		page.setRowsAvailable(totalPages);
	}
	
	public static String replaceSplCharForHtml(String str) {
		StringBuilder filtered = new StringBuilder(str.length());
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);	        
			if (current >= 0x20 && current <= 0x7e) {
				filtered.append(current);
			}else{
				int ik = (int)current;
				String splChar = null;
				if ((splChar = SPL_CHAR_MAP.get(ik)) != null){
					filtered.append(splChar);
				}else{
					filtered.append(current);
				}
			}
		}
		return filtered.toString();
	}
	
	public static double bigDecimalValue(BigDecimal value){
		if(value == null){
			return Double.valueOf(0);
		}
		return value.doubleValue();
	}
	
	public static BigDecimal addBigDecimals(BigDecimal val1,BigDecimal val2){
		if(val1 == null){
			val1 = BigDecimal.ZERO;
		}
		if(val2 == null){
			val2 = BigDecimal.ZERO;
		}
		return val1.add(val2);		
	}
	
	public static BigDecimal addBigDecimals1(BigDecimal val1,BigDecimal val2){		
		return roundBigDecimal(addBigDecimals(val1,val2));		
	}
	
	public static BigDecimal subtractBigDecimals(BigDecimal val1,BigDecimal val2){
		if(val1 == null){
			val1 = BigDecimal.ZERO;
		}
		if(val2 == null){
			val2 = BigDecimal.ZERO;
		}
		return val1.subtract(val2);		
	}
	
	public static BigDecimal subtractBigDecimals1(BigDecimal val1,BigDecimal val2){		
		return roundBigDecimal(subtractBigDecimals(val1,val2));		
	}
	
	public static BigDecimal multiplyBigDecimals(BigDecimal val1,BigDecimal val2){
		if(val1 == null){
			val1 = BigDecimal.ZERO;
		}
		if(val2 == null){
			val2 = BigDecimal.ZERO;
		}
		return val1.multiply(val2);		
	}
	
	public static BigDecimal multiplyBigDecimals1(BigDecimal val1,BigDecimal val2){		
		return roundBigDecimal(multiplyBigDecimals(val1,val2));		
	}
	
	public static BigDecimal multiplyBigDecimals(BigDecimal val1,BigDecimal val2,BigDecimal val3){
		if(val1 == null){
			val1 = BigDecimal.ZERO;
		}
		if(val2 == null){
			val2 = BigDecimal.ZERO;
		}
		if(val3 == null){
			val3 = BigDecimal.ZERO;
		}
		return val1.multiply(val2).multiply(val3);		
	}
	
	public static BigDecimal addBigDecimals(BigDecimal val1,BigDecimal val2,BigDecimal val3){
		if(val1 == null){
			val1 = BigDecimal.ZERO;
		}
		if(val2 == null){
			val2 = BigDecimal.ZERO;
		}
		if(val3 == null){
			val3 = BigDecimal.ZERO;
		}
		return val1.add(val2).add(val3);		
	}
	
	public static BigDecimal addBigDecimals1(BigDecimal val1,BigDecimal val2,BigDecimal val3){		
		return addBigDecimals1(addBigDecimals1(val1,val2),val3);		
	}	

	public static BigDecimal formattBigDecimal(BigDecimal value){
		if(value == null){
			return null;
		}
		return BigDecimal.valueOf(value.doubleValue());
	}
	
	public static boolean inBetween(DateTime startTime,DateTime endTime , DateTime inputTime){
		if(startTime == null && endTime == null && inputTime == null){
			return true;
		}
		if(startTime == null || endTime == null || inputTime == null){
			return false;
		}
		return (inputTime.compareTo(startTime) >= 0 && inputTime.compareTo(endTime) <= 0);
	}
	
	public static boolean inBetween(MizeDateTime startTime,MizeDateTime endTime , MizeDateTime inputTime){
		if(startTime == null && endTime == null && inputTime == null){
			return true;
		}
		return inBetween(startTime.getDateTime(), endTime.getDateTime(), inputTime.getDateTime());
	}

	public static boolean inBetween(MizeDate startDate,MizeDate endDate , MizeDate inputDate){
		if(startDate == null && endDate == null && inputDate == null){
			return true;
		}
		if(startDate == null || endDate == null || inputDate == null){
			return false;
		}
		return (inputDate.compareTo(startDate) >= 0 && inputDate.compareTo(endDate) <= 0);
	}
	
	public static double formattedBigDecimal(BigDecimal value) {
		if(value == null){
			value = BigDecimal.ZERO;
		}
		double returnValue = Math.round(value.doubleValue() * 100) / 100.0;
		return returnValue;
	}
	
	public static BigDecimal roundBigDecimal(BigDecimal value) {
		if(value == null){
			value = BigDecimal.ZERO;
		}
		double returnValue = Math.round(value.doubleValue() * 100) / 100.0;
		return BigDecimal.valueOf(returnValue);
	}
	
	public static BigDecimal notNullBigDecimal(BigDecimal value) {
		if(value == null){
			value = BigDecimal.ZERO;
		}
		return value;
	}
		
	public static String formattedBigDecimal2(BigDecimal value) {
		if(value == null){
			value = BigDecimal.ZERO;
		}
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMinimumFractionDigits(2);
		decimalFormat.setMaximumFractionDigits(2);
		String returnValue = decimalFormat.format(value.doubleValue());
		return returnValue;
	}
		 
	 public static XMLGregorianCalendar toXMLGregorianCalendar(DateTime dateTime){
		 XMLGregorianCalendar gregorianCalendar = null;
		 if(dateTime == null){
			 return null;
		 }else {
			 try {
				 gregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime.toGregorianCalendar());
			 } catch (Exception e) {
			 }
		 }
		 return gregorianCalendar;
	 }
	 	 
	 public static String htmlEncode(String input) {
		 if (isNull(input)) {
			 return EMPTY;
		 }
		 String tmpStr = globalReplace(input, "&", "&amp;");
		 tmpStr = globalReplace(tmpStr, ">", "&gt;");
		 tmpStr = globalReplace(tmpStr, "<", "&lt;");
		 tmpStr = globalReplace(tmpStr, "\"", "&quot;");
		 return tmpStr;
	 }
	 
	 public static String globalReplace(String input, String find, String replace) {
		 int start;
		 start = input.indexOf(find);
		 if (start == -1)
			 return input;

		 StringBuffer result = new StringBuffer("");
		 result.append(input.substring(0, start)).append(replace).append(globalReplace(input.substring(start + find.length()), find, replace));
		 return result.toString();
	 }
	 
	 public static MizeDateTime toMizeDateTime(MizeDate dateTime){
		 if(dateTime != null){
			 return new MizeDateTime(dateTime.getDateTime());
		 }
		 return null;
	 }
	 
	 public static MizeDate toMizeDate(MizeDateTime dateTime){
		 if(dateTime != null){
			 return new MizeDate(dateTime.getDateTime());
		 }
		 return null;
	 }
	 
	 public static MizeDate convertMizeDateTimeToMizeDate(MizeDateTime mizeDateTime){
		 MizeDate mizeDate = mizeDateTime != null ? new MizeDate(new DateTime(mizeDateTime.getMillis())) :null;
		 DateTime dateTime = mizeDate != null ? mizeDate.getDateTime() :null; 
		 dateTime = dateTime!= null ? dateTime.withTime(0, 0, 0, 0):null;
		 return dateTime!= null? new MizeDate(dateTime) :null;
	 }
	 
	 public static MizeDate toMizeDate(DateTime dateTime){
		 if(dateTime != null){
			 return new MizeDate(dateTime);
		 }
		 return null;
	 }
	 
	 public static DateTime toDateTime(MizeDateTime mizeDateTime){
		 if(mizeDateTime !=null){
			 return mizeDateTime.getDateTime();
		 }
		 return null;
	 }
	 
	 public static DateTime toDateTime(MizeDate mizeDate){
		 if(mizeDate !=null){
			 return mizeDate.getDateTime();
		 }
		 return null;
	 }
	 
	 public static void main(String[] args) {
		 System.out.println();
	 }
	 
	 public static final String generateRandomPassword() {
			final String ALPHA_NUMERIC = "12345690abcdefghijklmnopqrstuvwxyz";
			int passwordLength = 10;
			StringBuilder sb = new StringBuilder();
			for (int i=0; i < passwordLength; i++) {
				double d = Math.random();
				double d1 = d * ALPHA_NUMERIC.length();
				System.out.println(d);
				System.out.println(d1);
				System.out.println((int)d1);
				sb.append(ALPHA_NUMERIC.charAt((int) (Math.random() * ALPHA_NUMERIC.length())));
			}
			return sb.toString();
		}
	
}
