package com.mize.domain.sce.serviceentity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_rqst_oth")
public class ServiceEntityRequestOther extends MizeSceEntity implements Comparable<ServiceEntityRequestOther> {

	
	private static final long serialVersionUID = 1955038213931636949L;
	
	private ServiceEntityRequest serviceEntityRequest;
	private String chargeType;
	private String chargeCode;
	private String chargeDescription;
	private ServiceEntityAmount chargeAmount;

	public ServiceEntityRequestOther() {
		
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
	
	@ManyToOne
	@JoinColumn(name = "service_request_id")
	@JsonBackReference(value="service_request_otherCharges")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntityRequest getServiceEntityRequest() {
		return serviceEntityRequest;
	}

	public void setServiceEntityRequest(ServiceEntityRequest serviceEntityRequest) {
		this.serviceEntityRequest = serviceEntityRequest;
	}
	
	@Column(name = "other_charge_type", length = 50)
	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}
	
	@Column(name = "other_charge_code", length = 100)
	public String getChargeCode() {
		return chargeCode;
	}

	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}
	
	@Column(name = "other_charge_descr", length = 500)
	public String getChargeDescription() {
		return chargeDescription;
	}

	public void setChargeDescription(String chargeDescription) {
		this.chargeDescription = chargeDescription;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "other_amount_id")
	public ServiceEntityAmount getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(ServiceEntityAmount chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime
				* result
				+ ((chargeAmount == null) ? 0 : chargeAmount
						.hashCode());
		result = prime * result
				+ ((chargeCode == null) ? 0 : chargeCode.hashCode());
		result = prime
				* result
				+ ((chargeDescription == null) ? 0
						: chargeDescription.hashCode());
		result = prime * result
				+ ((chargeType == null) ? 0 : chargeType.hashCode());
		result = prime
				* result
				+ ((serviceEntityRequest == null) ? 0 : serviceEntityRequest
						.hashCode());
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
		ServiceEntityRequestOther other = (ServiceEntityRequestOther) obj;
		if (chargeAmount == null) {
			if (other.chargeAmount != null)
				return false;
		} else if (!chargeAmount.equals(other.chargeAmount))
			return false;
		if (chargeCode == null) {
			if (other.chargeCode != null)
				return false;
		} else if (!chargeCode.equals(other.chargeCode))
			return false;
		if (chargeDescription == null) {
			if (other.chargeDescription != null)
				return false;
		} else if (!chargeDescription.equals(other.chargeDescription))
			return false;
		if (chargeType == null) {
			if (other.chargeType != null)
				return false;
		} else if (!chargeType.equals(other.chargeType))
			return false;
		if (serviceEntityRequest == null) {
			if (other.serviceEntityRequest != null)
				return false;
		} else {
			if(serviceEntityRequest.getId() == null) {
				if(other.serviceEntityRequest.getId() != null)
					return false;
			} else if(!serviceEntityRequest.getId().equals(other.serviceEntityRequest.getId()))
				return false;
		}
		return true;
	}

	@Override
	public int compareTo(ServiceEntityRequestOther o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
