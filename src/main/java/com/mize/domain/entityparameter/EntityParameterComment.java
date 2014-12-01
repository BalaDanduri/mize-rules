package com.mize.domain.entityparameter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name = "entity_parameter_comment")
public class EntityParameterComment  extends MizeSceEntity implements Comparable<EntityParameterComment>{

	private static final long serialVersionUID = -1218611300848444271L;
	private EntityParameter entityParameter;
	private EntityComment comment;
	
	public EntityParameterComment() {
		super();
	}
	
	public EntityParameterComment(EntityParameter entityParameter,EntityComment comment) {
		super();
		this.entityParameter = entityParameter;
		this.comment = comment;
	}

	@Id
	@Column(name="id",unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY ,cascade=CascadeType.ALL)
	@JoinColumn(name = "parameter_id")
	@JsonBackReference(value="entityParameterComment")
	public EntityParameter getEntityParameter() {
		return entityParameter;
	}

	public void setEntityParameter(EntityParameter entityParameter) {
		this.entityParameter = entityParameter;
	}

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "comment_id")
	public EntityComment getEntityComment() {
		return comment;
	}

	public void setEntityComment(EntityComment comment) {
		this.comment = comment;
	}
	
	public int compareTo(EntityParameterComment entityParameterComment) {
		if (this == entityParameterComment)
			return EQUAL;
		else if (this.id < entityParameterComment.id)
			return BEFORE;
		else if (entityParameterComment.id == this.id)
			return EQUAL;
		else if (this.id > entityParameterComment.id)
			return AFTER;
		return EQUAL;
	}

	@Override
	public String toString() {
		return "EntityParameterComment [comment=" + comment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((comment == null) ? 0 : comment.hashCode());
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
		EntityParameterComment other = (EntityParameterComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;	
		return true;
	}

}
