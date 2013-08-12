package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.common.PaginationPage;

public class MizeProductSearchResponse extends MizeEntity implements Comparable<MizeProductSearchResponse>{
	private static final long serialVersionUID = 155385665556860537L;
	private PaginationPage<Product> productPage;
	private RefineFilters refineFilters;

	@Override
	public Long getId(){
		return id;
	}
	
	@Override
	public void setId(Long id){
		this.id = id;
	}	
	

	@Override
	public String toString() {
		return "MizeProductSearchResponse [productPage=" + productPage + ", refineFilters=" + refineFilters + "]";
	}

	public PaginationPage<Product> getProductPage() {
		return productPage;
	}

	public void setProductPage(PaginationPage<Product> productPage) {
		this.productPage = productPage;
	}

	public RefineFilters getRefineFilters() {
		return refineFilters;
	}

	public void setRefineFilters(RefineFilters refineFilters) {
		this.refineFilters = refineFilters;
	}

	@Override
	public int compareTo(MizeProductSearchResponse arg0) {
		return 0;
	}
	
}
