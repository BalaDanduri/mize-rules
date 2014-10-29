package com.mize.domain.purchaseorder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.shipping.ShipmentTracking;

@Entity
@Table(name="purchase_order_tracking")
public class PurchaseOrderTracking extends MizeSceEntity implements Comparable<PurchaseOrderTracking> {
	private static final long serialVersionUID = -1717047364038293135L;

	private ShipmentTracking shipment;
	private PurchaseOrder purchaseOrder;
	
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

	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name ="shipment_tracking_id")
	public ShipmentTracking getShipment() {
		return shipment;
	}

	public void setShipment(ShipmentTracking shipment) {
		this.shipment = shipment;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonBackReference(value="shipment_po")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@Override
	public int compareTo(PurchaseOrderTracking o) {
		return 0;
	}
	
}
