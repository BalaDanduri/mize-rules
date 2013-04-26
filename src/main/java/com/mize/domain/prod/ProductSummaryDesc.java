package com.mize.domain.prod;


public class ProductSummaryDesc extends Entity{

	private static final long serialVersionUID = -6322316442345311722L;
	private Long id;
	private Long localeId;
	private Long sourceId;
	public Long getId() {
		return id;
	}
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
