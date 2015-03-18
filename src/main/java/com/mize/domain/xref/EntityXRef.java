package com.mize.domain.xref;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.TenantSerializer;

@Entity
@Table(name = "entity_xref")
public class EntityXRef extends MizeSceEntityAudit implements Comparable<EntityXRef> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3470667256971918688L;
	private BusinessEntity tenant;
	private String code;
	private String type;
	private String isActive;
	private String criteria;
	private String result;
	@Transient
	private List<EntityXRefCriteria> criteriaList = new ArrayList<EntityXRefCriteria>();
	@Transient
	private List<EntityXRefResult> resultList = new ArrayList<EntityXRefResult>();

	private User user;
	@Transient
	private Locale locale;

	public EntityXRef() {
		super();
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id")	
	@JsonInclude(Include.NON_DEFAULT)
	@JsonSerialize(using=TenantSerializer.class)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column(name = "xref_code", length = 100, nullable = true)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "xref_type", length = 50, nullable = true)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "is_active", length = 1, nullable = true)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Column(name = "xref_criteria", nullable = true)
	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	@Column(name = "xref_result", nullable = true)
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Transient
	public List<EntityXRefCriteria> getCriteriaList() {
		return criteriaList;
	}

	public void setCriteriaList(List<EntityXRefCriteria> criteriaList) {
		this.criteriaList = criteriaList;
	}

	@Transient
	public List<EntityXRefResult> getResultList() {
		return resultList;
	}

	public void setResultList(List<EntityXRefResult> resultList) {
		this.resultList = resultList;
	}

	@Transient
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "EntityXRef [code=" + code + ", type=" + type + ", isActive=" + isActive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
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
		EntityXRef other = (EntityXRef) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		return true;
	}

	@Override
	public int compareTo(EntityXRef entityXRef) {
		if (this == entityXRef)
			return EQUAL;
		else if (this.id < entityXRef.id)
			return BEFORE;
		else if (entityXRef.id == this.id)
			return EQUAL;
		else if (this.id > entityXRef.id)
			return AFTER;
		return EQUAL;
	}
}
