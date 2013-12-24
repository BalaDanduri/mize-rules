package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

public class UserCommentsActivities {
	private Integer countOfComments;
	private Integer countOfThumbsUp;
	private Integer countOfThumbsDown;
	private Integer countOfSpam;
	private List<UserComment> userComments = new ArrayList<UserComment>();
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
	public List<UserComment> getUserComments() {
		return userComments;
	}
	public void setUserComments(List<UserComment> userComments) {
		this.userComments = userComments;
	}
}
