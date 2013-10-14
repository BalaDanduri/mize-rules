package com.mize.domain.product;


import com.mize.domain.common.MizeEntity;



public class ProductCategoryName extends MizeEntity{

	private static final long serialVersionUID = -2450196415219764436L;
	private Long srcCategoryId;
	private String name;
	private Integer localeId;	
	
	public Long getSrcCategoryId() {
		return srcCategoryId;
	}
	public void setSrcCategoryId(Long srcCategoryId) {
		this.srcCategoryId = srcCategoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Integer localeId) {
		this.localeId = localeId;
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
	public String toString() {
		return "ProductCategoryName [srcCategoryId=" + srcCategoryId
				+ ", name=" + name + ", localeId=" + localeId + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((localeId == null) ? 0 : localeId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ProductCategoryName other = (ProductCategoryName) obj;
		if (localeId == null) {
			if (other.localeId != null)
				return false;
		} else if (!localeId.equals(other.localeId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (srcCategoryId == null) {
			if (other.srcCategoryId != null)
				return false;
		} else if (!srcCategoryId.equals(other.srcCategoryId))
			return false;
		return true;
	}
	
}
