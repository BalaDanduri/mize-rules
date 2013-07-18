package com.mize.domain.product;

public class EngagementLink {
	private Engagement engagement;
	private Product product;
	private ProductCategory prodCategory;
	public Engagement getEngagement() {
		return engagement;
	}
	public void setEngagement(Engagement engagement) {
		this.engagement = engagement;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductCategory getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(ProductCategory prodCategory) {
		this.prodCategory = prodCategory;
	}

}
