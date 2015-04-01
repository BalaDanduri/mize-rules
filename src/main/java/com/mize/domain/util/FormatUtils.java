package com.mize.domain.util;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mize.domain.auth.User;
import com.mize.domain.common.BigDecimal;
import com.mize.domain.common.Number;

@Component
public class FormatUtils {
	public static final String EMPTY = "";
	public static final String YES = "Y";
	public static final String NO = "N";
	private static MizeApplicationProperties mizeApplicationProperties;	
	
	@Autowired
	public void setMizeApplicationProperties(MizeApplicationProperties mizeApplicationProperties) {
		FormatUtils.mizeApplicationProperties = mizeApplicationProperties;
	}
	
	private static BigDecimal bigDecimal(){
		return BigDecimal.getInstance(java.math.BigDecimal.ZERO, mizeApplicationProperties.getDefaultDecimalFormat());
	}
	
	public static BigDecimal getBigDecimal(java.math.BigDecimal bigDecimal){
		return BigDecimal.getInstance(bigDecimal, mizeApplicationProperties.getDefaultDecimalFormat());
	}
	
	public static BigDecimal addBigDecimals(BigDecimal ...values){
		if(values == null || values.length == 0){
			return null;
		}
		BigDecimal bigDecimal = null;
		for(BigDecimal val : values){
			if(val != null && val.getBaseValue() != null){
				if(bigDecimal == null){
					bigDecimal = val;
				}else{
					bigDecimal=bigDecimal.add(val);
				}
			}
		}
		return bigDecimal;		
	}
	
	public static BigDecimal subtractBigDecimals(BigDecimal ...values){
		if(values == null || values.length == 0){
			return null;
		}
		BigDecimal bigDecimal = null;
		for(BigDecimal val : values){
			if(val != null && val.getBaseValue() != null){
				if(bigDecimal == null){
					bigDecimal = val;
				}else{
					bigDecimal = bigDecimal.subtract(val);
				}
			}
		}
		return bigDecimal;	
	}
	
	public static BigDecimal multiplyBigDecimals(BigDecimal ...values){
		if(values == null || values.length == 0){
			return bigDecimal();
		}
		BigDecimal bigDecimal = null;
		for(BigDecimal val : values){
			if(val != null && val.getBaseValue() != null){
				if(bigDecimal == null){
					bigDecimal = val;
				}else{
					bigDecimal = bigDecimal.multiply(val);
				}
			}
		}
		return bigDecimal;	
	}
		
	public static double formattedBigDecimal(BigDecimal value) {
		if(value == null || value.getBaseValue() == null){
			value = bigDecimal();		
		}
		double returnValue = Math.round(value.getBaseValue().doubleValue() * 100) / 100.0;
		return returnValue;
	}
	
	public static BigDecimal roundBigDecimal(BigDecimal value) {
		if(value == null || value.getBaseValue() == null){
			return bigDecimal();
		}
		double returnValue = Math.round(value.getBaseValue().doubleValue() * 100) / 100.0;
		return value.createNewBigDecimal(java.math.BigDecimal.valueOf(returnValue));
	}
	
	public static BigDecimal safeBigDecimal(BigDecimal value) {
		if(value == null || value.getBaseValue() == null){
			value = bigDecimal();
		}
		return value;
	}
	
	public static String formattedBigDecimal2(BigDecimal value) {
		if(value == null || value.getBaseValue() == null){
			value = bigDecimal();
		}
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMinimumFractionDigits(2);
		decimalFormat.setMaximumFractionDigits(2);
		String returnValue = decimalFormat.format(value.getBaseValue().doubleValue());
		return returnValue;
	}
	
	public static String toString(Integer intVal){
		if(intVal == null){
			return EMPTY;
		}else {
			return EMPTY+intVal.intValue();
		}
	}
	
	public static String toString(Number value){
		if(value == null || value.getBaseValue() == null){
			return EMPTY;
		}else {
			return String.valueOf(value.getBaseValue().longValue());
		}
	}
	
	public static String toString(BigDecimal value){
		if(value == null || value.getBaseValue() == null){
			return EMPTY;
		}else {
			return String.valueOf(value.getBaseValue().longValue());
		}
	}
	
