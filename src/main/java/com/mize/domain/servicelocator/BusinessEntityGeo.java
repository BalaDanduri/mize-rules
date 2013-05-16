package com.mize.domain.servicelocator;

import com.mize.domain.common.Entity;

public class BusinessEntityGeo extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2024187778230039496L;
	
	
	private long beAddressId;
	private double latitude;
	private double longitude;
	public long getBeAddressId() {
		return beAddressId;
	}
	public void setBeAddressId(long beAddressId) {
		this.beAddressId = beAddressId;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
