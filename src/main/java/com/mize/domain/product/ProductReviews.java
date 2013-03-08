package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.util.Formatter;

public class ProductReviews {
	
	private List<ProductReview> productReviewList = new ArrayList<ProductReview>();
	private Integer count ;
	
	public static class ProductReview {
		private String reviewLink;
		private String sourceName;
		protected Long sourceId;

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
		public String getReviewLink() {
			return reviewLink;
		}
		public void setReviewLink(String reviewLink) {
			this.reviewLink = reviewLink;
		}	
	}

	public List<ProductReview> getProductReviewList() {
		return productReviewList;
	}

	public void setProductReviewList(List<ProductReview> productReviewList) {
		this.productReviewList = productReviewList;
	}

	public Integer getCount() {
		return Formatter.isEmpty(productReviewList) ? null :productReviewList.size() ;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
			
}
