package com.mize.domain.common;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.TypeDef;

import com.mize.domain.jpa.BigDecimalJPA;

@XmlType(name="appBigDecimal")
@TypeDef(name = "bigDecimal", defaultForType = BigDecimal.class, typeClass = BigDecimalJPA.class)
@MappedSuperclass
public class BigDecimal implements Serializable, Comparable<BigDecimal>, Cloneable{
	private static final long serialVersionUID = 4496100137434567327L;
	private java.math.BigDecimal baseValue;
	private String decimalValue;
	private boolean isValid;
	private String decimalFormat;
	public static BigDecimal ZERO = ZERO();
	public static BigDecimal ONE = ONE();
	
	public BigDecimal(){
		super();
	}
	
	private static BigDecimal ONE() {
		return getInstance(java.math.BigDecimal.ZERO);
	}

	private static BigDecimal ZERO() {
		return getInstance(java.math.BigDecimal.ONE);
	}

	public String getDecimalValue() {
		return decimalValue;
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	public boolean isInValid() {
		return !isValid();
	}

	public String getDecimalFormat() {
		return decimalFormat;
	}
	
	public java.math.BigDecimal getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(java.math.BigDecimal baseValue) {
		this.baseValue = baseValue;
	}

	public static BigDecimal getInstance(String decimalValue, String decimalFormat){
		return new BigDecimal(decimalValue, decimalFormat);
	}
	
	public static BigDecimal getInstance(java.math.BigDecimal baseValue, String decimalFormat){
		if(baseValue != null){
			return new BigDecimal(baseValue);
		}
		return null;
	}
	
	public static BigDecimal getInstance(java.math.BigDecimal baseValue){
		return getInstance(baseValue, null);
	}
	
	public static BigDecimal getInstance(String decimalValue, String decimalFormat, DecimalFormat df){
		return new BigDecimal(decimalValue, decimalFormat, df);
	}
	
	public BigDecimal(java.math.BigDecimal baseValue){
		this(baseValue, null);
	}
	
	public BigDecimal(java.math.BigDecimal baseValue, String decimalFormat){
		this.baseValue = baseValue;
		if(baseValue != null){
			this.decimalValue = baseValue.toPlainString();
			this.decimalFormat = decimalFormat;
			this.isValid = true;
		}
	}
	
	public BigDecimal(String decimalValue, String decimalFormat){
		this.decimalValue = decimalValue;
		this.decimalFormat = decimalFormat;
		try{
			DecimalFormat df = new DecimalFormat(decimalFormat);
			String convertedValue = df.format(df.parse(decimalValue)); // user entered value to user format value
			this.decimalValue = convertedValue;
			java.lang.Number num = df.parse(convertedValue); // getting Number from formatted value
			baseValue = new java.math.BigDecimal(num.toString());
			this.isValid = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public BigDecimal(String decimalValue, String decimalFormat, DecimalFormat df){
		this.decimalValue = decimalValue;
		this.decimalFormat = decimalFormat;
		try{
			String convertedValue = df.format(df.parse(decimalValue)); // user entered value to user format value
			this.decimalValue = convertedValue;
			java.lang.Number num = df.parse(convertedValue); // getting Number from formatted value
			baseValue = new java.math.BigDecimal(num.toString());
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	public String print(DecimalFormat df) {
		try{
			return df.format(this.baseValue);
		}catch(Exception e){
		}
		return null;
	}
	
	public String print(String dateTimeFormat) {
		try{
			DecimalFormat df = new DecimalFormat(decimalFormat);
			return df.format(this.baseValue);
		}catch(Exception e){
		}
		return null;
	}
	
	@Override
	public int compareTo(BigDecimal val) {
		if(this.baseValue == null && val.baseValue == null){
			return 0;
		}
		if(this.baseValue != null){
			return this.baseValue.compareTo(val.baseValue);
		}
		return 0;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof BigDecimal){
			BigDecimal other = (BigDecimal)obj;
			if(this.baseValue == null && other.getBaseValue() == null){
				return true;
			}
			if(this.baseValue != null){
				return this.baseValue.equals(other.getBaseValue());
			}
		}
		return false;
	}
	
	public BigDecimal add(BigDecimal bigDecimal){
		java.math.BigDecimal bvalue = null;
		if(this.isValid()){
			if(this.baseValue == null){
				bvalue = java.math.BigDecimal.ZERO;
			}else{
				bvalue = this.baseValue;
			}
			if(bigDecimal != null && bigDecimal.getBaseValue() != null){
				bvalue = bvalue.add(bigDecimal.getBaseValue());
			}
		}
		return createNewBigDecimal(bvalue);
	}
	
	public BigDecimal subtract(BigDecimal bigDecimal){
		java.math.BigDecimal bvalue = null;
		if(this.isValid()){
			if(this.baseValue == null){
				bvalue = java.math.BigDecimal.ZERO;
			}else{
				bvalue = this.baseValue;
			}
			if(bigDecimal != null && bigDecimal.getBaseValue() != null){
				bvalue = bvalue.subtract(bigDecimal.getBaseValue());
			}
		}
		return createNewBigDecimal(bvalue);
	}

	public BigDecimal multiply(BigDecimal bigDecimal){
		java.math.BigDecimal bvalue = null;
		if(this.isValid()){
			if(this.baseValue == null){
				bvalue = java.math.BigDecimal.ZERO;
			}else{
				bvalue = this.baseValue;
			}
			if(bigDecimal != null && bigDecimal.getBaseValue() != null){
				bvalue = bvalue.multiply(bigDecimal.getBaseValue());
			}
		}
		return createNewBigDecimal(bvalue);
	}
	
	public BigDecimal createNewBigDecimal(java.math.BigDecimal baseValue){
		BigDecimal bigDecimal = null;
		if(baseValue != null){
			bigDecimal = new BigDecimal(baseValue);
			bigDecimal.isValid = this.isValid;
			bigDecimal.decimalFormat = this.decimalFormat;
			bigDecimal.decimalValue = baseValue.toPlainString();
		}
		return bigDecimal;
	}
	
	@Override
	public String toString() {
		return "BigDecimal [baseValue=" + baseValue + ", decimalValue="
				+ decimalValue + ", isValid=" + isValid + ", decimalFormat="
				+ decimalFormat + "]";
	}
	
	@Override
	public Object clone(){
		return createNewBigDecimal(this.baseValue);
	}
	
	@Override
	public int hashCode() {
		return (baseValue == null) ? 0 : baseValue.hashCode();
	}
	
}
