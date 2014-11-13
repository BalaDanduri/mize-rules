package com.mize.domain.businessentity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.JPASerializer;
/**
 * @author Raghavendra Serikar
 * @version 1.0
*/
@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("BusinessEntityIntl")
@Table(name="business_entity_intl")
public class BusinessEntityIntl extends MizeEntity {
	private static final long serialVersionUID = -1362236702129137109L;
	private BusinessEntity businessEntity;
	private String name;
	private String description;
	private Locale locale;
	private String firstName;
	private String lastName;
	private String middleInitial;
	
	public BusinessEntityIntl() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "be_id")
	@JsonBackReference(value="intl")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}
	
	@Column(name = "be_name")
	public String getName() {
		return name;
	}

	@Column(name = "be_description")
	public String getDescription() {
		return description;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "locale_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public Locale getLocale() {
		return locale;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	@Column(name = "be_first_name", length = 100, nullable = true)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "be_last_name", length = 100, nullable = true)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "be_middle_initial", length = 50, nullable = true)
	public String getMiddleInitial() {
		return middleInitial;
	}
	
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result
				+ ((middleInitial == null) ? 0 : middleInitial.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;		
		if (getClass() != obj.getClass())
			return false;
		BusinessEntityIntl other = (BusinessEntityIntl) obj;
		if (Formatter.isNull(description)) {
			if (Formatter.isNotNull(other.description))
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Formatter.isNull(firstName)) {
			if (Formatter.isNotNull(other.firstName))
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (Formatter.isNull(lastName)) {
			if (Formatter.isNotNull(other.lastName))
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (Formatter.isNull(middleInitial)) {
			if (Formatter.isNotNull(other.middleInitial))
				return false;
		} else if (!middleInitial.equals(other.middleInitial))
			return false;
		if (Formatter.isNull(name)) {
			if (Formatter.isNotNull(other.name))
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
