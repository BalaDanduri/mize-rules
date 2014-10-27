package com.mize.domain.search;

import java.util.Map;

public class SirenInputDocument {
	public static final String FIELD_ID = "id";
	public static final String FIELD_ENTITY_TYPE = "entityType";
	public static final String FIELD_JSON = "json";
	public static final String SORT_STRING_SUFFIX = "_s_sort";
	public static final String SORT_NUMBER_SUFFIX = "_n_sort";
	public static final String FACET_SUFFIX = "_facet";
	
	private String id;
	private Map<String, Object> sortFields;
	private Map<String, String> facetFields;
	private SirenDataObject jsonObject;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Object> getSortFields() {
		return sortFields;
	}
	public void setSortFields(Map<String, Object> sortFields) {
		this.sortFields = sortFields;
	}
	public Map<String, String> getFacetFields() {
		return facetFields;
	}
	public void setFacetFields(Map<String, String> facetFields) {
		this.facetFields = facetFields;
	}
	
	public SirenDataObject getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(SirenDataObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	@Override
	public String toString() {
		return "SirenInputDocument [id=" + id + ", "
				+ ", sortFields=" + sortFields + ", facetFields=" + facetFields
				+ ", jsonObject=" + jsonObject + "]";
	}
}
