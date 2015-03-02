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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((formatType == null) ? 0 : formatType.hashCode());
		result = prime * result
				+ ((formatValue == null) ? 0 : formatValue.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
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
		ApplicationFormatCache other = (ApplicationFormatCache) obj;
		if (formatType == null) {
			if (other.formatType != null)
				return false;
		} else if (!formatType.equals(other.formatType))
			return false;
		if (formatValue == null) {
			if (other.formatValue != null)
				return false;
		} else if (!formatValue.equals(other.formatValue))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		return true;
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
