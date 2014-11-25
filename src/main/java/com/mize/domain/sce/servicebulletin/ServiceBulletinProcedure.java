package com.mize.domain.sce.servicebulletin;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;

/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */

@Entity
@Table(name = "srvc_blltn_proc")
public class ServiceBulletinProcedure extends MizeSceEntity implements Comparable<ServiceBulletinProcedure> {
	
	private static final long serialVersionUID = -7125659097589369685L;
	
	private ServiceBulletin serviceBulletin;
	private String procedureCode;
	private String procedureReference;
	private String complaintCode;
	private String causeCode;
	private String correctiveActionCode;
	private List<ServiceBulletinProcedurePart> parts;
	private List<ServiceBulletinProcedureLabor> labors;
	private List<ServiceBulletinProcedureOther> otherCharges;
	private ServiceBulletinAmount partAmount;
	private ServiceBulletinAmount laborAmount;
	private ServiceBulletinAmount otherAmount;
	private ServiceBulletinAmount totalAmount;
	private List<ServiceBulletinProcedureIntl> procedureIntl = new ArrayList<ServiceBulletinProcedureIntl>();

	public ServiceBulletinProcedure() {
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blltn_id")
	@JsonBackReference(value="service_bulletin_procedures")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceBulletin getServiceBulletin() {
		return serviceBulletin;
	}

	public void setServiceBulletin(ServiceBulletin serviceBulletin) {
		this.serviceBulletin = serviceBulletin;
	}	
	
	@Column(name = "proc_code", length = 50)
	public String getProcedureCode() {
		return procedureCode;
	}

	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}
	
	@Column(name = "proc_reference", length = 100)
	public String getProcedureReference() {
		return procedureReference;
	}

	public void setProcedureReference(String procedureReference) {
		this.procedureReference = procedureReference;
	}
	
	@Column(name = "complaint_code", length = 100)
	public String getComplaintCode() {
		return complaintCode;
	}

	public void setComplaintCode(String complaintCode) {
		this.complaintCode = complaintCode;
	}
	
