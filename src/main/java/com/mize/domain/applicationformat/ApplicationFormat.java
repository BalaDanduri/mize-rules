package com.mize.domain.applicationformat;

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

import com.mize.domain.auth.User;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityAudit;

@Entity
@Table(name = "application_formats")
public class ApplicationFormat extends MizeSceEntityAudit implements Comparable<ApplicationFormat> {
	
	private static final long serialVersionUID = 848292818865493379L;
	private String formatType;
    private Long tenantId;
	private Locale locale;
	private String formatValue;
	private String isActive;
	private String tenantCode;
	private String formatTypeName;
	private String regExp;

	@Transient
	public User user;

	public ApplicationFormat() {
	}
	
	public ApplicationFormat(Long id,String formatType, Locale locale,String formatValue, String isActive) {
		super();
		this.id = id;
		this.formatType = formatType;
		this.locale = locale;
		this.formatValue = formatValue;
		this.isActive = isActive;
	}
	
	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
    @Transient
	public String getTenantCode() {
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
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
	
	@Column(name = "tenant_id")
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	@Column(name = "format_type")
	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	@Column(name = "format_value")
	public String getFormatValue() {
		return formatValue;
	}

	public void setFormatValue(String formatValue) {
		this.formatValue = formatValue;
	}

	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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
	public String getFormatTypeName() {
		return formatTypeName;
	}

	public void setFormatTypeName(String formatTypeName) {
		this.formatTypeName = formatTypeName;
	}
	

	@Column(name = "reg_exp")
	public String getRegExp() {
		return regExp;
	}

	public void setRegExp(String regExp) {
		this.regExp = regExp;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
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
		ApplicationFormat other = (ApplicationFormat) obj;
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
	public int compareTo(ApplicationFormat applicationFormat) {
		if ( this == applicationFormat ) 
			return EQUAL;
		else if (this.id < applicationFormat.id) 
			return BEFORE;
		else if (applicationFormat.id == this.id) 
			return EQUAL;
		else if (this.id > applicationFormat.id)
			return AFTER;
		return EQUAL;
	}

	@Override
	public String toString() {
		return "ApplicationFormat [formatType=" + formatType + ", tenantId="
				+ tenantId + ", locale=" + locale + ", formatValue="
				+ formatValue + ", isActive=" + isActive + ", tenantCode="
				+ tenantCode + ", formatTypeName=" + formatTypeName
				+ ", regExp=" + regExp + "]";
	}

}
