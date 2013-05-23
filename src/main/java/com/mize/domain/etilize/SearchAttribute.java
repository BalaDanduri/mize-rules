package com.mize.domain.etilize;

import com.mize.domain.common.Entity;

public class SearchAttribute extends Entity{

	private static final long serialVersionUID = -6127521446685342752L;
	private Long prodId;
	private Long attributeId;
	private String absoluteValue;
	private Integer isAbsolute;
	private Long valueId;
	private Long localeId;
	
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public Long getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
	public String getAbsoluteValue() {
		return absoluteValue;
	}
	public void setAbsoluteValue(String absoluteValue) {
		this.absoluteValue = absoluteValue;
	}
	
	public Integer getIsAbsolute() {
		return isAbsolute;
	}
	public void setIsAbsolute(Integer isAbsolute) {
		this.isAbsolute = isAbsolute;
	}
	public Long getValueId() {
		return valueId;
	}
	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}
	
	
}
