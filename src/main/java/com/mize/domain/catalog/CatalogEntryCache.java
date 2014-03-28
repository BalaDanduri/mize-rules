package com.mize.domain.catalog;

import java.io.Serializable;

public class CatalogEntryCache implements Serializable{
	
	private static final long serialVersionUID = -8488237770262609141L;	
	private String entryCode;
	private String entryName;
	private Long localeId;
	private Long entryId;
	private String isDefault;
	private String isActive;
	
	public CatalogEntryCache(){
		super();
	}
	
	public CatalogEntryCache(String entryCode,String entryName,Long localeId){
		super();
		this.entryCode = entryCode;
		this.entryName = entryName;
		this.localeId = localeId;
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

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public boolean isActive() {
		return "Y".equalsIgnoreCase(isActive);
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "CatalogEntryCache [entryCode=" + entryCode + ", entryName="
				+ entryName + ", localeId=" + localeId + ", entryId=" + entryId
				+ ", isDefault=" + isDefault + ", isActive=" + isActive + "]";
	}
	
}
	

