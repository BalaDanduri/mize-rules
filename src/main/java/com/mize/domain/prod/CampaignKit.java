package com.mize.domain.prod;


public class CampaignKit extends Entity{

	private static final long serialVersionUID = -6127526412345342722L;
	private Long id;
	private Long campaignId;
	private Long prodId;
	private Long clickThroughCount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Long campaignId) {
		this.campaignId = campaignId;
	}
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public Long getClickThroughCount() {
		return clickThroughCount;
	}
	public void setClickThroughCount(Long clickThroughCount) {
		this.clickThroughCount = clickThroughCount;
	}
	
	
}
