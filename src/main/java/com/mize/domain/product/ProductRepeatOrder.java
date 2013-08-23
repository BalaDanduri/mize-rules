package com.mize.domain.product;

import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class ProductRepeatOrder extends MizeEntity implements Comparable<ProductRepeatOrder>{
	
	private static final long serialVersionUID = 3558480216294413887L;
	private Long userId;
	private Long brandId;
	private Product product;
	private ProductRepeatOrderType productRepeatOrderType;
	private ProductRepeatOrderShipOptions productRepeatOrderShipOptions;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime startDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime endDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime lastOrderDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime nextOrderDate;
	private String active;
	private Double quantity;
	private Double unitAmount;
	private Double shipAmount;
	private Double totalAmount;
	private Double discountAmount;
	private Double taxAmount;
	private Double totalOrderAmount;
	private String confirmationNumber;
	private String email;
	private String phoneMobile;
	private String phoneHome;
	private String phoneWork;	
	private ProductRepeatOrderHistory productRepeatOrderHistory;
	private ProductRepeatOrderAddress productRepeatOrderAddress ;
	@Transient
	private Integer pageIndex;

	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
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

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getStartDate() {
		return startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getEndDate() {
		return endDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getLastOrderDate() {
		return lastOrderDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setLastOrderDate(DateTime lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getNextOrderDate() {
		return nextOrderDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setNextOrderDate(DateTime nextOrderDate) {
		this.nextOrderDate = nextOrderDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public ProductRepeatOrderHistory getProductRepeatOrderHistory() {
		return productRepeatOrderHistory;
	}

	public void setProductRepeatOrderHistory(ProductRepeatOrderHistory productRepeatOrderHistory) {
		this.productRepeatOrderHistory = productRepeatOrderHistory;
	}
	
	@Transient
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Double getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	}

	public Double getShipAmount() {
		return shipAmount;
	}

	public void setShipAmount(Double shipAmount) {
		this.shipAmount = shipAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(Double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public ProductRepeatOrderAddress getProductRepeatOrderAddress() {
		return productRepeatOrderAddress;
	}

	public void setProductRepeatOrderAddress(ProductRepeatOrderAddress productRepeatOrderAddress) {
		this.productRepeatOrderAddress = productRepeatOrderAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}

	public String getPhoneWork() {
		return phoneWork;
	}

	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
		result = prime * result + ((confirmationNumber == null) ? 0 : confirmationNumber.hashCode());
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((lastOrderDate == null) ? 0 : lastOrderDate.hashCode());
		result = prime * result + ((nextOrderDate == null) ? 0 : nextOrderDate.hashCode());
		result = prime * result + ((pageIndex == null) ? 0 : pageIndex.hashCode());
		result = prime * result + ((phoneHome == null) ? 0 : phoneHome.hashCode());
		result = prime * result + ((phoneMobile == null) ? 0 : phoneMobile.hashCode());
		result = prime * result + ((phoneWork == null) ? 0 : phoneWork.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productRepeatOrderAddress == null) ? 0 : productRepeatOrderAddress.hashCode());
		result = prime * result + ((productRepeatOrderHistory == null) ? 0 : productRepeatOrderHistory.hashCode());
		result = prime * result
				+ ((productRepeatOrderShipOptions == null) ? 0 : productRepeatOrderShipOptions.hashCode());
		result = prime * result + ((productRepeatOrderType == null) ? 0 : productRepeatOrderType.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((shipAmount == null) ? 0 : shipAmount.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((taxAmount == null) ? 0 : taxAmount.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result + ((totalOrderAmount == null) ? 0 : totalOrderAmount.hashCode());
		result = prime * result + ((unitAmount == null) ? 0 : unitAmount.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
			return false;
		if (confirmationNumber == null) {
			if (other.confirmationNumber != null)
				return false;
		} else if (!confirmationNumber.equals(other.confirmationNumber))
			return false;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (pageIndex == null) {
			if (other.pageIndex != null)
				return false;
		} else if (!pageIndex.equals(other.pageIndex))
			return false;
		if (phoneHome == null) {
			if (other.phoneHome != null)
				return false;
		} else if (!phoneHome.equals(other.phoneHome))
			return false;
		if (phoneMobile == null) {
			if (other.phoneMobile != null)
				return false;
		} else if (!phoneMobile.equals(other.phoneMobile))
			return false;
		if (phoneWork == null) {
			if (other.phoneWork != null)
				return false;
		} else if (!phoneWork.equals(other.phoneWork))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productRepeatOrderAddress == null) {
			if (other.productRepeatOrderAddress != null)
				return false;
		} else if (!productRepeatOrderAddress.equals(other.productRepeatOrderAddress))
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
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (shipAmount == null) {
			if (other.shipAmount != null)
				return false;
		} else if (!shipAmount.equals(other.shipAmount))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (taxAmount == null) {
			if (other.taxAmount != null)
				return false;
		} else if (!taxAmount.equals(other.taxAmount))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		if (totalOrderAmount == null) {
			if (other.totalOrderAmount != null)
				return false;
		} else if (!totalOrderAmount.equals(other.totalOrderAmount))
			return false;
		if (unitAmount == null) {
			if (other.unitAmount != null)
				return false;
		} else if (!unitAmount.equals(other.unitAmount))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "ProductRepeatOrder [userId=" + userId + ", brandId=" + brandId + ", product=" + product
				+ ", productRepeatOrderType=" + productRepeatOrderType + ", productRepeatOrderShipOptions="
				+ productRepeatOrderShipOptions + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", lastOrderDate=" + lastOrderDate + ", nextOrderDate=" + nextOrderDate + ", active=" + active
				+ ", quantity=" + quantity + ", unitAmount=" + unitAmount + ", shipAmount=" + shipAmount
				+ ", totalAmount=" + totalAmount + ", discountAmount=" + discountAmount + ", taxAmount=" + taxAmount
				+ ", totalOrderAmount=" + totalOrderAmount + ", confirmationNumber=" + confirmationNumber + ", email="
				+ email + ", phoneMobile=" + phoneMobile + ", phoneHome=" + phoneHome + ", phoneWork=" + phoneWork
				+ ", productRepeatOrderHistory=" + productRepeatOrderHistory + ", productRepeatOrderAddress="
				+ productRepeatOrderAddress + ", pageIndex=" + pageIndex + "]";
	}

	@Override
	public int compareTo(ProductRepeatOrder arg0) {
		return 0;
	}
}
