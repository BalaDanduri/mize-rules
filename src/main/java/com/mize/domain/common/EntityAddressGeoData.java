package com.mize.domain.common;

import java.io.Serializable;

public class EntityAddressGeoData implements Serializable {	
	
	private static final long serialVersionUID = -3183100013616192694L;
	private double distance;
	private double duration;
	private String distanceText;
	private String durationText;
	
	public EntityAddressGeoData() {
		
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getDistanceText() {
		return distanceText;
	}

	public void setDistanceText(String distanceText) {
		this.distanceText = distanceText;
	}

	public String getDurationText() {
		return durationText;
	}

	public void setDurationText(String durationText) {
		this.durationText = durationText;
	}

	

}
