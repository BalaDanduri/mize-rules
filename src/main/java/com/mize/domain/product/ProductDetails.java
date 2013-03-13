package com.mize.domain.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mize.domain.common.Entity;

public class ProductDetails extends Entity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6338652951554117142L;

	public enum DESC{
		PRD_DESC("Product Description");
		private String desc;
		DESC(String value){
			desc = value;
		}
		public String getDesc(){
			return desc;
		}
	}
	private List<ProductFeature> productFeatures;
	private List<SimilarProducts> similarProducts;
	private List<SimilarProducts> accessories;
	private Map<String,Dimension> dimensions;	
	private String detailsDescription;
	private String warranty;
	private List<ProductImage> productImages;
	private List<ProductImageSet> imageSets;
	private ProductPrices productPrices;
	private ProductLinks productLinks;
	private ProductReviews productReviews;

	public ProductDetails(){
		productFeatures = new ArrayList<ProductFeature>();
		dimensions = new HashMap<String, Dimension>();
		similarProducts = new ArrayList<SimilarProducts>();
		productImages = new ArrayList<ProductImage>();
		imageSets = new ArrayList<ProductImageSet>();
		accessories = new ArrayList<SimilarProducts>();
		productPrices = new ProductPrices();
	}
	
	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	

	public List<ProductFeature> getProductFeatures() {
		return productFeatures;
	}

	public void setProductFeatures(List<ProductFeature> productFeatures) {
		this.productFeatures = productFeatures;
	}
	
	public List<SimilarProducts> getSimilarProducts() {
		return similarProducts;
	}

	public void setSimilarProducts(List<SimilarProducts> similarProducts) {
		this.similarProducts = similarProducts;
	}

	public Map<String, Dimension> getDimensions() {
		return dimensions;
	}

	public void setDimensions(Map<String, Dimension> dimensions) {
		this.dimensions = dimensions;
	}

	public String getDetailsDescription() {
		return detailsDescription;
	}

	public void setDetailsDescription(String detailsDescription) {
		this.detailsDescription = detailsDescription;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public List<ProductImageSet> getImageSets() {
		return imageSets;
	}

	public void setImageSets(List<ProductImageSet> imageSets) {
		this.imageSets = imageSets;
	}

	public List<SimilarProducts> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<SimilarProducts> accessories) {
		this.accessories = accessories;
	}

	public ProductPrices getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(ProductPrices productPrices) {
		this.productPrices = productPrices;
	}

	public ProductLinks getProductLinks() {
		return productLinks;
	}

	public void setProductLinks(ProductLinks productLinks) {
		this.productLinks = productLinks;
	}

	public ProductReviews getProductReviews() {
		return productReviews;
	}

	public void setProductReviews(ProductReviews productReviews) {
		this.productReviews = productReviews;
	}
	
}
