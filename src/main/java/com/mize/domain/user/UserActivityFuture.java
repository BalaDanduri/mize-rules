package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;
import com.mize.domain.product.UserProduct;
import com.mize.domain.product.UserProductFeedback;

public class UserActivityFuture extends Entity{
	
	private static final long serialVersionUID = -7594149151108797145L;
	private User user;
	private List<UserFriend> userFriends;
	List<UserProductFeedback> prodFeedbacks;
	private Map<Long, FriendsActivities> commentsMap;
	private Map<Long, FriendsActivities> likeMap;
	private Map<Long, FriendsActivities> userLikedMap;
	private FriendsActivities activity;
	private List<UserProduct> userProducts = new ArrayList<UserProduct>();
	private Map<Long, FriendsActivities> commentTagMap;
	private Map<Long, FriendsActivities> likeTagMap;
	private Map<Long, FriendsActivities> likedTagMap;
	private Integer countOfComments;
	private Integer countOfThumbsUp;
	private Integer countOfThumbsDown;
	private Integer countOfSpam;

	private List<FriendsActivities> friendsActivities;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserFriend> getUserFriends() {
		return userFriends;
	}

	public void setUserFriends(List<UserFriend> userFriends) {
		this.userFriends = userFriends;
	}

	public List<UserProductFeedback> getProdFeedbacks() {
		return prodFeedbacks;
	}

	public void setProdFeedbacks(List<UserProductFeedback> prodFeedbacks) {
		this.prodFeedbacks = prodFeedbacks;
	}

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

	public FriendsActivities getActivity() {
		return activity;
	}

	public void setActivity(FriendsActivities activity) {
		this.activity = activity;
	}

	public List<UserProduct> getUserProducts() {
		return userProducts;
	}

	public void setUserProducts(List<UserProduct> userProducts) {
		this.userProducts = userProducts;
	}

	public Map<Long, FriendsActivities> getCommentTagMap() {
		return commentTagMap;
	}

	public void setCommentTagMap(Map<Long, FriendsActivities> commentTagMap) {
		this.commentTagMap = commentTagMap;
	}

	public Map<Long, FriendsActivities> getLikeTagMap() {
		return likeTagMap;
	}

	public void setLikeTagMap(Map<Long, FriendsActivities> likeTagMap) {
		this.likeTagMap = likeTagMap;
	}

	public Map<Long, FriendsActivities> getLikedTagMap() {
		return likedTagMap;
	}

	public void setLikedTagMap(Map<Long, FriendsActivities> likedTagMap) {
		this.likedTagMap = likedTagMap;
	}

	public Integer getCountOfComments() {
		return countOfComments;
	}

	public void setCountOfComments(Integer countOfComments) {
		this.countOfComments = countOfComments;
	}

	public Integer getCountOfThumbsUp() {
		return countOfThumbsUp;
	}

	public void setCountOfThumbsUp(Integer countOfThumbsUp) {
		this.countOfThumbsUp = countOfThumbsUp;
	}

	public Integer getCountOfThumbsDown() {
		return countOfThumbsDown;
	}

	public void setCountOfThumbsDown(Integer countOfThumbsDown) {
		this.countOfThumbsDown = countOfThumbsDown;
	}

	public Integer getCountOfSpam() {
		return countOfSpam;
	}

	public void setCountOfSpam(Integer countOfSpam) {
		this.countOfSpam = countOfSpam;
	}

	public List<FriendsActivities> getFriendsActivities() {
		return friendsActivities;
	}

	public void setFriendsActivities(List<FriendsActivities> friendsActivities) {
		this.friendsActivities = friendsActivities;
	}

	public List<Long> getUserIds() {
		List<Long> userIds = new ArrayList<Long>();
		if (userFriends != null) {
			for (UserFriend user2 : userFriends) {
				userIds.add(user2.getFriendUser().getId());
			}
		}
		return userIds;
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

	public List<Long> getUserProdIds() {
		List<Long> userProdIds = new ArrayList<Long>();
		if (userProducts != null) {
			for (UserProduct userProduct2 : userProducts) {
				userProdIds.add(userProduct2.getId());
			}
		}
		return userProdIds;
	}

	@Override
	public String toString() {
		return "UserActivityFuture [user=" + user + ", userFriends=" + userFriends + ", prodFeedbacks=" + prodFeedbacks + ", commentsMap=" + commentsMap
				+ ", likeMap=" + likeMap + ", userLikedMap=" + userLikedMap + ", activity=" + activity + ", userProducts=" + userProducts + ", commentTagMap="
				+ commentTagMap + ", likeTagMap=" + likeTagMap + ", likedTagMap=" + likedTagMap + ", countOfComments=" + countOfComments + ", countOfThumbsUp="
				+ countOfThumbsUp + ", countOfThumbsDown=" + countOfThumbsDown + ", countOfSpam=" + countOfSpam + ", friendsActivities=" + friendsActivities
				+ "]";
	}
	
	

}
