package com.mize.domain.applicationlabel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="application_labels")
public class ApplicationLabel extends MizeSceEntityAudit  implements Comparable<ApplicationLabel>{
	
	private static final long serialVersionUID = 493248365353248606L;
	private BusinessEntity tenant;
	private String code;
	private String isActive;
	private String isDefault;
	private String category;
	private List<ApplicationLabelIntl> intls;
	@Transient
	private User user;
	
	public ApplicationLabel() {
		super();
		intls = new ArrayList<ApplicationLabelIntl>();
	}

	public ApplicationLabel(BusinessEntity tenant, String code, String isActive,
			String isDefault) {
		super();
		this.tenant = tenant;
		this.code = code;
		this.isActive = isActive;
		this.isDefault = isDefault;
	}

	public ApplicationLabel(String code) {
		this.code = code;	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column(name = "label_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Column(name = "is_default")
	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL}, mappedBy = "applicationLabel" ,orphanRemoval= true)
	@JsonManagedReference(value="appLabel_intl")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)	
	public List<ApplicationLabelIntl> getIntls() {
		return intls;
	}

	public void setIntls(List<ApplicationLabelIntl> intls) {
		this.intls = intls;
	}

	@Column(name = "label_category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "ApplicationLabel [code=" + code + ", isActive=" + isActive + ", isDefault=" + isDefault + ", category=" + category 
				+ ", intls=" + intls + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((intls == null) ? 0 : intls.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
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
		ApplicationLabel other = (ApplicationLabel) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (intls == null) {
			if (other.intls != null)
				return false;
		} else if (!intls.equals(other.intls))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		return true;
	}

	@Override
	public int compareTo(ApplicationLabel o) {
		if ( this == o ) 
			return EQUAL;
		else if (this.id < o.id) 
			return BEFORE;
		else if (o.id == this.id) 
			return EQUAL;
		else if (this.id > o.id)
			return AFTER;
		return EQUAL;
	}
	
}
