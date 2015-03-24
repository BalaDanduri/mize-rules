package com.mize.domain.common;

import java.text.DecimalFormat;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.TypeDef;

import com.mize.domain.jpa.BigIntegerJPA;

@TypeDef(name = "bigInteger", defaultForType = BigInteger.class, typeClass = BigIntegerJPA.class)
@MappedSuperclass
public class BigInteger implements java.io.Serializable,Comparable<BigInteger>{
	private static final long serialVersionUID = 4496100137434567327L;
	private java.math.BigInteger baseValue;
	private String numberValue;
	private boolean isValid;
	private String decimalFormat;
	
	public BigInteger(){
		super();
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
	
	public java.math.BigInteger getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(java.math.BigInteger baseValue) {
		this.baseValue = baseValue;
	}
/*
	public static BigInteger getInstance(String decimalValue, String decimalFormat){
		return new BigInteger(decimalValue, decimalFormat);
	}*/
	
	public static BigInteger getInstance(java.math.BigInteger baseValue){
		if(baseValue != null){
			return new BigInteger(baseValue);
		}
		return null;
	}
	
	/*public static BigInteger getInstance(String decimalValue, String decimalFormat, DecimalFormat df){
		return new BigInteger(decimalValue, decimalFormat, df);
	}
	*/
	public BigInteger(java.math.BigInteger baseValue){
		this.baseValue = baseValue;
		if(baseValue != null){
			this.numberValue = baseValue.toString();
			this.isValid = true;
		}
	}
	/*
	public BigInteger(String numberValue, String decimalFormat){
		this.numberValue = numberValue;
		this.decimalFormat = decimalFormat;
		try{
			DecimalFormat df = new DecimalFormat(decimalFormat);
			String convertedValue = df.format(df.parse(decimalValue)); // user entered value to user format value
			this.decimalValue = convertedValue;
			Number num = df.parse(convertedValue); // getting Number from formatted value
			baseValue = new java.math.BigDecimal(num.toString());
			this.isValid = true;
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	/*
	public BigInteger(String decimalValue, String decimalFormat, DecimalFormat df){
		this.decimalValue = decimalValue;
		this.decimalFormat = decimalFormat;
		try{
			String convertedValue = df.format(df.parse(decimalValue)); // user entered value to user format value
			this.decimalValue = convertedValue;
			Number num = df.parse(convertedValue); // getting Number from formatted value
			baseValue = new java.math.BigDecimal(num.toString());
			this.isValid = true;
		}catch(Exception e){
		}
	}*/
	
	public String toString(DecimalFormat df) {
		return this.numberValue;
	}
	
	@Override
	public int compareTo(BigInteger val) {
		return baseValue.compareTo(val.baseValue);
	}
	
	public boolean equals(Object object){
		BigInteger other = (BigInteger)object;
		if(this.isValid && other.isValid){
			return this.baseValue.equals(other.getBaseValue());
		}else{
			return true;
		}
	}
	
	@Override
	public String toString() {
		return "BigDecimal [baseValue=" + baseValue + ", numberValue="
				+ numberValue + ", isValid=" + isValid + ", decimalFormat="
				+ decimalFormat + "]";
	}
	
}
