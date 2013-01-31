package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonFilter;

public class Products {

	private long searchResults;
	private List<Product> product = new ArrayList<Product>();
	private List<RefineFilters> refineFilters = new ArrayList<RefineFilters>(); 
	
	public Products() {
		
	}
	
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
	public List<RefineFilters> getRefineFilters() {
		return refineFilters;
	}

	public void setRefineFilters(List<RefineFilters> furtherFilters) {
		this.refineFilters = furtherFilters;
	}

	@Override
	public String toString() {
		return "Products [searchResults=" + searchResults + ", product="
				+ product + ", furtherFilters=" + refineFilters + "]";
	}
}
