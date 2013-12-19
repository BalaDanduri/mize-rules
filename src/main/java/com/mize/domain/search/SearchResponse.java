package com.mize.domain.search;

import java.util.List;

public class SearchResponse {
	private String entityName;
	private String version;
	private List<SearchResponseAttribute> attributes;

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<SearchResponseAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<SearchResponseAttribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "SearchRequest [entityName=" + entityName + ", version="
				+ version + ", attributes=" + attributes + "]";
	}

}
