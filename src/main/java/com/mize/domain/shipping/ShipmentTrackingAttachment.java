package com.mize.domain.shipping;

import javax.persistence.CascadeType;
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
import com.mize.domain.common.EntityAttachment;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.CachedEntity;

@Entity
@Table(name = "shipment_tracking_attach")
public class ShipmentTrackingAttachment extends MizeSceEntity implements Comparable<ShipmentTrackingAttachment>{	

	private static final long serialVersionUID = 261638805962518728L;
	@CachedEntity
	private ShipmentTracking shipmentTracking;
	private EntityAttachment attachment = new EntityAttachment();

	public  ShipmentTrackingAttachment(){
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}	
	
	@ManyToOne
	@JoinColumn(name="shipment_tracking_id")
	@JsonBackReference(value="shipmentTracking_attachment")
	public ShipmentTracking getShipmentTracking() {
		return shipmentTracking;
	}

	public void setShipmentTracking(ShipmentTracking shipmentTracking) {
		this.shipmentTracking = shipmentTracking;
	}

	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="attach_id")
	public EntityAttachment getAttachment() {
		return attachment;
	}

	public void setAttachment(EntityAttachment attachment) {
		this.attachment = attachment;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
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
		return true;
	}

	@Override
	public int compareTo(ShipmentTrackingAttachment o) {
		return 0;
	}

}
