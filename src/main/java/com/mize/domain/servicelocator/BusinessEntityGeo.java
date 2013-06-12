package com.mize.domain.servicelocator;

import java.util.Comparator;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.mize.domain.common.Entity;
import com.mize.domain.util.DecimalValueDeserializer;

public class BusinessEntityGeo extends Entity implements Comparable<BusinessEntityGeo> {

	private static final long serialVersionUID = -2024187778230039496L;
	private long beAddressId;
	private double latitude;
	private double longitude;
	private double distance;
	private double duration;
	private String distanceText;
	private String durationText;
	
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
	@JsonDeserialize(using=DecimalValueDeserializer.class)
	@JsonIgnore
	public Double getDistanceInMiles() {
		return (this.distance/1000) * 0.621371;
	}
	@Override
	@JsonIgnore
	public int compareTo(BusinessEntityGeo beGeo) {
		if(this.getLongitude()==beGeo.getLongitude() && 
				this.getLatitude()==beGeo.getLatitude()	) {
			return 0;
		}
		return Double.compare(this.getDistance(),beGeo.getDistance());
	}
	@JsonIgnore
	public static Comparator<BusinessEntityGeo> BusinessEntityGeoDurationComparator = new  Comparator<BusinessEntityGeo>() {
		public int compare(BusinessEntityGeo beGeo1, BusinessEntityGeo beGeo2) {
		      return Double.compare( beGeo1.getDuration() , beGeo1.getDuration());
		    }
	};
}
