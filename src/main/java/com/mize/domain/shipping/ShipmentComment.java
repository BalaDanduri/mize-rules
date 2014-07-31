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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="shipment_tracking_comment")
public class ShipmentComment extends MizeEntity implements Comparable<ShipmentComment>{
	private static final long serialVersionUID = -1285187789767965930L;

	private ShipmentTracking shipmentTracking;
	private EntityComment entityComment;
	
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JoinColumn(name = "comment_id")
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityComment == null) ? 0 : entityComment.hashCode());
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
		if (entityComment == null) {
			if (other.entityComment != null)
				return false;
		} else if (!entityComment.equals(other.entityComment))
			return false;
		return true;
	}

	@Override
	public int compareTo(ShipmentComment o) {
		return 0;
	}

	
}
