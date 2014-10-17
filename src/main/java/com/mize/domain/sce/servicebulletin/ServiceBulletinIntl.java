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
@Table(name = "srvc_blltn_intl")
public class ServiceBulletinIntl extends MizeEntity {	
	
	private static final long serialVersionUID = -1164448119809296797L;
	private ServiceBulletin serviceBulletin;
	private Locale locale;
	private String name;
	private String description;
	
	public ServiceBulletinIntl() {
		super();
	}

	public ServiceBulletinIntl(ServiceBulletin serviceBulletin, Locale locale, String bulletinName,
			String bulletinDescription) {
		this.serviceBulletin = serviceBulletin;
		this.locale = locale;
		this.name = bulletinName;
		this.description = bulletinDescription;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {		
		return id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blltn_id")
	@JsonBackReference(value ="bulletinIntl")
	public ServiceBulletin getServiceBulletin() {
		return serviceBulletin;
	}

	public void setServiceBulletin(ServiceBulletin serviceBulletin) {
		this.serviceBulletin = serviceBulletin;
	}

	@ManyToOne(fetch = FetchType.EAGER ,optional = true)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	@Column(name = "blltn_name", length = 250, nullable = true)
	public String getName() {
		return name;
	}
	
	@Column(name = "blltn_description", length = 1000, nullable = true)
	public String getDescription() {
		return description;
	}
	
	
	@Override
	public void setId(Long id) {
		super.id = id;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(DateTime.now());
		}
		setUpdatedDate(DateTime.now());		
	}
	

	@Override
	public String toString() {
		return "ServiceBulletinIntl [ServiceBulletin=" + serviceBulletin + ", locale=" + locale + ", name="
				+ name + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((serviceBulletin == null) ? 0 : serviceBulletin.hashCode());
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
		ServiceBulletinIntl other = (ServiceBulletinIntl) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (serviceBulletin == null) {
			if (other.serviceBulletin != null)
				return false;
		} else if (!serviceBulletin.equals(other.serviceBulletin))
			return false;
		return true;
	}
	
	

}