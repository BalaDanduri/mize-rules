package com.mize.domain.shipping;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.purchaseorder.PurchaseOrder;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="purchase_order_tracking")
public class PurchaseOrderTracking extends MizeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1717047364038293135L;

	private Shipment shipment;
	private PurchaseOrder purchaseOrder;
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="shipment_tracking_id")
	@JsonBackReference(value="shipment_po")
	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JoinColumn(name = "order_id")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@Override
	public String toString() {
		return "PurchaseOrderTracking [shipment=" + shipment
				+ ", purchaseOrder=" + purchaseOrder + "]";
	}

	
}
