package com.mize.domain.etilize;

import com.mize.domain.common.MizeEntity;


public class ProductMultimedia extends MizeEntity{

	private static final long serialVersionUID = -623434234531123L;

	private String link;
	private String shortDesc;
	private Long localeId;
	private Long size;
	private String contentType;
	private String keepAsUrl;
	private String type;
	private Double heigth;
	private Double width;
	private Long sourceId;
	
	@Override
	public Long getId() {
		return id;
	}	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getKeepAsUrl() {
		return keepAsUrl;
	}
	public void setKeepAsUrl(String keepAsUrl) {
		this.keepAsUrl = keepAsUrl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getHeigth() {
		return heigth;
	}
	public void setHeigth(Double heigth) {
		this.heigth = heigth;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	
}
