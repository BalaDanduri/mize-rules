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
public class ShipmentPackageAttribute extends MizeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 289509348269489424L;

	private ShipmentPackage shipmentPackage;
	private String attributeCode;
	private String attributeUom;
	private String attributeValue;
	
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
	public String getAttributeCode() {
		return attributeCode;
	}

	public void setAttributeCode(String attributeCode) {
		this.attributeCode = attributeCode;
	}

	@Column(name="attribute_uom")
	public String getAttributeUom() {
		return attributeUom;
	}

	public void setAttributeUom(String attributeUom) {
		this.attributeUom = attributeUom;
	}

	@Column(name="attribute_value")
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Override
	public String toString() {
		return "ShipmentPackageAttribute [shipmentPackage=" + shipmentPackage
				+ ", attributeCode=" + attributeCode + ", attributeUom="
				+ attributeUom + ", attributeValue=" + attributeValue + "]";
	}

}
