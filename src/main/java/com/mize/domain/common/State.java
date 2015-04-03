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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.util.JPASerializer;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include="all")
@Table(name = "state")
public class State extends MizeSceEntityAudit implements Comparable<State>{
	
	private static final long serialVersionUID = -1518811417788517045L;
	private User user;
	@Deprecated
	private String name;
	private String code;
	private String isActive;
	private Country country;
	// need to remove
	@Deprecated
	private Country stateCountry;
	private List<StateIntl> intls = new ArrayList<StateIntl>();
	
	
	
	public State() {
		super();		
	}
	
	public State(Long id) {
		super();
		this.id = id;		
	}
	
	public State(Long id,String code) {
		super();
		this.id = id;
		this.code = code;	
	}
	
	public State(Long id,String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;		
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "state_id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	@Column(name="state_name",nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="state_code",nullable=false)
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="is_active",nullable=false)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "country_id")
	@JsonBackReference(value="country")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Transient
	public Country getStateCountry() {
		return stateCountry;
	}

	public void setStateCountry(Country stateCountry) {
		this.stateCountry = stateCountry;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "state" ,orphanRemoval= true)
	@Fetch(FetchMode.SELECT)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JsonManagedReference(value="stateIntl")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@BatchSize(size = 500)
	public List<StateIntl> getIntls() {
		return intls;
	}

	public void setIntls(List<StateIntl> stateIntlList) {
		this.intls = stateIntlList;
	}

	public int compareTo(State state) {
		if ( this == state ) 
			return EQUAL;
		else if (this.id < state.id) 
			return BEFORE;
		else if (state.id == this.id) 
			return EQUAL;
		else if (this.id > state.id)
			return AFTER;
		return EQUAL;		
	}

	@Override
	public String toString() {
		return "State [id" + id + ",code=" + code + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((intls == null) ? 0 : intls.hashCode());
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
		State other = (State) obj;
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
		return true;
	}


}
