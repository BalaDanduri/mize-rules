package com.mize.domain.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Formatter {
	public static final String EMPTY = "";
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final DateTimeFormatter  DATE_FORMAT = DateTimeFormat.forPattern("MM-dd-yyyy HH:mm:ss");
	public static final DateTimeFormatter  DB_DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
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
	
	public static double doubleValue(Double dValue){
		double value = 0.0;
		if(dValue != null){
			value = dValue.doubleValue();
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
	
	public static boolean isNull(String str){
		return (str == null || str.trim().length()==0);
	}
	
	public static boolean isNotNull(String str){
		return (!isNull(str));
	}
	
	public static boolean isYorN(String str){
		if(str == null || !(YES.equalsIgnoreCase(str.trim()) || NO.equalsIgnoreCase(str.trim()))){
			return false;
		}
		return true;
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
	
	public static String getDBDateTime(DateTime dateTime){
		return (dateTime == null ? null : dateTime.toString(DB_DATE_TIME_FORMAT));
	}
	
	public static String getDateTime(DateTime dateTime){
		return (dateTime == null ? null : dateTime.toString(DATE_FORMAT));
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
		return returnValue   ;
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
	
	public static boolean equal(Long var1,Long var2){
		return (longValue(var1) == longValue(var2));
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
}
