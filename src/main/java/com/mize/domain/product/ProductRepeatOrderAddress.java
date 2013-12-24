package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.user.UserAddress;

@Entity
@Table(name = "prod_repeat_order_address")
public class ProductRepeatOrderAddress extends MizeEntity implements Comparable<ProductRepeatOrderAddress>{
	
	private static final long serialVersionUID = 5924025513879604072L;
	
	private ProductRepeatOrder repeatOrder;
	@Transient
	private Long productRepeatOrderId;
	private Long billingAddressId;
	@Transient
	private UserAddress billingAddress;
	private Long shippingAddressId;
	@Transient
	private UserAddress shippingAddress;
	
	@JsonIgnore
	@OneToOne(optional=false,fetch=FetchType.EAGER)
    @JoinColumn(name="prod_repeat_order_id")
	public ProductRepeatOrder getRepeatOrder() {
		return repeatOrder;
	}

	public void setRepeatOrder(ProductRepeatOrder repeatOrder) {
		this.repeatOrder = repeatOrder;
	}
	
	
	@Transient
	public Long getProductRepeatOrderId() {
		return productRepeatOrderId;
	}

	public void setProductRepeatOrderId(Long productRepeatOrderId) {
		this.productRepeatOrderId = productRepeatOrderId;
	}
	
	@Transient
	public UserAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(UserAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Transient
	public UserAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(UserAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	@Column(name = "billing_address_id",  nullable = true,length=20)
	public Long getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(Long billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	@Column(name = "shipping_address_id",  nullable = true,length=20)
	public Long getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(Long shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((billingAddress == null) ? 0 : billingAddress.hashCode());
		result = prime * result + ((billingAddressId == null) ? 0 : billingAddressId.hashCode());
		result = prime * result + ((productRepeatOrderId == null) ? 0 : productRepeatOrderId.hashCode());
		result = prime * result + ((repeatOrder == null) ? 0 : repeatOrder.hashCode());
		result = prime * result + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
		result = prime * result + ((shippingAddressId == null) ? 0 : shippingAddressId.hashCode());
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
		ProductRepeatOrderAddress other = (ProductRepeatOrderAddress) obj;
		if (billingAddress == null) {
			if (other.billingAddress != null)
				return false;
		} else if (!billingAddress.equals(other.billingAddress))
			return false;
		if (billingAddressId == null) {
			if (other.billingAddressId != null)
				return false;
		} else if (!billingAddressId.equals(other.billingAddressId))
			return false;
		if (productRepeatOrderId == null) {
			if (other.productRepeatOrderId != null)
				return false;
		} else if (!productRepeatOrderId.equals(other.productRepeatOrderId))
			return false;
		if (repeatOrder == null) {
			if (other.repeatOrder != null)
				return false;
		} else if (!repeatOrder.equals(other.repeatOrder))
			return false;
		if (shippingAddress == null) {
			if (other.shippingAddress != null)
				return false;
		} else if (!shippingAddress.equals(other.shippingAddress))
			return false;
		if (shippingAddressId == null) {
			if (other.shippingAddressId != null)
				return false;
		} else if (!shippingAddressId.equals(other.shippingAddressId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductRepeatOrderAddress [repeatOrder=" + repeatOrder + ", productRepeatOrderId="
				+ productRepeatOrderId + ", billingAddressId=" + billingAddressId + ", billingAddress="
				+ billingAddress + ", shippingAddressId=" + shippingAddressId + ", shippingAddress=" + shippingAddress
				+ "]";
	}

	@Override
	public int compareTo(ProductRepeatOrderAddress o) {
		return 0;
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

}
