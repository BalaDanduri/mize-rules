package com.mize.domain.product;


public class ProductSource  {
	
	protected Long productId;
	protected Long sourceId;
	protected String sourceProductId;

	
	public ProductSource() {
		// TODO Auto-generated constructor stub
	}
	

	public ProductSource(Long productId, Long sourceId, String sourceProductId) {
		this.productId = productId;
		this.sourceId = sourceId;
		this.sourceProductId = sourceProductId;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result
				+ ((sourceProductId == null) ? 0 : sourceProductId.hashCode());
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
			if (other.getProductId() != null)
				return false;
		} else if (!productId.equals(other.getProductId()))
			return false;
		if (sourceId == null) {
			if (other.getSourceId() != null)
				return false;
		} else if (!sourceId.equals(other.getSourceId()))
			return false;
		if (sourceProductId == null) {
			if (other.getSourceProductId() != null)
				return false;
		} else if (!sourceProductId.equals(other.getSourceProductId()))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", sourceId=" + sourceId + ", sourceProductId="
				+ sourceProductId + "]";
	}
}
