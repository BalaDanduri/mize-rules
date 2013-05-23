package com.mize.domain.etilize;

import com.mize.domain.common.Entity;


public class ProductSource extends Entity{

	private static final long serialVersionUID = -1752623485342722L;
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
