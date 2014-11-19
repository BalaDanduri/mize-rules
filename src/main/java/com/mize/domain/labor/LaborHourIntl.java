package com.mize.domain.labor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("LaborHourIntl")
@Table(name = "labor_hour_intl", uniqueConstraints = {@UniqueConstraint (columnNames = {"labor_hour_id", "locale_id"})})
public class LaborHourIntl extends MizeSceEntity implements Comparable<LaborHourIntl>{

	private static final long serialVersionUID = -1862266220815979799L;
	private LaborHour laborHour;
	private Locale locale;
	private String name;
	private String description;

	public LaborHourIntl() {
	}
	
	public LaborHourIntl(LaborHour laborHour, Locale locale, String name,
			String description) {
		super();
		this.laborHour = laborHour;
		this.locale = locale;
		this.name = name;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "labor_hour_id")
	@JsonBackReference(value ="laborHour")	
	public LaborHour getLaborHour() {
		return laborHour;
	}

	public void setLaborHour(LaborHour laborHour) {
		this.laborHour = laborHour;
	}

	@ManyToOne(fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Column(name = "labor_name", length = 250, nullable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "labor_description", length = 500, nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		LaborHourIntl other = (LaborHourIntl) obj;
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

	@Override
	public int compareTo(LaborHourIntl  intl) {
		if ( this == intl ) 
			return EQUAL;
		else if (this.id < intl.id) 
			return BEFORE;
		else if (intl.id == this.id) 
			return EQUAL;
		else if (this.id > intl.id)
			return AFTER;
		return EQUAL;
	}

}
