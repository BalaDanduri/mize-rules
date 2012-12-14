package com.mize.domain.product;

import com.mize.domain.common.BaseEntity;

public class ProductFeature  extends BaseEntity{
	private String feature;

	
	public ProductFeature(String feature) {
		super();
		this.feature = feature;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}
	
	
}
