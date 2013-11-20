package com.mize.domain.common;

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

@Entity
@Table(name = "entity_address_geo")
public class EntityAddressGeo extends MizeEntity implements Comparable<EntityAddressGeo>{

	private static final long serialVersionUID = 1L;
	@Transient
	private Long entityAddressId;
	private EntityAddress address;
	private String latitude;
	private String longitude;

	public EntityAddressGeo(){
		super();
	}

	public EntityAddressGeo(Long entityAddressId, String latitude,
			String longitude) {
		super();
		this.entityAddressId = entityAddressId;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public Long getEntityAddressId() {
		return entityAddressId;
	}

	public void setEntityAddressId(Long entityAddressId) {
		this.entityAddressId = entityAddressId;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entity_address_id")
	public EntityAddress getAddress() {
		return address;
	}

	public void setAddress(EntityAddress address) {
		this.address = address;
	}

	@Column(name = "latitude", nullable = true)
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", nullable = true)
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
		StringBuilder builder = new StringBuilder();
		builder.append("EntityAddressGeo [entityAddressId=");
		builder.append(entityAddressId);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(EntityAddressGeo o) {
		return 0;
	}



}
