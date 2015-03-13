package com.mize.domain.shipping;

import java.math.BigDecimal;

import com.mize.domain.common.MizeSceEntity;

public class PackageSpecialOptions extends MizeSceEntity implements Comparable<PackageSpecialOptions>{

	private static final long serialVersionUID = -7225407340276787225L;

	private String deliveryConfirmation;
	private BigDecimal declaredValue;	
	private ShipmentReturnService returnService;
	private ShipmentCashOnDelivery cashOnDelivery;
	
	public PackageSpecialOptions() {
		super();
	}
	
	public PackageSpecialOptions(String deliveryConfirmation, BigDecimal declaredValue) {
		super();
		this.deliveryConfirmation = deliveryConfirmation;
		this.declaredValue = declaredValue;
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

	public BigDecimal getDeclaredValue() {
		return declaredValue;
	}

	public void setDeclaredValue(BigDecimal declaredValue) {
		this.declaredValue = declaredValue;
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

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((cashOnDelivery == null) ? 0 : cashOnDelivery.hashCode());
		result = prime * result
				+ ((declaredValue == null) ? 0 : declaredValue.hashCode());
		result = prime
				* result
				+ ((deliveryConfirmation == null) ? 0 : deliveryConfirmation
						.hashCode());
		result = prime * result
				+ ((returnService == null) ? 0 : returnService.hashCode());
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
		PackageSpecialOptions other = (PackageSpecialOptions) obj;
		if (cashOnDelivery == null) {
			if (other.cashOnDelivery != null)
				return false;
		} else if (!cashOnDelivery.equals(other.cashOnDelivery))
			return false;
		if (declaredValue == null) {
			if (other.declaredValue != null)
				return false;
		} else if (!declaredValue.equals(other.declaredValue))
			return false;
		if (deliveryConfirmation == null) {
			if (other.deliveryConfirmation != null)
				return false;
		} else if (!deliveryConfirmation.equals(other.deliveryConfirmation))
			return false;
		if (returnService == null) {
			if (other.returnService != null)
				return false;
		} else if (!returnService.equals(other.returnService))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PackageSpecialOptions [deliveryConfirmation="
				+ deliveryConfirmation + ", declaredValue=" + declaredValue
				+ ", returnService=" + returnService + ", cashOnDelivery="
				+ cashOnDelivery + "]";
	}

}
