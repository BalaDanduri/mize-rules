package com.mize.domain.common;

import java.math.BigDecimal;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "entity_address_geo")
public class EntityAddressGeo extends MizeSceEntity implements Comparable<EntityAddressGeo>{

	private static final long serialVersionUID = 1L;
	@Transient
	private Long entityAddressId;
	private EntityAddress address;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private EntityAddressGeoData addressGeoData;

	public EntityAddressGeo(){
		super();
	}

	public EntityAddressGeo(Long entityAddressId, BigDecimal latitude,
			BigDecimal longitude) {
		super();
		this.entityAddressId = entityAddressId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	@Column(name="be_address_id")
	@JsonIgnore
	public Long getEntityAddressId() {
		return entityAddressId;
	}

	public void setEntityAddressId(Long entityAddressId) {
		this.entityAddressId = entityAddressId;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entity_address_id")
	@JsonBackReference(value="geoAddress")
	public EntityAddress getAddress() {
		return address;
	}

	public void setAddress(EntityAddress address) {
		this.address = address;
	}

	@Column(name = "latitude")
	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude")
	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
	@Transient
	public EntityAddressGeoData getAddressGeoData() {
		return addressGeoData;
	}
	
	public void setAddressGeoData(EntityAddressGeoData addressGeoData) {
		this.addressGeoData = addressGeoData;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityAddressId == null) ? 0 : entityAddressId.hashCode());
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((longitude == null) ? 0 : longitude.hashCode());
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
		EntityAddressGeo other = (EntityAddressGeo) obj;
		if (entityAddressId == null) {
			if (other.entityAddressId != null)
				return false;
		} else if (!entityAddressId.equals(other.entityAddressId))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "EntityAddressGeo [entityAddressId=" + entityAddressId
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", addressGeoData=" + addressGeoData + ", id=" + id + "]";
	}

	@Override
	public int compareTo(EntityAddressGeo o) {
		return 0;
	}
	
	@JsonIgnore
	public static Comparator<EntityAddressGeo> EntityGeoDistanceComparator = new  Comparator<EntityAddressGeo>() {
		public int compare(EntityAddressGeo geo1, EntityAddressGeo geo2) {
			 if(geo1.getAddressGeoData() != null && geo2.getAddressGeoData() != null) {
				 return Double.compare( geo1.getAddressGeoData().getDistance() , geo2.getAddressGeoData().getDistance());
			 }  else {
				 return 0;
			 }  
		      
		}
	};
}
