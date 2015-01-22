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
import com.mize.domain.common.EntityErrorMessage;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;



@Entity
@Table(name = "insp_form_msg")
public class InspectionFormMessage extends MizeSceEntity implements Comparable<InspectionFormMessage> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3777376798221094439L;
	private InspectionForm inspectionForm;
	private EntityErrorMessage entityErrorMessage;

	public InspectionFormMessage() {
		
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
	
	@ManyToOne
	@JoinColumn(name = "insp_form_id")
	@JsonBackReference(value="insp_form_messages")
	@JsonSerialize(using=JPASerializer.class)
	public InspectionForm getInspectionForm() {
		return inspectionForm;
	}

	public void setInspectionForm(InspectionForm inspectionForm) {
		this.inspectionForm = inspectionForm;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "error_message_id")
	public EntityErrorMessage getEntityErrorMessage() {
		return entityErrorMessage;
	}

	public void setEntityErrorMessage(EntityErrorMessage entityErrorMessage) {
		this.entityErrorMessage = entityErrorMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((entityErrorMessage == null) ? 0 : entityErrorMessage.hashCode());
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
		InspectionFormMessage other = (InspectionFormMessage) obj;
		if (entityErrorMessage == null) {
			if (other.entityErrorMessage != null)
				return false;
		} else if (!entityErrorMessage.equals(other.entityErrorMessage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InspectionFormMessage [entityErrorMessage=" + entityErrorMessage + "]";
	}
	
	@Override
	public int compareTo(InspectionFormMessage o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
