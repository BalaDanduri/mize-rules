package com.mize.domain.sce.servicebulletin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;

/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */

@Entity
@Table(name = "srvc_blltn_proc_intl")
public class ServiceBulletinProcedureIntl extends MizeEntity {
	
	private static final long serialVersionUID = -1164448119809296797L;
	private ServiceBulletinProcedure serviceBulletinProcedure;
	private Locale locale;
	private String procedureName;
	private String procedureDescription;
	private String complaintDescription;
	private String causeDescription;
	private String correctiveActionDescription;
	
	
	public ServiceBulletinProcedureIntl() {
		super();
	}

	public ServiceBulletinProcedureIntl(ServiceBulletinProcedure serviceBulletinProcedure, Locale locale, String procedureName,
			String procedureDescription,String complaintDescription,String causeDescription,String correctiveActionDescription) {
		this.setServiceBulletinProcedure(serviceBulletinProcedure);
		this.locale = locale;
		this.setProcedureName(procedureName);
		this.setProcedureDescription(procedureDescription);
		this.complaintDescription = complaintDescription;
		this.causeDescription = causeDescription;
		this.correctiveActionDescription = correctiveActionDescription;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {		
		return id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blltn_proc_id")
	@JsonBackReference(value ="serviceBulletinProcIntl")
	public ServiceBulletinProcedure getServiceBulletinProcedure() {
		return serviceBulletinProcedure;
	}

	public void setServiceBulletinProcedure(ServiceBulletinProcedure serviceBulletinProcedure) {
		this.serviceBulletinProcedure = serviceBulletinProcedure;
	}

	@ManyToOne(fetch = FetchType.EAGER ,optional = true)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	@Column(name = "proc_name", length = 250, nullable = true)
	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	
	@Column(name = "proc_descr", length = 1000, nullable = true)
	public String getProcedureDescription() {
		return procedureDescription;
	}

	public void setProcedureDescription(String procedureDescription) {
		this.procedureDescription = procedureDescription;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(DateTime.now());
		}
		setUpdatedDate(DateTime.now());		
	}
	
	@Column(name = "complaint_descr", length = 1000, nullable = true)
	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}
	
	@Column(name = "cause_descr", length = 1000, nullable = true)
	public String getCauseDescription() {
		return causeDescription;
	}

	public void setCauseDescription(String causeDescription) {
		this.causeDescription = causeDescription;
	}
	
	@Column(name = "corrective_action_descr", length = 1000, nullable = true)
	public String getCorrectiveActionDescription() {
		return correctiveActionDescription;
	}

	public void setCorrectiveActionDescription(String correctiveActionDescription) {
		this.correctiveActionDescription = correctiveActionDescription;
	}

	@Override
	public String toString() {
		return "ServiceBulletinIntl [ServiceBulletin="
				+ serviceBulletinProcedure + ", locale=" + locale
				+ ", procedureName=" + procedureName
				+ ", procedureDescription=" + procedureDescription
				+ ", complaintDescription=" + complaintDescription
				+ ", causeDescription=" + causeDescription
				+ ", correctiveActionDescription=" + correctiveActionDescription
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((procedureDescription == null) ? 0 : procedureDescription.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((procedureName == null) ? 0 : procedureName.hashCode());
		result = prime * result + ((complaintDescription == null) ? 0 : complaintDescription.hashCode());
		result = prime * result + ((causeDescription == null) ? 0 : causeDescription.hashCode());
		result = prime * result + ((correctiveActionDescription == null) ? 0 : correctiveActionDescription.hashCode());
		result = prime * result + ((serviceBulletinProcedure == null) ? 0 : serviceBulletinProcedure.hashCode());
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
		ServiceBulletinProcedureIntl other = (ServiceBulletinProcedureIntl) obj;
		if (procedureDescription == null) {
			if (other.procedureDescription != null)
				return false;
		} else if (!procedureDescription.equals(other.procedureDescription))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (procedureName == null) {
			if (other.procedureName != null)
				return false;
		} else if (!procedureName.equals(other.procedureName))
			return false;
		if (complaintDescription == null) {
			if (other.complaintDescription != null)
				return false;
		} else if (!complaintDescription.equals(other.complaintDescription))
			return false;
		if (causeDescription == null) {
			if (other.causeDescription != null)
				return false;
		} else if (!causeDescription.equals(other.causeDescription))
			return false;
		if (correctiveActionDescription == null) {
			if (other.correctiveActionDescription != null)
				return false;
		} else if (!correctiveActionDescription.equals(other.correctiveActionDescription))
			return false;
		if (serviceBulletinProcedure == null) {
			if (other.serviceBulletinProcedure != null)
				return false;
		} else if (!serviceBulletinProcedure.equals(other.serviceBulletinProcedure))
			return false;
		return true;
	}

}