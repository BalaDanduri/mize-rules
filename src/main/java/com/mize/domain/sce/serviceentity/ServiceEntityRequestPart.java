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
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.part.Part;
import com.mize.domain.util.JPASerializer;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_rqst_part")
public class ServiceEntityRequestPart extends MizeEntity implements Comparable<ServiceEntityRequestPart> {

	
	private static final long serialVersionUID = 609285366151566036L;
	
	private ServiceEntityRequest serviceEntityRequest;
	private Part part;
	private Long partId;
	private String partType;
	private String partCode;
	private String partName;
	private String partDescription;
	private String partUom;
	private String partSerial;	
	private ServiceEntityAmount partAmount;
	
	private boolean isUpdated;
	

	public ServiceEntityRequestPart() {
		
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
	@JsonBackReference(value="service_request_parts")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntityRequest getServiceEntityRequest() {
		return serviceEntityRequest;
	}
	
	public void setServiceEntityRequest(ServiceEntityRequest serviceEntityRequest) {
		this.serviceEntityRequest = serviceEntityRequest;
	}
	
	@Transient
	@JsonIgnore
	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}
	
	@Column(name = "part_id", nullable = true)
	public Long getPartId() {
		return partId;
	}
	
	public void setPartId(Long partId) {
		this.partId = partId;
	}
	
	@Column(name = "part_type", length = 50)
	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}
	
	@Column(name = "part_code", length = 100)
	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	
	@Column(name = "part_name", length = 250)
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}
	
	@Column(name = "part_descr", length = 500)
	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	
	@Column(name = "part_uom", length = 50)
	public String getPartUom() {
		return partUom;
	}

	public void setPartUom(String partUom) {
		this.partUom = partUom;
	}
	
	@Column(name = "part_serial", length = 100)
	public String getPartSerial() {
		return partSerial;
	}

	public void setPartSerial(String partSerial) {
		this.partSerial = partSerial;
	}	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "part_amount_id")
	public ServiceEntityAmount getPartAmount() {
		return partAmount;
	}

	public void setPartAmount(ServiceEntityAmount partAmount) {
		this.partAmount = partAmount;
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
		result = prime * result + (isUpdated ? 1231 : 1237);
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		result = prime * result
				+ ((partAmount == null) ? 0 : partAmount.hashCode());
		result = prime * result
				+ ((partCode == null) ? 0 : partCode.hashCode());
		result = prime * result
				+ ((partDescription == null) ? 0 : partDescription.hashCode());
		result = prime * result + ((partId == null) ? 0 : partId.hashCode());
		result = prime * result
				+ ((partName == null) ? 0 : partName.hashCode());
		result = prime * result
				+ ((partSerial == null) ? 0 : partSerial.hashCode());
		result = prime * result
				+ ((partType == null) ? 0 : partType.hashCode());
		result = prime * result + ((partUom == null) ? 0 : partUom.hashCode());
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
		ServiceEntityRequestPart other = (ServiceEntityRequestPart) obj;
		if (isUpdated != other.isUpdated)
			return false;
		if (part == null) {
			if (other.part != null)
				return false;
		} else if (!part.equals(other.part))
			return false;
		if (partAmount == null) {
			if (other.partAmount != null)
				return false;
		} else if (!partAmount.equals(other.partAmount))
			return false;
		if (partCode == null) {
			if (other.partCode != null)
				return false;
		} else if (!partCode.equals(other.partCode))
			return false;
		if (partDescription == null) {
			if (other.partDescription != null)
				return false;
		} else if (!partDescription.equals(other.partDescription))
			return false;
		if (partId == null) {
			if (other.partId != null)
				return false;
		} else if (!partId.equals(other.partId))
			return false;
		if (partName == null) {
			if (other.partName != null)
				return false;
		} else if (!partName.equals(other.partName))
			return false;
		if (partSerial == null) {
			if (other.partSerial != null)
				return false;
		} else if (!partSerial.equals(other.partSerial))
			return false;
		if (partType == null) {
			if (other.partType != null)
				return false;
		} else if (!partType.equals(other.partType))
			return false;
		if (partUom == null) {
			if (other.partUom != null)
				return false;
		} else if (!partUom.equals(other.partUom))
			return false;
		return true;
	}

	@Override
	public int compareTo(ServiceEntityRequestPart o) {
		return 0;
	}

	@Override
	public String toString() {
		return "ServiceEntityRequestPart [part=" + part + ", partId=" + partId
				+ ", partType=" + partType + ", partCode=" + partCode
				+ ", partName=" + partName + ", partDescription="
				+ partDescription + ", partUom=" + partUom + ", partSerial="
				+ partSerial + ", partAmount=" + partAmount + ", isUpdated="
				+ isUpdated + "]";
	}
	

}
