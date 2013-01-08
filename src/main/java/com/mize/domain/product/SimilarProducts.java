package com.mize.domain.product;

public class SimilarProducts{

	private ProductSource productSource;
	private String name;
	
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
	

}
