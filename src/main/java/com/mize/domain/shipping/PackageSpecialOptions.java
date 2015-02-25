package com.mize.domain.shipping;

import com.mize.domain.common.MizeSceEntity;

public class PackageSpecialOptions extends MizeSceEntity implements Comparable<PackageSpecialOptions>{

	private static final long serialVersionUID = -7225407340276787225L;

	private String deliveryConfirmation;
	private String saturdayDelivery;
	private String saturdayPickup;
	private ShipmentReturnService returnService;
	private ShipmentCashOnDelivery cashOnDelivery;
	
	public PackageSpecialOptions() {
		super();
	}
	
	public PackageSpecialOptions(String deliveryConfirmation, String saturdayDelivery, String saturdayPickup) {
		super();
		this.deliveryConfirmation = deliveryConfirmation;
		this.saturdayDelivery = saturdayDelivery;
		this.saturdayPickup = saturdayPickup;
	}


	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getDeliveryConfirmation() {
		return deliveryConfirmation;
	}

	public void setDeliveryConfirmation(String deliveryConfirmation) {
		this.deliveryConfirmation = deliveryConfirmation;
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

	public ShipmentReturnService getReturnService() {
		return returnService;
	}

	public void setReturnService(ShipmentReturnService returnService) {
		this.returnService = returnService;
	}

	public ShipmentCashOnDelivery getCashOnDelivery() {
		return cashOnDelivery;
	}

	public void setCashOnDelivery(ShipmentCashOnDelivery cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
	}

	@Override
	public int compareTo(PackageSpecialOptions o) {
		return 0;
	}
	
	
}
