package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

public class ProductPrices {
	
	private List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
	
	public static class ProductPrice {
		private Double price;
		private String sourceName;
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
