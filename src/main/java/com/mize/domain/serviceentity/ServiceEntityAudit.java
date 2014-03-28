package com.mize.domain.serviceentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "service_entity_audit")
public class ServiceEntityAudit extends MizeEntity implements Comparable<ServiceEntityAudit> {

	private static final long serialVersionUID = 6821133638967617947L;
	@Transient
	private Long entityId;
	private ServiceEntity serviceEntity;
	private String statusCode;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime statusDate;
	private Long statusBy;
	@Transient
	private String userName;
	
	public ServiceEntityAudit(){
		super();
	}
	
	public ServiceEntityAudit(Long entityId, ServiceEntity serviceEntity,
			String statusCode, DateTime statusDate, Long statusBy,
			String userName) {
		super();
		this.entityId = entityId;
		this.serviceEntity = serviceEntity;
		this.statusCode = statusCode;
		this.statusDate = statusDate;
		this.statusBy = statusBy;
		this.userName = userName;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	public Long getEntityId() {
		return entityId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entity_id")
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}
	
	@Column(name = "status_code", length = 30, nullable = true)
	public String getStatusCode() {
		return statusCode;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@Column(name = "status_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getStatusDate() {
		return statusDate;
	}

	@Column(name = "status_by", length = 20, nullable = true)
	public Long getStatusBy() {
		return statusBy;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	@JsonIgnore(value=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore(value=false)
	public Long getUpdatedBy() {
		return updatedBy;
	}
	
	public String getUserName() {
		return userName;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}
	
	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}
	
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setStatusDate(DateTime statusDate) {
		this.statusDate = statusDate;
	}
	
	public void setStatusBy(Long statusBy) {
		this.statusBy = statusBy;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result
				+ ((serviceEntity == null) ? 0 : serviceEntity.hashCode());
		result = prime * result
				+ ((statusBy == null) ? 0 : statusBy.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result
				+ ((statusDate == null) ? 0 : statusDate.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
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
		ServiceEntityAudit other = (ServiceEntityAudit) obj;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (serviceEntity == null) {
			if (other.serviceEntity != null)
				return false;
		} else if (!serviceEntity.equals(other.serviceEntity))
			return false;
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
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SEAudit [entityId=");
		builder.append(entityId);
		builder.append(", serviceEntity=");
		builder.append(serviceEntity);
		builder.append(", statusCode=");
		builder.append(statusCode);
		builder.append(", statusDate=");
		builder.append(statusDate);
		builder.append(", statusBy=");
		builder.append(statusBy);
		builder.append(", userName=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(ServiceEntityAudit arg0) {
		return 0;
	}

}
