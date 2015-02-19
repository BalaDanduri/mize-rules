package com.mize.domain.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityAudit;

@Entity
@Table(name = "mize_date_format")
public class MizeDateFormat extends MizeSceEntityAudit implements Comparable<MizeDateFormat>{

	private static final long serialVersionUID = 848292818865493379L;
	private String dateFormat;
	private String dateTimeFormat;
	private String isActive;
	private BusinessEntity tenant;
	private Locale locale;
	@Transient
	private User user;
	@Transient
	private Long tenantId;
	@Transient
	private String userTimeZone;
	private String lastAccessedTime;
	
	public MizeDateFormat(){		
	}
	
	public MizeDateFormat(String dateFormat, String dateTimeFormat,String isDefault,String isActive, Locale locale) {
		super();
		this.dateFormat = dateFormat;
		this.dateTimeFormat = dateTimeFormat;
		this.isActive = isActive;
		this.locale = locale;
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
	
	@Column(name = "date_format")
	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	@Column(name = "date_time_format")
	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@OneToOne(fetch = FetchType.LAZY)
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

	@Transient
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	

	@Transient
	public String getUserTimeZone() {
		return userTimeZone;
	}

	public void setUserTimeZone(String userTimeZone) {
		this.userTimeZone = userTimeZone;
	}

	public String getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(String lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
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
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
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
		return true;
	}

	@Override
	public int compareTo(MizeDateFormat arg0) {
		return 0;
	}

	@Override
	public String toString() {
		return "MizeDateFormat [dateFormat=" + dateFormat + ", dateTimeFormat=" + dateTimeFormat + ", isActive=" + isActive 
				+ ", locale=" + locale + ", tenantId=" + tenantId + ", userTimeZone=" + userTimeZone + "]";
	}

	
}
