package com.mize.domain.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "prod_repeat_order")
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
	@Transient
	private ProductRepeatOrderAddress productRepeatOrderAddress ;
	private String cardType;
	private String cardNumber;
	private String cardExpiryDate;
	private String cardSecurityCode;
	private List<ProductRepeatOrderHistory> orderHistories;	

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prod_id", nullable = true)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prod_repeat_type_id", nullable = true)
	public ProductRepeatOrderType getProductRepeatOrderType() {
		return productRepeatOrderType;
	}

	public void setProductRepeatOrderType(ProductRepeatOrderType productRepeatOrderType) {
		this.productRepeatOrderType = productRepeatOrderType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prod_repeat_ship_options_id", nullable = true)
	public ProductRepeatOrderShipOptions getProductRepeatOrderShipOptions() {
		return productRepeatOrderShipOptions;
	}

	public void setProductRepeatOrderShipOptions(ProductRepeatOrderShipOptions productRepeatOrderShipOptions) {
		this.productRepeatOrderShipOptions = productRepeatOrderShipOptions;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "start_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
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
	@Column(name = "end_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
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
	@Column(name = "last_order_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
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
	@Column(name = "next_order_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getNextOrderDate() {
		return nextOrderDate;
	}
	

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setNextOrderDate(DateTime nextOrderDate) {
		this.nextOrderDate = nextOrderDate;
	}

	@Column(name = "active",  nullable = true)
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Column(name = "qty",  nullable = true)
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Transient
	public ProductRepeatOrderHistory getProductRepeatOrderHistory() {
		return productRepeatOrderHistory;
	}

	public void setProductRepeatOrderHistory(ProductRepeatOrderHistory productRepeatOrderHistory) {
		this.productRepeatOrderHistory = productRepeatOrderHistory;
	}
	
	@Column(name = "unit_amt",  nullable = true)
	public Double getUnitAmount() {
		return unitAmount;
	}

	public void setUnitAmount(Double unitAmount) {
		this.unitAmount = unitAmount;
	}

	@Column(name = "ship_amt",  nullable = true)
	public Double getShipAmount() {
		return shipAmount;
	}

	public void setShipAmount(Double shipAmount) {
		this.shipAmount = shipAmount;
	}

	@Column(name = "total_amt",  nullable = true)
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "discount_amt",  nullable = true)
	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Column(name = "tax_amt",  nullable = true)
	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	@Column(name = "total_order_amt",  nullable = true)
	public Double getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(Double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	@Column(name = "confirmation_number",  nullable = true,length=50)
	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	@Transient
	public ProductRepeatOrderAddress getProductRepeatOrderAddress() {
		return productRepeatOrderAddress;
	}
	
	public void setProductRepeatOrderAddress(ProductRepeatOrderAddress productRepeatOrderAddress) {
		this.productRepeatOrderAddress = productRepeatOrderAddress;
	}

	@Column(name = "email",  nullable = true,length=50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone_mobile",  nullable = true,length=50)
	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	@Column(name = "phone_home",  nullable = true,length=50)
	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}

	@Column(name = "phone_work",  nullable = true,length=50)
	public String getPhoneWork() {
		return phoneWork;
	}

	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}

	@Column(name = "user_id",  nullable = true, length = 20)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "brand_id",  nullable = true, length = 20)
	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	@Transient
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	@Transient
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Transient
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	@Transient
	public String getCardSecurityCode() {
		return cardSecurityCode;
	}

	public void setCardSecurityCode(String cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}
	
	
	@JsonIgnore
	@OneToMany(targetEntity=ProductRepeatOrderHistory.class,mappedBy="productRepeatOrder",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<ProductRepeatOrderHistory> getOrderHistories() {
		return orderHistories;
	}

	public void setOrderHistories(List<ProductRepeatOrderHistory> orderHistories) {
		this.orderHistories = orderHistories;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
		result = prime * result + ((cardExpiryDate == null) ? 0 : cardExpiryDate.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + ((cardSecurityCode == null) ? 0 : cardSecurityCode.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((confirmationNumber == null) ? 0 : confirmationNumber.hashCode());
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((lastOrderDate == null) ? 0 : lastOrderDate.hashCode());
		result = prime * result + ((nextOrderDate == null) ? 0 : nextOrderDate.hashCode());
		result = prime * result + ((orderHistories == null) ? 0 : orderHistories.hashCode());
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
		if (cardExpiryDate == null) {
			if (other.cardExpiryDate != null)
				return false;
		} else if (!cardExpiryDate.equals(other.cardExpiryDate))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardSecurityCode == null) {
			if (other.cardSecurityCode != null)
				return false;
		} else if (!cardSecurityCode.equals(other.cardSecurityCode))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
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
		if (orderHistories == null) {
			if (other.orderHistories != null)
				return false;
		} else if (!orderHistories.equals(other.orderHistories))
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
				+ productRepeatOrderAddress + ", cardType=" + cardType + ", cardNumber=" + cardNumber
				+ ", cardExpiryDate=" + cardExpiryDate + ", cardSecurityCode=" + cardSecurityCode + ", orderHistories="
				+ orderHistories + "]";
	}

	@Override
	public int compareTo(ProductRepeatOrder arg0) {
		return 0;
	}
}
