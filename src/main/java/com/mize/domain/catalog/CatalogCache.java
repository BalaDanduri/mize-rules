package com.mize.domain.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CatalogCache implements Serializable{
	
	private static final long serialVersionUID = -8488237770262609141L;	
	private String catalogName;
	private Long catalogId;	
	private String isActive;
	private List<CatalogEntryCache> catalogEntryCaches = new ArrayList<CatalogEntryCache>();
	
	public Long getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public List<CatalogEntryCache> getCatalogEntryCaches() {
		return catalogEntryCaches;
	}
	public void setCatalogEntryCaches(List<CatalogEntryCache> catalogEntryCaches) {
		this.catalogEntryCaches = catalogEntryCaches;
	}
	
	public boolean isActive() {
		return "Y".equalsIgnoreCase(isActive);
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "CatalogCache [catalogName=" + catalogName + ", catalogId="
				+ catalogId + ", isActive=" + isActive
				+ ", catalogEntryCaches=" + catalogEntryCaches + "]";
	}
	
	
}
	

