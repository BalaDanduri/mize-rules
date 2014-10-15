package com.mize.domain.sce.servicebulletin;

import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */
@Entity
@Table(name = "srvc_blltn_audit")
public class ServiceBulletinAudit extends MizeEntity {

	
	private static final long serialVersionUID = -4801057184698573353L;
	
	private ServiceBulletin serviceBulletin;
	private String statusCode;
	private DateTime statusDate;
	private Long statusBy;

	public ServiceBulletinAudit() {
		
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "blltn_id")
	@JsonBackReference(value="service_bulletin_audits")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceBulletin getServiceBulletin() {
		return serviceBulletin;
	}

	public void setServiceBulletin(ServiceBulletin serviceBulletin) {
		this.serviceBulletin = serviceBulletin;
	}
	
	
	@Column(name = "status_code", length= 50)
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	@Column(name = "status_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public DateTime getStatusDate() {
		return statusDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setStatusDate(DateTime statusDate) {
		this.statusDate = statusDate;
	}
	
	@Column(name = "status_by")
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
				+ ((serviceBulletin == null) ? 0 : serviceBulletin.hashCode());
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
		ServiceBulletinAudit other = (ServiceBulletinAudit) obj;
		if (serviceBulletin == null) {
			if (other.serviceBulletin != null)
				return false;
		} else {
			if(serviceBulletin.getId() == null) {
				if(other.serviceBulletin.getId() != null)
					return false;
			} else if(!serviceBulletin.getId().equals(other.serviceBulletin.getId()))
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
		} else if (!statusDate.equals(other.statusDate))
			return false;
		return true;
	}

}
