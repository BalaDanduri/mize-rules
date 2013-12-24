package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;

public class Unit extends MizeEntity implements Comparable<Unit> {

	private static final long serialVersionUID = 936976445854937548L;
	private Long unitId;
	private String unitName;
	private Long baseUnitId;
	private Integer multiple;
	private String unitSign;
	private String pattern;
	private Integer tid;
	private Long prodSourceId;
	
	
	public Long getUnitId() {
		return unitId;
	}
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Long getBaseUnitId() {
		return baseUnitId;
	}
	public void setBaseUnitId(Long baseUnitId) {
		this.baseUnitId = baseUnitId;
	}
	public Integer getMultiple() {
		return multiple;
	}
	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}
	public String getUnitSign() {
		return unitSign;
	}
	public void setUnitSign(String unitSign) {
		this.unitSign = unitSign;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Long getProdSourceId() {
		return prodSourceId;
	}
	public void setProdSourceId(Long prodSourceId) {
		this.prodSourceId = prodSourceId;
	}
	@Override
	public int compareTo(Unit arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((baseUnitId == null) ? 0 : baseUnitId.hashCode());
		result = prime * result + ((multiple == null) ? 0 : multiple.hashCode());
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		result = prime * result + ((prodSourceId == null) ? 0 : prodSourceId.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + ((unitId == null) ? 0 : unitId.hashCode());
		result = prime * result + ((unitName == null) ? 0 : unitName.hashCode());
		result = prime * result + ((unitSign == null) ? 0 : unitSign.hashCode());
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
		Unit other = (Unit) obj;
		if (baseUnitId == null) {
			if (other.baseUnitId != null)
				return false;
		} else if (!baseUnitId.equals(other.baseUnitId))
			return false;
		if (multiple == null) {
			if (other.multiple != null)
				return false;
		} else if (!multiple.equals(other.multiple))
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		if (prodSourceId == null) {
			if (other.prodSourceId != null)
				return false;
		} else if (!prodSourceId.equals(other.prodSourceId))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (unitId == null) {
			if (other.unitId != null)
				return false;
		} else if (!unitId.equals(other.unitId))
			return false;
		if (unitName == null) {
			if (other.unitName != null)
				return false;
		} else if (!unitName.equals(other.unitName))
			return false;
		if (unitSign == null) {
			if (other.unitSign != null)
				return false;
		} else if (!unitSign.equals(other.unitSign))
			return false;
		return true;
	}

	
}
