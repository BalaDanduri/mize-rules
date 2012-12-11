package com.mize.domain.product;

public class ProdCategorySource {
	
	protected String sourceCatId;
	protected Long sourceId;
	protected Long catId;

	public String getSourceCatId() {
		return sourceCatId;
	}

	public void setSourceCatId(String sourceCatId) {
		this.sourceCatId = sourceCatId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	@Override
	public String toString() {
		return "ProdCategorySource [sourceCatId=" + sourceCatId + ", sourceId="
				+ sourceId + ", catId=" + catId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catId == null) ? 0 : catId.hashCode());
		result = prime * result
				+ ((sourceCatId == null) ? 0 : sourceCatId.hashCode());
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
		ProdCategorySource other = (ProdCategorySource) obj;
		if (catId == null) {
			if (other.catId != null)
				return false;
		} else if (!catId.equals(other.catId))
			return false;
		if (sourceCatId == null) {
			if (other.sourceCatId != null)
				return false;
		} else if (!sourceCatId.equals(other.sourceCatId))
			return false;
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		return true;
	}

	public ProdCategorySource() {
		// TODO Auto-generated constructor stub
	}

}
