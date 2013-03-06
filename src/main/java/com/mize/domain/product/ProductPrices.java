package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mize.domain.util.NumberValueSerializer;

public class ProductPrices {
	
	private List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
	
	public static class ProductPrice {
		@JsonSerialize(using=NumberValueSerializer.class)
		private Double price;
		private String sourceName;
		protected Long sourceId;
		
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getSourceName() {
			return sourceName;
		}
		public void setSourceName(String sourceName) {
			this.sourceName = sourceName;
		}
		public Long getSourceId() {
			return sourceId;
		}
		public void setSourceId(Long sourceId) {
			this.sourceId = sourceId;
		}
		
	}

	public List<ProductPrice> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(List<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}
	
	public void addProductPrice(ProductPrice productPrice) {
		this.productPrices.add(productPrice);
	}
}
