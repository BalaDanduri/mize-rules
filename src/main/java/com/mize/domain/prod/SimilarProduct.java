package com.mize.domain.prod;



public class SimilarProduct extends Entity{
	private static final long serialVersionUID = -6725341511569003526L;
	
	private Long id;
	private Long localeId;
	private Long sourceId;
	private String preferredOption;
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
	public String getPreferredOption() {
		return preferredOption;
	}
	public void setPreferredOption(String preferredOption) {
		this.preferredOption = preferredOption;
	}
	 
	
}
