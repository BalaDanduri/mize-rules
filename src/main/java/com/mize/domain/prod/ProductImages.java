package com.mize.domain.prod;


public class ProductImages extends Entity{

	private static final long serialVersionUID = -6211234234531123L;

	private Long id;	
	private String isActive;
	private String isOption;
	private String isPreferred;
	private String note;
	private Long sourceId;
	private Long localeId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIsOption() {
		return isOption;
	}
	public void setIsOption(String isOption) {
		this.isOption = isOption;
	}
	public String getIsPreferred() {
		return isPreferred;
	}
	public void setIsPreferred(String isPreferred) {
		this.isPreferred = isPreferred;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
		
}
