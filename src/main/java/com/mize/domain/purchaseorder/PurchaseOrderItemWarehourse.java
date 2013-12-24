package com.mize.domain.purchaseorder;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "purchase_order_item_warehouse")
public class PurchaseOrderItemWarehourse extends MizeEntity implements Comparable<PurchaseOrderItemWarehourse> {

	private static final long serialVersionUID = -8674802160381208633L;
	private PurchaseOrderItem orderItem;
	private String code;
	private String name;
	private String status;
	private BigDecimal availableQuantity;
	private BigDecimal backorderQuantity;
	private BigDecimal estimatedShipmentCost;
	private DateTime estimatedShipmentDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_item_id")
	@JsonBackReference(value = "warehouse_itemOrder")
	public PurchaseOrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(PurchaseOrderItem orderItem) {
		this.orderItem = orderItem;
	}
	
	@Column(name = "warehouse_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "warehouse_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "warehouse_status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "available_quantity")
	public BigDecimal getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(BigDecimal availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@Column(name = "backorder_quantity")
	public BigDecimal getBackorderQuantity() {
		return backorderQuantity;
	}

	public void setBackorderQuantity(BigDecimal backorderQuantity) {
		this.backorderQuantity = backorderQuantity;
	}

	@Column(name = "estimated_ship_cost")
	public BigDecimal getEstimatedShipmentCost() {
		return estimatedShipmentCost;
	}

	public void setEstimatedShipmentCost(BigDecimal estimatedShipmentCost) {
		this.estimatedShipmentCost = estimatedShipmentCost;
	}

	@Column(name = "estimated_ship_date")
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getEstimatedShipmentDate() {
		return estimatedShipmentDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEstimatedShipmentDate(DateTime estimatedShipmentDate) {
		this.estimatedShipmentDate = estimatedShipmentDate;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime
				* result
				+ ((availableQuantity == null) ? 0 : availableQuantity
						.hashCode());
		result = prime
				* result
				+ ((backorderQuantity == null) ? 0 : backorderQuantity
						.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((estimatedShipmentCost == null) ? 0 : estimatedShipmentCost.hashCode());
		result = prime * result
				+ ((estimatedShipmentDate == null) ? 0 : estimatedShipmentDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		PurchaseOrderItemWarehourse other = (PurchaseOrderItemWarehourse) obj;
		if (availableQuantity == null) {
			if (other.availableQuantity != null)
				return false;
		} else if (!availableQuantity.equals(other.availableQuantity))
			return false;
		if (backorderQuantity == null) {
			if (other.backorderQuantity != null)
				return false;
		} else if (!backorderQuantity.equals(other.backorderQuantity))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (estimatedShipmentCost == null) {
			if (other.estimatedShipmentCost != null)
				return false;
		} else if (!estimatedShipmentCost.equals(other.estimatedShipmentCost))
			return false;
		if (estimatedShipmentDate == null) {
			if (other.estimatedShipmentDate != null)
				return false;
		} else if (!estimatedShipmentDate.equals(other.estimatedShipmentDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderItemWarehourse [orderItem=" + orderItem
				+ ", code=" + code + ", name=" + name + ", status=" + status
				+ ", availableQuantity=" + availableQuantity
				+ ", backorderQuantity=" + backorderQuantity + ", estimatedShipmentCost="
				+ estimatedShipmentCost + ", estimatedShipmentDate=" + estimatedShipmentDate + "]";
	}

	@Override
	public int compareTo(PurchaseOrderItemWarehourse o) {
		return 0;
	}

}
