package com.mize.domain.product;

import java.util.List;

import com.mize.domain.common.Entity;

public class SimilarProducts extends Entity{

	private static final long serialVersionUID = -1394688774116638338L;
	private ProductSource productSource;
	private String name;
	private Double price;
	private List<ProductImage> images;
	
	public SimilarProducts(){
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public ProductSource getProductSource() {
		return productSource;
	}


	public void setProductSource(ProductSource productSource) {
		this.productSource = productSource;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public List<ProductImage> getImages() {
		return images;
	}


	public void setImages(List<ProductImage> images) {
		this.images = images;
	}
	

}
