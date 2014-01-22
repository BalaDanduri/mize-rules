package com.mize.domain.product;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"filterName", "filterItemCount", "params"})
public class RefineFilter implements Comparable<RefineFilter>{
	
	private String filterName;
	private BigInteger filterItemCount;
	private List<Parameter> params = new ArrayList<Parameter>();
	
	public RefineFilter() {		
	}
	
	public static class Parameter {
		protected String name;
		protected String value;
		protected Boolean leaf = null;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return "Parameter [name=" + name + ", value=" + value + ", leaf=" + leaf + "]";
		}
		public Boolean isLeaf() {
			return leaf;
		}
		public void setLeaf(Boolean leaf) {
			this.leaf = leaf;
		}
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public BigInteger getFilterItemCount() {
		return filterItemCount;
	}

	public void setFilterItemCount(BigInteger filterItemCount) {
		this.filterItemCount = filterItemCount;
	}

	public List<Parameter> getParams() {
		return params;
	}

	@Override
	public String toString() {
		return "RefineFilter [filterName=" + filterName + ", filterItemCount="
				+ filterItemCount + ", params=" + params + "]";
	}

	@Override
	public int compareTo(RefineFilter o) {	
		return filterName.compareToIgnoreCase(o.filterName);
	}

}
