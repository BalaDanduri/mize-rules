package com.mize.domain.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mize.domain.common.Entity;

public class ProductDetails extends Entity{
	
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
	private List<Retailer> retailersList;

	public ProductDetails(){
		productFeatures = new ArrayList<ProductFeature>();
		dimensions = new HashMap<String, Dimension>();
		similarProducts = new ArrayList<SimilarProducts>();
		productImages = new ArrayList<ProductImage>();
		imageSets = new ArrayList<ProductImageSet>();
		accessories = new ArrayList<SimilarProducts>();
		retailersList = new ArrayList<Retailer>();
	}
	
	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}	
	
	public List<Retailer> getRetailersList() {
		return retailersList;
	}

	public void setRetailersList(List<Retailer> retailersList) {
		this.retailersList = retailersList;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessories == null) ? 0 : accessories.hashCode());
		result = prime * result + ((detailsDescription == null) ? 0 : detailsDescription.hashCode());
		result = prime * result + ((dimensions == null) ? 0 : dimensions.hashCode());
		result = prime * result + ((imageSets == null) ? 0 : imageSets.hashCode());
		result = prime * result + ((productFeatures == null) ? 0 : productFeatures.hashCode());
		result = prime * result + ((productImages == null) ? 0 : productImages.hashCode());
		result = prime * result + ((retailersList == null) ? 0 : retailersList.hashCode());
		result = prime * result + ((similarProducts == null) ? 0 : similarProducts.hashCode());
		result = prime * result + ((warranty == null) ? 0 : warranty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDetails other = (ProductDetails) obj;
		if (accessories == null) {
			if (other.accessories != null)
				return false;
		} else if (!accessories.equals(other.accessories))
			return false;
		if (detailsDescription == null) {
			if (other.detailsDescription != null)
				return false;
		} else if (!detailsDescription.equals(other.detailsDescription))
			return false;
		if (dimensions == null) {
			if (other.dimensions != null)
				return false;
		} else if (!dimensions.equals(other.dimensions))
			return false;
		if (imageSets == null) {
			if (other.imageSets != null)
				return false;
		} else if (!imageSets.equals(other.imageSets))
			return false;
		if (productFeatures == null) {
			if (other.productFeatures != null)
				return false;
		} else if (!productFeatures.equals(other.productFeatures))
			return false;
		if (productImages == null) {
			if (other.productImages != null)
				return false;
		} else if (!productImages.equals(other.productImages))
			return false;
		if (retailersList == null) {
			if (other.retailersList != null)
				return false;
		} else if (!retailersList.equals(other.retailersList))
			return false;
		if (similarProducts == null) {
			if (other.similarProducts != null)
				return false;
		} else if (!similarProducts.equals(other.similarProducts))
			return false;
		if (warranty == null) {
			if (other.warranty != null)
				return false;
		} else if (!warranty.equals(other.warranty))
			return false;
		return true;
	}
	
	
	
}
