package com.mize.domain.product;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeEntity;

public class SimilarProducts extends MizeEntity {

	private static final long serialVersionUID = -1394688774116638338L;
	private ProductSource productSource;
	private String name;
	private Double price;
	private List<ProductImage> images;
	@JsonIgnore
	private String isConsumable;
	
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


	@Override
	public Long getId() {
		return id;
	}


	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public String getIsConsumable() {
		return isConsumable;
	}

	@JsonIgnore
	public void setIsConsumable(String isConsumable) {
		this.isConsumable = isConsumable;
	}	

}
