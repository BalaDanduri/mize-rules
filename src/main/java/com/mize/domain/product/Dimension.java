package com.mize.domain.product;

import com.mize.domain.common.BaseEntity;

public class Dimension extends BaseEntity{

	public enum Name{
		Height,Length,Weight,Width;		
	}
	private String units;
	private double value;
	public Dimension(){
		
	}
	public Dimension(String units,double value){
		this.units = units;
		this.value = value;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	

}
