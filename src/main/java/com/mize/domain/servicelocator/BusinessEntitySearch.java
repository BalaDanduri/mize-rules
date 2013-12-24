package com.mize.domain.servicelocator;

import java.util.List;

public class BusinessEntitySearch {
	
	private BusinessEntityAddress entityAddress;
	private int radius;
	private List<BusinessEntityAddress> addressList;	
	private Integer pageIndex;
	private String entityType;
	private String sourceProductId;
	private String searchType;
	
	public BusinessEntitySearch() {
		entityAddress = new BusinessEntityAddress();
		
	}
	
	public BusinessEntityAddress getEntityAddress() {
		return entityAddress;
	}
	public void setEntityAddress(BusinessEntityAddress entityAddress) {
		this.entityAddress = entityAddress;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public List<BusinessEntityAddress> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<BusinessEntityAddress> addressList) {
		this.addressList = addressList;
	}	
	public Integer getPageIndex() {
		return pageIndex;
	}	
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getSourceProductId() {
		return sourceProductId;
	}

	public void setSourceProductId(String sourceProductId) {
		this.sourceProductId = sourceProductId;
	}
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
}
