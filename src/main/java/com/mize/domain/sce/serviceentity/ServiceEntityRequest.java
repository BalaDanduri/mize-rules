package com.mize.domain.sce.serviceentity;

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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.CachedEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDate;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_rqst")
public class ServiceEntityRequest extends MizeSceEntity implements Comparable<ServiceEntityRequest> {

	private static final long serialVersionUID = -7125659097589369685L;

	private ServiceEntity serviceEntity;
	private String requestType;
	private String requestCode;
	private MizeDate failureDate;
	private MizeDate repairDate;
	private String repairSiteCode;
	private String complaintCode;
	private String complaintDescription;
	private String causeCode;
	private String causeDescription;
	private String correctiveActionCode;
	private String correctiveActionDescription;
	private List<ServiceEntityRequestPart> parts;
	private List<ServiceEntityRequestLabor> labors;
	private List<ServiceEntityRequestOther> otherCharges;
	@CachedEntity
	private ServiceEntityRequestProduct product;
	private ServiceEntityRequestCoverage coverage;
	private ServiceEntityAmount partAmount;
	private ServiceEntityAmount laborAmount;
	private ServiceEntityAmount otherAmount;
	private ServiceEntityAmount totalAmount;

	private MizeDate requestedDate;
	private MizeDate promisedDate;
	private MizeDate resolvedDate;
	private String requestStatus;
	private String priority;

	public ServiceEntityRequest() {

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_entity_id")
	@JsonBackReference(value = "service_entity_request")
	@JsonSerialize(using = JPASerializer.class)
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}

