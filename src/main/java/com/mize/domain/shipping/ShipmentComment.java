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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name="shipment_tracking_comment")
public class ShipmentComment extends MizeSceEntity implements Comparable<ShipmentComment>{
	private static final long serialVersionUID = -1285187789767965930L;

	private ShipmentTracking shipmentTracking;
	private EntityComment comment;
	
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
	@JsonBackReference(value="shipment_comments")
	public ShipmentTracking getShipmentTracking() {
		return shipmentTracking;
	}

	public void setShipmentTracking(ShipmentTracking shipmentTracking) {
		this.shipmentTracking = shipmentTracking;
	}

	@JoinColumn(name = "comment_id")
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	public EntityComment getComment() {
		return comment;
	}

	public void setComment(EntityComment comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((comment == null) ? 0 : comment.hashCode());
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
		ShipmentComment other = (ShipmentComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}

	@Override
	public int compareTo(ShipmentComment o) {
		return 0;
	}	
}
