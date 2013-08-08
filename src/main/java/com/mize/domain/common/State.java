package com.mize.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "state")
public class State extends MizeEntity implements Comparable<State>{
	
	private static final long serialVersionUID = -1518811417788517045L;
	private String name;
	private String code;

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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
