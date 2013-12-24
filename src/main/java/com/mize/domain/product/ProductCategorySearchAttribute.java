package com.mize.domain.product;


import com.mize.domain.common.MizeEntity;

public class ProductCategorySearchAttribute extends MizeEntity implements Comparable<ProductCategorySearchAttribute>{

	private static final long serialVersionUID = -2450196415219764436L;
	private Long srcCategoryId;
	private Long srcAttributeId;
	private Long attributeId;
	private Integer isactive;
	private Integer isPreferred;
	
	public Long getSrcAttributeId() {
		return srcAttributeId;
	}
	public void setSrcAttributeId(Long srcAttributeId) {
		this.srcAttributeId = srcAttributeId;
	}
	public Long getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public Integer getIsPreferred() {
		return isPreferred;
	}
	public void setIsPreferred(Integer isPreferred) {
		this.isPreferred = isPreferred;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSrcCategoryId() {
		return srcCategoryId;
	}
	public void setSrcCategoryId(Long srcCategoryId) {
		this.srcCategoryId = srcCategoryId;
	}	
	
	@Override
	public String toString() {
		return "ProductCategorySearchAttribute [srcCategoryId=" + srcCategoryId
				+ ", srcAttributeId=" + srcAttributeId + ", attributeId="
				+ attributeId + ", isactive=" + isactive + ", isPreferred="
				+ isPreferred + "]";
	}
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((attributeId == null) ? 0 : attributeId.hashCode());
		result = prime * result
				+ ((isPreferred == null) ? 0 : isPreferred.hashCode());
		result = prime * result
				+ ((isactive == null) ? 0 : isactive.hashCode());
		result = prime * result
				+ ((srcAttributeId == null) ? 0 : srcAttributeId.hashCode());
		result = prime * result
				+ ((srcCategoryId == null) ? 0 : srcCategoryId.hashCode());
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
		ProductCategorySearchAttribute other = (ProductCategorySearchAttribute) obj;
		if (attributeId == null) {
			if (other.attributeId != null)
				return false;
		} else if (!attributeId.equals(other.attributeId))
			return false;
		if (isPreferred == null) {
			if (other.isPreferred != null)
				return false;
		} else if (!isPreferred.equals(other.isPreferred))
			return false;
		if (isactive == null) {
			if (other.isactive != null)
				return false;
		} else if (!isactive.equals(other.isactive))
			return false;
		if (srcAttributeId == null) {
			if (other.srcAttributeId != null)
				return false;
		} else if (!srcAttributeId.equals(other.srcAttributeId))
			return false;
		if (srcCategoryId == null) {
			if (other.srcCategoryId != null)
				return false;
		} else if (!srcCategoryId.equals(other.srcCategoryId))
			return false;
		return true;
	}
	@Override
	public int compareTo(ProductCategorySearchAttribute arg0) {
		return 0;
	}	
	
}
