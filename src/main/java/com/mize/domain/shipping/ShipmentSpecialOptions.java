package com.mize.domain.shipping;

import com.mize.domain.common.MizeSceEntity;

public class ShipmentSpecialOptions extends MizeSceEntity implements Comparable<ShipmentSpecialOptions>{

	private static final long serialVersionUID = 7024994176092778875L;

	private String staturdayDelivery;
	private String pickUpAtUPSFacility;
	private String dropOfAtUPSFacility;
	private ShipmentHoldAtLocation holdAtLocation;
	private ShipmentEmailNotications emailNotications;
	private ShipmentCashOnDelivery cashOnDelivery;
	
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
	
	public String getStaturdayDelivery() {
		return staturdayDelivery;
	}

	public void setStaturdayDelivery(String staturdayDelivery) {
		this.staturdayDelivery = staturdayDelivery;
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

	public ShipmentEmailNotications getEmailNotications() {
		return emailNotications;
	}

	public void setEmailNotications(ShipmentEmailNotications emailNotications) {
		this.emailNotications = emailNotications;
	}

	public ShipmentCashOnDelivery getCashOnDelivery() {
		return cashOnDelivery;
	}

	public void setCashOnDelivery(ShipmentCashOnDelivery cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
	}

	@Override
	public int compareTo(ShipmentSpecialOptions o) {
		return 0;
	}
	
}
