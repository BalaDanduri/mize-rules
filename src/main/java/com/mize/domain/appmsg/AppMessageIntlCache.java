package com.mize.domain.appmsg;

import java.io.Serializable;

public class AppMessageIntlCache implements Comparable<AppMessageIntlCache> , Serializable {

	private static final long serialVersionUID = 16153638967617947L;
	private Long id;
	private String shortDesc;
	private String longDesc;
	private Long localeId;
	boolean isDefault;
	
	public AppMessageIntlCache() {
		super();
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public Long getLocaleId() {
		return localeId;
	}

	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public int compareTo(AppMessageIntlCache o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isDefault ? 1231 : 1237);
		result = prime * result + ((localeId == null) ? 0 : localeId.hashCode());
		result = prime * result + ((longDesc == null) ? 0 : longDesc.hashCode());
		result = prime * result + ((shortDesc == null) ? 0 : shortDesc.hashCode());
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
		AppMessageIntlCache other = (AppMessageIntlCache) obj;
		if (isDefault != other.isDefault)
			return false;
		if (localeId == null) {
			if (other.localeId != null)
				return false;
		} else if (!localeId.equals(other.localeId))
			return false;
		if (longDesc == null) {
			if (other.longDesc != null)
				return false;
		} else if (!longDesc.equals(other.longDesc))
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppMessageIntlCache [shortDesc=" + shortDesc + ", longDesc=" + longDesc + ", localeId=" + localeId + ", isDefault=" + isDefault + "]";
	}
	
}
