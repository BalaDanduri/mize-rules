package com.mize.domain.form.link;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@Entity
@Table(name = "form_instance_link_audit", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class FormInstanceLinkAudit extends MizeEntity {
	
	private static final long serialVersionUID = -7334138913699640923L;
	
	private FormInstanceLink formInstanceLink;
	private String statusCode;
	private DateTime statusDate;
	private Long statusBy;
	
	public FormInstanceLinkAudit() {
		super();
	}

	public FormInstanceLinkAudit(FormInstanceLink formInstanceLink,
			String statusCode, DateTime statusDate, Long statusBy) {
		super();
		this.formInstanceLink = formInstanceLink;
		this.statusCode = statusCode;
		this.statusDate = statusDate;
		this.statusBy = statusBy;
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
	@JoinColumn(name = "instance_link_id", nullable = false)
	@JsonBackReference(value="form_instance_link")
	public FormInstanceLink getFormInstanceLink() {
		return formInstanceLink;
	}

	public void setFormInstanceLink(FormInstanceLink formInstanceLink) {
		this.formInstanceLink = formInstanceLink;
	}
	
	@Column( name = "status_code", nullable = true, length = 30)
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@Column(name = "status_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getStatusDate() {
		return statusDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setStatusDate(DateTime statusDate) {
		this.statusDate = statusDate;
	}
	
	@Column( name = "status_by", nullable = true, length = 20)
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
		FormInstanceLinkAudit other = (FormInstanceLinkAudit) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "FormInstanceLinkAudit [statusCode=" + statusCode
				+ ", statusDate=" + statusDate + ", statusBy=" + statusBy + "]";
	}

}
