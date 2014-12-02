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
import com.mize.domain.labor.LaborHour;
import com.mize.domain.util.JPASerializer;

/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */

@Entity
@Table(name = "srvc_blltn_proc_lbr")
public class ServiceBulletinProcedureLabor extends MizeSceEntity implements Comparable<ServiceBulletinProcedureLabor>{

	
	private static final long serialVersionUID = 7457276515383997804L;
	
	private ServiceBulletinProcedure serviceBulletinProcedure;
	private LaborHour laborHour;
	private Long laborHourId;
	private String laborType;
	private String laborCode;
	private String laborUom;
	private String laborReference;
	private ServiceBulletinAmount laborAmount;
	private String description;
	private String name;
	
	private boolean isUpdated;

	public ServiceBulletinProcedureLabor() {
		
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
	@JsonBackReference(value="service_procedure_labors")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceBulletinProcedure getServiceBulletinProcedure() {
		return serviceBulletinProcedure;
	}

	public void setServiceBulletinProcedure(ServiceBulletinProcedure serviceBulletinProcedure) {
		this.serviceBulletinProcedure = serviceBulletinProcedure;
	}
	
	@Transient
	@JsonIgnore
	public LaborHour getLaborHour() {
		return laborHour;
	}

	public void setLaborHour(LaborHour laborHour) {
		this.laborHour = laborHour;
	}
	
	@Column(name = "labor_id")
	public Long getLaborHourId() {
		return laborHourId;
	}
	
	public void setLaborHourId(Long laborHourId) {
		this.laborHourId = laborHourId;
	}
	
	@Column(name = "labor_type")
	public String getLaborType() {
		return laborType;
	}

	public void setLaborType(String laborType) {
		this.laborType = laborType;
	}
	
	@Column(name = "labor_code")
	public String getLaborCode() {
		return laborCode;
	}

	public void setLaborCode(String laborCode) {
		this.laborCode = laborCode;
	}
	
	@Column(name = "labor_uom")
	public String getLaborUom() {
		return laborUom;
	}

	public void setLaborUom(String laborUom) {
		this.laborUom = laborUom;
	}
	
	@Column(name = "labor_reference")
	public String getLaborReference() {
		return laborReference;
	}

	public void setLaborReference(String laborReference) {
		this.laborReference = laborReference;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "labor_amount_id")
	public ServiceBulletinAmount getLaborAmount() {
		return laborAmount;
	}

	public void setLaborAmount(ServiceBulletinAmount laborAmount) {
		this.laborAmount = laborAmount;
	}
	
	@Transient
	public boolean getIsUpdated() {
		return isUpdated;
	}

	public void setIsUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}
	
	@Column(name="labor_descr")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="labor_name")
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
		result = prime * result + (isUpdated ? 1231 : 1237);
		result = prime * result
				+ ((laborAmount == null) ? 0 : laborAmount.hashCode());
		result = prime * result
				+ ((laborCode == null) ? 0 : laborCode.hashCode());
		result = prime * result
				+ ((laborHour == null) ? 0 : laborHour.hashCode());
		result = prime * result
				+ ((laborHourId == null) ? 0 : laborHourId.hashCode());
		result = prime * result
				+ ((laborReference == null) ? 0 : laborReference.hashCode());
		result = prime * result
				+ ((laborType == null) ? 0 : laborType.hashCode());
		result = prime * result
				+ ((laborUom == null) ? 0 : laborUom.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ServiceBulletinProcedureLabor other = (ServiceBulletinProcedureLabor) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isUpdated != other.isUpdated)
			return false;
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
		if (laborHour == null) {
			if (other.laborHour != null)
				return false;
		} else if (!laborHour.equals(other.laborHour))
			return false;
		if (laborHourId == null) {
			if (other.laborHourId != null)
				return false;
		} else if (!laborHourId.equals(other.laborHourId))
			return false;
		if (laborReference == null) {
			if (other.laborReference != null)
				return false;
		} else if (!laborReference.equals(other.laborReference))
			return false;
		if (laborType == null) {
			if (other.laborType != null)
				return false;
		} else if (!laborType.equals(other.laborType))
			return false;
		if (laborUom == null) {
			if (other.laborUom != null)
				return false;
		} else if (!laborUom.equals(other.laborUom))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceBulletinProcedureLabor [laborHour=" + laborHour
				+ ", laborHourId=" + laborHourId + ", laborType=" + laborType
				+ ", laborCode=" + laborCode + ", laborUom=" + laborUom
				+ ", laborReference=" + laborReference + ", laborAmount="
				+ laborAmount + ", description=" + description + ", name="
				+ name + ", isUpdated=" + isUpdated + "]";
	}

	@Override
	public int compareTo(ServiceBulletinProcedureLabor o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
