package com.mize.domain.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class CatalogCache implements Serializable{
	
	private static final long serialVersionUID = -8488237770262609141L;	
	private String catalogName;
	private Long catalogId;	
	private String isActive;
	private List<CatalogEntryCache> catalogEntryCaches = new ArrayList<CatalogEntryCache>();
	private Long tenantId;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime updatedDate;	
	
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
	
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	@Override
	public String toString() {
		return "CatalogCache [catalogName=" + catalogName + ", catalogId="
				+ catalogId + ", isActive=" + isActive
				+ ", catalogEntryCaches=" + catalogEntryCaches
				+ ", tenantId=" + tenantId
				+ "]";
	}
}
	

