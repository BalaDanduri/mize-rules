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
@Table(name="country_intl")
public class CountryIntl extends MizeSceEntityIntl implements Comparable<CountryIntl> {

	private static final long serialVersionUID = 251263039560820237L;

	private Country country;
	private String name;
	private String description;

	public CountryIntl() {
		super();
	}

	public CountryIntl(Country country, Locale locale, String name,
			String description) {
		super();
		this.country = country;
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
	
	@JsonBackReference(value="countryIntl")
	@ManyToOne(fetch = FetchType.EAGER ,optional = true)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JoinColumn(name = "country_id")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Column(name = "country_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "country_description")
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
	public String toString() {
		return "CountryIntl [locale=" + locale + ", name=" + name
				+ ", description=" + description + "]";
	}

	@Override
	public int compareTo(CountryIntl otherCountryIntl) {
		if ( this == otherCountryIntl ) 
			return EQUAL;
		else if (this.id < otherCountryIntl.id) 
			return BEFORE;
		else if (otherCountryIntl.id == this.id) 
			return EQUAL;
		else if (this.id > otherCountryIntl.id)
			return AFTER;
		return EQUAL;	
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
		CountryIntl other = (CountryIntl) obj;
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
