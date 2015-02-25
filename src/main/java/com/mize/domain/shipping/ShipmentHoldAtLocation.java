package com.mize.domain.shipping;

import com.mize.domain.common.MizeSceEntity;

public class ShipmentHoldAtLocation extends MizeSceEntity implements Comparable<ShipmentHoldAtLocation>{

	private static final long serialVersionUID = 7024994176092778875L;
	
	private String customerPhone;
	private String locationType;
	
	public ShipmentHoldAtLocation() {
		super();
	}
	
	public ShipmentHoldAtLocation(String customerPhone, String locationType) {
		super();
		this.customerPhone = customerPhone;
		this.locationType = locationType;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	@Override
	public int compareTo(ShipmentHoldAtLocation o) {
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((customerPhone == null) ? 0 : customerPhone.hashCode());
		result = prime * result
				+ ((locationType == null) ? 0 : locationType.hashCode());
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
		ShipmentHoldAtLocation other = (ShipmentHoldAtLocation) obj;
		if (customerPhone == null) {
			if (other.customerPhone != null)
				return false;
		} else if (!customerPhone.equals(other.customerPhone))
			return false;
		if (locationType == null) {
			if (other.locationType != null)
				return false;
		} else if (!locationType.equals(other.locationType))
			return false;
		return true;
	}
	
	
	
}
