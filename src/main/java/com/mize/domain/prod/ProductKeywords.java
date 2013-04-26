package com.mize.domain.prod;

public class ProductKeywords extends Entity{

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
	

}
