package com.mize.domain.etilize;

import com.mize.domain.common.MizeEntity;


public class ProductDescription extends MizeEntity{

	private static final long serialVersionUID = -632131644234531123L;
	private Long prodId;
	private String shortDesc;
	private String longDesc;
	private String warrantyInfo;
	private String officialUrl;
	private String pdfUrl;
	private Long pdfSize;
	private String manualPdfUrl;
	private Long manualPdfSize;
	private Long sourceId;
	private String isDefault;
	private String type;
	private Long localeId;
	
	@Override
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
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public String getWarrantyInfo() {
		return warrantyInfo;
	}
	public void setWarrantyInfo(String warrantyInfo) {
		this.warrantyInfo = warrantyInfo;
	}
	public String getOfficialUrl() {
		return officialUrl;
	}
	public void setOfficialUrl(String officialUrl) {
		this.officialUrl = officialUrl;
	}
	public String getPdfUrl() {
		return pdfUrl;
	}
	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}
	public Long getPdfSize() {
		return pdfSize;
	}
	public void setPdfSize(Long pdfSize) {
		this.pdfSize = pdfSize;
	}
	public String getManualPdfUrl() {
		return manualPdfUrl;
	}
	public void setManualPdfUrl(String manualPdfUrl) {
		this.manualPdfUrl = manualPdfUrl;
	}
	public Long getManualPdfSize() {
		return manualPdfSize;
	}
	public void setManualPdfSize(Long manualPdfSize) {
		this.manualPdfSize = manualPdfSize;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "ProductDescription [prodId=" + prodId + ", shortDesc="
				+ shortDesc + ", longDesc=" + longDesc + ", warrantyInfo="
				+ warrantyInfo + ", officialUrl=" + officialUrl + ", pdfUrl="
				+ pdfUrl + ", pdfSize=" + pdfSize + ", manualPdfUrl="
				+ manualPdfUrl + ", manualPdfSize=" + manualPdfSize
				+ ", sourceId=" + sourceId + ", isDefault=" + isDefault
				+ ", type=" + type + ", localeId=" + localeId + "]";
	}
	
}
