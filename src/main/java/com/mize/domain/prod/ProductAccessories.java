package com.mize.domain.prod;


public class ProductAccessories extends Entity{

	private static final long serialVersionUID = -632231234234531123L;
	private Long prodId;
	private Long accessoryId;
	private Integer isActive;
	private Integer isPreferred;
	private Integer isOption;
	private String note;
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	
	public Long getAccessoryId() {
		return accessoryId;
	}
	public void setAccessoryId(Long accessoryId) {
		this.accessoryId = accessoryId;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Integer getIsPreferred() {
		return isPreferred;
	}
	public void setIsPreferred(Integer isPreferred) {
		this.isPreferred = isPreferred;
	}
	public Integer getIsOption() {
		return isOption;
	}
	public void setIsOption(Integer isOption) {
		this.isOption = isOption;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
