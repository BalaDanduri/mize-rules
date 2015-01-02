package com.mize.domain.user;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntity;

public class UserPreference extends MizeSceEntity implements  Comparable<UserPreference>{
	private static final long serialVersionUID = -1662758492625928365L;
	private String dateFormat;
	private String dateTimeFormat;
	private Locale locale;
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
	public int compareTo(UserPreference o) {
		return 0;
	}
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id  = id;
	}
}
