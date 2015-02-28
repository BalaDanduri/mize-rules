package com.mize.domain.common;

import java.text.DecimalFormat;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.TypeDef;

import com.mize.domain.jpa.BigDecimalJPA;

@TypeDef(name = "bigDecimal", defaultForType = BigDecimal.class, typeClass = BigDecimalJPA.class)
@MappedSuperclass
public class BigDecimal implements Comparable<BigDecimal>{
	
	private java.math.BigDecimal baseValue;
	private String decimalValue;
	private boolean isValid;
	private String decimalFormat;
	
	public BigDecimal(){
		super();
	}
	
	public String getDecimalValue() {
		return decimalValue;
	}
	
	public boolean isValid() {
		return isValid;
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
	
	public static BigDecimal getInstance(java.math.BigDecimal baseValue){
		if(baseValue != null){
			return new BigDecimal(baseValue);
		}
		return null;
	}
	
	public static BigDecimal getInstance(String decimalValue, String decimalFormat, DecimalFormat df){
		return new BigDecimal(decimalValue, decimalFormat, df);
	}
	
	public BigDecimal(java.math.BigDecimal baseValue){
		this.baseValue = baseValue;
		if(baseValue != null){
			this.decimalValue = baseValue.toPlainString();
			this.isValid = true;
		}
	}
	
	public BigDecimal(String decimalValue, String decimalFormat){
		this.decimalValue = decimalValue;
		this.decimalFormat = decimalFormat;
		try{
			DecimalFormat df = new DecimalFormat(decimalFormat);
			baseValue = new java.math.BigDecimal(df.format(df.parse(decimalValue)));
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	public BigDecimal(String decimalValue, String decimalFormat, DecimalFormat df){
		this.decimalValue = decimalValue;
		this.decimalFormat = decimalFormat;
		try{
			baseValue = new java.math.BigDecimal(df.format(df.parse(decimalValue)));
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
	public String toString(DecimalFormat df) {
		return this.decimalValue;
	}
	
	@Override
	public int compareTo(BigDecimal val) {
		return baseValue.compareTo(val.baseValue);
	}
	
	public boolean equals(Object object){
		BigDecimal other = (BigDecimal)object;
		if(this.isValid && other.isValid){
			return this.baseValue.equals(other.getBaseValue());
		}else{
			return true;
		}
	}
	
	@Override
	public String toString() {
		return "BigDecimal [baseValue=" + baseValue + ", decimalValue="
				+ decimalValue + ", isValid=" + isValid + ", decimalFormat="
				+ decimalFormat + "]";
	}
	
}
