package com.mize.domain.inspection;

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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;


@Entity
@Table(name = "insp_form_comment")
public class InspectionFormComment extends MizeSceEntity implements Comparable<InspectionFormComment> {

	
	private static final long serialVersionUID = -3606993641052519739L;
	
	private InspectionForm inspectionForm;
	private EntityComment entityComment;

	public InspectionFormComment() {
		
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "insp_form_id")
	@JsonBackReference(value="insp_form_comments")
	@JsonSerialize(using=JPASerializer.class)
	public InspectionForm getInspectionForm() {
		return inspectionForm;
	}

	public void setInspectionForm(InspectionForm inspectionForm) {
		this.inspectionForm = inspectionForm;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "comment_id")
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((entityComment == null) ? 0 : entityComment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof InspectionFormComment)) {
			return false;
		}
		InspectionFormComment other = (InspectionFormComment) obj;
		if (entityComment == null) {
			if (other.entityComment != null) {
				return false;
			}
		} else if (!entityComment.equals(other.entityComment)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(InspectionFormComment o) {
		// TODO Auto-generated method stub
		return 0;
	}	
	

}
