package com.mize.domain.prod;


public class ProductAttribute extends Entity{

	private static final long serialVersionUID = 6493104044294016583L;
   
    private Long attributeId;
    private Double displayValue;
    private Long catId;
    private Double absoluteValue;
    private Long unitId;
    private String isAbsolute;
    private String isActive;
    private Long localeId;
    private Long sourceId;
    private Double value;
    private Long catAttributeId;
    
	public Long getLocaleId() {
		return localeId;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Long getCatAttributeId() {
		return catAttributeId;
	}
	public void setCatAttributeId(Long catAttributeId) {
		this.catAttributeId = catAttributeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
	
	public Long getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}
	public Double getDisplayValue() {
		return displayValue;
	}
	public void setDisplayValue(Double displayValue) {
		this.displayValue = displayValue;
	}
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public Double getAbsoluteValue() {
		return absoluteValue;
	}
	public void setAbsoluteValue(Double absoluteValue) {
		this.absoluteValue = absoluteValue;
	}
	public Long getUnitId() {
		return unitId;
	}
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	public String getIsAbsolute() {
		return isAbsolute;
	}
	public void setIsAbsolute(String isAbsolute) {
		this.isAbsolute = isAbsolute;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}		
}
