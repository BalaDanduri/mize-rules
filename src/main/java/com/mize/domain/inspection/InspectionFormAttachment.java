package com.mize.domain.inspection;

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
import com.mize.domain.common.EntityAttachment;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name = "insp_form_attach")
public class InspectionFormAttachment extends MizeSceEntity {

	
	private static final long serialVersionUID = -7260590314327288513L;
	
	private EntityAttachment entityAttachment;
	private InspectionForm inspectionForm;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}

	@OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name = "attach_id")
	public EntityAttachment getEntityAttachment() {
		return entityAttachment;
	}

	public void setEntityAttachment(EntityAttachment entityAttachment) {
		this.entityAttachment = entityAttachment;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "insp_form_id")
	@JsonBackReference(value="insp_form_attachments")
	public InspectionForm getInspectionForm() {
		return inspectionForm;
	}

	public void setInspectionForm(InspectionForm inspectionForm) {
		this.inspectionForm = inspectionForm;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((entityAttachment == null) ? 0 : entityAttachment.hashCode());
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
		if (!(obj instanceof InspectionFormAttachment)) {
			return false;
		}
		InspectionFormAttachment other = (InspectionFormAttachment) obj;
		if (entityAttachment == null) {
			if (other.entityAttachment != null) {
				return false;
			}
		} else if (!entityAttachment.equals(other.entityAttachment)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "InspectionFormAttachment [id=" + id + ", entityAttachment="
				+ entityAttachment + "]";
	}
	
	
	
	
	
}
