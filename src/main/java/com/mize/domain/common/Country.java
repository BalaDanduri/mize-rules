package com.mize.domain.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "country")
public class Country extends MizeEntity implements Comparable<Country>{

	private static final long serialVersionUID = 3412102873370612905L;
	
	private String code;
	private String name;
	private String code3;
	private List<State> states = new ArrayList<State>();
	
	@Id
	@GenericGenerator(name="countryId" , strategy="increment")
	@GeneratedValue(generator="countryId")
	@Column(name="country_id",nullable=false)
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
		} else if (!states.equals(other.states))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", code3=" + code3
				+ ", states=" + states + "]";
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

	@Transient
	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Transient
	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}		
	
}
