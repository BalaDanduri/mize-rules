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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_pymt")
public class ServiceEntityPayment extends MizeEntity {

	private static final long serialVersionUID = -7468833613615827599L;
	
	private ServiceEntity serviceEntity;
	private BusinessEntity payeeEntity;
	private String payeeCode;
	private String payeeTypeCode;
	private String payeeName;
	private String payeeFirstName;
	private String payeeLastName;
	private String payeeMiddleInitial;
	private EntityAddress payeeAddress;

	public ServiceEntityPayment() {
		
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
	@JoinColumn(name = "service_entity_id")
	@JsonBackReference(value="service_entity_payment")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payee_be_id", nullable = true)
	public BusinessEntity getPayeeEntity() {
		return payeeEntity;
	}

	public void setPayeeEntity(BusinessEntity payeeEntity) {
		this.payeeEntity = payeeEntity;
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
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "payee_address_id")
	public EntityAddress getPayeeAddress() {
		return payeeAddress;
	}

	public void setPayeeAddress(EntityAddress payeeAddress) {
		this.payeeAddress = payeeAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((payeeAddress == null) ? 0 : payeeAddress.hashCode());
		result = prime * result
				+ ((payeeCode == null) ? 0 : payeeCode.hashCode());
		result = prime * result
				+ ((payeeEntity == null) ? 0 : payeeEntity.hashCode());
		result = prime * result
				+ ((payeeFirstName == null) ? 0 : payeeFirstName.hashCode());
		result = prime * result
				+ ((payeeLastName == null) ? 0 : payeeLastName.hashCode());
		result = prime
				* result
				+ ((payeeMiddleInitial == null) ? 0 : payeeMiddleInitial
						.hashCode());
		result = prime * result
				+ ((payeeName == null) ? 0 : payeeName.hashCode());
		result = prime * result
				+ ((payeeTypeCode == null) ? 0 : payeeTypeCode.hashCode());
		result = prime * result
				+ ((serviceEntity == null) ? 0 : serviceEntity.hashCode());
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
		if (payeeTypeCode == null) {
			if (other.payeeTypeCode != null)
				return false;
		} else if (!payeeTypeCode.equals(other.payeeTypeCode))
			return false;
		if (serviceEntity == null) {
			if (other.serviceEntity != null)
				return false;
		} else {
			if(serviceEntity.getId() == null) {
				if(other.serviceEntity.getId() != null)
					return false;
			} else if(!serviceEntity.getId().equals(other.serviceEntity.getId()))
				return false;
		}
		return true;
	}

}
