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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.labor.LaborHour;
import com.mize.domain.util.JPASerializer;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_rqst_lbr")
public class ServiceEntityRequestLabor extends MizeEntity {

	
	private static final long serialVersionUID = 7457276515383997804L;
	
	private ServiceEntityRequest serviceEntityRequest;
	private LaborHour laborHour;
	private Long laborHourId;
	private String laborType;
	private String laborCode;
	private String laborName;
	private String laborDescription;
	private ServiceEntityAmount laborAmount;
	
	private boolean isUpdated;

	public ServiceEntityRequestLabor() {
		
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
	@JsonBackReference(value="service_request_labors")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntityRequest getServiceEntityRequest() {
		return serviceEntityRequest;
	}

	public void setServiceEntityRequest(ServiceEntityRequest serviceEntityRequest) {
		this.serviceEntityRequest = serviceEntityRequest;
	}
	
	@Transient
	@JsonIgnore
	public LaborHour getLaborHour() {
		return laborHour;
	}

	public void setLaborHour(LaborHour laborHour) {
		this.laborHour = laborHour;
	}
	
	@Column(name = "labor_id", nullable = true)
	public Long getLaborHourId() {
		return laborHourId;
	}
	
	public void setLaborHourId(Long laborHourId) {
		this.laborHourId = laborHourId;
	}
	
	@Column(name = "labor_type", length = 50)
	public String getLaborType() {
		return laborType;
	}

	public void setLaborType(String laborType) {
		this.laborType = laborType;
	}
	
	@Column(name = "labor_code", length = 100)
	public String getLaborCode() {
		return laborCode;
	}

	public void setLaborCode(String laborCode) {
		this.laborCode = laborCode;
	}
	
	@Column(name = "labor_name", length = 250)
	public String getLaborName() {
		return laborName;
	}

	public void setLaborName(String laborName) {
		this.laborName = laborName;
	}
	
	@Column(name = "labor_descr", length = 500)
	public String getLaborDescription() {
		return laborDescription;
	}

	public void setLaborDescription(String laborDescription) {
		this.laborDescription = laborDescription;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "labor_amount_id")
	public ServiceEntityAmount getLaborAmount() {
		return laborAmount;
	}

	public void setLaborAmount(ServiceEntityAmount laborAmount) {
		this.laborAmount = laborAmount;
	}
	
	@Transient
	public boolean getIsUpdated() {
		return isUpdated;
	}

	public void setIsUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((laborAmount == null) ? 0 : laborAmount.hashCode());
		result = prime * result
				+ ((laborCode == null) ? 0 : laborCode.hashCode());
		result = prime
				* result
				+ ((laborDescription == null) ? 0 : laborDescription.hashCode());
		result = prime * result
				+ ((laborHour == null) ? 0 : laborHour.hashCode());
		result = prime * result
				+ ((laborName == null) ? 0 : laborName.hashCode());
		result = prime * result
				+ ((laborType == null) ? 0 : laborType.hashCode());
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
		ServiceEntityRequestLabor other = (ServiceEntityRequestLabor) obj;
		if (laborAmount == null) {
			if (other.laborAmount != null)
				return false;
		} else if (!laborAmount.equals(other.laborAmount))
			return false;
		if (laborCode == null) {
			if (other.laborCode != null)
				return false;
		} else if (!laborCode.equals(other.laborCode))
			return false;
		if (laborDescription == null) {
			if (other.laborDescription != null)
				return false;
		} else if (!laborDescription.equals(other.laborDescription))
			return false;
		if (laborHour == null) {
			if (other.laborHour != null)
				return false;
		} else if (!laborHour.equals(other.laborHour))
			return false;
		if (laborName == null) {
			if (other.laborName != null)
				return false;
		} else if (!laborName.equals(other.laborName))
			return false;
		if (laborType == null) {
			if (other.laborType != null)
				return false;
		} else if (!laborType.equals(other.laborType))
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
	

}
