package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeEntity;

public class Products extends MizeEntity implements Comparable<Products>{

	private static final long serialVersionUID = 5620440549204450869L;
	private long searchResults;
	private List<Product> productList = new ArrayList<Product>();
	private List<RefineFilters> refineFilters = new ArrayList<RefineFilters>(); 
	
	@Override
	public Long getId(){
		return id;
	}
	
	@Override
	public void setId(Long id){
		this.id = id;
	}
	
	public long getSearchResults() {
		return searchResults;
	}
	public void setSearchResults(long searchResults) {
		this.searchResults = searchResults;
	}
	
	public List<RefineFilters> getRefineFilters() {
		return refineFilters;
	}

	public void setRefineFilters(List<RefineFilters> furtherFilters) {
		this.refineFilters = furtherFilters;
	}

	@Override
	public String toString() {
		return "Products [searchResults=" + searchResults + ", product="
				+ productList + ", furtherFilters=" + refineFilters + "]";
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public int compareTo(Products o) {
		return 0;
	}
	
}
