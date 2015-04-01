package com.mize.domain.util;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

import com.mize.domain.common.BigDecimal;
import com.mize.domain.common.BigInteger;

@Component
public class FormatUtils {
	protected static java.math.BigDecimal ZERO = java.math.BigDecimal.ZERO;
	public static final String EMPTY = "";
	public static final String YES = "Y";
	public static final String NO = "N";
	
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
					bigDecimal.add(val);
				}
			}
		}
		return bigDecimal;		
	}
	
	public static com.mize.domain.common.BigDecimal subtractBigDecimals(BigDecimal ...values){
		if(values == null || values.length == 0){
			return null;
		}
		BigDecimal bigDecimal = null;
		for(BigDecimal val : values){
			if(val != null && val.getBaseValue() != null){
				if(bigDecimal == null){
					bigDecimal = val;
				}else{
					bigDecimal.subtract(val);
				}
			}
		}
		return bigDecimal;	
	}
	
	public static com.mize.domain.common.BigDecimal multiplyBigDecimals(BigDecimal ...values){
		if(values == null || values.length == 0){
			return BigDecimal.getInstance(ZERO);
		}
		BigDecimal bigDecimal = null;
		for(BigDecimal val : values){
			if(val != null && val.getBaseValue() != null){
				if(bigDecimal == null){
					bigDecimal = val;
				}else{
					bigDecimal.multiply(val);
				}
			}
		}
		return bigDecimal;	
	}
		
	public static double formattedBigDecimal(BigDecimal value) {
		if(value == null || value.getBaseValue() == null){
			value = com.mize.domain.common.BigDecimal.getInstance(ZERO);		
		}
		double returnValue = Math.round(value.getBaseValue().doubleValue() * 100) / 100.0;
		return returnValue;
	}
	
	public static BigDecimal roundBigDecimal(BigDecimal value) {
		if(value == null || value.getBaseValue() == null){
			return BigDecimal.getInstance(ZERO);
		}
		double returnValue = Math.round(value.getBaseValue().doubleValue() * 100) / 100.0;
		return value.createNewBigDecimal(java.math.BigDecimal.valueOf(returnValue));
	}
	
	public static BigDecimal safeBigDecimal(BigDecimal value) {
		if(value == null || value.getBaseValue() == null){
			value = BigDecimal.getInstance(ZERO);
		}
		return value;
	}
	
	public static String formattedBigDecimal2(BigDecimal value) {
		if(value == null || value.getBaseValue() == null){
			value = BigDecimal.getInstance(ZERO);
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
	
	public static String toString(BigInteger value){
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
	
	public static boolean isNull(BigDecimal number){
		double value = 0;
		if(number != null && number.getBaseValue() != null){
			value = number.getBaseValue().doubleValue();
		}		
		return value <= 0;
	}
	
	public static boolean isNotNull(BigInteger number){
		return !isNull(number);
	}
	
	public static boolean isNull(BigInteger number){
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
	
	public static BigInteger toBigInteger(Long value) {
		BigInteger returnValue = null;
		if (value != null) {
			try {
				returnValue = BigInteger.getInstance(java.math.BigInteger.valueOf(value));
			} catch(Exception e) {
			}
		}
		return returnValue;
	}
	
	public static long longValue(BigInteger value) {
		long val = 0;
		if (value != null && value.getBaseValue() != null) {
			val = value.getBaseValue().longValue();
		}
		return val;
	}
	
	public static int intValue(BigInteger value) {
		int val = 0;
		if (value != null && value.getBaseValue() != null) {
			val = value.getBaseValue().intValue();
		}
		return val;
	}
}
