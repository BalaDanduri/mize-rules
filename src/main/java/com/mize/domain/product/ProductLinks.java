package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.util.Formatter;

public class ProductLinks {
	
	private List<ProductLink> productLinkList = new ArrayList<ProductLink>();
	private Integer count ;
	
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

	public List<ProductLink> getProductLinkList() {
		return productLinkList;
	}

	public void setProductLinkList(List<ProductLink> productLinkList) {
		this.productLinkList = productLinkList;
	}

	public Integer getCount() {
		return Formatter.isEmpty(productLinkList) ? null :productLinkList.size() ;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
