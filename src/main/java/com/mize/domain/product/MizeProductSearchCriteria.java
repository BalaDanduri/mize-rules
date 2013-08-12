package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;

public class MizeProductSearchCriteria extends MizeEntity implements Comparable<MizeProductSearchCriteria>{
	private static final long serialVersionUID = 155385665556860537L;
	private String brandName;
	private String searchKey;
	private String categoryId;
	private String pageSize;
	private String pageIndex;

	@Override
	public Long getId(){
		return id;
	}
	
	@Override
	public void setId(Long id){
		this.id = id;
	}	
	

	@Override
	public String toString() {
		return "MizeProductSearchCriteria [brandName=" + brandName + ", searchKey=" + searchKey + ", categoryId="
				+ categoryId + ", pageSize=" + pageSize + ", pageIndex=" + pageIndex + "]";
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public int compareTo(MizeProductSearchCriteria arg0) {
		return 0;
	}
	
}
