package com.mize.domain.socialnetwork;

import com.mize.domain.auth.User;

public class SocialPostRequest {

	private String provider;
	private User user;
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private String message;
	private String to;
	private String picture;
	private String caption;
	private String name;
	private String description;
	private String link;
	private String url;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "SocialPostRequest [provider=" + provider + ", user=" + user + ", message=" + message + ", to=" + to
				+ ", picture=" + picture + ", caption=" + caption + ", name=" + name + ", description=" + description
				+ ", link=" + link + ", url=" + url + "]";
	}

	
}
