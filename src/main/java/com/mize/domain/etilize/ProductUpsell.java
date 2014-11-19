package com.mize.domain.etilize;

import com.mize.domain.common.MizeSceEntity;


public class ProductUpsell extends MizeSceEntity{

	private static final long serialVersionUID = 6738887069779058581L;
	private Long prodId;
	private Long upSellProductId;
	private Long localeId;
	
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}	
	
	public Long getUpSellProductId() {
		return upSellProductId;
	}
	public void setUpSellProductId(Long upSellProductId) {
		this.upSellProductId = upSellProductId;
	}
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
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
