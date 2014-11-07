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

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeAuditEntity;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "form_defn_audit")
public class FormDefinitionAudit extends MizeAuditEntity {

	private static final long serialVersionUID = 8404321187371760846L;
	
	private FormDefinition formDefinition;
	
	private String statusCode;
	
	public FormDefinitionAudit() {
		super();
		formDefinition = new FormDefinition();
	}

	public FormDefinitionAudit(FormDefinition formDefinition,
			String statusCode, DateTime statusDate, Long statusBy, String statusByUser) {
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
	
	@Column(name = "status_code", nullable = true, length = 50)
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy HH:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@Column(name = "status_date")
	@JsonIgnore(value = false)
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@Override
	public DateTime getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(DateTime statusDate) {
		this.statusDate = statusDate;
	}

	@Column(name = "status_by", nullable = true, length = 20)
	@Override
	public Long getStatusBy() {
		return statusBy;
	}

	public void setStatusBy(Long statusBy) {
		this.statusBy = statusBy;
	}

	@Column(name = "status_by_user", nullable = true, length = 250)
	@Override
	public String getStatusByUser() {
		return statusByUser;
	}

	public void setStatusByUser(String statusByUser) {
		this.statusByUser = statusByUser;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((formDefinition == null) ? 0 : formDefinition.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
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
		FormDefinitionAudit other = (FormDefinitionAudit) obj;
		if (formDefinition == null) {
			if (other.formDefinition != null)
				return false;
		} else if (!formDefinition.equals(other.formDefinition))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "FormDefinitionAudit [formDefinition=" + formDefinition + ", statusCode=" + statusCode + "]";
	}

}
