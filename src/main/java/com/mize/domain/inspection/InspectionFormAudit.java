package com.mize.domain.inspection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeAuditEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "insp_form_audit")
public class InspectionFormAudit extends MizeAuditEntity implements Comparable<InspectionFormAudit> {

	private static final long serialVersionUID = 6821133638967617947L;

	private InspectionForm inspectionForm;
	
	public InspectionFormAudit(){
	
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "insp_form_id")
	@JsonBackReference(value="insp_form_audits")
	@JsonSerialize(using=JPASerializer.class)
	public InspectionForm getInspectionForm() {
		return inspectionForm;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	public void setInspectionForm(InspectionForm inspectionForm) {
		this.inspectionForm = inspectionForm;
	}
	
	@Override
	public int compareTo(InspectionFormAudit arg0) {
		return 0;
	}

}
