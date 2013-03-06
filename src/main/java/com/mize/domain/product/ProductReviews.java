package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

public class ProductReviews {
	
	private List<ProductReview> productReviews = new ArrayList<ProductReview>();
	
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
	public List<ProductReview> getProductReviews() {
		return productReviews;
	}

	public void setProductReviews(List<ProductReview> productReviews) {
		this.productReviews = productReviews;
	}
		
}
