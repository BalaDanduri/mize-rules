package com.mize.domain.businessentity;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.EntityContact;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
/**
 * @author Raghavendra Serikar
 * @version 1.0
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("BusinessEntityContact")
@Table(name="business_entity_contact")
public class BusinessEntityContact extends MizeSceEntity implements Comparable<BusinessEntityContact> {
	private static final long serialVersionUID = -1908157637318196738L;
	private BusinessEntity businessEntity;
	private EntityContact entityContact;
	private String certificationInfo;

	public BusinessEntityContact(){
		super();
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="be_id")
	@JsonBackReference(value="be_contact")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@OneToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER,orphanRemoval = true)
	@JoinColumn(name="be_contact_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public EntityContact getEntityContact() {
		return entityContact;
	}

	public void setEntityContact(EntityContact entityContact) {
		this.entityContact = entityContact;
	}
		
	@Column(name = "crtfctn_info")
	public String getCertificationInfo() {
		return certificationInfo;
	}

	public void setCertificationInfo(String certificationInfo) {
		this.certificationInfo = certificationInfo;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime
				* result
				+ ((certificationInfo == null) ? 0 : certificationInfo
						.hashCode());
		result = prime * result
				+ ((entityContact == null) ? 0 : entityContact.hashCode());
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
		BusinessEntityContact other = (BusinessEntityContact) obj;
		if (certificationInfo == null) {
			if (other.certificationInfo != null)
				return false;
		} else if (!certificationInfo.equals(other.certificationInfo))
			return false;
		if (entityContact == null) {
			if (other.entityContact != null)
				return false;
		} else if (!entityContact.equals(other.entityContact))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusinessEntityContact [entityContact=" + entityContact
				+ ", certificationInfo=" + certificationInfo + "]";
	}

	@Override
	public int compareTo(BusinessEntityContact arg0) {
		return 0;
	}
}
