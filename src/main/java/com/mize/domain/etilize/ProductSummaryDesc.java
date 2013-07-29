package com.mize.domain.etilize;

import com.mize.domain.common.MizeEntity;


public class ProductSummaryDesc extends MizeEntity{

	private static final long serialVersionUID = -6322316442345311722L;
	private Long localeId;
	private Long sourceId;
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
		
}
