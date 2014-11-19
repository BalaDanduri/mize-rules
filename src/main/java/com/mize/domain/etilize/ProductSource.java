package com.mize.domain.etilize;

import com.mize.domain.common.MizeSceEntity;


public class ProductSource extends MizeSceEntity{

	private static final long serialVersionUID = -1752623485342722L;	
	private String name;
	
	@Override
	public Long getId() {
		return id;
	}	
	@Override
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
