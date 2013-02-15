package com.mize.domain.prod;

public class SearchAttribute extends Entity{

	private static final long serialVersionUID = -6127521446685342752L;
	private Long prodId;
	private Long attributeId;
	private Long localeId;
	private String absoluteValue;
	private String isAbsolute;
	private Double value;
	private Long unitId;
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
	public String getIsAbsolute() {
		return isAbsolute;
	}
	public void setIsAbsolute(String isAbsolute) {
		this.isAbsolute = isAbsolute;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Long getUnitId() {
		return unitId;
	}
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	
}
