package com.mize.domain.common;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.util.JPASerializer;

@MappedSuperclass
public abstract class MizeSceEntityIntl extends MizeSceEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3812303023607270371L;
	
	protected Locale locale;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="locale_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
}