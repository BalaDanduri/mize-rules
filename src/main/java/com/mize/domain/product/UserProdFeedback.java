package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mize.domain.user.FriendsActivities;

public class UserProdFeedback {
	Map<Long, FriendsActivities> commentsMap ;
	Map<Long, FriendsActivities> likeMap;
	Map<Long, FriendsActivities> userLikedMap ;
	List<UserProductFeedback>  prodFeedbacks;
	
	
	public Map<Long, FriendsActivities> getCommentsMap() {
		return commentsMap;
	}
	public void setCommentsMap(Map<Long, FriendsActivities> commentsMap) {
		this.commentsMap = commentsMap;
	}
	public Map<Long, FriendsActivities> getLikeMap() {
		return likeMap;
	}
	public void setLikeMap(Map<Long, FriendsActivities> likeMap) {
		this.likeMap = likeMap;
	}
	public Map<Long, FriendsActivities> getUserLikedMap() {
		return userLikedMap;
	}
	public void setUserLikedMap(Map<Long, FriendsActivities> userLikedMap) {
		this.userLikedMap = userLikedMap;
	}
	public List<UserProductFeedback> getProdFeedbacks() {
		return prodFeedbacks;
	}
	public void setProdFeedbacks(List<UserProductFeedback> prodFeedbacks) {
		this.prodFeedbacks = prodFeedbacks;
	}
	public List<Long> getFeedbackIds() {
		List<Long> feedbackIds = new ArrayList<Long>();
		if (prodFeedbacks != null) {
			for (UserProductFeedback prodFeedback : prodFeedbacks) {
				feedbackIds.add(prodFeedback.getId());
			}
		}
		return feedbackIds;
	}
}
