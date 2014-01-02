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
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "entity_parameter_comment", uniqueConstraints = { @UniqueConstraint(columnNames = {"id"}) })
public class EntityParameterComment  extends MizeEntity implements Comparable<EntityParameterComment>{

	private static final long serialVersionUID = -1218611300848444271L;
	private EntityParameter entityParameter;
	private EntityComment entityComment;
	
	public EntityParameterComment() {
		super();
	}
	
	public EntityParameterComment(EntityParameter entityParameter,EntityComment entityComment) {
		super();
		this.entityParameter = entityParameter;
		this.entityComment = entityComment;
	}

	@Id
	@Column(name="id",nullable=false,unique=true)
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
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
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
		return "EntityParameterComment [entityComment=" + entityComment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityComment == null) ? 0 : entityComment.hashCode());
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
		if (entityComment == null) {
			if (other.entityComment != null)
				return false;
		} else if (!entityComment.equals(other.entityComment))
			return false;	
		return true;
	}

}
