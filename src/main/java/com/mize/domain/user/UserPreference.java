package com.mize.domain.user;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntity;

public class UserPreference extends MizeSceEntity implements  Comparable<UserPreference>{
	private static final long serialVersionUID = -1662758492625928365L;
	private String dateFormat;
	private String dateTimeFormat;
	private Locale locale;
	private String decimalFormat;
	
	public UserPreference(){
		super();
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
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id  = id;
	}
	
	public String getDecimalFormat() {
		return decimalFormat;
	}

	public void setDecimalFormat(String decimalFormat) {
		this.decimalFormat = decimalFormat;
	}

	@Override
	public int compareTo(UserPreference o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((dateFormat == null) ? 0 : dateFormat.hashCode());
		result = prime * result
				+ ((dateTimeFormat == null) ? 0 : dateTimeFormat.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
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
		UserPreference other = (UserPreference) obj;
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
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserPreference [dateFormat=" + dateFormat + ", dateTimeFormat="
				+ dateTimeFormat + ", locale=" + locale + ", decimalFormat="
				+ decimalFormat + "]";
	}

}
