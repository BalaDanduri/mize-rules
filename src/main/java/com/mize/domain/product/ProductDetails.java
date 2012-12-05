package com.mize.domain.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mize.domain.common.Entity;

public class ProductDetails extends Entity{

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
	private List<String> productFeatures;
	private List<SimilarProduct> similarProducts;
	private Map<String,Dimension> dimensions;	
	private String detailsDescription;
	private String warranty;
	private List<ProductImage> productImages;
	private List<ProductImageSet> imageSets;

	public ProductDetails(){
		productFeatures = new ArrayList<String>();
		dimensions = new HashMap<String, Dimension>();
		similarProducts = new ArrayList<SimilarProduct>();
		productImages = new ArrayList<ProductImage>();
		imageSets = new ArrayList<ProductImageSet>();
	}
	
	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	

	public List<String> getProductFeatures() {
		return productFeatures;
	}

	public void setProductFeatures(List<String> productFeatures) {
		this.productFeatures = productFeatures;
	}
	
	public List<SimilarProduct> getSimilarProducts() {
		return similarProducts;
	}

	public void setSimilarProducts(List<SimilarProduct> similarProducts) {
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
	
}
