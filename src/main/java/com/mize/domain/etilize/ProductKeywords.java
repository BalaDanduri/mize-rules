package com.mize.domain.etilize;

import com.mize.domain.common.MizeEntity;

public class ProductKeywords extends MizeEntity{

	private static final long serialVersionUID = -7658094166308695427L;
	private Long prodId;
	private Long localeId;
	private String keywords;
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
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
