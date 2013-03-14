package com.mize.domain.product;

import com.mize.domain.common.Entity;


public class Dimension extends Entity{
	
	private static final long serialVersionUID = 8691446210400725036L;
	public enum Name{
		Height,Length,Weight,Width;		
	}
	private String units;
	private String value;
	public Dimension(){
		
	}
	public Dimension(String units,String value){
		this.units = units;
		this.value = value;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	

}
