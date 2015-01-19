package com.mize.domain.util;

import java.io.Serializable;

import com.mize.domain.common.Locale;

public class MizeDateFormatCache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1351223877892439005L;
	
	private Long id;
	private String dateFormat;
	private String dateTimeFormat;
	private String userTimeZone;
	private String isActive;
	private Locale locale;
	private Long tenantId;
	private MizeDateTime updatedDate;

	public MizeDateFormatCache() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserTimeZone() {
		return userTimeZone;
	}

	public void setUserTimeZone(String userTimeZone) {
		this.userTimeZone = userTimeZone;
	}

	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateFormat == null) ? 0 : dateFormat.hashCode());
		result = prime * result + ((dateTimeFormat == null) ? 0 : dateTimeFormat.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + ((userTimeZone == null) ? 0 : userTimeZone.hashCode());
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
		MizeDateFormatCache other = (MizeDateFormatCache) obj;
		if (dateFormat == null) {
			if (other.dateFormat != null)
				return false;
		} else if (!dateFormat.equals(other.dateFormat))
			return false;
		if (dateTimeFormat == null) {
			if (other.dateTimeFormat != null)
				return false;
		} else if (!dateTimeFormat.equals(other.dateTimeFormat))
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
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
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
		if (userTimeZone == null) {
			if (other.userTimeZone != null)
				return false;
		} else if (!userTimeZone.equals(other.userTimeZone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MizeDateFormatCache [id=" + id + ", dateFormat=" + dateFormat + ", dateTimeFormat=" + dateTimeFormat 
				+ ", userTimeZone=" + userTimeZone + ", isActive=" + isActive + ", locale=" + locale + ", tenantId=" + tenantId 
				+ ", updatedDate=" + updatedDate + "]";
	}

	
}
