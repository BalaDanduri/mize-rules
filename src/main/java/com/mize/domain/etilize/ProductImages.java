package com.mize.domain.etilize;

import com.mize.domain.common.Entity;


public class ProductImages extends Entity{

	private static final long serialVersionUID = -6211234234531123L;

	private Long id;	
	private String isActive;
	private String isOption;
	private String isPreferred;
	private String note;
	private Long sourceId;
	private Long localeId;
	private Long prodId;
	private String type;
	private String status;
	private String url;
	
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
		
}
