package com.mize.domain.businessentity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="business_entity_geo")
public class BusinessEntityGeo extends MizeEntity implements Comparable<BusinessEntityGeo> {
	private static final long serialVersionUID = -2024187778230039496L;
	private Long  beAddressId;
	private Double latitude;
	private Double longitude;
	private BusinessEntityAddress businessEntityAddress;
	
	public BusinessEntityGeo() {
	}
	
	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Transient
	@Column(name="be_address_id",insertable=false,updatable=false)
	@JsonIgnore
	public Long getBeAddressId() {
		return beAddressId;
	}
	
	public void setBeAddressId(Long beAddressId) {
		this.beAddressId = beAddressId;
	}
	
	@Column(name="latitude", nullable=true)
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	@Column(name="longitude",nullable=true)
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="be_address_id")
	public BusinessEntityAddress getBusinessEntityAddress() {
		return businessEntityAddress;
	}

	public void setBusinessEntityAddress(BusinessEntityAddress businessEntityAddress) {
		this.businessEntityAddress = businessEntityAddress;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((beAddressId == null) ? 0 : beAddressId.hashCode());
		result = prime
				* result
				+ ((businessEntityAddress == null) ? 0 : businessEntityAddress
						.hashCode());
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
		BusinessEntityGeo other = (BusinessEntityGeo) obj;
		if (beAddressId == null) {
			if (other.beAddressId != null)
				return false;
		} else if (!beAddressId.equals(other.beAddressId))
			return false;
		if (businessEntityAddress == null) {
			if (other.businessEntityAddress != null)
				return false;
		} else if (!businessEntityAddress.equals(other.businessEntityAddress))
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
		StringBuilder builder = new StringBuilder();
		builder.append("BusinessEntityGeo [beAddressId=");
		builder.append(beAddressId);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", businessEntityAddress=");
		builder.append(businessEntityAddress);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public int compareTo(BusinessEntityGeo arg0) {
		return 0;
	}
	
}
