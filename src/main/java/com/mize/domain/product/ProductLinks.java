package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

public class ProductLinks {
	
	private List<ProductLink> productLinks = new ArrayList<ProductLink>();
	
	public static class ProductLink {
		private String produtLink;
		private String sourceName;
		protected Long sourceId;
		public String getProdutLink() {
			return produtLink;
		}
		public void setProdutLink(String produtLink) {
			this.produtLink = produtLink;
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

	public List<ProductLink> getProductLinks() {
		return productLinks;
	}

	public void setProductLinks(List<ProductLink> productLinks) {
		this.productLinks = productLinks;
	}
		
}
