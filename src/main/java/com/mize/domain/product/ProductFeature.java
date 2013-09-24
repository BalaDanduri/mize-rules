package com.mize.domain.product;

import java.util.List;

import com.mize.domain.common.MizeEntity;

public class ProductFeature extends MizeEntity implements Comparable<ProductFeature>{
	
	private static final long serialVersionUID = -97276364683192909L;
	private String feature;
	private String name;
	private String absoluteValue;
	private String groupName;
	private List<ProductFeature> attributes;

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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<ProductFeature> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ProductFeature> attributes) {
		this.attributes = attributes;
	}

	@Override
	public int compareTo(ProductFeature arg0) {
		return 0;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}		
	
}
