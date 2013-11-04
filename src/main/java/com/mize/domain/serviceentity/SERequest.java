package com.mize.domain.serviceentity;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.ProductRegister;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class SERequest extends MizeEntity implements Comparable<SERequest> {

	private static final long serialVersionUID = 6821133638967617947L;
	private String entityId;
	private String type;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime failureDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime repairDate;
	private Long prodId;
	private Long contractId;
	private ProductRegister productRegister;
	private String repairSiteCode;
	private String coverageCode;
	private String coverageDesc;
	private Long coverageId;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime coverageEndDate;
	private String complaintCode;
	private String complaintDesc;
	private String causeCode;
	private String causeDesc;
	private String correctiveActionCode;
	private String correctiveActionDesc;
	private SEAmount partAmount = new SEAmount();
	private SEAmount laborAmount = new SEAmount();
	private SEAmount otherAmount = new SEAmount();
	private SEAmount totalAmount = new SEAmount();
	private List<SEPart> parts = new ArrayList<SEPart>();
	private List<SELabor> labors = new ArrayList<SELabor>();
	private List<SEOtherCharges> othersCharges = new ArrayList<SEOtherCharges>();
	
	public SERequest() {
		super();
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getFailureDate() {
		return failureDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setFailureDate(DateTime failureDate) {
		this.failureDate = failureDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getRepairDate() {
		return repairDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setRepairDate(DateTime repairDate) {
		this.repairDate = repairDate;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public ProductRegister getProductRegister() {
		return productRegister;
	}

	public void setProductRegister(ProductRegister productRegister) {
		this.productRegister = productRegister;
	}

	public String getRepairSiteCode() {
		return repairSiteCode;
	}

	public void setRepairSiteCode(String repairSiteCode) {
		this.repairSiteCode = repairSiteCode;
	}

	public String getCoverageCode() {
		return coverageCode;
	}

	public void setCoverageCode(String coverageCode) {
		this.coverageCode = coverageCode;
	}

	public String getCoverageDesc() {
		return coverageDesc;
	}

	public void setCoverageDesc(String coverageDesc) {
		this.coverageDesc = coverageDesc;
	}

	public Long getCoverageId() {
		return coverageId;
	}

	public void setCoverageId(Long coverageId) {
		this.coverageId = coverageId;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getCoverageEndDate() {
		return coverageEndDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setCoverageEndDate(DateTime coverageEndDate) {
		this.coverageEndDate = coverageEndDate;
	}

	public String getComplaintCode() {
		return complaintCode;
	}

	public void setComplaintCode(String complaintCode) {
		this.complaintCode = complaintCode;
	}

	public String getComplaintDesc() {
		return complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}

	public String getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}

	public String getCauseDesc() {
		return causeDesc;
	}

	public void setCauseDesc(String causeDesc) {
		this.causeDesc = causeDesc;
	}

	public String getCorrectiveActionCode() {
		return correctiveActionCode;
	}

	public void setCorrectiveActionCode(String correctiveActionCode) {
		this.correctiveActionCode = correctiveActionCode;
	}

	public String getCorrectiveActionDesc() {
		return correctiveActionDesc;
	}

	public void setCorrectiveActionDesc(String correctiveActionDesc) {
		this.correctiveActionDesc = correctiveActionDesc;
	}

	public SEAmount getPartAmount() {
		return partAmount;
	}

	public void setPartAmount(SEAmount partAmount) {
		this.partAmount = partAmount;
	}

	public SEAmount getLaborAmount() {
		return laborAmount;
	}

	public void setLaborAmount(SEAmount laborAmount) {
		this.laborAmount = laborAmount;
	}

	public SEAmount getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(SEAmount otherAmount) {
		this.otherAmount = otherAmount;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore(value=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore(value=false)
	public Long getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public SEAmount getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(SEAmount totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<SEPart> getParts() {
		return parts;
	}

	public void setParts(List<SEPart> parts) {
		this.parts = parts;
	}

	public List<SELabor> getLabors() {
		return labors;
	}

	public void setLabors(List<SELabor> labors) {
		this.labors = labors;
	}

	public List<SEOtherCharges> getOthersCharges() {
		return othersCharges;
	}

	public void setOthersCharges(List<SEOtherCharges> othersCharges) {
		this.othersCharges = othersCharges;
	}

	@Override
	public String toString() {
		return "SERequest [entityId=" + entityId + ", type=" + type
				+ ", failureDate=" + failureDate + ", repairDate=" + repairDate
				+ ", prodId=" + prodId + ", contractId=" + contractId
				+ ", productRegister=" + productRegister + ", repairSiteCode="
				+ repairSiteCode + ", coverageCode=" + coverageCode
				+ ", coverageDesc=" + coverageDesc + ", coverageId="
				+ coverageId + ", coverageEndDate=" + coverageEndDate
				+ ", complaintCode=" + complaintCode + ", complaintDesc="
				+ complaintDesc + ", causeCode=" + causeCode + ", causeDesc="
				+ causeDesc + ", correctiveActionCode=" + correctiveActionCode
				+ ", correctiveActionDesc=" + correctiveActionDesc
				+ ", partAmount=" + partAmount + ", laborAmount=" + laborAmount
				+ ", otherAmount=" + otherAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((causeCode == null) ? 0 : causeCode.hashCode());
		result = prime * result
				+ ((causeDesc == null) ? 0 : causeDesc.hashCode());
		result = prime * result
				+ ((complaintCode == null) ? 0 : complaintCode.hashCode());
		result = prime * result
				+ ((complaintDesc == null) ? 0 : complaintDesc.hashCode());
		result = prime * result
				+ ((contractId == null) ? 0 : contractId.hashCode());
		result = prime
				* result
				+ ((correctiveActionCode == null) ? 0 : correctiveActionCode
						.hashCode());
		result = prime
				* result
				+ ((correctiveActionDesc == null) ? 0 : correctiveActionDesc
						.hashCode());
		result = prime * result
				+ ((coverageCode == null) ? 0 : coverageCode.hashCode());
		result = prime * result
				+ ((coverageDesc == null) ? 0 : coverageDesc.hashCode());
		result = prime * result
				+ ((coverageEndDate == null) ? 0 : coverageEndDate.hashCode());
		result = prime * result
				+ ((coverageId == null) ? 0 : coverageId.hashCode());
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result
				+ ((failureDate == null) ? 0 : failureDate.hashCode());
		result = prime * result
				+ ((laborAmount == null) ? 0 : laborAmount.hashCode());
		result = prime * result
				+ ((otherAmount == null) ? 0 : otherAmount.hashCode());
		result = prime * result
				+ ((partAmount == null) ? 0 : partAmount.hashCode());
		result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
		result = prime * result
				+ ((productRegister == null) ? 0 : productRegister.hashCode());
		result = prime * result
				+ ((repairDate == null) ? 0 : repairDate.hashCode());
		result = prime * result
				+ ((repairSiteCode == null) ? 0 : repairSiteCode.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SERequest other = (SERequest) obj;
		if (causeCode == null) {
			if (other.causeCode != null)
				return false;
		} else if (!causeCode.equals(other.causeCode))
			return false;
		if (causeDesc == null) {
			if (other.causeDesc != null)
				return false;
		} else if (!causeDesc.equals(other.causeDesc))
			return false;
		if (complaintCode == null) {
			if (other.complaintCode != null)
				return false;
		} else if (!complaintCode.equals(other.complaintCode))
			return false;
		if (complaintDesc == null) {
			if (other.complaintDesc != null)
				return false;
		} else if (!complaintDesc.equals(other.complaintDesc))
			return false;
		if (contractId == null) {
			if (other.contractId != null)
				return false;
		} else if (!contractId.equals(other.contractId))
			return false;
		if (correctiveActionCode == null) {
			if (other.correctiveActionCode != null)
				return false;
		} else if (!correctiveActionCode.equals(other.correctiveActionCode))
			return false;
		if (correctiveActionDesc == null) {
			if (other.correctiveActionDesc != null)
				return false;
		} else if (!correctiveActionDesc.equals(other.correctiveActionDesc))
			return false;
		if (coverageCode == null) {
			if (other.coverageCode != null)
				return false;
		} else if (!coverageCode.equals(other.coverageCode))
			return false;
		if (coverageDesc == null) {
			if (other.coverageDesc != null)
				return false;
		} else if (!coverageDesc.equals(other.coverageDesc))
			return false;
		if (coverageEndDate == null) {
			if (other.coverageEndDate != null)
				return false;
		} else if (!coverageEndDate.equals(other.coverageEndDate))
			return false;
		if (coverageId == null) {
			if (other.coverageId != null)
				return false;
		} else if (!coverageId.equals(other.coverageId))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
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
		if (otherAmount == null) {
			if (other.otherAmount != null)
				return false;
		} else if (!otherAmount.equals(other.otherAmount))
			return false;
		if (partAmount == null) {
			if (other.partAmount != null)
				return false;
		} else if (!partAmount.equals(other.partAmount))
			return false;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		if (productRegister == null) {
			if (other.productRegister != null)
				return false;
		} else if (!productRegister.equals(other.productRegister))
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int compareTo(SERequest arg0) {
		return 0;
	}	

}