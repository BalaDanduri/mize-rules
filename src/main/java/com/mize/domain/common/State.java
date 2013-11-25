package com.mize.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "state")
public class State extends MizeEntity implements Comparable<State>{
	
	private static final long serialVersionUID = -1518811417788517045L;
	private String name;
	private String code;
	private Country country;

	@Override
	@Id
	@GenericGenerator(name="stateId" , strategy="increment")
	@GeneratedValue(generator="stateId")
	@Column(name="state_id",nullable=false,unique=true)
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
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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
	
}
