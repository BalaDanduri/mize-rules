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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeAuditEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "insp_form_audit")
public class InspectionFormAudit extends MizeAuditEntity implements Comparable<InspectionFormAudit> {

	private static final long serialVersionUID = 6821133638967617947L;

	private InspectionForm inspectionForm;
	private String statusCode;
	
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
	
	@Column(name = "status_code")
	public String getStatusCode() {
		return statusCode;
	}

	
	@Column(name = "status_date")
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getStatusDate() {
		return statusDate;
	}

	@Column(name = "status_by")
	public Long getStatusBy() {
		return statusBy;
	}
	
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	
	public void setInspectionForm(InspectionForm inspectionForm) {
		this.inspectionForm = inspectionForm;
	}
	
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	public void setStatusDate(MizeDateTime statusDate) {
		this.statusDate = statusDate;
	}
	
	public void setStatusBy(Long statusBy) {
		this.statusBy = statusBy;
	}
	
	@Column(name = "status_by_user")
	@Override
	public String getStatusByUser() {
		return statusByUser;
	}

	public void setStatusByUser(String statusByUser) {
		this.statusByUser = statusByUser;
	}



	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((statusBy == null) ? 0 : statusBy.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result + ((statusDate == null) ? 0 : statusDate.hashCode());
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
		InspectionFormAudit other = (InspectionFormAudit) obj;
		if (statusBy == null) {
			if (other.statusBy != null)
				return false;
		} else if (!statusBy.equals(other.statusBy))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (statusDate == null) {
			if (other.statusDate != null)
				return false;
		} else if (statusDate.compareTo(other.statusDate) != 0)
			return false;
		return true;
	}
	
	
	@Override
	public int compareTo(InspectionFormAudit arg0) {
		return 0;
	}



	@Override
	public String toString() {
		return "InspectionFormAudit [id=" + id + ", statusCode="
				+ statusCode + ", statusDate=" + statusDate + ", statusBy="
				+ statusBy +  "]";
	}

}
