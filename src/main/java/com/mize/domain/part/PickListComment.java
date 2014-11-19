package com.mize.domain.part;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name = "picklist_comment", uniqueConstraints = { @UniqueConstraint(columnNames = {"id"}) })
public class PickListComment  extends MizeSceEntity implements Comparable<PickListComment> {
	private static final long serialVersionUID = 5105389907084215025L;
	private PickList pickList;
	private EntityComment comment;

	public PickListComment() {
		super();
	}

	public PickListComment(PickList pickList, EntityComment comment) {
		super();
		this.pickList = pickList;
		this.comment = comment;
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

	@OneToOne(fetch = FetchType.LAZY ,cascade=CascadeType.ALL)
	@JoinColumn(name = "picklist_id")
	@JsonBackReference(value="pickListComment")
	public PickList getPickList() {
		return pickList;
	}

	public void setPickList(PickList pickList) {
		this.pickList = pickList;
	}

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "comment_id")
	public EntityComment getComment() {
		return comment;
	}

	public void setComment(EntityComment comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result
				+ ((pickList == null) ? 0 : pickList.hashCode());
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
		PickListComment other = (PickListComment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (pickList == null) {
			if (other.pickList != null)
				return false;
		} else if (!pickList.equals(other.pickList))
			return false;
		return true;
	}

	@Override
	public int compareTo(PickListComment o) {
		return 0;
	}

}
