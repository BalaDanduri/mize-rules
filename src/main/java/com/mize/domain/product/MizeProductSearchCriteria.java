package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;

public class MizeProductSearchCriteria extends MizeEntity implements Comparable<MizeProductSearchCriteria>{
	private static final long serialVersionUID = 155385665556860537L;
	private String brandName;
	private String searchKey;
	private Long categoryId;
	private String pageSize = "10";
	private String pageIndex;
	private Long userId;
	private Integer maxLength;

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
				+ categoryId + ", pageSize=" + pageSize + ", pageIndex=" + pageIndex + ", userId=" + userId
				+ ", maxLength=" + maxLength + "]";
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	@Override
	public int compareTo(MizeProductSearchCriteria arg0) {
		return 0;
	}
	
}
