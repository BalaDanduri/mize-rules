package com.mize.domain.product;

import java.util.List;

import com.mize.domain.common.MizeEntity;

public class ProdListItems extends MizeEntity implements Comparable<ProdListItems>{

	private static final long serialVersionUID = 8289857282481014535L;

	private ProdList prodList;
	private List<Product> products;
	private String active;
	private String sourceId;
	private String sourceType;
	
	public ProdList getProdList() {
		return prodList;
	}

	public void setProdList(ProdList prodList) {
		this.prodList = prodList;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
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
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((prodList == null) ? 0 : prodList.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result + ((sourceType == null) ? 0 : sourceType.hashCode());
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
		ProdListItems other = (ProdListItems) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (prodList == null) {
			if (other.prodList != null)
				return false;
		} else if (!prodList.equals(other.prodList))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		if (sourceType == null) {
			if (other.sourceType != null)
				return false;
		} else if (!sourceType.equals(other.sourceType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProdListItems [prodList=" + prodList + ", products=" + products + ", active=" + active + ", sourceId="
				+ sourceId + ", sourceType=" + sourceType + "]";
	}

	@Override
	public int compareTo(ProdListItems arg0) {
		return 0;
	}

}
