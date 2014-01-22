package com.mize.domain.serviceentity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name = "service_entity_amount")
public class ServiceEntityAmount extends MizeEntity implements Comparable<ServiceEntityAmount> {
	private static final long serialVersionUID = 6821336389676111L;
	private BigDecimal requestedQuantity;
	private BigDecimal adjustedQuantity;
	private BigDecimal adjustedAmount;
	private BigDecimal requestedAmount;
	private BigDecimal totalAmount;
	private BigDecimal discountAmount;
	private BigDecimal handlingAmount;
	private BigDecimal freightAmount;
	private BigDecimal taxAmount;
	private BigDecimal miscellaneousAmount;
	
	public ServiceEntityAmount() {
		super();
	}
	
	public ServiceEntityAmount(Long id) {
		super();
		this.id = id;
		
	}
	
	public ServiceEntityAmount(BigDecimal requestedQuantity, BigDecimal adjustedQuantity,
			BigDecimal adjustedAmount, BigDecimal requestedAmount,
			BigDecimal totalAmount, BigDecimal discountAmount,
			BigDecimal handlingAmount, BigDecimal freightAmount,
			BigDecimal taxAmount, BigDecimal miscellaneousAmount) {
		super();
		this.requestedQuantity = requestedQuantity;
		this.adjustedQuantity = adjustedQuantity;
		this.adjustedAmount = adjustedAmount;
		this.requestedAmount = requestedAmount;
		this.totalAmount = totalAmount;
		this.discountAmount = discountAmount;
		this.handlingAmount = handlingAmount;
		this.freightAmount = freightAmount;
		this.taxAmount = taxAmount;
		this.miscellaneousAmount = miscellaneousAmount;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}	

	@Column(name = "requested_quantity", nullable = true)
	public BigDecimal getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(BigDecimal requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	@Column(name = "adjusted_quantity", nullable = true)
	public BigDecimal getAdjustedQuantity() {
		return adjustedQuantity;
	}

	public void setAdjustedQuantity(BigDecimal adjustedQuantity) {
		this.adjustedQuantity = adjustedQuantity;
	}

	@Column(name = "adjusted_amount", nullable = true)
	public BigDecimal getAdjustedAmount() {
		return adjustedAmount;
	}

	public void setAdjustedAmount(BigDecimal adjustedAmount) {
		this.adjustedAmount = adjustedAmount;
	}

	@Column(name = "requested_amount", nullable = true)
	public BigDecimal getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(BigDecimal requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	@Column(name = "total_amount", nullable = true)
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Transient
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Transient
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore(value=false)
	@Transient
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore(value=false)
	@Transient
	public Long getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Override
	public int compareTo(ServiceEntityAmount arg0) {
		return 0;
	}

	@Column(name = "discount_amount", nullable = true)
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Column(name = "handling_amount", nullable = true)
	public BigDecimal getHandlingAmount() {
		return handlingAmount;
	}

	public void setHandlingAmount(BigDecimal handlingAmount) {
		this.handlingAmount = handlingAmount;
	}

	@Column(name = "freight_amount", nullable = true)
	public BigDecimal getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(BigDecimal freightAmount) {
		this.freightAmount = freightAmount;
	}

	@Column(name = "tax_amount", nullable = true)
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	@Column(name = "miscellaneous_amount", nullable = true)
	public BigDecimal getMiscellaneousAmount() {
		return miscellaneousAmount;
	}

	public void setMiscellaneousAmount(BigDecimal miscellaneousAmount) {
		this.miscellaneousAmount = miscellaneousAmount;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((adjustedAmount == null) ? 0 : adjustedAmount.hashCode());
		result = prime
				* result
				+ ((adjustedQuantity == null) ? 0 : adjustedQuantity.hashCode());
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
		result = prime
				* result
				+ ((requestedQuantity == null) ? 0 : requestedQuantity
						.hashCode());
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
		if (adjustedQuantity == null) {
			if (other.adjustedQuantity != null)
				return false;
		} else if (!adjustedQuantity.equals(other.adjustedQuantity))
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
		if (requestedQuantity == null) {
			if (other.requestedQuantity != null)
				return false;
		} else if (!requestedQuantity.equals(other.requestedQuantity))
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
		StringBuilder builder = new StringBuilder();
		builder.append("SEAmount [requestedQuantity=");
		builder.append(requestedQuantity);
		builder.append(", adjustedQuantity=");
		builder.append(adjustedQuantity);
		builder.append(", adjustedAmount=");
		builder.append(adjustedAmount);
		builder.append(", requestedAmount=");
		builder.append(requestedAmount);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", discountAmount=");
		builder.append(discountAmount);
		builder.append(", handlingAmount=");
		builder.append(handlingAmount);
		builder.append(", freightAmount=");
		builder.append(freightAmount);
		builder.append(", taxAmount=");
		builder.append(taxAmount);
		builder.append(", miscellaneousAmount=");
		builder.append(miscellaneousAmount);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
}
