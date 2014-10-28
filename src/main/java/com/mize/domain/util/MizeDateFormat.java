package com.mize.domain.util;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name = "mize_date_format")
public class MizeDateFormat extends MizeSceEntity implements Comparable<MizeDateFormat>{

	private static final long serialVersionUID = 848292818865493379L;
	private String dateFormat;
	private String dateTimeFormat;
	private String isDefault;
	private BusinessEntity tenant;
	private Locale locale;
	@Transient
	private User user;
	
	public MizeDateFormat(){
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "date_format", nullable = true)
	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	@Column(name = "date_time_format", nullable = true)
	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}

	@Column(name = "is_default", length = 1, nullable = true)
	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int compareTo(MizeDateFormat arg0) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((dateFormat == null) ? 0 : dateFormat.hashCode());
		result = prime * result + ((dateTimeFormat == null) ? 0 : dateTimeFormat.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
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
		MizeDateFormat other = (MizeDateFormat) obj;
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
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		return true;
	} 
	
	
	
	
}
