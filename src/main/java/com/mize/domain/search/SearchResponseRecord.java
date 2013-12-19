package com.mize.domain.search;

import java.util.List;

public class SearchResponseRecord {
	private List<SearchResponseAttribute> attributes;

	public List<SearchResponseAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<SearchResponseAttribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "SearchResponseRecord [ attributes=" + attributes + "]";
	}

}
