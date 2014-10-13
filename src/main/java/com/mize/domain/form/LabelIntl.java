package com.mize.domain.form;

import java.io.Serializable;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;

public class LabelIntl extends MizeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1332602324562292216L;
	
	private Locale locale;
	private String name;
	private String description;
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "LabelIntl [locale=" + locale + ", name=" + name
				+ ", description=" + description + "]";
	}
	
}
