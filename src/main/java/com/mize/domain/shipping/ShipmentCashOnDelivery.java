package com.mize.domain.shipping;

import java.math.BigDecimal;

import com.mize.domain.common.MizeSceEntity;

public class ShipmentCashOnDelivery extends MizeSceEntity implements Comparable<ShipmentCashOnDelivery>{
	
	private static final long serialVersionUID = -350317419410443313L;
	private String collectionType;
	private BigDecimal amount;
	private String addTransportCost;
	private String charges;
	private String currencyCode;
	
	public ShipmentCashOnDelivery() {
		super();
	}
	
	public ShipmentCashOnDelivery(String collectionType, BigDecimal amount,String addTransportCost, String charges,String currencyCode) {
		super();
		this.collectionType = collectionType;
		this.amount = amount;
		this.addTransportCost = addTransportCost;
		this.charges = charges;
		this.currencyCode = currencyCode;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAddTransportCost() {
		return addTransportCost;
	}

	public void setAddTransportCost(String addTransportCost) {
		this.addTransportCost = addTransportCost;
	}

	public String getCharges() {
		return charges;
	}

	public void setCharges(String charges) {
		this.charges = charges;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public int compareTo(ShipmentCashOnDelivery o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime
				* result
				+ ((addTransportCost == null) ? 0 : addTransportCost.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((charges == null) ? 0 : charges.hashCode());
		result = prime * result
				+ ((collectionType == null) ? 0 : collectionType.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
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
		ShipmentCashOnDelivery other = (ShipmentCashOnDelivery) obj;
		if (addTransportCost == null) {
			if (other.addTransportCost != null)
				return false;
		} else if (!addTransportCost.equals(other.addTransportCost))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (charges == null) {
			if (other.charges != null)
				return false;
		} else if (!charges.equals(other.charges))
			return false;
		if (collectionType == null) {
			if (other.collectionType != null)
				return false;
		} else if (!collectionType.equals(other.collectionType))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShipmentCashOnDelivery [collectionType=" + collectionType
				+ ", amount=" + amount + ", addTransportCost="
				+ addTransportCost + ", charges=" + charges + ", currencyCode="
				+ currencyCode + "]";
	}
	

}
