package com.mize.domain.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class CatalogEntity extends MizeEntity implements Serializable{
	
	private static final long serialVersionUID = -8481137770262609141L;	

	private String catalogName;
	private Long catalogId;	
	private String isActive;
	private List<CatalogEntryCache> catalogEntryCaches = new ArrayList<CatalogEntryCache>();
	private List<Catalog> catalogNames = new ArrayList<Catalog>();	
	private BusinessEntity tenant;
	private User user;
	private String languageCode;
	private String countryCode;
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	
	public Long getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(Long catalogId) {
		this.catalogId = catalogId;
	}
	
	@JsonIgnore
	public boolean isActive() {
		return "Y".equalsIgnoreCase(isActive);
	}
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public List<CatalogEntryCache> getCatalogEntryCaches() {
		return catalogEntryCaches;
	}
	public void setCatalogEntryCaches(List<CatalogEntryCache> catalogEntryCaches) {
		this.catalogEntryCaches = catalogEntryCaches;
	}
	
	public List<Catalog> getCatalogNames() {
		return catalogNames;
	}
	public void setCatalogNames(List<Catalog> catalogNames) {
		this.catalogNames = catalogNames;
	}
	public BusinessEntity getTenant() {
		return tenant;
	}
	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Override	
	@JsonIgnore(false)
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
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
	
}
	

