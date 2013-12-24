package com.mize.domain.etilize;

import com.mize.domain.common.MizeEntity;


public class CampaignKit extends MizeEntity{

	private static final long serialVersionUID = -6127526412345342722L;
	private Long campaignId;
	private Long prodId;
	private Long clickThroughCount;
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
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
