package com.mize.domain.applicationlabel;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mize.domain.util.MizeDateTime;

public class ApplicationLabelCache implements Comparable<ApplicationLabelCache>, Serializable {

	private static final long serialVersionUID = -3154049662206787600L;

	private Long id;
	private String code;
	private String category;
	private String isActive;
	private String isDefault;
	private Long tenantId;
	private MizeDateTime createdDate;
	private MizeDateTime updatedDate;
	private Map<Long, ApplicationLabelIntlCache> intlMap = new ConcurrentHashMap<Long, ApplicationLabelIntlCache>();

	public ApplicationLabelCache() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Map<Long, ApplicationLabelIntlCache> getIntlMap() {
		if(intlMap == null){
			intlMap = new ConcurrentHashMap<Long, ApplicationLabelIntlCache>();
		}
		return intlMap;
	}

	public void setIntlMap(Map<Long, ApplicationLabelIntlCache> intlMap) {
		this.intlMap = intlMap;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result
				+ ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result
				+ ((updatedDate == null) ? 0 : updatedDate.hashCode());
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
		ApplicationLabelCache other = (ApplicationLabelCache) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
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
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApplicationLabelCache [id=" + id + ", code=" + code
				+ ", isActive=" + isActive + ", isDefault=" + isDefault
				+ ", tenantId=" + tenantId + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", intlMap=" + intlMap + "]";
	}

	@Override
	public int compareTo(ApplicationLabelCache arg0) {
		return 0;
	}

}
