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
	private String comment;
	private int like;
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
		result = prime * result + ((commentType == null) ? 0 : commentType.hashCode());
		result = prime * result + ((commentTypeId == null) ? 0 : commentTypeId.hashCode());
		result = prime * result + like;
		result = prime * result + ((parentCommentId == null) ? 0 : parentCommentId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserComment other = (UserComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		if (commentType == null) {
			if (other.commentType != null)
				return false;
		} else if (!commentType.equals(other.commentType))
			return false;
		if (commentTypeId == null) {
			if (other.commentTypeId != null)
				return false;
		} else if (!commentTypeId.equals(other.commentTypeId))
			return false;
		if (like != other.like)
			return false;
		if (parentCommentId == null) {
			if (other.parentCommentId != null)
				return false;
		} else if (!parentCommentId.equals(other.parentCommentId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserComment [commentId=" + commentId + ", parentCommentId=" + parentCommentId + ", commentTypeId="
				+ commentTypeId + ", commentType=" + commentType + ", user=" + user + ", comment=" + comment
				+ ", like=" + like + "]";
	}
	
	
}
