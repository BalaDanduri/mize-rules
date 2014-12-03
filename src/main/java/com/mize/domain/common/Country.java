package com.mize.domain.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "country")
public class Country extends MizeSceEntity implements Comparable<Country>{

	private static final long serialVersionUID = 3412102873370612905L;
	
	private String code;
	private String name;
	private String code3;
	private List<State> states = new ArrayList<State>();
	private List<State> stateList;
	
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
	
	public Country(String code, String code3) {
		super();
		this.code = code;
		this.code3 = code3;
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
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((code3 == null) ? 0 : code3.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((states == null) ? 0 : states.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (states == null) {
			if (other.states != null)
				return false;
		} else {
			if (other.states == null || !(states.size() == other.states.size() && states.containsAll(other.states))){
				return false;
			}
		}
			
		return true;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", code3=" + code3+ "]";
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

	@OneToMany(fetch= FetchType.LAZY , mappedBy ="country")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonBackReference(value="country_states")
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
	
}
