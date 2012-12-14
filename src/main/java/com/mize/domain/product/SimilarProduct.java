package com.mize.domain.product;

import com.mize.domain.common.BaseEntity;

public class SimilarProduct extends BaseEntity{

	private String asin;
	private String title;
	
	public SimilarProduct(){
		
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

}
