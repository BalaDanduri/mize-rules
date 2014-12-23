package com.mize.domain.form;

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
import com.mize.domain.common.MizeAuditEntity;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "form_defn_audit")
public class FormDefinitionAudit extends MizeAuditEntity {

	private static final long serialVersionUID = 8404321187371760846L;
	
	private FormDefinition formDefinition;
	
	public FormDefinitionAudit() {
		super();
		formDefinition = new FormDefinition();
	}

	public FormDefinitionAudit(FormDefinition formDefinition,
			String statusCode, MizeDateTime statusDate, Long statusBy, String statusByUser) {
		this.statusCode = statusCode;
		super.statusDate = statusDate;
		super.statusBy = statusBy;
		super.statusByUser = statusByUser;
		this.formDefinition = formDefinition;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false, length = 20)
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id=id;
	}
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "form_defn_id", nullable = false)
	@JsonBackReference(value="form_def")
	public FormDefinition getFormDefinition() {
		return formDefinition;
	}

	public void setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition = formDefinition;
	}

}
