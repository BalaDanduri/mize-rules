package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.mize.domain.common.Entity;

@JsonPropertyOrder ({"filterTypeName", "filters"})
public class RefineFilters extends Entity{

	private static final long serialVersionUID = 2938728873171419969L;
	protected String filterTypeName;
	protected List<RefineFilter> filters = new ArrayList<>();
	
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
