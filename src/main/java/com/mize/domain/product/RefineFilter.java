package com.mize.domain.product;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"filterName", "filterItemCount", "params"})
public class RefineFilter {
	
	private String filterName;
	private BigInteger filterItemCount;
	private List<Parameter> params = new ArrayList<Parameter>();
	
	public RefineFilter() {
		
	}
	
	public static class Parameter {
		protected String name;
		protected String value;
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
			return "Parameter [name=" + name + ", value=" + value + "]";
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

}
