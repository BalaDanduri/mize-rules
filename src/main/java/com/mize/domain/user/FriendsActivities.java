package com.mize.domain.user;

import com.mize.domain.common.Entity;
import com.mize.domain.product.UserProduct;
import com.mize.domain.product.UserProductFeedback;

public class FriendsActivities extends Entity{

	private static final long serialVersionUID = -1735212175295L;
	private Integer countOfComments;
	private Integer countOfThumbsUp;
	private Integer countOfThumbsDown;
	private Integer countOfSpam;
	private UserProduct product;
	private UserProductFeedback feedback;
	private Integer liked;
	
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
	public UserProduct getProduct() {
		return product;
	}
	public void setProduct(UserProduct product) {
		this.product = product;
	}
	public UserProductFeedback getFeedback() {
		return feedback;
	}
	public void setFeedback(UserProductFeedback feedback) {
		this.feedback = feedback;
	}
	public Integer getLiked() {
		return liked;
	}
	public void setLiked(Integer liked) {
		this.liked = liked;
	}
}
