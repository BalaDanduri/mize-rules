package com.mize.domain.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
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
	
	private Formatter(){
		
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
	
	public static double intValue(Double dValue){
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

	public static String likeString(String value){		
		return LIKE+toUpperCase(value)+LIKE;
	}
	public static String removeHtml(String value){
		if(getLength(value) >0){
			try{
				value=value.replaceAll(HTML_COMMENTS_PATTERN, EMPTY);
				Matcher m = HTML_TAGS_PATTERN.matcher(value);
				value = m.replaceAll(EMPTY);
			}catch(Exception e){
			}
		}	
		return value;
	}
	public String getDateAsMonthDay(DateTime dateTime) {
		String date = null;
		if(dateTime != null){
			date = dateTime.toString(Formatter.DATE_FORMAT);
			String arr[] = date.split("\\-");
			int count = 0;
			date = "";
			for(String str : arr){
				if(count++==0){
					date=date+str;
				}else{
					date=date+DATE_SEPARATE+str;
					break;
				}
			} 
		}
		return date;
	}	
	public static long getLongValue(Long value){
		long val = 0;
		if(value != null){
			val = value.longValue();
		}
		return val;
	}
}
