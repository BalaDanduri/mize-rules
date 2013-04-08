package com.mize.domain.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetworkContactResponse {

	private String providerName;
	private Long userId;
	private Long countOfConnections;
	private List<SocialNetworkContactDetail> connections = new ArrayList<SocialNetworkContactDetail>();
	public String getProviderName() {
		return providerName;
	}
	public List<SocialNetworkContactDetail> getConnections() {
		return connections;
	}
	public void setConnections(List<SocialNetworkContactDetail> connections) {
		this.connections = connections;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCountOfConnections() {
		return countOfConnections;
	}
	public void setCountOfConnections(Long countOfConnections) {
		this.countOfConnections = countOfConnections;
	}
	@Override
	public String toString() {
		return "SocialNetworkContactResponse [providerName=" + providerName + ", userId=" + userId
				+ ", totalNoOfConnections=" + countOfConnections + ", mizeFriends=" + connections + "]";
	}
	
}
