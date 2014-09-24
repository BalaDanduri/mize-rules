package com.mize.domain.common;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.util.Formatter;

@Entity
@Table(name = "state")
public class State extends MizeEntity implements Comparable<State>{
	
	private static final long serialVersionUID = -1518811417788517045L;
	private String name;
	private String code;
	private Country country;
	private Country stateCountry;
	
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

	@ManyToOne(fetch = FetchType.LAZY)
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

	@Override
	public String toString() {
		return "State [name=" + name + ", code=" + code + ", id=" + id + "]";
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
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;		
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (Formatter.isNull(code)) {
			if (Formatter.isNotNull(other.code))
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (Formatter.isNull(name)) {
			if (Formatter.isNotNull(other.name))
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
