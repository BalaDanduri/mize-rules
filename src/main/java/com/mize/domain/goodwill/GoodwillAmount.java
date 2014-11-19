package com.mize.domain.goodwill;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mize.domain.common.MizeSceEntity;
/**
 * @author Raghavendra Serikar
 * @version 1.0
 */
@Entity
@Table(name="goodwill_amount")
public class GoodwillAmount extends MizeSceEntity implements Comparable<GoodwillAmount>{
	
	private static final long serialVersionUID = 6653001788453076837L;
	private BigDecimal partAmount;
	private BigDecimal laborAmount;
	private BigDecimal otherAmount;
	private BigDecimal totalAmount;
	
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
	    this.id = id;	
	}
	
	@Column(name = "part_amount", length = 20)
	public BigDecimal getPartAmount() {
		return partAmount;
	}

	@Column(name = "labor_amount", length = 20)
	public BigDecimal getLaborAmount() {
		return laborAmount;
	}

	@Column(name = "other_amount", length = 20)
	public BigDecimal getOtherAmount() {
		return otherAmount;
	}

	@Column(name = "total_amount", length = 20)
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setPartAmount(BigDecimal partAmount) {
		this.partAmount = partAmount;
	}

	public void setLaborAmount(BigDecimal laborAmount) {
		this.laborAmount = laborAmount;
	}

	public void setOtherAmount(BigDecimal otherAmount) {
		this.otherAmount = otherAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((laborAmount == null) ? 0 : laborAmount.hashCode());
		result = prime * result
				+ ((otherAmount == null) ? 0 : otherAmount.hashCode());
		result = prime * result
				+ ((partAmount == null) ? 0 : partAmount.hashCode());
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
		GoodwillAmount other = (GoodwillAmount) obj;
		if (laborAmount == null) {
			if (other.laborAmount != null)
				return false;
		} else if (!laborAmount.equals(other.laborAmount))
			return false;
		if (otherAmount == null) {
			if (other.otherAmount != null)
				return false;
		} else if (!otherAmount.equals(other.otherAmount))
			return false;
		if (partAmount == null) {
			if (other.partAmount != null)
				return false;
		} else if (!partAmount.equals(other.partAmount))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		return true;
	}

	@Override
	public int compareTo(GoodwillAmount o) {
		return 0;
	}
}
