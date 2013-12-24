package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;

public class AttributeName extends MizeEntity implements Comparable<AttributeName>{
	
	private static final long serialVersionUID = 9200960678285880479L;
	private Long srcAttrId;
	private Long attrId;
	private String attrName;
	private Long unitId;
	private Integer active;
	private Long localeId;
	private Integer attrType;
	
	public Long getSrcAttrId() {
		return srcAttrId;
	}

	public void setSrcAttrId(Long srcAttrId) {
		this.srcAttrId = srcAttrId;
	}

	public Long getAttrId() {
		return attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Long getLocaleId() {
		return localeId;
	}

	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}

	public Integer getAttrType() {
		return attrType;
	}

	public void setAttrType(Integer attrType) {
		this.attrType = attrType;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((attrId == null) ? 0 : attrId.hashCode());
		result = prime * result + ((attrName == null) ? 0 : attrName.hashCode());
		result = prime * result + ((attrType == null) ? 0 : attrType.hashCode());
		result = prime * result + ((localeId == null) ? 0 : localeId.hashCode());
		result = prime * result + ((srcAttrId == null) ? 0 : srcAttrId.hashCode());
		result = prime * result + ((unitId == null) ? 0 : unitId.hashCode());
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
		AttributeName other = (AttributeName) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (attrId == null) {
			if (other.attrId != null)
				return false;
		} else if (!attrId.equals(other.attrId))
			return false;
		if (attrName == null) {
			if (other.attrName != null)
				return false;
		} else if (!attrName.equals(other.attrName))
			return false;
		if (attrType == null) {
			if (other.attrType != null)
				return false;
		} else if (!attrType.equals(other.attrType))
			return false;
		if (localeId == null) {
			if (other.localeId != null)
				return false;
		} else if (!localeId.equals(other.localeId))
			return false;
		if (srcAttrId == null) {
			if (other.srcAttrId != null)
				return false;
		} else if (!srcAttrId.equals(other.srcAttrId))
			return false;
		if (unitId == null) {
			if (other.unitId != null)
				return false;
		} else if (!unitId.equals(other.unitId))
			return false;
		return true;
	}

	@Override
	public int compareTo(AttributeName o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
