package com.mize.domain.etilize;

import com.mize.domain.common.Entity;


public class ProductAttribute extends Entity{

	private static final long serialVersionUID = 6493104044294016583L;
   
    private Long attributeId;
    private String displayValue;
    private Long categoryId;
    private Double absoluteValue;
    private Long unitId;
    private Integer isAbsolute;
    private Integer isActive;
    private Long localeId;
    private Long sourceId;
    private Double value;
    private Long catAttributeId;
    private Long prodId;
    
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
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
		
	public String getDisplayValue() {
		return displayValue;
	}
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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
	public Integer getIsAbsolute() {
		return isAbsolute;
	}
	public void setIsAbsolute(Integer isAbsolute) {
		this.isAbsolute = isAbsolute;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
}
