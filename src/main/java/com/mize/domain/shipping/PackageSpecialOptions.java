package com.mize.domain.shipping;

import com.mize.domain.common.MizeSceEntity;

public class PackageSpecialOptions extends MizeSceEntity implements Comparable<PackageSpecialOptions>{

	private static final long serialVersionUID = -7225407340276787225L;

	private String deliveryConfirmation;
	private ShipmentReturnService returnService;
	private ShipmentCashOnDelivery cashOnDelivery;
	
	public PackageSpecialOptions() {
		super();
	}
	
	public PackageSpecialOptions(String deliveryConfirmation) {
		super();
		this.deliveryConfirmation = deliveryConfirmation;
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
