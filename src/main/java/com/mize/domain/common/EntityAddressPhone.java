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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "entity_address_phone" )
public class EntityAddressPhone extends MizeEntity implements Comparable<EntityAddressPhone> {

	private static final long serialVersionUID = 1L;
	@Transient
	private Long entityAddressId;
	private EntityAddress address;
	private String phoneType;
	private String phoneValue;
	private String phoneExt;

	public EntityAddressPhone(){
		super();
	}

	public EntityAddressPhone(Long entityAddressId, String phoneType,
			String phoneValue, String phoneExt) {
		super();
		this.entityAddressId = entityAddressId;
		this.phoneType = phoneType;
		this.phoneValue = phoneValue;
		this.phoneExt = phoneExt;
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
	@JsonBackReference(value="addressPhone")
	public EntityAddress getAddress() {
		return address;
	}


	public void setAddress(EntityAddress address) {
		this.address = address;
	}

	@Column(name = "phone_type", nullable = true)
	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	@Column(name = "phone_value", nullable = true)
	public String getPhoneValue() {
		return phoneValue;
	}

	public void setPhoneValue(String phoneValue) {
		this.phoneValue = phoneValue;
	}

	@Column(name = "phone_ext", nullable = true)
	public String getPhoneExt() {
		return phoneExt;
	}

	public void setPhoneExt(String phoneExt) {
		this.phoneExt = phoneExt;
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((phoneExt == null) ? 0 : phoneExt.hashCode());
		result = prime * result
				+ ((phoneType == null) ? 0 : phoneType.hashCode());
		result = prime * result
				+ ((phoneValue == null) ? 0 : phoneValue.hashCode());
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
		EntityAddressPhone other = (EntityAddressPhone) obj;
		if (phoneExt == null) {
			if (other.phoneExt != null)
				return false;
		} else if (!phoneExt.equals(other.phoneExt))
			return false;
		if (phoneType == null) {
			if (other.phoneType != null)
				return false;
		} else if (!phoneType.equals(other.phoneType))
			return false;
		if (phoneValue == null) {
			if (other.phoneValue != null)
				return false;
		} else if (!phoneValue.equals(other.phoneValue))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "EntityAddressPhone [entityAddressId=" + entityAddressId
				+ ", phoneType=" + phoneType + ", phoneValue=" + phoneValue
				+ ", phoneExt=" + phoneExt + "]";
	}

	@Override
	public int compareTo(EntityAddressPhone o) {
		return 0;
	}

}
