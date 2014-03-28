package com.mize.domain.etilize;

import com.mize.domain.common.MizeEntity;


public class CampaignGallery extends MizeEntity{

	private static final long serialVersionUID = -6127526442345342722L;
	private Long campaignId;
	private String logoPic;
	private String thumbPic;
	
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
	public String getLogoPic() {
		return logoPic;
	}
	public void setLogoPic(String logoPic) {
		this.logoPic = logoPic;
	}
	public String getThumbPic() {
		return thumbPic;
	}
	public void setThumbPic(String thumbPic) {
		this.thumbPic = thumbPic;
	}
	
}
