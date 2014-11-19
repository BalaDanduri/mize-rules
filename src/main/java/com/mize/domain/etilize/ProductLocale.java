package com.mize.domain.etilize;

import com.mize.domain.common.MizeSceEntity;


public class ProductLocale extends MizeSceEntity{

	private static final long serialVersionUID = 67388870695558581L;
	private Long prodId;
	private Long localeId;
	private Integer isActive;
	private String status;
	
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
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
