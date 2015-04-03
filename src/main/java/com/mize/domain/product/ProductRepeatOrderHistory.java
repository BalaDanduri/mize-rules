package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.DateTime;

@Entity
@Table(name = "prod_repeat_order_history")
public class ProductRepeatOrderHistory extends MizeSceEntity implements Comparable<ProductRepeatOrderHistory>{
	
	private static final long serialVersionUID = -3861494853684026293L;
	
	private ProductRepeatOrder productRepeatOrder;
	private DateTime orderDate;
	private ProductRepeatOrder orderSnapshot;
	private DateTime createdDate;
	
	
	@ManyToOne
	@JoinColumn(name="prod_repeat_order_id")
	public ProductRepeatOrder getProductRepeatOrder() {
		return productRepeatOrder;
	}

	public void setProductRepeatOrder(ProductRepeatOrder productRepeatOrder) {
		this.productRepeatOrder = productRepeatOrder;
	}

	@Column(name = "order_date",  nullable = true)
	public DateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(DateTime orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name="order_snapshot",nullable=true)
	public ProductRepeatOrder getOrderSnapshot() {
		return orderSnapshot;
	}

	public void setOrderSnapshot(ProductRepeatOrder orderSnapshot) {
		this.orderSnapshot = orderSnapshot;
	}

	@Column(name = "created_date",  nullable = true)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator="id")
	@Column(name="id",unique=true,nullable=false,length=20)
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
		return "ProductRepeatOrderHistory [orderDate=" + orderDate
				+", createdDate=" + createdDate + "]";
	}

	@Override
	public int compareTo(ProductRepeatOrderHistory o) {
		return 0;
	}

}
