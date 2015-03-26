package com.mize.domain.sce.serviceentity;

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
import com.mize.domain.datetime.Date;
import com.mize.domain.util.JPASerializer;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_pymt")
public class ServiceEntityPayment extends MizeSceEntity implements Comparable<ServiceEntityPayment> {

	private static final long serialVersionUID = -7468833613615827599L;
	
	private ServiceEntity serviceEntity;
	private BusinessEntity payeeEntity;
	
	private Long payeeId;
	private String payeeCode;
	private String payeeTypeCode;
	private String payeeName;
	private String payeeFirstName;
	private String payeeLastName;
	private String payeeMiddleInitial;	
	private String payeeReference;
	private String isNewPayee;
	private Date paymentDate;
	private String paymentType;
	
	private EntityAddress payeeAddress;
	private EntityContact payeeContact;

	public ServiceEntityPayment() {
		
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_entity_id")
	@JsonBackReference(value="service_entity_payment")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}
	
	@Transient
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payee_be_id")
	public BusinessEntity getPayeeEntity() {
		return payeeEntity;
	}

	public void setPayeeEntity(BusinessEntity payeeEntity) {
		this.payeeEntity = payeeEntity;
	}
	
	@Column(name = "payee_be_id")
	public Long getPayeeId() {
		return payeeId;
	}
	
	public void setPayeeId(Long payeeId) {
		this.payeeId = payeeId;
	}
	
