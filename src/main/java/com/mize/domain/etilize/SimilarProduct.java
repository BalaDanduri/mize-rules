package com.mize.domain.etilize;

import com.mize.domain.common.MizeSceEntity;

public class SimilarProduct extends MizeSceEntity{
	private static final long serialVersionUID = -6725341511569003526L;
	
	private Long localeId;
	private Long prodId;
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
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
