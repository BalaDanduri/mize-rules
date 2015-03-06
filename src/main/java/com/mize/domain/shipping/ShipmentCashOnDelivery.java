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

}
