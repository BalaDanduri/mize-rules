package com.mize.domain.product;

import com.mize.domain.common.Entity;

public class ProdCategorySource extends Entity{
	
	private static final long serialVersionUID = 3381103262267511052L;
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
}
