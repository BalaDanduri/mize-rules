package com.mize.domain.partsOrder;

import java.beans.Transient;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.servicelocator.BusinessEntity;

@Entity
public class PartsOrderPayment extends MizeEntity implements Comparable<PartsOrderPayment>{	

	private static final long serialVersionUID = 261638805962518728L;	
	private Long orderId;
	private BusinessEntity businessEntity;
	private EntityAddress address;
	private String method;
	private PartsOrder partsOrder;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}
	
	@Transient
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	public EntityAddress getAddress() {
		return address;
	}

	public void setAddress(EntityAddress address) {
		this.address = address;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	public PartsOrder getPartsOrder() {
		return partsOrder;
	}

	public void setPartsOrder(PartsOrder partsOrder) {
		this.partsOrder = partsOrder;
	}	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		PartsOrderPayment other = (PartsOrderPayment) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartsOrderPayment [orderId=" + orderId + ", address=" + address
				+ ", method=" + method + "]";
	}

	@Override
	public int compareTo(PartsOrderPayment o) {
		return 0;
	}

}
