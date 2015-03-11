package com.mize.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.DateTime;

public class UserComment extends MizeSceEntity implements Comparable<UserComment>{
	
	private static final long serialVersionUID = 5202517627419277416L;
	private Long commentId;
	private Long parentCommentId;
	private Long commentTypeId;
	private String commentType;
	private User user;
	private String comments;
	private Integer liked;	
	
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

	@JsonIgnore(value=false)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int compareTo(UserComment o) {
		return 0;
	}
	
}
