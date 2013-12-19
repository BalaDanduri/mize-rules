package com.mize.domain.search;

import java.util.List;

public class SearchResponse {
	private String entityName;
	private String version;
	private Long numberOfRecords;
	private Long pageIndex;
	private List<SearchResponseRecord> records;

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

	public List<SearchResponseRecord> getRecords() {
		return records;
	}

	public void setRecords(List<SearchResponseRecord> records) {
		this.records = records;
	}

	public Long getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(Long numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	public Long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public String toString() {
		return "SearchResponse [entityName=" + entityName + ", version="
				+ version + ", numberOfRecords=" + numberOfRecords
				+ ", pageIndex=" + pageIndex + ", records=" + records + "]";
	}

}
