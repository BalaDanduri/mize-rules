package com.mize.domain.etilize;

import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;



public class ProductSku extends MizeSceEntity{
	private static final long serialVersionUID = -6722341511569003526L;	
	
	private Long prodId;
	private MizeDateTime discontinueDate;
	private MizeDateTime addedDate;
	private String name;
	private String sku;
	private Long localeId;
	
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
	
	public MizeDateTime getAddedDate() {
		return addedDate;
	}
	
	public void setAddedDate(MizeDateTime addedDate) {
		this.addedDate = addedDate;
	}

	
	public MizeDateTime getDiscontinueDate() {
		return discontinueDate;
	}
	
	
	public void setDiscontinueDate(MizeDateTime discontinueDate) {
		this.discontinueDate = discontinueDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
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