	@Column(name = "payee_be_code", length = 50)
	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}
	
	@Column(name = "payee_be_type_code", length = 50)
	public String getPayeeTypeCode() {
		return payeeTypeCode;
	}

	public void setPayeeTypeCode(String payeeTypeCode) {
		this.payeeTypeCode = payeeTypeCode;
	}
	
	@Column(name = "payee_be_name", length = 250)
	public String getPayeeName() {
		return payeeName;
	}
	
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	
	@Column(name = "payee_be_first_name", length = 100)
	public String getPayeeFirstName() {
		return payeeFirstName;
	}

	public void setPayeeFirstName(String payeeFirstName) {
		this.payeeFirstName = payeeFirstName;
	}
	
	@Column(name = "payee_be_last_name", length = 100)
	public String getPayeeLastName() {
		return payeeLastName;
	}

	public void setPayeeLastName(String payeeLastName) {
		this.payeeLastName = payeeLastName;
	}
	
	@Column(name = "payee_be_middle_initial", length = 50)
	public String getPayeeMiddleInitial() {
		return payeeMiddleInitial;
	}

	public void setPayeeMiddleInitial(String payeeMiddleInitial) {
		this.payeeMiddleInitial = payeeMiddleInitial;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "payee_address_id")
	public EntityAddress getPayeeAddress() {
		return payeeAddress;
	}

	public void setPayeeAddress(EntityAddress payeeAddress) {
		this.payeeAddress = payeeAddress;
	}	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "payee_contact_id")
	public EntityContact getPayeeContact() {
		return payeeContact;
	}

	public void setPayeeContact(EntityContact payeeContact) {
		this.payeeContact = payeeContact;
	}
	
	@Column(name = "payee_be_reference", length = 100)
	public String getPayeeReference() {
		return payeeReference;
	}

	public void setPayeeReference(String payeeReference) {
		this.payeeReference = payeeReference;
	}
	
	@Column(name = "is_new_payee", length = 1)
	public String getIsNewPayee() {
		return isNewPayee;
	}

	public void setIsNewPayee(String isNewPayee) {
		this.isNewPayee = isNewPayee;
	}
	
	
	@Column(name = "pymt_date")
	public Date getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	@Column(name = "pymt_type", length = 50)
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((isNewPayee == null) ? 0 : isNewPayee.hashCode());
		result = prime * result
				+ ((payeeAddress == null) ? 0 : payeeAddress.hashCode());
		result = prime * result
				+ ((payeeCode == null) ? 0 : payeeCode.hashCode());
		result = prime * result
				+ ((payeeContact == null) ? 0 : payeeContact.hashCode());
		result = prime * result
				+ ((payeeEntity == null) ? 0 : payeeEntity.hashCode());
		result = prime * result
				+ ((payeeFirstName == null) ? 0 : payeeFirstName.hashCode());
		result = prime * result + ((payeeId == null) ? 0 : payeeId.hashCode());
		result = prime * result
				+ ((payeeLastName == null) ? 0 : payeeLastName.hashCode());
		result = prime
				* result
				+ ((payeeMiddleInitial == null) ? 0 : payeeMiddleInitial
						.hashCode());
		result = prime * result
				+ ((payeeName == null) ? 0 : payeeName.hashCode());
		result = prime * result
				+ ((payeeReference == null) ? 0 : payeeReference.hashCode());
		result = prime * result
				+ ((payeeTypeCode == null) ? 0 : payeeTypeCode.hashCode());
		result = prime * result
				+ ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result
				+ ((paymentType == null) ? 0 : paymentType.hashCode());
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
		ServiceEntityPayment other = (ServiceEntityPayment) obj;
		if (isNewPayee == null) {
			if (other.isNewPayee != null)
				return false;
		} else if (!isNewPayee.equals(other.isNewPayee))
			return false;
		if (payeeAddress == null) {
			if (other.payeeAddress != null)
				return false;
		} else if (!payeeAddress.equals(other.payeeAddress))
			return false;
		if (payeeCode == null) {
			if (other.payeeCode != null)
				return false;
		} else if (!payeeCode.equals(other.payeeCode))
			return false;
		if (payeeContact == null) {
			if (other.payeeContact != null)
				return false;
		} else if (!payeeContact.equals(other.payeeContact))
			return false;
		if (payeeEntity == null) {
			if (other.payeeEntity != null)
				return false;
		} else if (!payeeEntity.equals(other.payeeEntity))
			return false;
		if (payeeFirstName == null) {
			if (other.payeeFirstName != null)
				return false;
		} else if (!payeeFirstName.equals(other.payeeFirstName))
			return false;
		if (payeeId == null) {
			if (other.payeeId != null)
				return false;
		} else if (!payeeId.equals(other.payeeId))
			return false;
		if (payeeLastName == null) {
			if (other.payeeLastName != null)
				return false;
		} else if (!payeeLastName.equals(other.payeeLastName))
			return false;
		if (payeeMiddleInitial == null) {
			if (other.payeeMiddleInitial != null)
				return false;
		} else if (!payeeMiddleInitial.equals(other.payeeMiddleInitial))
			return false;
		if (payeeName == null) {
			if (other.payeeName != null)
				return false;
		} else if (!payeeName.equals(other.payeeName))
			return false;
		if (payeeReference == null) {
			if (other.payeeReference != null)
				return false;
		} else if (!payeeReference.equals(other.payeeReference))
			return false;
		if (payeeTypeCode == null) {
			if (other.payeeTypeCode != null)
				return false;
		} else if (!payeeTypeCode.equals(other.payeeTypeCode))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (paymentType == null) {
			if (other.paymentType != null)
				return false;
		} else if (!paymentType.equals(other.paymentType))
			return false;
		return true;
	}

	@Override
	public int compareTo(ServiceEntityPayment o) {
		return 0;
	}

	@Override
	public String toString() {
		return "ServiceEntityPayment [payeeEntity=" + payeeEntity
				+ ", payeeId=" + payeeId + ", payeeCode=" + payeeCode
				+ ", payeeTypeCode=" + payeeTypeCode + ", payeeName="
				+ payeeName + ", payeeFirstName=" + payeeFirstName
				+ ", payeeLastName=" + payeeLastName + ", payeeMiddleInitial="
				+ payeeMiddleInitial + ", payeeAddress=" + payeeAddress
				+ ", payeeContact=" + payeeContact + ", payeeReference="
				+ payeeReference + ", isNewPayee=" + isNewPayee
				+ ", paymentDate=" + paymentDate + ", paymentType="
				+ paymentType + "]";
	}
	

}
