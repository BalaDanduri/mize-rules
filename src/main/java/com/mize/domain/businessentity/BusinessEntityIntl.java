package com.mize.domain.businessentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
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

	@ManyToOne(fetch = FetchType.LAZY)
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
	
}
