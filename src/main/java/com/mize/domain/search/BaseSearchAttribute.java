package com.mize.domain.search;

public class BaseSearchAttribute {
	
	private String name;
	private String type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	protected String getFormatedValue(String value) {
		if (value == null) {
			return value;
		} else {
			return value.trim().toUpperCase();
		}
	}
	
	
}
