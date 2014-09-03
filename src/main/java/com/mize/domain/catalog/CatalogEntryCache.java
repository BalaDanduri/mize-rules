package com.mize.domain.catalog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeEntity;

public class CatalogEntryCache extends MizeEntity implements Comparable<CatalogEntryCache>{
	
	private static final long serialVersionUID = -8488237770262609141L;	
	private String entryCode;
	private String entryName;
	private Long entryId;
	private String isDefault;
	private String isActive;
	private Long orderSequence;
	private Map<Long,CatalogEntryIntlCache> intlMap = new ConcurrentHashMap<Long, CatalogEntryIntlCache>();
	public CatalogEntryCache(){
		super();
	}
	
	public CatalogEntryCache(String entryCode,String entryName){
		super();
		this.entryCode = entryCode;
		this.entryName = entryName;
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
	
	@JsonIgnore
	public Map<Long, CatalogEntryIntlCache> getIntlMap() {
		return intlMap;
	}

	public void setIntlMap(Map<Long, CatalogEntryIntlCache> intlMap) {
		this.intlMap = intlMap;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}
	
	@Override
	public String toString() {
		return "CatalogEntryCache [entryCode=" + entryCode + ", entryName="
				+ entryName + ", entryId=" + entryId + ", isDefault="
				+ isDefault + ", isActive=" + isActive + ", orderSequence="
				+ orderSequence + ", intlMap=" + intlMap + "]";
	}

	@Override
	public int compareTo(CatalogEntryCache o) {
		return 0;
	}
	
}
	

