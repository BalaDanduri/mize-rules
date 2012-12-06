package com.mize.domain.product;

public class ProductLookup {
		
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
	protected String lookupId;
	private Long userId;

	
	public ProductLookup() {
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

	public String getLookupId() {
		return lookupId;
	}
	
	public void setLookupId(String LookupId) {
		this.lookupId = LookupId;
	}
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lookupId == null) ? 0 : lookupId.hashCode());
		result = prime * result
				+ ((lookupKey == null) ? 0 : lookupKey.hashCode());
		result = prime * result
				+ ((sourceId == null) ? 0 : sourceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductLookup other = (ProductLookup) obj;
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
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductLookup [sourceId=" + sourceId + ", lookupKey="
				+ lookupKey + ", lookupId=" + lookupId + "]";
	}


}