	public static String doubleString(BigDecimal value){
		if(value == null || value.getBaseValue() == null){
			return EMPTY;
		}else {
			return String.valueOf(value.getBaseValue().doubleValue());
		}
	}
	
	public static boolean isNull(BigDecimal number){
		double value = 0;
		if(number != null && number.getBaseValue() != null){
			value = number.getBaseValue().doubleValue();
		}		
		return value <= 0;
	}
	
	public static boolean isNotNull(Number number){
		return !isNull(number);
	}
	
	public static boolean isNull(Number number){
		long value = 0;
		if(number != null && number.getBaseValue() != null){
			value = number.getBaseValue().longValue();
		}		
		return value <= 0;
	}
	
	public static boolean isNotNull(BigDecimal number){
		return !isNull(number);
	}
	
	public static double doubleValue(BigDecimal decimal){
		double value = 0.0;
		if(decimal != null && decimal.getBaseValue() != null){
			value = decimal.getBaseValue().doubleValue();
		}		
		return value;
	}
	
	public static BigDecimal toBigDecimal(String value) {
		BigDecimal returnValue = null;
		if (value != null && value.trim().length() > 0) {
			try {
				returnValue = BigDecimal.getInstance(new java.math.BigDecimal(value));
			} catch(Exception e) {
			}
		}
		return returnValue;
	}
	
	public static BigDecimal toBigDecimal(Double value) {
		BigDecimal returnValue = null;
		if (value != null) {
			try {
				returnValue = BigDecimal.getInstance(new java.math.BigDecimal(value));
			} catch(Exception e) {
			}
		}
		return returnValue;
	}
	
	public static BigDecimal toBigDecimal(java.math.BigDecimal value) {
		BigDecimal returnValue = null;
		if (value != null) {
			try {
				returnValue = BigDecimal.getInstance(value);
			} catch(Exception e) {
			}
		}
		return returnValue;
	}
	
	public static Number toBigInteger(Long value) {
		return Number.getInstance(value);
	}
	
	public static int intValue(BigDecimal value) {
		if(value != null && value.getBaseValue() != null){
			return value.getBaseValue().intValue();
		}
		return 0;
	}
	
	public static long longValue(BigDecimal value) {
		if(value != null && value.getBaseValue() != null){
			return value.getBaseValue().longValue();
		}
		return 0;
	}
	
	public static Number toNumber(Long value) {
		return Number.getInstance(value);
	}
	
	public static long longValue(Number value) {
		long val = 0;
		if (value != null && value.getBaseValue() != null) {
			val = value.getBaseValue().longValue();
		}
		return val;
	}
	
	public static int intValue(Number value) {
		int val = 0;
		if (value != null && value.getBaseValue() != null) {
			val = value.getBaseValue().intValue();
		}
		return val;
	}
	
	public static String formattedBigDecimal(BigDecimal bigDecimal, User user) {
		return formattedBigDecimal(bigDecimal, user, true);
	}
	
	public static String formattedBigDecimal(BigDecimal bigDecimal, User user, boolean fallback) {
		if(bigDecimal == null){
			return EMPTY;
		}else{
			String decimalFormat = getUserDecimalFormat(user, fallback);
			return bigDecimal.print(getDecimalFormatter(decimalFormat));
		}
	}
	
	public static DecimalFormat getDecimalFormatter(String decimalFormat) {
		return new DecimalFormat(decimalFormat);
	}
	
	private static String getUserDecimalFormat(User user, boolean fallback) {
		String decimalFormat = null;
		if(user != null && user.getUserProfile() != null && user.getUserProfile().getUserPreference() != null && user.getUserProfile().getUserPreference().getDateTimeFormat() != null){
			decimalFormat = user.getUserProfile().getUserPreference().getDecimalFormat();
		}
		if(Formatter.isNull(decimalFormat) && fallback){
			decimalFormat = getDecimalFormat();
		}
		return decimalFormat;
	}
	
	public static String getDecimalFormat(){
		return mizeApplicationProperties.getDefaultDecimalFormat();
	}
}
