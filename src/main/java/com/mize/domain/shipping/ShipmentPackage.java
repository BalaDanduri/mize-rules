package com.mize.domain.shipping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="shipment_package")
public class ShipmentPackage extends MizeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8265420845919537745L;

	private Shipment shipment;
	private String packageNumber;
	private String packageType;
	private Long itemQuantity;
	private String trackingNumber;
	private Double handlingAmount;
	private Double freightAmount;
	private Double totalAmount;
	private List<ShipmentPackageAttribute> shipmentPackageAttributes = new ArrayList<ShipmentPackageAttribute>();
	private String shipmentLabel;
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="shipment_tracking_id")
	@JsonBackReference(value="shipment_packages")
	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	@Column(name="package_number")
	public String getPackageNumber() {
		return packageNumber;
	}

	public void setPackageNumber(String packageNumber) {
		this.packageNumber = packageNumber;
	}

	@Column(name="package_type")
	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	@Column(name="package_item_quantity")
	public Long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Column(name="tracking_number")
	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@Column(name="handling_amount")
	public Double getHandlingAmount() {
		return handlingAmount;
	}

	public void setHandlingAmount(Double handlingAmount) {
		this.handlingAmount = handlingAmount;
	}

	@Column(name="freight_amount")
	public Double getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(Double freightAmount) {
		this.freightAmount = freightAmount;
	}

	@Column(name="total_amount")
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="shipmentPackage",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="shipment_package_attribute")
	public List<ShipmentPackageAttribute> getShipmentPackageAttributes() {
		return shipmentPackageAttributes;
	}

	public void setShipmentPackageAttributes(
			List<ShipmentPackageAttribute> shipmentPackageAttributes) {
		this.shipmentPackageAttributes = shipmentPackageAttributes;
	}

	@Column(name="shipment_label")
	public String getShipmentLabel() {
		return shipmentLabel;
	}

	public void setShipmentLabel(String shipmentLabel) {
		this.shipmentLabel = shipmentLabel;
	}

	@Override
	public String toString() {
		return "ShipmentPackage [shipment=" + shipment + ", packageNumber="
				+ packageNumber + ", packageType=" + packageType
				+ ", itemQuantity=" + itemQuantity + ", trackingNumber="
				+ trackingNumber + ", handlingAmount=" + handlingAmount
				+ ", freightAmount=" + freightAmount + ", totalAmount="
				+ totalAmount + ", shipmentPackageAttributes="
				+ shipmentPackageAttributes + ", shipmentLabel="
				+ shipmentLabel + "]";
	}
	
}
