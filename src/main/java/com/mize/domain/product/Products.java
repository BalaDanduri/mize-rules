package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.BaseEntity;

public class Products extends BaseEntity{

	private long searchResults;
	private List<Product> product = new ArrayList<Product>();
	public long getSearchResults() {
		return searchResults;
	}
	public void setSearchResults(long searchResults) {
		this.searchResults = searchResults;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