	@Column(name = "request_type")
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Column(name = "request_code")
	public String getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}

	@Column(name = "failure_date")
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getFailureDate() {
		return failureDate;
	}

	public void setFailureDate(MizeDate failureDate) {
		this.failureDate = failureDate;
	}

	@Column(name = "repair_date")
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(MizeDate repairDate) {
		this.repairDate = repairDate;
	}

	@Column(name = "repair_site_code")
	public String getRepairSiteCode() {
		return repairSiteCode;
	}

	public void setRepairSiteCode(String repairSiteCode) {
		this.repairSiteCode = repairSiteCode;
	}

	@Column(name = "complaint_code")
	public String getComplaintCode() {
		return complaintCode;
	}

	public void setComplaintCode(String complaintCode) {
		this.complaintCode = complaintCode;
	}

	@Column(name = "complaint_descr")
	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	@Column(name = "cause_code")
	public String getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}

	@Column(name = "cause_descr")
	public String getCauseDescription() {
		return causeDescription;
	}

	public void setCauseDescription(String causeDescription) {
		this.causeDescription = causeDescription;
	}

	@Column(name = "corrective_action_code")
	public String getCorrectiveActionCode() {
		return correctiveActionCode;
	}

	public void setCorrectiveActionCode(String correctiveActionCode) {
		this.correctiveActionCode = correctiveActionCode;
	}

	@Column(name = "corrective_action_descr")
	public String getCorrectiveActionDescription() {
		return correctiveActionDescription;
	}

	public void setCorrectiveActionDescription(String correctiveActionDescription) {
		this.correctiveActionDescription = correctiveActionDescription;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "serviceEntityRequest", orphanRemoval = true)
	@JsonSerialize(using = JPASerializer.class)
	@JsonManagedReference(value = "service_request_parts")
	public List<ServiceEntityRequestPart> getParts() {
		return parts;
	}

	public void setParts(List<ServiceEntityRequestPart> parts) {
		this.parts = parts;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "serviceEntityRequest", orphanRemoval = true)
	@JsonSerialize(using = JPASerializer.class)
	@JsonManagedReference(value = "service_request_labors")
	public List<ServiceEntityRequestLabor> getLabors() {
		return labors;
	}

	public void setLabors(List<ServiceEntityRequestLabor> labors) {
		this.labors = labors;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "serviceEntityRequest", orphanRemoval = true)
	@JsonSerialize(using = JPASerializer.class)
	@JsonManagedReference(value = "service_request_otherCharges")
	public List<ServiceEntityRequestOther> getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(List<ServiceEntityRequestOther> otherCharges) {
		this.otherCharges = otherCharges;
	}

	@OneToOne(mappedBy = "serviceEntityRequest", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "service_request_product")
	@JsonSerialize(using = JPASerializer.class)
	public ServiceEntityRequestProduct getProduct() {
		return product;
	}

	public void setProduct(ServiceEntityRequestProduct product) {
		this.product = product;
	}

	@OneToOne(mappedBy = "serviceEntityRequest", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "service_request_coverage")
	@JsonSerialize(using = JPASerializer.class)
	public ServiceEntityRequestCoverage getCoverage() {
		return coverage;
	}

	public void setCoverage(ServiceEntityRequestCoverage coverage) {
		this.coverage = coverage;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "part_amount_id")
	@JsonSerialize(using = JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceEntityAmount getPartAmount() {
		return partAmount;
	}

	public void setPartAmount(ServiceEntityAmount partAmount) {
		this.partAmount = partAmount;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "labor_amount_id")
	@JsonSerialize(using = JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceEntityAmount getLaborAmount() {
		return laborAmount;
	}

	public void setLaborAmount(ServiceEntityAmount laborAmount) {
		this.laborAmount = laborAmount;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "other_amount_id")
	@JsonSerialize(using = JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceEntityAmount getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(ServiceEntityAmount otherAmount) {
		this.otherAmount = otherAmount;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "total_amount_id")
	@JsonSerialize(using = JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceEntityAmount getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(ServiceEntityAmount totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "srvc_requested_date")
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(MizeDate requestedDate) {
		this.requestedDate = requestedDate;
	}

	@Column(name = "srvc_promised_date")
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getPromisedDate() {
		return promisedDate;
	}

	public void setPromisedDate(MizeDate promisedDate) {
		this.promisedDate = promisedDate;
	}

	@Column(name = "srvc_resolved_date")
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(MizeDate resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	@Column(name = "srvc_request_status")
	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	@Column(name = "srvc_priority")
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((causeCode == null) ? 0 : causeCode.hashCode());
		result = prime * result + ((causeDescription == null) ? 0 : causeDescription.hashCode());
		result = prime * result + ((complaintCode == null) ? 0 : complaintCode.hashCode());
		result = prime * result + ((complaintDescription == null) ? 0 : complaintDescription.hashCode());
		result = prime * result + ((correctiveActionCode == null) ? 0 : correctiveActionCode.hashCode());
		result = prime * result + ((correctiveActionDescription == null) ? 0 : correctiveActionDescription.hashCode());
		result = prime * result + ((coverage == null) ? 0 : coverage.hashCode());
		result = prime * result + ((failureDate == null) ? 0 : failureDate.hashCode());
		result = prime * result + ((laborAmount == null) ? 0 : laborAmount.hashCode());
		result = prime * result + ((labors == null) ? 0 : labors.hashCode());
		result = prime * result + ((otherAmount == null) ? 0 : otherAmount.hashCode());
		result = prime * result + ((otherCharges == null) ? 0 : otherCharges.hashCode());
		result = prime * result + ((partAmount == null) ? 0 : partAmount.hashCode());
		result = prime * result + ((parts == null) ? 0 : parts.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((repairDate == null) ? 0 : repairDate.hashCode());
		result = prime * result + ((repairSiteCode == null) ? 0 : repairSiteCode.hashCode());
		result = prime * result + ((requestCode == null) ? 0 : requestCode.hashCode());
		result = prime * result + ((requestType == null) ? 0 : requestType.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
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
		ServiceEntityRequest other = (ServiceEntityRequest) obj;
		if (causeCode == null) {
			if (other.causeCode != null)
				return false;
		} else if (!causeCode.equals(other.causeCode))
			return false;
		if (causeDescription == null) {
			if (other.causeDescription != null)
				return false;
		} else if (!causeDescription.equals(other.causeDescription))
			return false;
		if (complaintCode == null) {
			if (other.complaintCode != null)
				return false;
		} else if (!complaintCode.equals(other.complaintCode))
			return false;
		if (complaintDescription == null) {
			if (other.complaintDescription != null)
				return false;
		} else if (!complaintDescription.equals(other.complaintDescription))
			return false;
		if (correctiveActionCode == null) {
			if (other.correctiveActionCode != null)
				return false;
		} else if (!correctiveActionCode.equals(other.correctiveActionCode))
			return false;
		if (correctiveActionDescription == null) {
			if (other.correctiveActionDescription != null)
				return false;
		} else if (!correctiveActionDescription.equals(other.correctiveActionDescription))
			return false;
		if (coverage == null) {
			if (other.coverage != null)
				return false;
		} else if (!coverage.equals(other.coverage))
			return false;
		if (failureDate == null) {
			if (other.failureDate != null)
				return false;
		} else if (!failureDate.equals(other.failureDate))
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
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (repairDate == null) {
			if (other.repairDate != null)
				return false;
		} else if (!repairDate.equals(other.repairDate))
			return false;
		if (repairSiteCode == null) {
			if (other.repairSiteCode != null)
				return false;
		} else if (!repairSiteCode.equals(other.repairSiteCode))
			return false;
		if (requestCode == null) {
			if (other.requestCode != null)
				return false;
		} else if (!requestCode.equals(other.requestCode))
			return false;
		if (requestType == null) {
			if (other.requestType != null)
				return false;
		} else if (!requestType.equals(other.requestType))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		return true;
	}

	@Override
	public int compareTo(ServiceEntityRequest o) {
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceEntityRequest [");
		builder.append("requestType=").append(requestType);
		builder.append(", requestCode=").append(requestCode);
		builder.append(", failureDate=").append(failureDate);
		builder.append(", repairDate=").append(repairDate);
		builder.append(", repairSiteCode=").append(repairSiteCode);
		builder.append(", complaintCode=").append(complaintCode);
		builder.append(", complaintDescription=").append(complaintDescription);
		builder.append(", causeDescription=").append(causeDescription);
		builder.append(", correctiveActionCode=").append(correctiveActionCode);
		builder.append(", correctiveActionDescription=").append(correctiveActionDescription);
		builder.append(", parts=").append(parts);
		builder.append(", labors=").append(labors);
		builder.append(", otherCharges=").append(otherCharges);
		builder.append(", product=").append(product);
		builder.append(", otherCharges=").append(otherCharges);
		builder.append(", coverage=").append(coverage);
		builder.append(", partAmount=").append(partAmount);
		builder.append(", laborAmount=").append(laborAmount);
		builder.append(", otherAmount=").append(otherAmount);
		builder.append(", totalAmount=").append(totalAmount);
		builder.append("]");
		return builder.toString();
	}

}
