package com.mize.domain.applicationlabel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;

public class ApplicationLabelEntity extends MizeSceEntity implements Serializable {

	private static final long serialVersionUID = -3154049662206787600L;

	private String code;
	private String isActive;
	private String isDefault;
	private String name;
	private String languageCode;
    private String countryCode;
	private List<ApplicationLabel> applicationLabels;
	private BusinessEntity tenant;
	private User user;
	private String lastAccessedTime;

	public ApplicationLabelEntity() {
		super();
		applicationLabels = new ArrayList<ApplicationLabel>();
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
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

	public List<ApplicationLabel> getApplicationLabels() {
		return applicationLabels;
	}

	public void setApplicationLabels(List<ApplicationLabel> applicationLabels) {
		this.applicationLabels = applicationLabels;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result + ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((lastAccessedTime == null) ? 0 : lastAccessedTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ApplicationLabelEntity other = (ApplicationLabelEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
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
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApplicationLabelEntity [id=" + id + ", code=" + code + ", isActive=" + isActive + ", isDefault=" + isDefault + ", name=" + name 
				+ ", languageCode=" + languageCode + ", countryCode=" + countryCode + ", lastAccessedTime=" + lastAccessedTime + "]";
	}
	
}
