package com.mize.domain.common;

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

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.TenantSerializer;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include="all")
@Table(name = "country")
public class Country extends MizeSceEntityAudit implements Comparable<Country>{

	private static final long serialVersionUID = 3412102873370612905L;
	
	private User user;
	private String code;
	private String name;
	private String code3;
	private String isActive;
	
	private BusinessEntity tenant;
	
	private List<State> states = new ArrayList<State>();
	@Deprecated
	private List<State> stateList;
	
	private List<CountryIntl> intls = new ArrayList<CountryIntl>();
	
	public Country(){
		super();
	}
	
	public Country(Long id){
		super();
		this.id = id;
	}
	
	public Country(Long id,String code, String name, String code3) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.code3 = code3;
	}
	@Deprecated
	public Country(Long id,String code, String code3, String yOrN, String name) {
		super();
		this.id = id;
		this.code = code;
		this.code3 = code3;
		this.isActive = yOrN;
		this.name = name;
	}

	public Country(String code, String code3) {
		super();
		this.code = code;
		this.code3 = code3;
	}
	
	
	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "country_id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="country_code",nullable=false)
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Column(name="country_name",nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Transient
	public List<State> getStateList() {
		return stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}	
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "country" ,orphanRemoval= true)
	@Fetch(FetchMode.SELECT)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JsonManagedReference(value="countryIntl")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@BatchSize(size = 500)
	public List<CountryIntl> getIntls() {
		return intls;
	}

	public void setIntls(List<CountryIntl> countryIntlList) {
		this.intls = countryIntlList;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((code3 == null) ? 0 : code3.hashCode());
		result = prime * result + ((intls == null) ? 0 : intls.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((states == null) ? 0 : states.hashCode());
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
		Country other = (Country) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (code3 == null) {
			if (other.code3 != null)
				return false;
		} else if (!code3.equals(other.code3))
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
		if (states == null) {
			if (other.states != null)
				return false;
		} else {
			if (other.states == null || !(states.size() == other.states.size() && states.containsAll(other.states))){
				return false;
			}
		}
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", code3=" + code3 + ", isActive="
				+ isActive +"]";
	}

	public int compareTo(Country country) {
		if ( this == country ) 
			return EQUAL;
		else if (this.id < country.id) 
			return BEFORE;
		else if (country.id == this.id) 
			return EQUAL;
		else if (this.id > country.id)
			return AFTER;
		return EQUAL;		
	}

	@OneToMany(cascade={CascadeType.ALL}, fetch= FetchType.EAGER , mappedBy ="country" ,orphanRemoval= true)
	@Fetch(FetchMode.SELECT)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="country")
	@JsonBackReference(value="country_states")
	@BatchSize(size = 500)
	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Column(name="country_code_3")
	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonSerialize(using=TenantSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JoinColumn(name = "tenant_id")
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}		
	
}
