package com.mize.domain.servicelocator;

import java.util.List;


public class BusinessEntitySearch {
	
	private BusinessEntityAddress entityAddress;
	private int radius;
	private List<BusinessEntityAddress> addressList;
	
	public BusinessEntityAddress getEntityAddress() {
		return entityAddress;
	}
	public void setEntityAddress(BusinessEntityAddress entityAddress) {
		this.entityAddress = entityAddress;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public List<BusinessEntityAddress> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<BusinessEntityAddress> addressList) {
		this.addressList = addressList;
	}
}
