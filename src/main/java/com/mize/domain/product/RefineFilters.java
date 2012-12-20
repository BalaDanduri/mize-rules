package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder ({"filterTypeName", "filters"})
public class RefineFilters {
	
	protected String filterTypeName;
	protected List<RefineFilter> filters = new ArrayList<>();
	
	public RefineFilters() {
		
	}
	
	public String getFilterTypeName() {
		return filterTypeName;
	}
	public void setFilterTypeName(String filterTypeName) {
		this.filterTypeName = filterTypeName;
	}
	public List<RefineFilter> getFilters() {
		return filters;
	}
	public void setFilters(List<RefineFilter> filters) {
		this.filters = filters;
	}

	@Override
	public String toString() {
		return "RefineFilters [filterTypeName=" + filterTypeName + ", filters="
				+ filters + "]";
	}
	

}
