package com.mize.domain.purchaseorder;

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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.shipping.ShipmentTracking;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="purchase_order_tracking")
public class PurchaseOrderTracking extends MizeEntity implements Comparable<PurchaseOrderTracking> {
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

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="shipment_tracking_id")
	@JsonBackReference(value="shipment_po")
	public ShipmentTracking getShipment() {
		return shipment;
	}

	public void setShipment(ShipmentTracking shipment) {
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
	public int compareTo(PurchaseOrderTracking o) {
		return 0;
	}
	
}
