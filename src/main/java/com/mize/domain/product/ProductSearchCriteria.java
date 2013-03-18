package com.mize.domain.product;

import java.util.HashMap;
import java.util.Map;

import com.mize.domain.common.Entity;

public class ProductSearchCriteria extends Entity{
	private static final long serialVersionUID = 155385665556860537L;
	private String category;
	private String searchKey;
	private String browseNode;
	private String searchIndex;
	private String pageIndex;
	private Map<String, String> filters = new HashMap<String, String>();
	private String sortBy;
	private Long userId;
	private String sourceCategory;
	private String upc;
	private String sourceId;
	private String brand;
	private String lowPrice;
	private String highPrice;
	private Integer maxLength;

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
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


	public Map<String, String> getFilters() {
		return filters;
	}


	public void setFilters(Map<String, String> filters) {
		this.filters = filters;
	}

	public String getFilterValue(String filterKey) {
		return filters.get(filterKey);
	}

	public String setFilterValue(String filterKey, String filterValue) {
		return filters.put(filterKey, filterValue);
	}
	
	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "ProductSearchCriteria [category=" + category + ", searchKey=" + searchKey + ", browseNode="
				+ browseNode + ", searchIndex=" + searchIndex + ", pageIndex=" + pageIndex + ", filters=" + filters
				+ ", sortBy=" + sortBy + ", userId=" + userId + ", sourceCategory=" + sourceCategory + ", upc=" + upc
				+ ", sourceId=" + sourceId + ", brand=" + brand + ", lowPrice=" + lowPrice + ", highPrice=" + highPrice
				+ ", maxLength=" + maxLength + "]";
	}


	public String getSourceCategory() {
		return sourceCategory;
	}


	public void setSourceCategory(String sourceCategory) {
		this.sourceCategory = sourceCategory;
	}

	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}


	public String getSourceId() {
		return sourceId;
	}


	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	}

	public String getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(String highPrice) {
		this.highPrice = highPrice;
	}
	
}
