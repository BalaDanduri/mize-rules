package com.mize.domain.socialnetwork;


public class ShareProductRequest{
		private String message;
		private String messageType;
		private String provider;
		private Product product;
		public class Product{
			private Long productId;
			private Long sourceId;
			private String sourceProductId;
			public Long getProductId() {
				return productId;
			}
			public void setProductId(Long productId) {
				this.productId = productId;
			}
			public Long getSourceId() {
				return sourceId;
			}
			public void setSourceId(Long sourceId) {
				this.sourceId = sourceId;
			}
			public String getSourceProductId() {
				return sourceProductId;
			}
			public void setSourceProductId(String sourceProductId) {
				this.sourceProductId = sourceProductId;
			}
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getMessageType() {
			return messageType;
		}
		public void setMessageType(String messageType) {
			this.messageType = messageType;
		}
		public String getProvider() {
			return provider;
		}
		public void setProvider(String provider) {
			this.provider = provider;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public ShareProductRequest() {
			setProduct(new Product());
		}
	}