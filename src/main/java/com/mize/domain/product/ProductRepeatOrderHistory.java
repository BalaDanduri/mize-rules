package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "prod_repeat_order_history")
public class ProductRepeatOrderHistory extends MizeEntity implements Comparable<ProductRepeatOrderHistory>{
	
	private static final long serialVersionUID = -3861494853684026293L;
	
	private ProductRepeatOrder productRepeatOrder;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime orderDate;
	private ProductRepeatOrder orderSnapshot;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime createdDate;
	
	
	@ManyToOne
	@JoinColumn(name="prod_repeat_order_id")
	public ProductRepeatOrder getProductRepeatOrder() {
		return productRepeatOrder;
	}

	public void setProductRepeatOrder(ProductRepeatOrder productRepeatOrder) {
		this.productRepeatOrder = productRepeatOrder;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "order_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getOrderDate() {
		return orderDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
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

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "created_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
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
		return "ProductRepeatOrderHistory [productRepeatOrder=" + productRepeatOrder + ", orderDate=" + orderDate
				+ ", orderSnapshot=" + orderSnapshot + ", createdDate=" + createdDate + "]";
	}

	@Override
	public int compareTo(ProductRepeatOrderHistory o) {
		return 0;
	}

}
