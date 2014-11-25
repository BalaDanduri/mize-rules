package com.mize.domain.sce.servicebulletin;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityContact;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;

/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */

@Entity
@Table(name = "srvc_blltn_rbu")
public class ServiceBulletinRespBusinessUnit extends MizeSceEntity implements Comparable<ServiceBulletinRespBusinessUnit> {


	private static final long serialVersionUID = 489453764812566721L;
	
	private ServiceBulletin serviceBulletin;
	private BusinessEntity businessEntity;
	private Long rbuId;
	private String code;
	private String typeCode;
	private String subTypeCode;
	private String name;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private EntityAddress address;
	private EntityContact contact;
	private String reference;

	public ServiceBulletinRespBusinessUnit() {
		
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blltn_id")
	@JsonBackReference(value="responsible_business_unit")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceBulletin getServiceBulletin() {
		return serviceBulletin;
	}

	public void setServiceBulletin(ServiceBulletin serviceBulletin) {
		this.serviceBulletin = serviceBulletin;
	}	
	
	@Transient
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rbu_be_id", nullable = true)
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}
	
	@Column(name = "rbu_be_id")
	public Long getRbuId() {
		return rbuId;
	}

	public void setRbuId(Long rbuId) {
		this.rbuId = rbuId;
	}
	
	@Column(name = "rbu_be_code", length = 50)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "rbu_be_type_code", length = 50)
	public String getTypeCode() {
		return typeCode;
	}
	
	@Column(name = "rbu_be_sub_type_code", length = 50)
	public String getSubTypeCode() {
		return subTypeCode;
	}

	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	@Column(name = "rbu_be_name", length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "rbu_be_first_name", length = 100)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "rbu_be_last_name", length = 100)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "rbu_be_middle_initial", length = 50)
	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "rbu_address_id")
	public EntityAddress getAddress() {
		return address;
	}

	public void setAddress(EntityAddress address) {
		this.address = address;
	}	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "rbu_contact_id")
	public EntityContact getContact() {
		return contact;
	}

	public void setContact(EntityContact contact) {
		this.contact = contact;
	}
	
	@Column(name = "rbu_be_reference", length = 100)
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((businessEntity == null) ? 0 : businessEntity.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleInitial == null) ? 0 : middleInitial.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rbuId == null) ? 0 : rbuId.hashCode());
		result = prime * result
				+ ((reference == null) ? 0 : reference.hashCode());
		result = prime * result
				+ ((subTypeCode == null) ? 0 : subTypeCode.hashCode());
		result = prime * result
				+ ((typeCode == null) ? 0 : typeCode.hashCode());
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
		ServiceBulletinRespBusinessUnit other = (ServiceBulletinRespBusinessUnit) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (businessEntity == null) {
			if (other.businessEntity != null)
				return false;
		} else if (!businessEntity.equals(other.businessEntity))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleInitial == null) {
			if (other.middleInitial != null)
				return false;
		} else if (!middleInitial.equals(other.middleInitial))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rbuId == null) {
			if (other.rbuId != null)
				return false;
		} else if (!rbuId.equals(other.rbuId))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (subTypeCode == null) {
			if (other.subTypeCode != null)
				return false;
		} else if (!subTypeCode.equals(other.subTypeCode))
			return false;
		if (typeCode == null) {
			if (other.typeCode != null)
				return false;
		} else if (!typeCode.equals(other.typeCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceBulletinRespBusinessUnit [businessEntity="
				+ businessEntity + ", rbuId=" + rbuId + ", code=" + code
				+ ", typeCode=" + typeCode + ", subTypeCode=" + subTypeCode
				+ ", name=" + name + ", firstName=" + firstName + ", lastName="
				+ lastName + ", middleInitial=" + middleInitial + ", address="
				+ address + ", contact=" + contact + ", reference=" + reference
				+ "]";
	}

	@Override
	public int compareTo(ServiceBulletinRespBusinessUnit o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
