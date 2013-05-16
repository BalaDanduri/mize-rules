package com.mize.domain.socialnetwork;

public class SocialPostResponse {
	private String postedId;
	private String postedData;
	public String getPostedId() {
		return postedId;
	}
	public void setPostedId(String postedId) {
		this.postedId = postedId;
	}
	public String getPostedData() {
		return postedData;
	}
	public void setPostedData(String postedData) {
		this.postedData = postedData;
	}
	@Override
	public String toString() {
		return "SocialPostResponse [postedId=" + postedId + ", postedData=" + postedData + "]";
	}
	

}
