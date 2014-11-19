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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name="application_labels")
public class ApplicationLabel extends MizeSceEntity  implements Comparable<ApplicationLabel>{
	
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
	@Column(name = "id", unique = true, nullable = false)
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

	@Column(name = "is_active",  nullable = true, length = 1)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Column(name = "is_default",  nullable = true, length = 1)
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

	@Column(name = "label_category", nullable = true, length = 50)
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
	
	@Column(name = "created_date", updatable = false)
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(false)
	public MizeDateTime getCreatedDate() {
		return this.createdDate;
	}

	
	@JsonIgnore(false)
	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(false)
	public MizeDateTime getUpdatedDate() {
		return this.updatedDate;
	}
	
	
	@JsonIgnore(false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	} 
	
	@Override
	@JsonIgnore
	@Column(name = "created_by", updatable = false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
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
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result
				+ ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result
				+ ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
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
		ApplicationLabel other = (ApplicationLabel) obj;
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
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
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
