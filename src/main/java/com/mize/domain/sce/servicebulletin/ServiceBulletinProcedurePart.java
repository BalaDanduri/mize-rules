package com.mize.domain.sce.servicebulletin;

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
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.part.Part;
import com.mize.domain.util.JPASerializer;

/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */

@Entity
@Table(name = "srvc_blltn_proc_part")
public class ServiceBulletinProcedurePart extends MizeSceEntity implements Comparable<ServiceBulletinProcedurePart> {

	
	private static final long serialVersionUID = 609285366151566036L;
	
	private ServiceBulletinProcedure serviceBulletinProcedure;
	private Part part;
	private Long partId;
	private String partType;
	private String partCode;
	private String partUom;
	private String partReference;	
	private ServiceBulletinAmount partAmount;
	private String isReturnable;
	private String description;
	private String name;
	private boolean isUpdated;
	

	public ServiceBulletinProcedurePart() {
		
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
	
	@ManyToOne
	@JoinColumn(name = "blltn_proc_id")
	@JsonBackReference(value="service_procedure_parts")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceBulletinProcedure getServiceBulletinProcedure() {
		return serviceBulletinProcedure;
	}

	public void setServiceBulletinProcedure(ServiceBulletinProcedure serviceBulletinProcedure) {
		this.serviceBulletinProcedure = serviceBulletinProcedure;
	}
	
	@Transient
	@JsonIgnore
	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}
	
	@Column(name = "part_id")
	public Long getPartId() {
		return partId;
	}
	
	public void setPartId(Long partId) {
		this.partId = partId;
	}
	
	@Column(name = "part_type")
	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}
	
	@Column(name = "part_code")
	public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	
	@Column(name = "part_uom")
	public String getPartUom() {
		return partUom;
	}

	public void setPartUom(String partUom) {
		this.partUom = partUom;
	}
	
	@Column(name = "part_reference")
	public String getPartReference() {
		return partReference;
	}

	public void setPartReference(String partReference) {
		this.partReference = partReference;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "part_amount_id")
	public ServiceBulletinAmount getPartAmount() {
		return partAmount;
	}

	public void setPartAmount(ServiceBulletinAmount partAmount) {
		this.partAmount = partAmount;
	}
	
	@Column(name = "is_returnable")
	public String getIsReturnable() {
		return isReturnable;
	}

	public void setIsReturnable(String isReturnable) {
		this.isReturnable = isReturnable;
	}
	
	@Transient
	public boolean getIsUpdated() {
		return isUpdated;
	}

	public void setIsUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}
	
	@Column(name="part_descr")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="part_name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((isReturnable == null) ? 0 : isReturnable.hashCode());
		result = prime * result + (isUpdated ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((part == null) ? 0 : part.hashCode());
		result = prime * result
				+ ((partAmount == null) ? 0 : partAmount.hashCode());
		result = prime * result
				+ ((partCode == null) ? 0 : partCode.hashCode());
		result = prime * result + ((partId == null) ? 0 : partId.hashCode());
		result = prime * result
				+ ((partReference == null) ? 0 : partReference.hashCode());
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
		ServiceBulletinProcedurePart other = (ServiceBulletinProcedurePart) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isReturnable == null) {
			if (other.isReturnable != null)
				return false;
		} else if (!isReturnable.equals(other.isReturnable))
			return false;
		if (isUpdated != other.isUpdated)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		if (partId == null) {
			if (other.partId != null)
				return false;
		} else if (!partId.equals(other.partId))
			return false;
		if (partReference == null) {
			if (other.partReference != null)
				return false;
		} else if (!partReference.equals(other.partReference))
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
	public String toString() {
		return "ServiceBulletinProcedurePart [part=" + part + ", partId="
				+ partId + ", partType=" + partType + ", partCode=" + partCode
				+ ", partUom=" + partUom + ", partReference=" + partReference
				+ ", partAmount=" + partAmount + ", isReturnable="
				+ isReturnable + ", description=" + description + ", name="
				+ name + ", isUpdated=" + isUpdated + "]";
	}

	@Override
	public int compareTo(ServiceBulletinProcedurePart o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
