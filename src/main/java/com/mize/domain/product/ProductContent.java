package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;

public class ProductContent extends MizeEntity{
	
	private static final long serialVersionUID = -76159028571766886L;
	private String brandName;
	private String productName;
	private String contentType;
	private Integer seqNo;
	private String title;
	private String description;
	private String url;
	private Integer pageIndex;
	private Integer count;
	
	public enum ContentType{
		faq,video,manuals; 
	}
	
	public static ContentType getContentType(String num){
		for (ContentType cType : ContentType.values()) {
			if( cType.toString().equals(num) ){
				return cType;
			}
		}
		return null;
	}
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ProductContent [brandName=" + brandName + ", productName=" + productName + ", contentType=" + contentType + ", seqNo=" + seqNo + ", title="
				+ title + ", description=" + description + ", url=" + url + ", pageIndex=" + pageIndex + ", count=" + count + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
