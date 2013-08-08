package com.mize.domain.product;

import com.mize.domain.common.Entity;


public class ProductSource  extends Entity{
	
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
}
