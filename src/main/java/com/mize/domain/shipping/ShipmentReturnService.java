package com.mize.domain.shipping;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.Date;

public class ShipmentReturnService extends MizeSceEntity implements Comparable<ShipmentReturnService>{
	
	private static final long serialVersionUID = -350317419410443313L;
	private Date shippingDate;
	private String returnType;
	private String reason;
	private List<SpecialServiceCode>  specialServiceCodes = new ArrayList<SpecialServiceCode>();
	
	public ShipmentReturnService() {
		super();
	}
	
	public ShipmentReturnService(Date shippingDate,String returnType, String reason) {
		super();
		this.shippingDate = shippingDate;
		this.returnType = returnType;
		this.reason = reason;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@JsonInclude(Include.NON_DEFAULT)
	public List<SpecialServiceCode> getSpecialServiceCodes() {
		return specialServiceCodes;
	}
	public void setSpecialServiceCodes(List<SpecialServiceCode> specialServiceCodes) {
		this.specialServiceCodes = specialServiceCodes;
	}

	@Override
	public int compareTo(ShipmentReturnService o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result
				+ ((returnType == null) ? 0 : returnType.hashCode());
		result = prime * result
				+ ((shippingDate == null) ? 0 : shippingDate.hashCode());
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
		ShipmentReturnService other = (ShipmentReturnService) obj;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (returnType == null) {
			if (other.returnType != null)
				return false;
		} else if (!returnType.equals(other.returnType))
			return false;
		if (shippingDate == null) {
			if (other.shippingDate != null)
				return false;
		} else if (!shippingDate.equals(other.shippingDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShipmentReturnService [shippingDate=" + shippingDate
				+ ", returnType=" + returnType + ", reason=" + reason
				+ ", specialServiceCodes=" + specialServiceCodes + "]";
	}
	
	

}