	@Column(name = "cause_code", length = 100)
	public String getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}
	
	@Column(name = "corrective_action_code", length = 50)
	public String getCorrectiveActionCode() {
		return correctiveActionCode;
	}

	public void setCorrectiveActionCode(String correctiveActionCode) {
		this.correctiveActionCode = correctiveActionCode;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceBulletinProcedure" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_procedure_parts")
	public List<ServiceBulletinProcedurePart> getParts() {
		return parts;
	}

	public void setParts(List<ServiceBulletinProcedurePart> parts) {
		this.parts = parts;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceBulletinProcedure" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_procedure_labors")
	public List<ServiceBulletinProcedureLabor> getLabors() {
		return labors;
	}

	public void setLabors(List<ServiceBulletinProcedureLabor> labors) {
		this.labors = labors;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceBulletinProcedure" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_procedure_otherCharges")
	public List<ServiceBulletinProcedureOther> getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(List<ServiceBulletinProcedureOther> otherCharges) {
		this.otherCharges = otherCharges;
	}	
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="part_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceBulletinAmount getPartAmount() {
		return partAmount;
	}

	public void setPartAmount(ServiceBulletinAmount partAmount) {
		this.partAmount = partAmount;
	}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="labor_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceBulletinAmount getLaborAmount() {
		return laborAmount;
	}

	public void setLaborAmount(ServiceBulletinAmount laborAmount) {
		this.laborAmount = laborAmount;
	}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="other_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceBulletinAmount getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(ServiceBulletinAmount otherAmount) {
		this.otherAmount = otherAmount;
	}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="total_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceBulletinAmount getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(ServiceBulletinAmount totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "serviceBulletinProcedure" ,orphanRemoval= true)
	@JsonManagedReference(value="serviceBulletinProcIntl")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ServiceBulletinProcedureIntl> getProcedureIntl() {
		return procedureIntl;
	}

	public void setProcedureIntl(List<ServiceBulletinProcedureIntl> procedureIntl) {
		this.procedureIntl = procedureIntl;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((causeCode == null) ? 0 : causeCode.hashCode());
		result = prime * result
				+ ((complaintCode == null) ? 0 : complaintCode.hashCode());
		result = prime
				* result
				+ ((correctiveActionCode == null) ? 0 : correctiveActionCode
						.hashCode());
		result = prime * result
				+ ((laborAmount == null) ? 0 : laborAmount.hashCode());
		result = prime * result + ((labors == null) ? 0 : labors.hashCode());
		result = prime * result
				+ ((otherAmount == null) ? 0 : otherAmount.hashCode());
		result = prime * result
				+ ((otherCharges == null) ? 0 : otherCharges.hashCode());
		result = prime * result
				+ ((partAmount == null) ? 0 : partAmount.hashCode());
		result = prime * result + ((parts == null) ? 0 : parts.hashCode());
		result = prime * result
				+ ((procedureCode == null) ? 0 : procedureCode.hashCode());
		result = prime * result
				+ ((procedureIntl == null) ? 0 : procedureIntl.hashCode());
		result = prime
				* result
				+ ((procedureReference == null) ? 0 : procedureReference
						.hashCode());
		result = prime * result
				+ ((totalAmount == null) ? 0 : totalAmount.hashCode());
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
		ServiceBulletinProcedure other = (ServiceBulletinProcedure) obj;
		if (causeCode == null) {
			if (other.causeCode != null)
				return false;
		} else if (!causeCode.equals(other.causeCode))
			return false;
		if (complaintCode == null) {
			if (other.complaintCode != null)
				return false;
		} else if (!complaintCode.equals(other.complaintCode))
			return false;
		if (correctiveActionCode == null) {
			if (other.correctiveActionCode != null)
				return false;
		} else if (!correctiveActionCode.equals(other.correctiveActionCode))
			return false;
		if (laborAmount == null) {
			if (other.laborAmount != null)
				return false;
		} else if (!laborAmount.equals(other.laborAmount))
			return false;
		if (labors == null) {
			if (other.labors != null)
				return false;
		} else if (!labors.equals(other.labors))
			return false;
		if (otherAmount == null) {
			if (other.otherAmount != null)
				return false;
		} else if (!otherAmount.equals(other.otherAmount))
			return false;
		if (otherCharges == null) {
			if (other.otherCharges != null)
				return false;
		} else if (!otherCharges.equals(other.otherCharges))
			return false;
		if (partAmount == null) {
			if (other.partAmount != null)
				return false;
		} else if (!partAmount.equals(other.partAmount))
			return false;
		if (parts == null) {
			if (other.parts != null)
				return false;
		} else if (!parts.equals(other.parts))
			return false;
		if (procedureCode == null) {
			if (other.procedureCode != null)
				return false;
		} else if (!procedureCode.equals(other.procedureCode))
			return false;
		if (procedureIntl == null) {
			if (other.procedureIntl != null)
				return false;
		} else if (!procedureIntl.equals(other.procedureIntl))
			return false;
		if (procedureReference == null) {
			if (other.procedureReference != null)
				return false;
		} else if (!procedureReference.equals(other.procedureReference))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceBulletinProcedure [procedureCode=" + procedureCode
				+ ", procedureReference=" + procedureReference
				+ ", complaintCode=" + complaintCode + ", causeCode="
				+ causeCode + ", correctiveActionCode=" + correctiveActionCode
				+ ", parts=" + parts + ", labors=" + labors + ", otherCharges="
				+ otherCharges + ", partAmount=" + partAmount
				+ ", laborAmount=" + laborAmount + ", otherAmount="
				+ otherAmount + ", totalAmount=" + totalAmount
				+ ", procedureIntl=" + procedureIntl + "]";
	}

	@Override
	public int compareTo(ServiceBulletinProcedure o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
