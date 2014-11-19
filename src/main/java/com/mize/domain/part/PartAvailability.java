package com.mize.domain.part;

import java.math.BigDecimal;

import com.mize.domain.common.MizeSceEntity;

public class PartAvailability extends MizeSceEntity implements Comparable<PartAvailability> {

	private static final long serialVersionUID = -8604802160381208633L;
	private String code;
	private String name;
	private String status;
	private BigDecimal availableQuantity;
	private BigDecimal backorderQuantity;
	private BigDecimal requestedQuantity;
	private String uom;

	public PartAvailability(){
		super();
	}
	
	public PartAvailability(String code, BigDecimal availableQuantity,String uom) {
		super();
		this.code = code;
		this.availableQuantity = availableQuantity;
		this.uom = uom;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(BigDecimal availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public BigDecimal getBackorderQuantity() {
		return backorderQuantity;
	}

	public void setBackorderQuantity(BigDecimal backorderQuantity) {
		this.backorderQuantity = backorderQuantity;
	}

	public BigDecimal getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(BigDecimal requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime
				* result
				+ ((availableQuantity == null) ? 0 : availableQuantity
						.hashCode());
		result = prime
				* result
				+ ((backorderQuantity == null) ? 0 : backorderQuantity
						.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		PartAvailability other = (PartAvailability) obj;
		if (availableQuantity == null) {
			if (other.availableQuantity != null)
				return false;
		} else if (!availableQuantity.equals(other.availableQuantity))
			return false;
		if (backorderQuantity == null) {
			if (other.backorderQuantity != null)
				return false;
		} else if (!backorderQuantity.equals(other.backorderQuantity))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public int compareTo(PartAvailability o) {
		return 0;
	}

}
