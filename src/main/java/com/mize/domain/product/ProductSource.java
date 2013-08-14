package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;


public class ProductSource  extends MizeEntity implements Comparable<ProductSource>{
	
	private static final long serialVersionUID = -4500817575280246709L;
	public static final String SOURCE_MIZE = "1";
	public static final String SOURCE_AMAZON = "2";
	public static final String SOURCE_ETILIZE = "3";
	public static final Long AMAZON_SOURCE_ID = new Long(SOURCE_AMAZON);
	
	protected Long productId;
	protected Long sourceId;
	protected String sourceProductId;

	
	public ProductSource() {
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getSourceId() {
		return sourceId;
	}
	
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceProductId() {
		return sourceProductId;
	}
	
	public void setSourceProductId(String sourceProductId) {
		this.sourceProductId = sourceProductId;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", sourceId=" + sourceId + ", sourceProductId="
				+ sourceProductId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result + ((sourceProductId == null) ? 0 : sourceProductId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductSource other = (ProductSource) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		if (sourceProductId == null) {
			if (other.sourceProductId != null)
				return false;
		} else if (!sourceProductId.equals(other.sourceProductId))
			return false;
		return true;
	}

	@Override
	public int compareTo(ProductSource o) {
		return 0;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id  = id;
		
	}
	
}
