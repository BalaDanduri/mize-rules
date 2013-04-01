package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.Entity;
import com.mize.domain.util.Formatter;

public class ProductLinks extends Entity{
	
	private static final long serialVersionUID = 8848336876918401799L;
	private List<ProductLink> productLinkList = new ArrayList<ProductLink>();
	@SuppressWarnings("unused")
	private Integer count ;
	
	public static class ProductLink {
		private String productLink;
		private String sourceName;
		protected Long sourceId;		
		
		public String getProductLink() {
			return productLink;
		}
		public void setProductLink(String productLink) {
			this.productLink = productLink;
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
		return (count = Formatter.isEmpty(productLinkList) ? null :productLinkList.size());
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
