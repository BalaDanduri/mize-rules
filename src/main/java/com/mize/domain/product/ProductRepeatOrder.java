package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.user.UserAddress;

public class ProductRepeatOrder extends MizeEntity implements Comparable<ProductRepeatOrder>{
	
	private static final long serialVersionUID = 3558480216294413887L;
	private User user;
	private Brand brand;
	private Product product;
	private ProductRepeatOrderType productRepeatOrderType;
	private ProductRepeatOrderShipOptions productRepeatOrderShipOptions;
	private DateTime startDate;
	private DateTime endDate;
	private DateTime lastOrderDate;
	private DateTime nextOrderDate;
	private String active;
	private Double Qty;
	private List<UserAddress> userAddresses = new ArrayList<UserAddress>();
	private ProductRepeatOrderHistory productRepeatOrderHistory;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductRepeatOrderType getProductRepeatOrderType() {
		return productRepeatOrderType;
	}

	public void setProductRepeatOrderType(ProductRepeatOrderType productRepeatOrderType) {
		this.productRepeatOrderType = productRepeatOrderType;
	}

	public ProductRepeatOrderShipOptions getProductRepeatOrderShipOptions() {
		return productRepeatOrderShipOptions;
	}

	public void setProductRepeatOrderShipOptions(ProductRepeatOrderShipOptions productRepeatOrderShipOptions) {
		this.productRepeatOrderShipOptions = productRepeatOrderShipOptions;
	}

	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	public DateTime getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(DateTime lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}

	public DateTime getNextOrderDate() {
		return nextOrderDate;
	}

	public void setNextOrderDate(DateTime nextOrderDate) {
		this.nextOrderDate = nextOrderDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Double getQty() {
		return Qty;
	}

	public void setQty(Double qty) {
		Qty = qty;
	}

	public List<UserAddress> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public ProductRepeatOrderHistory getProductRepeatOrderHistory() {
		return productRepeatOrderHistory;
	}

	public void setProductRepeatOrderHistory(ProductRepeatOrderHistory productRepeatOrderHistory) {
		this.productRepeatOrderHistory = productRepeatOrderHistory;
	}
	

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((Qty == null) ? 0 : Qty.hashCode());
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((lastOrderDate == null) ? 0 : lastOrderDate.hashCode());
		result = prime * result + ((nextOrderDate == null) ? 0 : nextOrderDate.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productRepeatOrderHistory == null) ? 0 : productRepeatOrderHistory.hashCode());
		result = prime * result
				+ ((productRepeatOrderShipOptions == null) ? 0 : productRepeatOrderShipOptions.hashCode());
		result = prime * result + ((productRepeatOrderType == null) ? 0 : productRepeatOrderType.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userAddresses == null) ? 0 : userAddresses.hashCode());
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
		ProductRepeatOrder other = (ProductRepeatOrder) obj;
		if (Qty == null) {
			if (other.Qty != null)
				return false;
		} else if (!Qty.equals(other.Qty))
			return false;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (lastOrderDate == null) {
			if (other.lastOrderDate != null)
				return false;
		} else if (!lastOrderDate.equals(other.lastOrderDate))
			return false;
		if (nextOrderDate == null) {
			if (other.nextOrderDate != null)
				return false;
		} else if (!nextOrderDate.equals(other.nextOrderDate))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productRepeatOrderHistory == null) {
			if (other.productRepeatOrderHistory != null)
				return false;
		} else if (!productRepeatOrderHistory.equals(other.productRepeatOrderHistory))
			return false;
		if (productRepeatOrderShipOptions == null) {
			if (other.productRepeatOrderShipOptions != null)
				return false;
		} else if (!productRepeatOrderShipOptions.equals(other.productRepeatOrderShipOptions))
			return false;
		if (productRepeatOrderType == null) {
			if (other.productRepeatOrderType != null)
				return false;
		} else if (!productRepeatOrderType.equals(other.productRepeatOrderType))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userAddresses == null) {
			if (other.userAddresses != null)
				return false;
		} else if (!userAddresses.equals(other.userAddresses))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "ProductRepeatOrder [user=" + user + ", brand=" + brand + ", product=" + product
				+ ", productRepeatOrderType=" + productRepeatOrderType + ", productRepeatOrderShipOptions="
				+ productRepeatOrderShipOptions + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", lastOrderDate=" + lastOrderDate + ", nextOrderDate=" + nextOrderDate + ", active=" + active
				+ ", Qty=" + Qty + ", userAddresses=" + userAddresses + ", productRepeatOrderHistory="
				+ productRepeatOrderHistory + "]";
	}

	@Override
	public int compareTo(ProductRepeatOrder arg0) {
		return 0;
	}
}