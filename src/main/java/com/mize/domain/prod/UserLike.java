package com.mize.domain.prod;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;

public class UserLike extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5985400828851615337L;
	private Long likeId;
	private Long likeTypeId;
	private String likeType;
	private User user;
	private Integer liked;
	
	public enum Like{
		Thumps_Up(1),Thumps_Down(2),Spam(3);
		private int value;
		private Like(int val){
			value = val;
		}
		public int getValue(){
			return value;
		}
	}
	
	public static Like getLike(int num) {
		for (Like li : Like.values()) {
			if (num == li.ordinal() + 1) {
				return li;
			}
		}
		return null;
	}
	
	
	public enum LikeType{
		prod_feedback,want,own;	
	}
	
	public static LikeType getLikeType(String num){
		for (LikeType cType : LikeType.values()) {
			if( cType.toString().equals(num) ){
				return cType;
			}
		}
		return null;
	}
	
	public Long getLikeId() {
		return likeId;
	}
	public void setLikeId(Long likeId) {
		this.likeId = likeId;
	}
	public Long getLikeTypeId() {
		return likeTypeId;
	}
	public void setLikeTypeId(Long likeTypeId) {
		this.likeTypeId = likeTypeId;
	}
	public String getLikeType() {
		return likeType;
	}
	public void setLikeType(String likeType) {
		this.likeType = likeType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getLiked() {
		return liked;
	}
	public void setLiked(Integer liked) {
		this.liked = liked;
	}
	
}

