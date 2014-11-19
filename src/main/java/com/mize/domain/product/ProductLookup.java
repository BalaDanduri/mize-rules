package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeSceEntity;


public class ProductLookup extends MizeSceEntity implements Comparable<ProductLookup>{
		
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
	private Long brandId;
	
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
	

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
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
	
	@Override
	public String toString() {
		return "ProductLookup [sourceId=" + sourceId + ", lookupKey="
				+ lookupKey + ", lookupId=" + lookupId + ", userId=" + userId
				+ ", maxLength=" + maxLength + ", prodId=" + prodId
				+ ", similarProdsReqd=" + similarProdsReqd
				+ ", accessoriesProdsReqd=" + accessoriesProdsReqd
				+ ", pageIndex=" + pageIndex + ", sourceProductId="
				+ sourceProductId + ", isValidate=" + isValidate
				+ ", pageSize=" + pageSize + ", brandId=" + brandId + "]";
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + (accessoriesProdsReqd ? 1231 : 1237);
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
		result = prime * result + (isValidate ? 1231 : 1237);
		result = prime * result
				+ ((lookupId == null) ? 0 : lookupId.hashCode());
		result = prime * result
				+ ((lookupKey == null) ? 0 : lookupKey.hashCode());
		result = prime * result
				+ ((maxLength == null) ? 0 : maxLength.hashCode());
		result = prime * result
				+ ((pageIndex == null) ? 0 : pageIndex.hashCode());
		result = prime * result
				+ ((pageSize == null) ? 0 : pageSize.hashCode());
		result = prime * result + ((prodId == null) ? 0 : prodId.hashCode());
		result = prime * result + (similarProdsReqd ? 1231 : 1237);
		result = prime * result
				+ ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result
				+ ((sourceProductId == null) ? 0 : sourceProductId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductLookup other = (ProductLookup) obj;
		if (accessoriesProdsReqd != other.accessoriesProdsReqd)
			return false;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
			return false;
		if (isValidate != other.isValidate)
			return false;
		if (lookupId == null) {
			if (other.lookupId != null)
				return false;
		} else if (!lookupId.equals(other.lookupId))
			return false;
		if (lookupKey == null) {
			if (other.lookupKey != null)
				return false;
		} else if (!lookupKey.equals(other.lookupKey))
			return false;
		if (maxLength == null) {
			if (other.maxLength != null)
				return false;
		} else if (!maxLength.equals(other.maxLength))
			return false;
		if (pageIndex == null) {
			if (other.pageIndex != null)
				return false;
		} else if (!pageIndex.equals(other.pageIndex))
			return false;
		if (pageSize == null) {
			if (other.pageSize != null)
				return false;
		} else if (!pageSize.equals(other.pageSize))
			return false;
		if (prodId == null) {
			if (other.prodId != null)
				return false;
		} else if (!prodId.equals(other.prodId))
			return false;
		if (similarProdsReqd != other.similarProdsReqd)
			return false;
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		if (sourceProductId == null) {
			if (other.sourceProductId != null)
				return false;
		} else if (!sourceProductId.equals(other.sourceProductId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public int compareTo(ProductLookup o) {
		return 0;
	}

}
