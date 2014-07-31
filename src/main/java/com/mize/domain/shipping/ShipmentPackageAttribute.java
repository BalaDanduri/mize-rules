package com.mize.domain.shipping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="shipment_package_attributes")
public class ShipmentPackageAttribute extends MizeEntity implements Comparable<ShipmentPackageAttribute>{
	private static final long serialVersionUID = 289509348269489424L;

	private ShipmentPackage shipmentPackage;
	private String code;
	private String uom;
	private String value;
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="shipment_package_id")
	@JsonBackReference(value="shipment_package_attribute")
	public ShipmentPackage getShipmentPackage() {
		return shipmentPackage;
	}

	public void setShipmentPackage(ShipmentPackage shipmentPackage) {
		this.shipmentPackage = shipmentPackage;
	}

	@Column(name="attribute_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="attribute_uom")
	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	@Column(name="attribute_value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		ShipmentPackageAttribute other = (ShipmentPackageAttribute) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public int compareTo(ShipmentPackageAttribute o) {
		return 0;
	}

}
