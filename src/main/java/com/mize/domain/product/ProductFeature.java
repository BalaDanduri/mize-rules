package com.mize.domain.product;

public class ProductFeature{
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
