package com.mize.domain.product;

import com.mize.domain.common.MizeSceEntity;

public class UnitNames extends MizeSceEntity implements Comparable<UnitNames>{

	private static final long serialVersionUID = 7598623592535043440L;
	private Long unitId;
	private String unitName;
	private Long localeId;
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

	public Long getLocaleId() {
		return localeId;
	}

	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
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
		result = prime * result + ((localeId == null) ? 0 : localeId.hashCode());
		result = prime * result + ((prodSourceId == null) ? 0 : prodSourceId.hashCode());
		result = prime * result + ((unitId == null) ? 0 : unitId.hashCode());
		result = prime * result + ((unitName == null) ? 0 : unitName.hashCode());
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
		UnitNames other = (UnitNames) obj;
		if (localeId == null) {
			if (other.localeId != null)
				return false;
		} else if (!localeId.equals(other.localeId))
			return false;
		if (prodSourceId == null) {
			if (other.prodSourceId != null)
				return false;
		} else if (!prodSourceId.equals(other.prodSourceId))
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
		return true;
	}
	
	@Override
	public String toString() {
		return "UnitNames [unitId=" + unitId + ", unitName=" + unitName + ", localeId=" + localeId + ", prodSourceId="
				+ prodSourceId + "]";
	}

	@Override
	public int compareTo(UnitNames o) {
		return 0;
	}

}
