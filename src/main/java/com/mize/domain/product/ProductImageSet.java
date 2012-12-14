package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.BaseEntity;

public class ProductImageSet  extends BaseEntity{
	private String category;
	private List<ProductImage> productImages;
	
	public ProductImageSet(){
		productImages = new ArrayList<ProductImage>();
	}
	public enum Category{
		SwatchImage,SmallImage,ThumbnailImage,TinyImage,MediumImage,LargeImage,	
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}
	
}
