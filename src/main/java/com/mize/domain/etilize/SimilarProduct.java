package com.mize.domain.etilize;

import com.mize.domain.common.Entity;



public class SimilarProduct extends Entity{
	private static final long serialVersionUID = -6725341511569003526L;
	
	private Long id;
	private Long localeId;
	private Long prodId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	} 
	
}
