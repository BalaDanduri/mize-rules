package com.mize.domain.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class CatalogCache extends MizeEntity implements Serializable{
	
	private static final long serialVersionUID = -8488237770262609141L;	
	private String catalogName;
	private Long catalogId;	
	private String isActive;
	private List<CatalogEntryCache> catalogEntryCaches = new ArrayList<CatalogEntryCache>();
	
	@Transient
	private List<Catalog> catalogNames = new ArrayList<Catalog>();
	
	@Transient
	private BusinessEntity tenant;
	
	@Override
	public Long getId() {
		return catalogId;
	}
	@Override
	public void setId(Long id) {
		this.id= catalogId;
	}
	
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
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = JsonSerialize.Inclusion.NON_DEFAULT)
	@JsonIgnore(false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Transient
	public List<Catalog> getCatalogNames() {
		return catalogNames;
	}
	public void setCatalogNames(List<Catalog> catalogNames) {
		this.catalogNames = catalogNames;
	}

	@Transient
	public BusinessEntity getTenant() {
		return tenant;
	}
	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	@Override
	public String toString() {
		return "CatalogCache [catalogName=" + catalogName + ", catalogId="
				+ catalogId + ", isActive=" + isActive
				+ ", catalogEntryCaches=" + catalogEntryCaches + "]";
	}
	
}
	

