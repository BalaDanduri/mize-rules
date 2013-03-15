package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.Entity;

public class ProductBuyList extends Entity{

	private static final long serialVersionUID = -4712168162637629908L;
	private List<ProductBuyItem> productBuyItems = new ArrayList<ProductBuyItem>();
	
	public static class ProductBuyItem {
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
