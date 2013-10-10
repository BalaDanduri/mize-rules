package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;

public class Units extends MizeEntity implements Comparable<Units>{

	private static final long serialVersionUID = 936976445854937548L;
	private String unitsName;
	private Long  baseUnitId;
	private Integer multiple;
	private String unitsSign;
	private String pattern;
	private Integer tid;
	private Long prodSourceId;
	
	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
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

	public String getUnitsSign() {
		return unitsSign;
	}

	public void setUnitsSign(String unitsSign) {
		this.unitsSign = unitsSign;
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
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
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
		result = prime * result + ((unitsName == null) ? 0 : unitsName.hashCode());
		result = prime * result + ((unitsSign == null) ? 0 : unitsSign.hashCode());
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
		Units other = (Units) obj;
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
		if (unitsName == null) {
			if (other.unitsName != null)
				return false;
		} else if (!unitsName.equals(other.unitsName))
			return false;
		if (unitsSign == null) {
			if (other.unitsSign != null)
				return false;
		} else if (!unitsSign.equals(other.unitsSign))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Units [unitsName=" + unitsName + ", baseUnitId=" + baseUnitId + ", multiple=" + multiple
				+ ", unitsSign=" + unitsSign + ", pattern=" + pattern + ", tid=" + tid + ", prodSourceId="
				+ prodSourceId + "]";
	}

	@Override
	public int compareTo(Units o) {
		return 0;
	}

}
