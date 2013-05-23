package com.mize.domain.etilize;

import com.mize.domain.common.Entity;


public class CampaignGallery extends Entity{

	private static final long serialVersionUID = -6127526442345342722L;
	private Long id;
	private Long campaignId;
	private String logoPic;
	private String thumbPic;
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
