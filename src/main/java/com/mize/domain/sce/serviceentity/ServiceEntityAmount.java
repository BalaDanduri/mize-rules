package com.mize.domain.sce.serviceentity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mize.domain.common.MizeEntity;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_amt")
public class ServiceEntityAmount extends MizeEntity {

	
	private static final long serialVersionUID = 2518021731761580833L;
	
	private BigDecimal requestedQty;
	private BigDecimal adjustedQty;
	private BigDecimal requestedAmount;
	private BigDecimal adjustedAmount;
	private BigDecimal taxAmount;
	private BigDecimal totalAmount;

	public ServiceEntityAmount() {
		
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	@Column(name = "requested_quantity", precision = 20, scale = 6)
	public BigDecimal getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(BigDecimal requestedQty) {
		this.requestedQty = requestedQty;
	}
	
	@Column(name = "adjusted_quantity", precision = 20, scale = 6)
	public BigDecimal getAdjustedQty() {
		return adjustedQty;
	}

	public void setAdjustedQty(BigDecimal adjustedQty) {
		this.adjustedQty = adjustedQty;
	}
	
	@Column(name = "requested_amount", precision = 20, scale = 6)
	public BigDecimal getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(BigDecimal requestedAmount) {
		this.requestedAmount = requestedAmount;
	}
	
	@Column(name = "adjusted_amount", precision = 20, scale = 6)
	public BigDecimal getAdjustedAmount() {
		return adjustedAmount;
	}

	public void setAdjustedAmount(BigDecimal adjustedAmount) {
		this.adjustedAmount = adjustedAmount;
	}
	
	@Column(name = "tax_amount", precision = 20, scale = 6)
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	@Column(name = "total_amount", precision = 20, scale = 6)
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((adjustedAmount == null) ? 0 : adjustedAmount.hashCode());
		result = prime * result
				+ ((adjustedQty == null) ? 0 : adjustedQty.hashCode());
		result = prime * result
				+ ((requestedAmount == null) ? 0 : requestedAmount.hashCode());
		result = prime * result
				+ ((requestedQty == null) ? 0 : requestedQty.hashCode());
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
		ServiceEntityAmount other = (ServiceEntityAmount) obj;
		if (adjustedAmount == null) {
			if (other.adjustedAmount != null)
				return false;
		} else if (!adjustedAmount.equals(other.adjustedAmount))
			return false;
		if (adjustedQty == null) {
			if (other.adjustedQty != null)
				return false;
		} else if (!adjustedQty.equals(other.adjustedQty))
			return false;
		if (requestedAmount == null) {
			if (other.requestedAmount != null)
				return false;
		} else if (!requestedAmount.equals(other.requestedAmount))
			return false;
		if (requestedQty == null) {
			if (other.requestedQty != null)
				return false;
		} else if (!requestedQty.equals(other.requestedQty))
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
	

}
