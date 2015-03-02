package com.mize.domain.applicationformat;

import java.io.Serializable;

public class ApplicationFormatCache implements Serializable, Comparable<ApplicationFormatCache> {
	
	private static final long serialVersionUID = 848292818865493379L;
	private String formatType;
    private Long tenantId;
	private Long localeId;
	private String formatValue;
	private String isActive;
	private String formatTypeName;
	private Long id;
	private String isRegEXp;

	public ApplicationFormatCache() {
	}
	
	public ApplicationFormatCache(Long id,String formatType, Long localeId,String formatValue, String isActive) {
		super();
		this.id = id;
		this.formatType = formatType;
		this.localeId = localeId;
		this.formatValue = formatValue;
		this.isActive = isActive;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public String getFormatValue() {
		return formatValue;
	}

	public void setFormatValue(String formatValue) {
		this.formatValue = formatValue;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public Long getLocaleId() {
		return localeId;
	}

	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}

	public String getFormatTypeName() {
		return formatTypeName;
	}

	public void setFormatTypeName(String formatTypeName) {
		this.formatTypeName = formatTypeName;
	}

	public String getIsRegEXp() {
		return isRegEXp;
	}

	public void setIsRegEXp(String isRegEXp) {
		this.isRegEXp = isRegEXp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((formatType == null) ? 0 : formatType.hashCode());
		result = prime * result
				+ ((formatTypeName == null) ? 0 : formatTypeName.hashCode());
		result = prime * result
				+ ((formatValue == null) ? 0 : formatValue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result
				+ ((isRegEXp == null) ? 0 : isRegEXp.hashCode());
		result = prime * result
				+ ((localeId == null) ? 0 : localeId.hashCode());
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
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
		ApplicationFormatCache other = (ApplicationFormatCache) obj;
		if (formatType == null) {
			if (other.formatType != null)
				return false;
		} else if (!formatType.equals(other.formatType))
			return false;
		if (formatTypeName == null) {
			if (other.formatTypeName != null)
				return false;
		} else if (!formatTypeName.equals(other.formatTypeName))
			return false;
		if (formatValue == null) {
			if (other.formatValue != null)
				return false;
		} else if (!formatValue.equals(other.formatValue))
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
		if (isRegEXp == null) {
			if (other.isRegEXp != null)
				return false;
		} else if (!isRegEXp.equals(other.isRegEXp))
			return false;
		if (localeId == null) {
			if (other.localeId != null)
				return false;
		} else if (!localeId.equals(other.localeId))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApplicationFormatCache [formatType=" + formatType
				+ ", tenantId=" + tenantId + ", localeId=" + localeId
				+ ", formatValue=" + formatValue + ", isActive=" + isActive
				+ ", formatTypeName=" + formatTypeName + ", id=" + id
				+ ", isRegEXp=" + isRegEXp + "]";
	}

	@Override
	public int compareTo(ApplicationFormatCache applicationFormat) {
		if ( this == applicationFormat ) 
			return 0;
		else if (this.id < applicationFormat.id) 
			return -1;
		else if (applicationFormat.id == this.id) 
			return 0;
		else if (this.id > applicationFormat.id)
			return 1;
		return 0;
	}

}
