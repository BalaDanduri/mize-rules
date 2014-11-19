package com.mize.domain.sce.servicebulletin;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mize.domain.common.MizeSceEntity;

/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */
@Entity
@Table(name = "srvc_blltn_amt")
public class ServiceBulletinAmount extends MizeSceEntity implements Comparable<ServiceBulletinAmount> {

	
	private static final long serialVersionUID = 2518021731761580833L;
	
	private BigDecimal approvedQty;
	private BigDecimal approvedAmount;
	private BigDecimal approvedTotalAmount;

	public ServiceBulletinAmount() {
		
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
	
	@Column(name = "approved_quantity", precision = 20, scale = 6)
	public BigDecimal getApprovedQty() {
		return approvedQty;
	}

	public void setApprovedQty(BigDecimal approvedQty) {
		this.approvedQty = approvedQty;
	}
	
	@Column(name = "approved_amount", precision = 20, scale = 6)
	public BigDecimal getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(BigDecimal approvedAmount) {
		this.approvedAmount = approvedAmount;
	}
	
	@Column(name = "approved_total_amount", precision = 20, scale = 6)
	public BigDecimal getApprovedTotalAmount() {
		return approvedTotalAmount;
	}

	public void setApprovedTotalAmount(BigDecimal approvedTotalAmount) {
		this.approvedTotalAmount = approvedTotalAmount;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((approvedQty == null) ? 0 : approvedQty.hashCode());
		result = prime * result
				+ ((approvedAmount == null) ? 0 : approvedAmount.hashCode());
		result = prime
				* result
				+ ((approvedTotalAmount == null) ? 0 : approvedTotalAmount
						.hashCode());
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
		ServiceBulletinAmount other = (ServiceBulletinAmount) obj;
		if (approvedQty == null) {
			if (other.approvedQty != null)
				return false;
		} else if (!approvedAmount.equals(other.approvedAmount))
			return false;
		if (approvedTotalAmount == null) {
			if (other.approvedTotalAmount != null)
				return false;
		}
		return true;
	}

	@Override
	public int compareTo(ServiceBulletinAmount o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
