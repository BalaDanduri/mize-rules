package com.mize.domain.inspection;

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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityContact;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("InspectionFormEquipmentOwner")
@Table(name = "insp_form_eqpmnt_owner")
public class InspectionFormEquipmentOwner extends MizeSceEntity implements Comparable<InspectionFormEquipmentOwner> {

	
	private static final long serialVersionUID = -8166569917962156239L;

	private InspectionFormEquipment inspectionFormEquipment;
	private BusinessEntity businessEntity;
	private Long ownerId;
	private String code;
	private String typeCode;
	private String subTypeCode;
	private String name;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String ownerReference;
	private EntityAddress ownerAddress;
	private EntityContact ownerContact;
	
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "insp_eqpmnt_id")
	@JsonBackReference(value="insp_eqpmnt_owner")
	@JsonSerialize(using=JPASerializer.class)
	public InspectionFormEquipment getInspectionFormEquipment() {
		return inspectionFormEquipment;
	}

	public void setInspectionFormEquipment(InspectionFormEquipment inspectionFormEquipment) {
		this.inspectionFormEquipment = inspectionFormEquipment;
	}

	@Transient
	@JsonIgnore
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@Column(name = "owner_be_id")
	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	@Column(name = "owner_be_code", length = 50)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "owner_be_type_code", length = 50)
	public String getTypeCode() {
		return typeCode;
	}

	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "owner_be_sub_type_code", length = 50)
	public String getSubTypeCode() {
		return subTypeCode;
	}

	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}

	@Column(name = "owner_be_name", length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "owner_be_first_name", length = 100)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "owner_be_middle_initial", length = 50)
	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	@Column(name = "owner_be_last_name", length = 100)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "owner_be_reference", length = 100)
	public String getOwnerReference() {
		return ownerReference;
	}
	
	public void setOwnerReference(String ownerReference) {
		this.ownerReference = ownerReference;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "owner_address_id")
	public EntityAddress getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(EntityAddress ownerAddress) {
		this.ownerAddress = ownerAddress;
	}


	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "owner_contact_id")
	public EntityContact getOwnerContact() {
		return ownerContact;
	}

	public void setOwnerContact(EntityContact ownerContact) {
		this.ownerContact = ownerContact;
	}

	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((ownerAddress == null) ? 0 : ownerAddress.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((ownerContact == null) ? 0 : ownerContact.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleInitial == null) ? 0 : middleInitial.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ownerReference == null) ? 0 : ownerReference.hashCode());
		result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
		result = prime * result + ((typeCode == null) ? 0 : typeCode.hashCode());
		
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
		InspectionFormEquipmentOwner other = (InspectionFormEquipmentOwner) obj;
		if (ownerAddress == null) {
			if (other.ownerAddress != null)
				return false;
		} else if (!ownerAddress.equals(other.ownerAddress))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (ownerContact == null) {
			if (other.ownerContact != null)
				return false;
		} else if (!ownerContact.equals(other.ownerContact))
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
		if (ownerReference == null) {
			if (other.ownerReference != null)
				return false;
		} else if (!ownerReference.equals(other.ownerReference))
			return false;
		if (ownerId == null) {
			if (other.ownerId != null)
				return false;
		} else if (!ownerId.equals(other.ownerId))
			return false;
		if (typeCode == null) {
			if (other.typeCode != null)
				return false;
		} else if (!typeCode.equals(other.typeCode))
			return false;
		if (subTypeCode == null) {
			if (other.subTypeCode != null)
				return false;
		} else if (!subTypeCode.equals(other.subTypeCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InspectionFormEquipmentOwner [id=" + id + ", businessEntity="
				+ businessEntity + ", code=" + code + ", firstName="
				+ firstName + ", lastName=" + lastName + ", middleInitial="
				+ middleInitial + ", name=" + name + ", ownerAddress="
				+ ownerAddress + ", ownerContact=" + ownerContact
				+ ", ownerId=" + ownerId + ", ownerReference=" + ownerReference
				+ ", subTypeCode=" + subTypeCode + ", typeCode=" + typeCode
				+ "]";
	}

	@Override
	public int compareTo(InspectionFormEquipmentOwner arg0) {
		// TODO Auto-generated method stub
		return 0;
	}	

	
	
	
}
