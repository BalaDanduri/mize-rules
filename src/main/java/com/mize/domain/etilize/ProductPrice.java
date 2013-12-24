package com.mize.domain.etilize;

import com.mize.domain.common.MizeEntity;

public class ProductPrice extends MizeEntity{

	private static final long serialVersionUID = 6738887069118581L;
	private Double netPrice;
	private Double listPrice;
	private String currencyCode;
	private Long unitId;
	private Long prodId;
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public Double getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(Double netPrice) {
		this.netPrice = netPrice;
	}
	public Double getListPrice() {
		return listPrice;
	}
	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Long getUnitId() {
		return unitId;
	}
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}	

	@Override
	public String toString() {
		return "ProductPrice [netPrice=" + netPrice + ", listPrice="
				+ listPrice + ", currencyCode=" + currencyCode + ", unitId="
				+ unitId + "]";
	}
}
