package com.mize.domain.inspection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@Entity
@Table(name = "inspection_template_audit")
public class InspectionTemplateAudit extends MizeEntity {
	
	
	private static final long serialVersionUID = 215712712972034765L;
	private InspectionTemplate template;
	private String statusCode;
	private DateTime statusDate;
	private Long statusBy;

	public InspectionTemplateAudit() {
		template = new InspectionTemplate();
	}	
	

	public InspectionTemplateAudit(InspectionTemplate template,
			String statusCode, DateTime statusDate, Long statusBy) {
		super();
		this.template = template;
		this.statusCode = statusCode;
		this.statusDate = statusDate;
		this.statusBy = statusBy;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",unique=true,nullable=false,length=20)
	@Override
	public Long getId() {		
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "template_id", nullable = false )
	public InspectionTemplate getTemplate() {
		return template;
	}


	public void setTemplate(InspectionTemplate template) {
		this.template = template;
	}

	@Column( name = "status_code", nullable = true, length = 30)
	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "status_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getStatusDate() {
		return statusDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setStatusDate(DateTime statusDate) {
		this.statusDate = statusDate;
	}

	@Column(name = "status_by",  nullable = true)
	public Long getStatusBy() {
		return statusBy;
	}


	public void setStatusBy(Long statusBy) {
		this.statusBy = statusBy;
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((statusBy == null) ? 0 : statusBy.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result
				+ ((statusDate == null) ? 0 : statusDate.hashCode());
		result = prime * result
				+ ((template == null) ? 0 : template.hashCode());
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
		InspectionTemplateAudit other = (InspectionTemplateAudit) obj;
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
		} else if (!statusDate.equals(other.statusDate))
			return false;
		if (template == null) {
			if (other.template != null)
				return false;
		} else if (!template.getId().equals(other.template.getId()))
			return false;
		return true;
	}	
	
	
	

}
