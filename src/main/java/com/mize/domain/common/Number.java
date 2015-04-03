package com.mize.domain.common;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.TypeDef;

import com.mize.domain.jpa.NumberJPA;

@XmlType(name="appNumber")
@TypeDef(name = "number", defaultForType = Number.class, typeClass = NumberJPA.class)
@MappedSuperclass
public class Number implements Serializable, Comparable<Number>, Cloneable{
	private static final long serialVersionUID = 449610013741237327L;
	private Long baseValue;
	private String numberValue;
	private boolean isValid;
	public static Number ONE = ONE();
	public static Number ZERO = ZERO();
	
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
		if(baseValue != null){
			return new Number(baseValue.trim());
		}
		return null;
	}
	
	public static Number getInstance(Integer baseValue){
		if(baseValue != null){
			return new Number(baseValue);
		}
		return null;
	}
	
	private Number(String strValue){
		try{
			this.numberValue = strValue;
			Long val = Long.parseLong(strValue);
			this.baseValue = val;
			this.isValid = true;
		}catch(Exception e){
		}
	}
	
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
	
	public String toString(DecimalFormat df) {
		return this.numberValue;
	}
	
	public String print() {
		return this.baseValue.toString();
	}
	
	private static Number ZERO(){
		return getInstance(0);
	}
	
	private static Number ONE(){
		return getInstance(1);
	}
	
	@Override
	public int compareTo(Number val) {
		if(this.baseValue == null && val.baseValue == null){
			return 0;
		}
		if(this.baseValue != null){
			return this.baseValue.compareTo(val.baseValue);
		}
		return 0;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Number){
			Number other = (Number)obj;
			if(this.baseValue == null && other.getBaseValue() == null){
				return true;
			}
			if(this.baseValue != null){
				return this.baseValue.equals(other.getBaseValue());
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "BigDecimal [baseValue=" + baseValue + ", numberValue="
				+ numberValue + ", isValid=" + isValid +"]";
	}
	
	@Override
	public Object clone(){
		return getInstance(this.baseValue);
	}
	
	@Override
	public int hashCode() {
		return (baseValue == null) ? 0 : baseValue.hashCode();
	}
			
}
