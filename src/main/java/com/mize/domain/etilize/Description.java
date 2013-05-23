package com.mize.domain.etilize;

import com.mize.domain.common.Entity;

public class Description extends Entity{

	private static final long serialVersionUID = -6127526446685342752L;
	private Long texId;
	private Long tId;
	private Long localeId;
	private String value;
	public Long getTexId() {
		return texId;
	}
	public void setTexId(Long texId) {
		this.texId = texId;
	}
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
