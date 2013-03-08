package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mize.domain.util.Formatter;
import com.mize.domain.util.NumberValueSerializer;

public class ProductPrices {
	
	private List<ProductPrice> productPriceList = new ArrayList<ProductPrice>();
	private Integer count ;
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
	public List<ProductPrice> getProductPriceList() {
		return productPriceList;
	}

	public void setProductPriceList(List<ProductPrice> productPriceList) {
		this.productPriceList = productPriceList;
	}

	public Integer getCount() {
		return Formatter.isEmpty(productPriceList) ? null :productPriceList.size() ;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
}
