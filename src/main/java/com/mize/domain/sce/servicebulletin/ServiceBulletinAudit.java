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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeAuditEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */
@Entity
@Table(name = "srvc_blltn_audit")
public class ServiceBulletinAudit extends MizeAuditEntity implements Comparable<ServiceBulletinAudit> {

	
	private static final long serialVersionUID = -4801057184698573353L;
	
	private ServiceBulletin serviceBulletin;
	private String statusCode;

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
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getStatusDate() {
		return statusDate;
	}
	
	public void setStatusDate(MizeDateTime statusDate) {
		this.statusDate = statusDate;
	}
	
	@Column(name = "status_by")
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
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
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
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceBulletinAudit [statusCode=" + statusCode + "]";
	}

	@Override
	public int compareTo(ServiceBulletinAudit o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
