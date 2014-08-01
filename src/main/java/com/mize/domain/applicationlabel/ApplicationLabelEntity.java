package com.mize.domain.applicationlabel;

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
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class ApplicationLabelEntity extends MizeEntity implements Serializable {

	private static final long serialVersionUID = -3154049662206787600L;
	private String code;
	private String isActive;
	private String isDefault;
	private List<ApplicationLabel> applicationLabels;
	private ApplicationLabelIntlCache intlCache;
	private BusinessEntity tenant;

	public ApplicationLabelEntity() {
		super();
		applicationLabels = new ArrayList<ApplicationLabel>();
		intlCache = new ApplicationLabelIntlCache();
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

	public ApplicationLabelIntlCache getIntlCache() {
		return intlCache;
	}

	public void setIntlCache(ApplicationLabelIntlCache intlCache) {
		this.intlCache = intlCache;
	}

	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((intlCache == null) ? 0 : intlCache.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationLabelEntity other = (ApplicationLabelEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (intlCache == null) {
			if (other.intlCache != null)
				return false;
		} else if (!intlCache.equals(other.intlCache))
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
		return true;
	}

	@Override
	public String toString() {
		return "ApplicationLabelEntity [code=" + code + ", isActive=" + isActive + ", isDefault=" + isDefault + "]";
	}
	
}
