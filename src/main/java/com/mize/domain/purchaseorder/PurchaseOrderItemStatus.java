package com.mize.domain.purchaseorder;


import java.math.BigDecimal;

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

@Entity
@Table(name = "purchase_order_item_status")
public class PurchaseOrderItemStatus extends MizeSceEntity implements Comparable<PurchaseOrderItemStatus>{	
	
	private static final long serialVersionUID = -472283743881333248L;
	private PurchaseOrderItem orderItem;
	private BigDecimal quantity;
	private String status;
	public PurchaseOrderItemStatus(){
		super();
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

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_item_id")
	@JsonBackReference(value="status_orderItem")
	public PurchaseOrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(PurchaseOrderItem orderItem) {
		this.orderItem = orderItem;
	}

	@Column(name = "item_quantity")
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Column(name = "item_status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(PurchaseOrderItemStatus o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
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
		PurchaseOrderItemStatus other = (PurchaseOrderItemStatus) obj;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderItemStatus [quantity=" + quantity + ", status="
				+ status + "]";
	}	

	
}
