package com.mize.domain.purchaseorder;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

public class OriginalOrder extends MizeSceEntity implements Comparable<OriginalOrder>{
	
	private static final long serialVersionUID = 34019502927801711L;
	private String number;
	private String status;
	private String type;
	private String requestType;
	private boolean isValidCombination;
	private String isReturnable;
	private String returnReason;
	private BigDecimal requestedQuantity;
	
	public OriginalOrder(){
		super();
	}
	
	public OriginalOrder(Long id,String number, String status, String type,	String requestType,MizeDateTime createdDate,MizeDateTime updatedDate,BigDecimal requestedQuantity,String returnReason) {
		super();
		this.id = id;
		this.number = number;
		this.status = status;
		this.type = type;
		this.requestType = requestType;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.requestedQuantity = requestedQuantity;
		this.returnReason = returnReason;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	@JsonIgnore(value=false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
		
	@JsonIgnore(value=false)
	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isValidCombination() {
		return isValidCombination;
	}

	public void setValidCombination(boolean isValidCombination) {
		this.isValidCombination = isValidCombination;
	}

	public String getIsReturnable() {
		return isReturnable;
	}

	public void setIsReturnable(String isReturnable) {
		this.isReturnable = isReturnable;
	}

	public BigDecimal getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(BigDecimal requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}

	@Override
	public String toString() {
		return "OriginalOrder [number=" + number + ", status=" + status
				+ ", type=" + type + ", requestType=" + requestType
				+ ", isValidCombination=" + isValidCombination
				+ ", isReturnable=" + isReturnable + ", returnReason="
				+ returnReason + ", requestedQuantity=" + requestedQuantity
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((isReturnable == null) ? 0 : isReturnable.hashCode());
		result = prime * result + (isValidCombination ? 1231 : 1237);
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((requestType == null) ? 0 : requestType.hashCode());
		result = prime
				* result
				+ ((requestedQuantity == null) ? 0 : requestedQuantity
						.hashCode());
		result = prime * result
				+ ((returnReason == null) ? 0 : returnReason.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		OriginalOrder other = (OriginalOrder) obj;
		if (isReturnable == null) {
			if (other.isReturnable != null)
				return false;
		} else if (!isReturnable.equals(other.isReturnable))
			return false;
		if (isValidCombination != other.isValidCombination)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (requestType == null) {
			if (other.requestType != null)
				return false;
		} else if (!requestType.equals(other.requestType))
			return false;
		if (requestedQuantity == null) {
			if (other.requestedQuantity != null)
				return false;
		} else if (!requestedQuantity.equals(other.requestedQuantity))
			return false;
		if (returnReason == null) {
			if (other.returnReason != null)
				return false;
		} else if (!returnReason.equals(other.returnReason))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int compareTo(OriginalOrder o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
