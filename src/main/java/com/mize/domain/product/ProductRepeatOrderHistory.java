package com.mize.domain.product;

import org.joda.time.DateTime;

import com.mize.domain.common.MizeEntity;

public class ProductRepeatOrderHistory extends MizeEntity implements Comparable<ProductRepeatOrderHistory>{
	
	private static final long serialVersionUID = -3861494853684026293L;
	private ProductRepeatOrder productRepeatOrder;
	private DateTime orderDate;
	private ProductRepeatOrder orderSnapshot;
	private DateTime createdDate;
	
	public ProductRepeatOrder getProductRepeatOrder() {
		return productRepeatOrder;
	}

	public void setProductRepeatOrder(ProductRepeatOrder productRepeatOrder) {
		this.productRepeatOrder = productRepeatOrder;
	}

	public DateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(DateTime orderDate) {
		this.orderDate = orderDate;
	}

	public ProductRepeatOrder getOrderSnapshot() {
		return orderSnapshot;
	}

	public void setOrderSnapshot(ProductRepeatOrder orderSnapshot) {
		this.orderSnapshot = orderSnapshot;
	}

	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderSnapshot == null) ? 0 : orderSnapshot.hashCode());
		result = prime * result + ((productRepeatOrder == null) ? 0 : productRepeatOrder.hashCode());
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
		ProductRepeatOrderHistory other = (ProductRepeatOrderHistory) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderSnapshot == null) {
			if (other.orderSnapshot != null)
				return false;
		} else if (!orderSnapshot.equals(other.orderSnapshot))
			return false;
		if (productRepeatOrder == null) {
			if (other.productRepeatOrder != null)
				return false;
		} else if (!productRepeatOrder.equals(other.productRepeatOrder))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "ProductRepeatOrderHistory [productRepeatOrder=" + productRepeatOrder + ", orderDate=" + orderDate
				+ ", orderSnapshot=" + orderSnapshot + ", createdDate=" + createdDate + "]";
	}

	@Override
	public int compareTo(ProductRepeatOrderHistory o) {
		return 0;
	}

}
