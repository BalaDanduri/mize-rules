package com.mize.domain.goodwill;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntity;
/**
 * @author Raghavendra Serikar
 * @version 1.0
 */
@Entity
@Table(name="goodwill_comment")
public class GoodwillComment extends MizeSceEntity implements Comparable<GoodwillComment>{
	private static final long serialVersionUID = 1L;
	private Goodwill goodwill;
	private EntityComment entityComment;
	
	public GoodwillComment(){
		super();
	}
	
	public GoodwillComment(EntityComment entityComment){
		super();
		this.entityComment = entityComment;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="goodwill_id")
	@JsonBackReference(value="comments")
	public Goodwill getGoodwill() {
		return goodwill;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="comment_id")
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setGoodwill(Goodwill goodwill) {
		this.goodwill = goodwill;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((entityComment == null) ? 0 : entityComment.hashCode());
		result = prime * result
				+ ((goodwill == null) ? 0 : goodwill.hashCode());
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
		GoodwillComment other = (GoodwillComment) obj;
		if (entityComment == null) {
			if (other.entityComment != null)
				return false;
		} else if (!entityComment.equals(other.entityComment))
			return false;
		if (goodwill == null) {
			if (other.goodwill != null)
				return false;
		} else if (!goodwill.equals(other.goodwill))
			return false;
		return true;
	}

	@Override
	public int compareTo(GoodwillComment o) {
		return 0;
	}
}
