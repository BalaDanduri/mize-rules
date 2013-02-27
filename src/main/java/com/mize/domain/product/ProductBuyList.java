package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

public class ProductBuyList {
	
	private List<ProductBuyItem> productBuyItems = new ArrayList<ProductBuyItem>();
	
	public class ProductBuyItem {
		private String buyLink;
		private String sourceName;
		public String getBuyLink() {
			return buyLink;
		}
		public void setBuyLink(String buyLink) {
			this.buyLink = buyLink;
		}
		public String getSourceName() {
			return sourceName;
		}
		public void setSourceName(String sourceName) {
			this.sourceName = sourceName;
		}
		
	}

	public List<ProductBuyItem> getProductBuyItems() {
		return productBuyItems;
	}

	public void setProductBuyItems(List<ProductBuyItem> productBuyItems) {
		this.productBuyItems = productBuyItems;
	}
	
	public void addProductBuyItem(ProductBuyItem productBuyItem) {
		this.productBuyItems.add(productBuyItem);
	}

}
