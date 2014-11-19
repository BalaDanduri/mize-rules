package com.mize.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "entity_comment", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class EntityComment extends MizeSceEntity implements Comparable<EntityComment>{

	private static final long serialVersionUID = -6912661566113329768L;
	private String commentType;
	private String comments;

	public EntityComment(){
		super();
	}
	
	public EntityComment(String commentType,String comments){
		super();
		this.commentType = commentType;
		this.comments = comments;
	}
	
	public enum Type{
		Internal,External;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "comment_type", nullable = false, length = 50)
	public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

	@Column(name = "comments", nullable = false, length = 5000)
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

	@Override
	@JsonIgnore(false)
	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
 
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	@JsonIgnore(false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	@Column(name = "created_date",updatable = false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(value=false)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(value = false)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@JsonIgnore(value=false)
	@Column(name = "created_by" , updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore(value=false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((commentType == null) ? 0 : commentType.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityComment other = (EntityComment) obj;
		if (commentType == null) {
			if (other.commentType != null)
				return false;
		} else if (!commentType.equals(other.commentType))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntityComment [id=" + id + ", commentType=" + commentType + ", comments="
				+ comments + "]";
	}

	@Override
	public int compareTo(EntityComment o) {
		return 0;
	}
	
}
