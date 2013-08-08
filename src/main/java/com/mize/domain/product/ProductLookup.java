package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeEntity;


public class ProductLookup extends MizeEntity{
		
	private static final long serialVersionUID = 7754176397823092647L;
	public static final String SOURCE_MIZE = "1";
	public static final String SOURCE_AMAZON = "2";
	public static final String SOURCE_ETILIZE = "3";
	
	public static final String LOOKUP_ASIN = "ASIN";
	public static final String LOOKUP_UPC = "UPC";
	public static final String LOOKUP_SKU = "SKU";
	public static final String LOOKUP_ISBN = "ISBN";
	public static final String LOOKUP_EAN = "EAN"; 
	
	protected Long sourceId;
	protected String lookupKey;
	protected List<String> lookupId = new ArrayList<String>();
	private Long userId;
	private Integer maxLength;
	private Long prodId;
	private boolean similarProdsReqd = true;
	private boolean accessoriesProdsReqd = true;
	private Integer pageIndex;
	protected String sourceProductId;
	private boolean isValidate;
	private Integer pageSize;
	
	
	
	public enum Source{
		AMAZON(2),ETILIZE(3);	
		private int value;
		private Source(int val){
			value = val;
		}
		public int getValue(){
			return value;
		}
	}
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public static Source getSourceID(int num) {
		for (Source sid : Source.values()) {
			if(num==sid.value){
				return sid;
			}
		}
		return null;
	}
	
	
	
	public Long getProdId() {
		return prodId;
	}


	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}


	public Integer getMaxLength() {
		return maxLength;
	}


	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}


	public String getLookupKey() {
		return lookupKey;
	}
	
	public void setLookupKey(String LookupKey) {
		this.lookupKey = LookupKey;
	}

	public Long getSourceId() {
		return sourceId;
	}
	
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public List<String> getLookupId() {
		return lookupId;
	}
	
	public void setLookupId(List<String> LookupId) {
		this.lookupId = LookupId;
	}
	
	public void addLookupId(String LookupId) {
		this.lookupId.add(LookupId);
	}
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ProductLookup [sourceId=" + sourceId + ", lookupKey="
				+ lookupKey + ", lookupId=" + lookupId + "]";
	}


	public boolean isSimilarProdsReqd() {
		return similarProdsReqd;
	}


	public void setSimilarProdsReqd(boolean similarProdsReqd) {
		this.similarProdsReqd = similarProdsReqd;
	}


	public boolean isAccessoriesProdsReqd() {
		return accessoriesProdsReqd;
	}


	public void setAccessoriesProdsReqd(boolean accessoriesProdsReqd) {
		this.accessoriesProdsReqd = accessoriesProdsReqd;
	}


	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getSourceProductId() {
		return sourceProductId;
	}


	public void setSourceProductId(String sourceProductId) {
		this.sourceProductId = sourceProductId;
	}

	public boolean isValidate() {
		return isValidate;
	}

	public void setValidate(boolean isValidate) {
		this.isValidate = isValidate;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
