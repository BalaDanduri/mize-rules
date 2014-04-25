package com.mize.domain.catalog;

import com.mize.domain.common.MizeEntity;

public class CatalogEntryCache extends MizeEntity implements Comparable<CatalogEntryCache>{
	
	private static final long serialVersionUID = -8488237770262609141L;	
	private String entryCode;
	private String entryName;
	private Long localeId;
	private Long entryId;
	private String isDefault;
	private String isActive;
	private Long orderSequence;
	
	public CatalogEntryCache(){
		super();
	}
	
	public CatalogEntryCache(String entryCode,String entryName,Long localeId){
		super();
		this.entryCode = entryCode;
		this.entryName = entryName;
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
	
	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}

	public String getEntryCode() {
		return entryCode;
	}
	public void setEntryCode(String entryCode) {
		this.entryCode = entryCode;
	}
	public String getEntryName() {
		return entryName;
	}
	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}

	public boolean isDefault() {
		return "Y".equalsIgnoreCase(isDefault);
	}

	public String getIsDefault() {
		return isDefault;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public boolean isActive() {
		return "Y".equalsIgnoreCase(isActive);
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Long getOrderSequence() {
		return orderSequence;
	}

	public void setOrderSequence(Long orderSequence) {
		this.orderSequence = orderSequence;
	}

	@Override
	public String toString() {
		return "CatalogEntryCache [entryCode=" + entryCode + ", entryName="
				+ entryName + ", localeId=" + localeId + ", entryId=" + entryId
				+ ", isDefault=" + isDefault + ", isActive=" + isActive
				+ ", orderSequence=" + orderSequence + "]";
	}

	@Override
	public int compareTo(CatalogEntryCache o) {
		return 0;
	}
	
}
	

