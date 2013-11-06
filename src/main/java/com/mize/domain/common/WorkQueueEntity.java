package com.mize.domain.common;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.service.schedule.ServiceSchedule;
import com.mize.domain.util.JodaDateTimeDeserializer;

public class WorkQueueEntity extends MizeEntity {

	private static final long serialVersionUID = -3725309680746498668L;

	private WorkQueue workQueue;
	private String entityType;
	private String entityCode;
	private ServiceSchedule serviceEntity;
	private String status;
	
	public WorkQueueEntity(){
		super();
	}
	
	public WorkQueueEntity(WorkQueue workQueue, String entityType,
			String entityCode, ServiceSchedule serviceEntity, String status) {
		super();
		this.workQueue = workQueue;
		this.entityType = entityType;
		this.entityCode = entityCode;
		this.serviceEntity = serviceEntity;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_queue_id")
	public WorkQueue getWorkQueue() {
		return workQueue;
	}

	@Column(name = "entity_type", length = 30, nullable = false)
	public String getEntityType() {
		return entityType;
	}

	@Column(name = "entity_code", length = 30, nullable = false)
	public String getEntityCode() {
		return entityCode;
	}


	@Column(name = "entity_status", length = 30, nullable = false)
	public String getStatus() {
		return status;
	}

	

	

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date")
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore
	@Column(name = "created_by")
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	public MizeEntity getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(ServiceSchedule serviceEntity) {
		this.serviceEntity = serviceEntity;
	}

	public void setWorkQueue(WorkQueue workQueue) {
		this.workQueue = workQueue;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public void setId(Long id) {
		this.id =id;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}

	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityCode == null) ? 0 : entityCode.hashCode());
		result = prime * result
				+ ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result
				+ ((serviceEntity == null) ? 0 : serviceEntity.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((workQueue == null) ? 0 : workQueue.hashCode());
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
		WorkQueueEntity other = (WorkQueueEntity) obj;
		if (entityCode == null) {
			if (other.entityCode != null)
				return false;
		} else if (!entityCode.equals(other.entityCode))
			return false;
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
			return false;
		if (serviceEntity == null) {
			if (other.serviceEntity != null)
				return false;
		} else if (!serviceEntity.equals(other.serviceEntity))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (workQueue == null) {
			if (other.workQueue != null)
				return false;
		} else if (!workQueue.equals(other.workQueue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkQueueItem [id=");
		builder.append(id);
		builder.append(", entityCode=");
		builder.append(entityCode);
		builder.append(", entityType=");
		builder.append(entityType);
		builder.append(", serviceEntity=");
		builder.append(serviceEntity);
		builder.append(", status=");
		builder.append(status);
		builder.append(", workQueue=");
		builder.append(workQueue);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
