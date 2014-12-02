package com.mize.domain.purchaseorder;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name = "purchase_order_amount")
public class PurchaseOrderAmount extends MizeSceEntity implements Comparable<PurchaseOrderAmount>{	

	private static final long serialVersionUID = 261638805962518728L;
	private BigDecimal requestedAmount;
	private BigDecimal adjustedAmount;	
	private BigDecimal totalAmount;
	private BigDecimal discountAmount;
	private BigDecimal handlingAmount;
	private BigDecimal shippingAmount;
	private BigDecimal taxAmount;
	private BigDecimal miscellaneousAmount;	
	private BigDecimal freightAmount;
	private BigDecimal totalAdjustedAmount;
	
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

	@Column(name = "requested_amount")
	public BigDecimal getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(BigDecimal requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	@Column(name = "adjusted_amount")
	public BigDecimal getAdjustedAmount() {
		return adjustedAmount;
	}

	public void setAdjustedAmount(BigDecimal adjustedAmount) {
		this.adjustedAmount = adjustedAmount;
	}

	@Column(name = "total_amount")
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "discount_amount")
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	@Column(name = "handling_amount")
	public BigDecimal getHandlingAmount() {
		return handlingAmount;
	}

	public void setHandlingAmount(BigDecimal handlingAmount) {
		this.handlingAmount = handlingAmount;
	}

	@Column(name = "shipping_amount")
	public BigDecimal getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(BigDecimal shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	@Column(name = "tax_amount")
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	@Column(name = "miscellaneous_amount")
	public BigDecimal getMiscellaneousAmount() {
		return miscellaneousAmount;
	}

	public void setMiscellaneousAmount(BigDecimal miscellaneousAmount) {
		this.miscellaneousAmount = miscellaneousAmount;
	}	

	@Column(name = "freight_amount")
	public BigDecimal getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(BigDecimal freightAmount) {
		this.freightAmount = freightAmount;
	}

	@Column(name = "total_adjusted_amount")
	public BigDecimal getTotalAdjustedAmount() {
		return totalAdjustedAmount;
	}

	public void setTotalAdjustedAmount(BigDecimal totalAdjustedAmount) {
		this.totalAdjustedAmount = totalAdjustedAmount;
	}

	@Override
	public int compareTo(PurchaseOrderAmount o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((adjustedAmount == null) ? 0 : adjustedAmount.hashCode());
		result = prime * result
				+ ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result
				+ ((freightAmount == null) ? 0 : freightAmount.hashCode());
		result = prime * result
				+ ((handlingAmount == null) ? 0 : handlingAmount.hashCode());
		result = prime
				* result
				+ ((miscellaneousAmount == null) ? 0 : miscellaneousAmount
						.hashCode());
		result = prime * result
				+ ((requestedAmount == null) ? 0 : requestedAmount.hashCode());
		result = prime * result
				+ ((shippingAmount == null) ? 0 : shippingAmount.hashCode());
		result = prime * result
				+ ((taxAmount == null) ? 0 : taxAmount.hashCode());
		result = prime * result
				+ ((totalAmount == null) ? 0 : totalAmount.hashCode());
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
		PurchaseOrderAmount other = (PurchaseOrderAmount) obj;
		if (adjustedAmount == null) {
			if (other.adjustedAmount != null)
				return false;
		} else if (!adjustedAmount.equals(other.adjustedAmount))
			return false;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (freightAmount == null) {
			if (other.freightAmount != null)
				return false;
		} else if (!freightAmount.equals(other.freightAmount))
			return false;
		if (handlingAmount == null) {
			if (other.handlingAmount != null)
				return false;
		} else if (!handlingAmount.equals(other.handlingAmount))
			return false;
		if (miscellaneousAmount == null) {
			if (other.miscellaneousAmount != null)
				return false;
		} else if (!miscellaneousAmount.equals(other.miscellaneousAmount))
			return false;
		if (requestedAmount == null) {
			if (other.requestedAmount != null)
				return false;
		} else if (!requestedAmount.equals(other.requestedAmount))
			return false;
		if (shippingAmount == null) {
			if (other.shippingAmount != null)
				return false;
		} else if (!shippingAmount.equals(other.shippingAmount))
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
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderAmount [requestedAmount=" + requestedAmount
				+ ", adjustedAmount=" + adjustedAmount + ", totalAmount="
				+ totalAmount + ", discountAmount=" + discountAmount
				+ ", handlingAmount=" + handlingAmount + ", shippingAmount="
				+ shippingAmount + ", taxAmount=" + taxAmount
				+ ", miscellaneousAmount=" + miscellaneousAmount
				+ ", freightAmount=" + freightAmount + "]";
	}
		

}
