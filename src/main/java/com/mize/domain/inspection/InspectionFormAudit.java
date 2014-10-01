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
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@Entity
@Table(name = "insp_form_audit")
public class InspectionFormAudit extends MizeEntity implements Comparable<InspectionFormAudit> {

	private static final long serialVersionUID = 6821133638967617947L;

	private InspectionForm inspectionForm;
	private String statusCode;
	private DateTime statusDate;
	private Long statusBy;

	
	public InspectionFormAudit(){
	
	}
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
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
	
	@Column(name = "status_code", length = 50)
	public String getStatusCode() {
		return statusCode;
	}

	@Column(name = "status_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public DateTime getStatusDate() {
		return statusDate;
	}

	@Column(name = "status_by", length = 20, nullable = true)
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
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)	
	public void setStatusDate(DateTime statusDate) {
		this.statusDate = statusDate;
	}
	
	public void setStatusBy(Long statusBy) {
		this.statusBy = statusBy;
	}
	
	



	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((inspectionForm == null) ? 0 : inspectionForm.hashCode());
		result = prime * result
				+ ((statusBy == null) ? 0 : statusBy.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result
				+ ((statusDate == null) ? 0 : statusDate.hashCode());
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
		if (inspectionForm == null) {
			if (other.inspectionForm != null)
				return false;
		} else {
			if(inspectionForm.getId() == null) {
				if(other.inspectionForm.getId() != null)
					return false;
			} else if(!inspectionForm.getId().equals(other.inspectionForm.getId()))
				return false;
		}
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
		return "InspectionFormAudit [id=" + id
				+ ", inspectionForm=" + inspectionForm + ", statusCode="
				+ statusCode + ", statusDate=" + statusDate + ", statusBy="
				+ statusBy +  "]";
	}

}