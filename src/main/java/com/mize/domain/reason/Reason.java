package com.mize.domain.reason;

import java.io.Serializable;
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
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="reason")
public class Reason extends MizeSceEntityAudit implements Serializable {
	
	
	private static final long serialVersionUID = -6610072481614002539L;
	private String code;
	private String category;
	private String type;
	private String isActive;
	private BusinessEntity tenant;
	private List<ReasonIntl> intls;
	
	@Transient
	private User user;
	
	@Transient
	private boolean isDuplicate;
	
	public Reason(Long id,String code, String category,String type,String isActive) {
		super();
		this.id = id;
		this.code = makeNotNullString(code);
		this.category=category;
		this.type = type;
		this.isActive = isActive;
	}
	
	public Reason(String code) {
		this.code = code;		
	}
	
	
	public Reason() {
		super();
		intls = new ArrayList<ReasonIntl>();
	}
	
	@Transient
	@JsonIgnore
	public boolean isDuplicate() {
		return isDuplicate;
	}

	public void setDuplicate(boolean isDuplicate) {
		this.isDuplicate = isDuplicate;
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
	
	@Column(name = "reason_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = makeNotNullString(code);
	}

	@Column(name = "reason_category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = makeNotNullString(category);
	}

	
	@Column(name = "reason_type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "reason", orphanRemoval = true)
	@JsonManagedReference(value="intl")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ReasonIntl> getIntls() {
		return intls;
	}

	public void setIntls(List<ReasonIntl> intls) {
		this.intls = intls;
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
	
	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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
		return "Reason [code=" + code + ", reasonType=" + type
				 + ", isActive =" + isActive + "]";
	}

	@Transient
	@JsonIgnore
	public static String makeNotNullString(String str){
		return str == null ? null:str.trim();
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((type == null) ? 0 : type.hashCode());
		
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
		Reason other = (Reason) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
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

	public int compareTo(Reason o) {
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
