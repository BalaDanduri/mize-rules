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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.datetime.DateTime;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include="all")
@Table(name="state_intl")
public class StateIntl extends MizeSceEntityIntl implements Comparable<StateIntl> {

	private static final long serialVersionUID = 7261081290169132228L;
	private State state;
	private String name;
	private String description;
	
	public StateIntl() {
		super();
	}

	public StateIntl(State state, Locale locale, String name, String description) {
		super();
		this.state = state;
		super.locale = locale;
		this.name = name;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}

	@JsonBackReference(value = "stateIntl")
	@ManyToOne(fetch = FetchType.EAGER ,optional = true)
	@JoinColumn(name = "state_id")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Column(name = "state_name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "state_description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "created_by" , updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@Column(name = "created_by_user",updatable=false)
	public String getCreatedByUser() {
		return super.getCreatedByUser();
	}
	
	@Override
	public void setCreatedByUser(String createdByUser) {
		super.setCreatedByUser(createdByUser);
	}
	
	@Override
	@Column(name = "updated_by_user")
	public String getUpdatedByUser() {
		return super.getUpdatedByUser();
	}
	
	@Override
	public void setUpdatedByUser(String updatedByUser) {
		super.setUpdatedByUser(updatedByUser);
	}
	
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "created_date",updatable = false)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "updated_date")
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	public int compareTo(StateIntl otherStateIntl) {
		if ( this == otherStateIntl ) 
			return EQUAL;
		else if (this.id < otherStateIntl.id) 
			return BEFORE;
		else if (otherStateIntl.id == this.id) 
			return EQUAL;
		else if (this.id > otherStateIntl.id)
			return AFTER;
		return EQUAL;	
	}

	@Override
	public String toString() {
		return "StateIntl [locale=" + locale + ", name=" + name
				+ ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
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
		StateIntl other = (StateIntl) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
