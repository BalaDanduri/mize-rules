package com.mize.domain.product;

public class ProductSearchCriteria {

	private String category;
	private String searchKey;
	private String browseNode;
	private String searchIndex;
	private String pageIndex;
	private String[] filters;
	private String sortBy;
	private Long userId;
	
	public ProductSearchCriteria() {
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getSearchKey() {
		return searchKey;
	}


	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}


	public String getBrowseNode() {
		return browseNode;
	}


	public void setBrowseNode(String browseNode) {
		this.browseNode = browseNode;
	}


	public String getSearchIndex() {
		return searchIndex;
	}


	public void setSearchIndex(String searchIndex) {
		this.searchIndex = searchIndex;
	}

	public String getSortBy() {
		return sortBy;
	}


	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}


	public String getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}


	public String[] getFilters() {
		return filters;
	}


	public void setFilters(String[] filters) {
		this.filters = filters;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
