package com.mize.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Authorization extends MizeEntity{
 
	private static final long serialVersionUID = 4053341559871679892L;
	
	private String code;
	private String name;
	
	@Override
	@JsonIgnore
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
