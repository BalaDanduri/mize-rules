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
	
}
