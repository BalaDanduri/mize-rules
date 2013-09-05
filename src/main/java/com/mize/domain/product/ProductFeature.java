package com.mize.domain.product;

import com.mize.domain.common.Entity;

public class ProductFeature extends Entity{
	
	private static final long serialVersionUID = -97276364683192909L;
	private String feature;
	private String name;
	private String absoluteValue;

	public ProductFeature(String feature) {
		super();
		this.feature = feature;
	}

	public ProductFeature() {
		super();
	}

	public ProductFeature(String feature, String name) {
		this.feature = feature;
		this.name = name;
	}

	public ProductFeature(String feature, String name, String absoluteValue) {
		this.feature = feature;
		this.name = name;
		this.absoluteValue = absoluteValue;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getAbsoluteValue() {
		return absoluteValue;
	}

	public void setAbsoluteValue(String absoluteValue) {
		this.absoluteValue = absoluteValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
