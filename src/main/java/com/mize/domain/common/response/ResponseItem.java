package com.mize.domain.common.response;

import java.util.List;

public class ResponseItem<T> {
	private String name;
	private List<T> items;
	public ResponseItem() {
		
	}
	
	public ResponseItem(String name, List<T> items) {
		this.name = name;
		this.items = items;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	} 
}
