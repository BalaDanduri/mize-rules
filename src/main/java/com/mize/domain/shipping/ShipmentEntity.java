package com.mize.domain.shipping;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;

public class ShipmentEntity extends MizeSceEntity implements Comparable<ShipmentEntity>{
	
	private static final long serialVersionUID = -3279332499661281505L;	
	private String requestType;
	private String orderType;
	private String orderReference;
	private String status;
	private String paymentReference;
	private String paymentMethod;
	private BusinessEntity businessEntity;
	
	public ShipmentEntity(){		
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderReference() {
		return orderReference;
	}
	public void setOrderReference(String orderReference) {
		this.orderReference = orderReference;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}
	
	@Override
	public String toString() {
		return "ShipmentEntity [requestType=" + requestType + ", orderType="
				+ orderType + ", orderReference=" + orderReference
				+ ", status=" + status + ", paymentReference="
				+ paymentReference + ", paymentMethod=" + paymentMethod + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((orderReference == null) ? 0 : orderReference.hashCode());
		result = prime * result
				+ ((orderType == null) ? 0 : orderType.hashCode());
		result = prime * result
				+ ((requestType == null) ? 0 : requestType.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ShipmentEntity other = (ShipmentEntity) obj;
		if (orderReference == null) {
			if (other.orderReference != null)
				return false;
		} else if (!orderReference.equals(other.orderReference))
			return false;
		if (orderType == null) {
			if (other.orderType != null)
				return false;
		} else if (!orderType.equals(other.orderType))
			return false;
		if (requestType == null) {
			if (other.requestType != null)
				return false;
		} else if (!requestType.equals(other.requestType))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public int compareTo(ShipmentEntity o) {
		return 0;
	}		
}
