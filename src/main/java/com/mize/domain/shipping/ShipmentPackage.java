package com.mize.domain.shipping;

import java.math.BigDecimal;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="shipment_package")
public class ShipmentPackage extends MizeSceEntity implements Comparable<ShipmentPackage> {
	private static final long serialVersionUID = 8265420845919537745L;
	private ShipmentTracking shipmentTracking;
	private String number;
	private String type;
	private Integer itemQuantity;
	private String trackingNumber;
	private BigDecimal handlingAmount;
	private BigDecimal freightAmount;
	private BigDecimal totalAmount;
	private BigDecimal shippingAmount;
	private String shipmentLabel;
	private String shipmentLabelPath;
	private List<ShipmentPackageAttribute> attributes = new ArrayList<ShipmentPackageAttribute>();
	private PackageSpecialOptions packageSpecialOptions;
	private String packageSpecialOptionsValue;
	
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
	public ShipmentTracking getShipmentTracking() {
		return shipmentTracking;
	}

	public void setShipmentTracking(ShipmentTracking shipmentTracking) {
		this.shipmentTracking = shipmentTracking;
	}

	@Column(name="package_number")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name="package_type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="item_quantity")
	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
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
	public BigDecimal getHandlingAmount() {
		return handlingAmount;
	}

	public void setHandlingAmount(BigDecimal handlingAmount) {
		this.handlingAmount = handlingAmount;
	}

	@Column(name="freight_amount")
	public BigDecimal getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(BigDecimal freightAmount) {
		this.freightAmount = freightAmount;
	}

	@Column(name="total_amount")
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="shipmentPackage",orphanRemoval = true,fetch=FetchType.LAZY)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="shipment_package_attribute")
	public List<ShipmentPackageAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ShipmentPackageAttribute> attributes) {
		this.attributes = attributes;
	}

	@Column(name="shipment_label")
	public String getShipmentLabel() {
		return shipmentLabel;
	}

	public void setShipmentLabel(String shipmentLabel) {
		this.shipmentLabel = shipmentLabel;
	}

	@Column(name="shipping_amount")
	public BigDecimal getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(BigDecimal shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	@Transient
	public String getShipmentLabelPath() {
		return shipmentLabelPath;
	}

	public void setShipmentLabelPath(String shipmentLabelPath) {
		this.shipmentLabelPath = shipmentLabelPath;
	}

	@Transient
	public PackageSpecialOptions getPackageSpecialOptions() {
		return packageSpecialOptions;
	}

	public void setPackageSpecialOptions(PackageSpecialOptions packageSpecialOptions) {
		this.packageSpecialOptions = packageSpecialOptions;
	}

	@Transient
	//@Column(name="pkg_spl_options")
	public String getPackageSpecialOptionsValue() {
		return packageSpecialOptionsValue;
	}

	public void setPackageSpecialOptionsValue(String packageSpecialOptionsValue) {
		this.packageSpecialOptionsValue = packageSpecialOptionsValue;
	}

	@Override
	public String toString() {
		return "ShipmentPackage [number=" + number + ", type=" + type
				+ ", itemQuantity=" + itemQuantity + ", trackingNumber="
				+ trackingNumber + ", handlingAmount=" + handlingAmount
				+ ", freightAmount=" + freightAmount + ", totalAmount="
				+ totalAmount + ", shippingAmount=" + shippingAmount
				+ ", shipmentLabel=" + shipmentLabel + ", shipmentLabelPath="
				+ shipmentLabelPath + ", attributes=" + attributes + "]";
	}

	@Override
	public int compareTo(ShipmentPackage o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((freightAmount == null) ? 0 : freightAmount.hashCode());
		result = prime * result
				+ ((handlingAmount == null) ? 0 : handlingAmount.hashCode());
		result = prime * result
				+ ((itemQuantity == null) ? 0 : itemQuantity.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((shipmentLabel == null) ? 0 : shipmentLabel.hashCode());
		result = prime
				* result
				+ ((shipmentLabelPath == null) ? 0 : shipmentLabelPath
						.hashCode());
		result = prime * result
				+ ((shippingAmount == null) ? 0 : shippingAmount.hashCode());
		result = prime * result
				+ ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result
				+ ((trackingNumber == null) ? 0 : trackingNumber.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ShipmentPackage other = (ShipmentPackage) obj;
		if (freightAmount == null) {
			if (other.freightAmount != null)
				return false;
		} else if (!freightAmount.equals(other.freightAmount))
			return false;
		if (handlingAmount == null) {
			if (other.handlingAmount != null)
				return false;
		} else if (!handlingAmount.equals(other.handlingAmount))
			return false;
		if (itemQuantity == null) {
			if (other.itemQuantity != null)
				return false;
		} else if (!itemQuantity.equals(other.itemQuantity))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (shipmentLabel == null) {
			if (other.shipmentLabel != null)
				return false;
		} else if (!shipmentLabel.equals(other.shipmentLabel))
			return false;
		if (shipmentLabelPath == null) {
			if (other.shipmentLabelPath != null)
				return false;
		} else if (!shipmentLabelPath.equals(other.shipmentLabelPath))
			return false;
		if (shippingAmount == null) {
			if (other.shippingAmount != null)
				return false;
		} else if (!shippingAmount.equals(other.shippingAmount))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		if (trackingNumber == null) {
			if (other.trackingNumber != null)
				return false;
		} else if (!trackingNumber.equals(other.trackingNumber))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
