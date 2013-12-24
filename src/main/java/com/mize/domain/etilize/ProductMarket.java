package com.mize.domain.etilize;

import com.mize.domain.common.MizeEntity;

public class ProductMarket extends MizeEntity{

	private static final long serialVersionUID = -2770711381739670331L;
	
	private Long localeId;
	private String isActive;
	private String status;
	
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
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
