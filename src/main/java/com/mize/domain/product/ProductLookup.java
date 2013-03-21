package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.Entity;


public class ProductLookup extends Entity{
		
	private static final long serialVersionUID = 7754176397823092647L;
	public static final String SOURCE_MIZE = "1";
	public static final String SOURCE_AMAZON = "2";
	public static final String SOURCE_GOOGLE = "3";
	
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


}
