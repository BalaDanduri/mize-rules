package com.mize.domain.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;

public class CatalogEntity extends MizeSceEntity implements Serializable{
	
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
	private String lastAccessedTime;

	@Override
	public Long getId() {
		return id;
	}

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

	public String getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(String lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalogEntryCaches == null) ? 0 : catalogEntryCaches.hashCode());
		result = prime * result + ((catalogId == null) ? 0 : catalogId.hashCode());
		result = prime * result + ((catalogName == null) ? 0 : catalogName.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((lastAccessedTime == null) ? 0 : lastAccessedTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatalogEntity other = (CatalogEntity) obj;
		if (catalogEntryCaches == null) {
			if (other.catalogEntryCaches != null)
				return false;
		} else if (!catalogEntryCaches.equals(other.catalogEntryCaches))
			return false;
		if (catalogId == null) {
			if (other.catalogId != null)
				return false;
		} else if (!catalogId.equals(other.catalogId))
			return false;
		if (catalogName == null) {
			if (other.catalogName != null)
				return false;
		} else if (!catalogName.equals(other.catalogName))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (languageCode == null) {
			if (other.languageCode != null)
				return false;
		} else if (!languageCode.equals(other.languageCode))
			return false;
		if (lastAccessedTime == null) {
			if (other.lastAccessedTime != null)
				return false;
		} else if (!lastAccessedTime.equals(other.lastAccessedTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CatalogEntity [id=" + id + ", catalogName=" + catalogName + ", catalogId=" + catalogId + ", isActive=" + isActive 
				+ ", catalogEntryCaches=" + catalogEntryCaches + ", languageCode=" + languageCode + ", countryCode=" + countryCode 
				+ ", lastAccessedTime=" + lastAccessedTime + "]";
	}
	
}
	

