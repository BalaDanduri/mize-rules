package com.mize.domain.product;


import com.mize.domain.common.MizeEntity;

public class ProductCategoryHeader extends MizeEntity{

	private static final long serialVersionUID = -2450196415219764436L;
	private Long srcCategoryId;
	private Long srcHeaderId;
	private Long headerId;
	private Integer isactive;
	private Integer templateType;
	private Integer defaultDisplayOrder;
	private Integer displayOrder;
	public Long getSrcCategoryId() {
		return srcCategoryId;
	}
	public void setSrcCategoryId(Long srcCategoryId) {
		this.srcCategoryId = srcCategoryId;
	}
	public Long getSrcHeaderId() {
		return srcHeaderId;
	}
	public void setSrcHeaderId(Long srcHeaderId) {
		this.srcHeaderId = srcHeaderId;
	}
	public Long getHeaderId() {
		return headerId;
	}
	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}
	public Integer getIsactive() {
		return isactive;
	}
	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}
	public Integer getTemplateType() {
		return templateType;
	}
	public void setTemplateType(Integer templateType) {
		this.templateType = templateType;
	}
	public Integer getDefaultDisplayOrder() {
		return defaultDisplayOrder;
	}
	public void setDefaultDisplayOrder(Integer defaultDisplayOrder) {
		this.defaultDisplayOrder = defaultDisplayOrder;
	}
	public Integer getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	
	@Override
	public String toString() {
		return "ProductCategoryHeader [srcCategoryId=" + srcCategoryId
				+ ", srcHeaderId=" + srcHeaderId + ", headerId=" + headerId
				+ ", isactive=" + isactive + ", templateType=" + templateType
				+ ", defaultDisplayOrder=" + defaultDisplayOrder
				+ ", displayOrder=" + displayOrder + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime
				* result
				+ ((defaultDisplayOrder == null) ? 0 : defaultDisplayOrder
						.hashCode());
		result = prime * result
				+ ((displayOrder == null) ? 0 : displayOrder.hashCode());
		result = prime * result
				+ ((headerId == null) ? 0 : headerId.hashCode());
		result = prime * result
				+ ((isactive == null) ? 0 : isactive.hashCode());
		result = prime * result
				+ ((srcCategoryId == null) ? 0 : srcCategoryId.hashCode());
		result = prime * result
				+ ((srcHeaderId == null) ? 0 : srcHeaderId.hashCode());
		result = prime * result
				+ ((templateType == null) ? 0 : templateType.hashCode());
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
		ProductCategoryHeader other = (ProductCategoryHeader) obj;
		if (defaultDisplayOrder == null) {
			if (other.defaultDisplayOrder != null)
				return false;
		} else if (!defaultDisplayOrder.equals(other.defaultDisplayOrder))
			return false;
		if (displayOrder == null) {
			if (other.displayOrder != null)
				return false;
		} else if (!displayOrder.equals(other.displayOrder))
			return false;
		if (headerId == null) {
			if (other.headerId != null)
				return false;
		} else if (!headerId.equals(other.headerId))
			return false;
		if (isactive == null) {
			if (other.isactive != null)
				return false;
		} else if (!isactive.equals(other.isactive))
			return false;
		if (srcCategoryId == null) {
			if (other.srcCategoryId != null)
				return false;
		} else if (!srcCategoryId.equals(other.srcCategoryId))
			return false;
		if (srcHeaderId == null) {
			if (other.srcHeaderId != null)
				return false;
		} else if (!srcHeaderId.equals(other.srcHeaderId))
			return false;
		if (templateType == null) {
			if (other.templateType != null)
				return false;
		} else if (!templateType.equals(other.templateType))
			return false;
		return true;
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
