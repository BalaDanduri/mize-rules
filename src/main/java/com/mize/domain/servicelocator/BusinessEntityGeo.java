package com.mize.domain.servicelocator;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.DecimalValueDeserializer;

@Entity
@Table(name="business_entity_geo")
public class BusinessEntityGeo extends MizeEntity implements Comparable<BusinessEntityGeo> {

	
	private static final long serialVersionUID = -2024187778230039496L;
	private long beAddressId;
	private double latitude;
	private double longitude;
	private double distance;
	private double duration;
	private String distanceText;
	private String durationText;
	private BusinessEntityAddress businessEntityAddress;
	
	public BusinessEntityGeo() {
		
	}
	
	public BusinessEntityGeo(long beAddressId, double latitude, double longitude) {
		super();
		this.beAddressId = beAddressId;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	@Id
	@Column(name="be_address_id")
	@GeneratedValue(generator="gen")
	@GenericGenerator(name = "gen",strategy="foreign", parameters=@Parameter(name="property",value="businessEntityAddress"))
	public long getBeAddressId() {
		return beAddressId;
	}
	public void setBeAddressId(long beAddressId) {
		this.beAddressId = beAddressId;
	}
	@Column(name="latitude",nullable=true)
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	@Column(name="longitude",nullable=true)
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Transient
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	@Transient
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	@Transient
	public String getDistanceText() {
		return distanceText;
	}
	public void setDistanceText(String distanceText) {
		this.distanceText = distanceText;
	}
	@Transient
	public String getDurationText() {
		return durationText;
	}
	public void setDurationText(String durationText) {
		this.durationText = durationText;
	}
	@JsonDeserialize(using=DecimalValueDeserializer.class)
	@JsonIgnore
	@Transient
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

	@Override
	@JsonIgnore	
	@Transient
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@OneToOne
	@PrimaryKeyJoinColumn
	@JsonIgnore
	public BusinessEntityAddress getBusinessEntityAddress() {
		return businessEntityAddress;
	}

	public void setBusinessEntityAddress(BusinessEntityAddress businessEntityAddress) {
		this.businessEntityAddress = businessEntityAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (beAddressId ^ (beAddressId >>> 32));
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BusinessEntityGeo other = (BusinessEntityGeo) obj;
		if (beAddressId != other.beAddressId)
			return false;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		return true;
	}	
	
}
