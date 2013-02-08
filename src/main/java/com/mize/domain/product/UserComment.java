package com.mize.domain.product;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class UserComment extends Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5202517627419277416L;
	private Long commentId;
	private Long parentCommentId;
	private Long commentTypeId;
	private String commentType;
	private User user;
	private String comments;
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
	
	
	public enum CommentType{
		prod_feedback,want,own;	
	}
	
	public static CommentType getCommentType(String num){
		for (CommentType cType : CommentType.values()) {
			if( cType.toString().equals(num) ){
				return cType;
			}
		}
		return null;
	}

	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(Long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public Long getCommentTypeId() {
		return commentTypeId;
	}
	public void setCommentTypeId(Long commentTypeId) {
		this.commentTypeId = commentTypeId;
	}
	public String getCommentType() {
		return commentType;
	}
	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Integer getLiked() {
		return liked;
	}
	public void setLiked(Integer liked) {
		this.liked = liked;
	}
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)	
	@JsonIgnore(value=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
}
