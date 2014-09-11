package com.mize.domain.inspection;

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
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "insp_form_rqstr")
public class InspectionFormRequestor extends MizeEntity {

	
	private static final long serialVersionUID = 344568895809535824L;

	private InspectionForm inspectionForm;
	private BusinessEntity businessEntity;
	private Long requestorId;
	private String code;
	private String typeCode;
	private String subTypeCode;
	private String name;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String requestorReference;
	private EntityAddress requestorAddress;
	private EntityContact requestorContact;
	
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
	@JoinColumn(name = "insp_form_id")
	@JsonBackReference(value="insp_form_requester")
	@JsonSerialize(using=JPASerializer.class)
	public InspectionForm getInspectionForm() {
		return inspectionForm;
	}

	public void setInspectionForm(InspectionForm inspectionForm) {
		this.inspectionForm = inspectionForm;
	}
	

	@Transient
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rqstr_be_id", nullable = true)
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}
	
	@Column(name = "rqstr_be_id")
	public Long getRequestorId() {
		return requestorId;
	}
	
	public void setRequestorId(Long requestorId) {
		this.requestorId = requestorId;
	}
	
	@Column(name = "rqstr_be_code", length = 50)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "rqstr_be_type_code", length = 50)
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	

	@Column(name = "rqstr_be_sub_type_code", length = 50)
	public String getSubTypeCode() {
		return subTypeCode;
	}

	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}
	
	@Column(name = "rqstr_be_name", length = 250)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "rqstr_be_first_name", length = 100)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	@Column(name = "rqstr_be_middle_initial", length = 50)
	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	@Column(name = "rqstr_be_last_name", length = 100)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "rqstr_be_reference", length = 100)
	public String getRequestorReference() {
		return requestorReference;
	}

	public void setRequestorReference(String requestorReference) {
		this.requestorReference = requestorReference;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "rqstr_address_id")
	public EntityAddress getRequestorAddress() {
		return requestorAddress;
	}

	public void setRequestorAddress(EntityAddress requestorAddress) {
		this.requestorAddress = requestorAddress;
	}	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "rqstr_contact_id")
	public EntityContact getRequestorContact() {
		return requestorContact;
	}

	public void setRequestorContact(EntityContact requestorContact) {
		this.requestorContact = requestorContact;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((requestorAddress == null) ? 0 : requestorAddress.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((requestorContact == null) ? 0 : requestorContact.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleInitial == null) ? 0 : middleInitial.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((requestorReference == null) ? 0 : requestorReference.hashCode());
		result = prime * result
				+ ((requestorId == null) ? 0 : requestorId.hashCode());
		result = prime * result
				+ ((inspectionForm == null) ? 0 : inspectionForm.hashCode());
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
		InspectionFormRequestor other = (InspectionFormRequestor) obj;
		if (requestorAddress == null) {
			if (other.requestorAddress != null)
				return false;
		} else if (!requestorAddress.equals(other.requestorAddress))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (requestorContact == null) {
			if (other.requestorContact != null)
				return false;
		} else if (!requestorContact.equals(other.requestorContact))
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
		if (requestorReference == null) {
			if (other.requestorReference != null)
				return false;
		} else if (!requestorReference.equals(other.requestorReference))
			return false;
		if (requestorId == null) {
			if (other.requestorId != null)
				return false;
		} else if (!requestorId.equals(other.requestorId))
			return false;
		if (inspectionForm == null) {
			if (other.inspectionForm != null)
				return false;
		} else {
			if(inspectionForm.getId() == null) {
				if(other.inspectionForm.getId() != null)
					return false;
			} else if(!inspectionForm.getId().equals(other.inspectionForm.getId()))
				return false;
		}
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



	
	
}
