package com.mize.domain.shipping;

import com.mize.domain.common.MizeSceEntity;

public class ShipmentSpecialOptions extends MizeSceEntity implements Comparable<ShipmentSpecialOptions>{

	private static final long serialVersionUID = 7024994176092778875L;

	private String saturdayDelivery;
	private String saturdayPickup;
	private String pickUpAtUPSFacility;
	private String dropOfAtUPSFacility;
	private ShipmentHoldAtLocation holdAtLocation;
	private ShipmentEmailNotifications emailNotifications;
	private ShipmentCashOnDelivery cashOnDelivery;
	private ShipmentReturnService returnService;
	
	public ShipmentSpecialOptions() {
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
	
	public String getSaturdayDelivery() {
		return saturdayDelivery;
	}

	public void setSaturdayDelivery(String saturdayDelivery) {
		this.saturdayDelivery = saturdayDelivery;
	}
	
	public String getSaturdayPickup() {
		return saturdayPickup;
	}

	public void setSaturdayPickup(String saturdayPickup) {
		this.saturdayPickup = saturdayPickup;
	}

	public String getPickUpAtUPSFacility() {
		return pickUpAtUPSFacility;
	}

	public void setPickUpAtUPSFacility(String pickUpAtUPSFacility) {
		this.pickUpAtUPSFacility = pickUpAtUPSFacility;
	}

	public String getDropOfAtUPSFacility() {
		return dropOfAtUPSFacility;
	}

	public void setDropOfAtUPSFacility(String dropOfAtUPSFacility) {
		this.dropOfAtUPSFacility = dropOfAtUPSFacility;
	}

	public ShipmentHoldAtLocation getHoldAtLocation() {
		return holdAtLocation;
	}

	public void setHoldAtLocation(ShipmentHoldAtLocation holdAtLocation) {
		this.holdAtLocation = holdAtLocation;
	}

	public ShipmentEmailNotifications getEmailNotifications() {
		return emailNotifications;
	}

	public void setEmailNotifications(ShipmentEmailNotifications emailNotifications) {
		this.emailNotifications = emailNotifications;
	}

	public ShipmentCashOnDelivery getCashOnDelivery() {
		return cashOnDelivery;
	}

	public void setCashOnDelivery(ShipmentCashOnDelivery cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
	}
	
	public ShipmentReturnService getReturnService() {
		return returnService;
	}

	public void setReturnService(ShipmentReturnService returnService) {
		this.returnService = returnService;
	}

	
	@Override
	public int compareTo(ShipmentSpecialOptions o) {
		return 0;
	}

	@Override
	public String toString() {
		return "ShipmentSpecialOptions [saturdayDelivery=" + saturdayDelivery
				+ ", saturdayPickup=" + saturdayPickup
				+ ", pickUpAtUPSFacility=" + pickUpAtUPSFacility
				+ ", dropOfAtUPSFacility=" + dropOfAtUPSFacility
				+ ", holdAtLocation=" + holdAtLocation
				+ ", emailNotifications=" + emailNotifications
				+ ", cashOnDelivery=" + cashOnDelivery + ", returnService="
				+ returnService + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((cashOnDelivery == null) ? 0 : cashOnDelivery.hashCode());
		result = prime
				* result
				+ ((dropOfAtUPSFacility == null) ? 0 : dropOfAtUPSFacility
						.hashCode());
		result = prime
				* result
				+ ((emailNotifications == null) ? 0 : emailNotifications
						.hashCode());
		result = prime * result
				+ ((holdAtLocation == null) ? 0 : holdAtLocation.hashCode());
		result = prime
				* result
				+ ((pickUpAtUPSFacility == null) ? 0 : pickUpAtUPSFacility
						.hashCode());
		result = prime * result
				+ ((returnService == null) ? 0 : returnService.hashCode());
		result = prime
				* result
				+ ((saturdayDelivery == null) ? 0 : saturdayDelivery.hashCode());
		result = prime * result
				+ ((saturdayPickup == null) ? 0 : saturdayPickup.hashCode());
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
		ShipmentSpecialOptions other = (ShipmentSpecialOptions) obj;
		if (cashOnDelivery == null) {
			if (other.cashOnDelivery != null)
				return false;
		} else if (!cashOnDelivery.equals(other.cashOnDelivery))
			return false;
		if (dropOfAtUPSFacility == null) {
			if (other.dropOfAtUPSFacility != null)
				return false;
		} else if (!dropOfAtUPSFacility.equals(other.dropOfAtUPSFacility))
			return false;
		if (emailNotifications == null) {
			if (other.emailNotifications != null)
				return false;
		} else if (!emailNotifications.equals(other.emailNotifications))
			return false;
		if (holdAtLocation == null) {
			if (other.holdAtLocation != null)
				return false;
		} else if (!holdAtLocation.equals(other.holdAtLocation))
			return false;
		if (pickUpAtUPSFacility == null) {
			if (other.pickUpAtUPSFacility != null)
				return false;
		} else if (!pickUpAtUPSFacility.equals(other.pickUpAtUPSFacility))
			return false;
		if (returnService == null) {
			if (other.returnService != null)
				return false;
		} else if (!returnService.equals(other.returnService))
			return false;
		if (saturdayDelivery == null) {
			if (other.saturdayDelivery != null)
				return false;
		} else if (!saturdayDelivery.equals(other.saturdayDelivery))
			return false;
		if (saturdayPickup == null) {
			if (other.saturdayPickup != null)
				return false;
		} else if (!saturdayPickup.equals(other.saturdayPickup))
			return false;
		return true;
	}
	
}
