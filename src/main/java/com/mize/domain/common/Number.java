package com.mize.domain.common;

import java.text.DecimalFormat;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.TypeDef;

import com.mize.domain.jpa.NumberJPA;

@XmlType(name="appNumber")
@TypeDef(name = "number", defaultForType = Number.class, typeClass = NumberJPA.class)
@MappedSuperclass
public class Number implements java.io.Serializable,Comparable<Number>{
	private static final long serialVersionUID = 449610013741237327L;
	private Long baseValue;
	private String numberValue;
	private boolean isValid;
	
	public Number(){
		super();
	}
		
	public boolean isValid() {
		return isValid;
	}
	
	public boolean isInValid() {
		return !isValid();
	}
	
	public Long getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(Long baseValue) {
		this.baseValue = baseValue;
	}
	
	public String getNumberValue() {
		return numberValue;
	}

	public void setNumberValue(String numberValue) {
		this.numberValue = numberValue;
	}

	public static Number getInstance(Long baseValue){
		if(baseValue != null){
			return new Number(baseValue);
		}
		return null;
	}
	
	public static Number getInstance(String baseValue){
		Long val = null;
		try{
			val = Long.parseLong(baseValue);
		}catch(Exception e){
		}
		if(val != null){
			return new Number(val);
		}
		return null;
	}
	
	public static Number getInstance(Integer baseValue){
		if(baseValue != null){
			return new Number(baseValue);
		}
		return null;
	}
	
	/*public static BigInteger getInstance(String decimalValue, String decimalFormat, DecimalFormat df){
		return new BigInteger(decimalValue, decimalFormat, df);
	}
	*/
	private Number(Long baseValue){
		this.baseValue = baseValue;
		if(baseValue != null){
			this.numberValue = baseValue.toString();
			this.isValid = true;
		}
	}
	
	private Number(Integer baseValue){
		if(baseValue != null){
			this.baseValue = baseValue.longValue();
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
	
	public String print() {
		return this.baseValue.toString();
	}
	
	@Override
	public int compareTo(Number val) {
		return baseValue.compareTo(val.baseValue);
	}
	
	public boolean equals(Object object){
		Number other = (Number)object;
		if(this.isValid && other.isValid && this.baseValue != null){
			return this.baseValue.equals(other.getBaseValue());
		}else{
			return true;
		}
	}
	
	@Override
	public String toString() {
		return "BigDecimal [baseValue=" + baseValue + ", numberValue="
				+ numberValue + ", isValid=" + isValid +"]";
	}
	
}
