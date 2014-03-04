package com.mize.domain.common;

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

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.product.ProductSerial;
import com.mize.domain.service.schedule.ServiceSchedule;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="work_queue_entity")
public class WorkQueueEntity extends MizeEntity implements Comparable<WorkQueueEntity>{

	private static final long serialVersionUID = -3725309680746498668L;

	private WorkQueue workQueue;
	private String entityType;
	private String entityCode;
	private Long entityId;
	@Transient
	private ServiceSchedule serviceEntity;
	private String status;
	private User user;
	@Transient
	private WorkQueueResult result;
	public WorkQueueEntity(){
		super();
	}
	
	public WorkQueueEntity(Long id,Long entityId, String entityType,String status,String serviceType,String serviceCode,DateTime serviceDate,BusinessEntity businessEntity,ProductSerial productSerial) {
		result = new WorkQueueResult(id,entityId, entityType,status,serviceType,serviceCode,serviceDate,businessEntity,productSerial);
	}
	
	public WorkQueueEntity(Long id,Long entityId, String entityType,String entityCode,String status,String orderType,DateTime serviceDate,BusinessEntity businessEntity) {
		result = new WorkQueueResult(id,entityId, entityType,entityCode,status,orderType,serviceDate,businessEntity);
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

	public enum EntityType{
		Claim,Service_Order,Support_Request,Parts_Order,Service_Entity,Inspection,ProductRegistration
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

	@Column(name = "entity_type", length = 30)
	public String getEntityType() {
		return entityType;
	}

	@Column(name = "entity_code", length = 30)
	public String getEntityCode() {
		return entityCode;
	}


	@Column(name = "entity_status", length = 30)
	public String getStatus() {
		return status;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date",updatable = false)
	@JsonIgnore(value = false)
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(value = false)
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@Column(name = "created_by")
	@JsonIgnore(value = false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@Column(name = "updated_by")
	@JsonIgnore(value = false)
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Transient
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
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonIgnore(value = false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonIgnore(value = false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Override
	@JsonIgnore(value = false)
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}

	@Override
	@JsonIgnore(value = false)
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}

	@Column(name="entity_id")
	public Long getEntityId() {
		return entityId;
	}
	
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}	
	
	@Override
	public int compareTo(WorkQueueEntity arg0) {
		return 0;
	}

	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	public WorkQueueResult getResult() {
		return result;
	}

	public void setResult(WorkQueueResult result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityCode == null) ? 0 : entityCode.hashCode());
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result
				+ ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkQueueEntity [entityType=" + entityType + ", entityCode="
				+ entityCode + ", entityId=" + entityId + ", status=" + status
				+ "]";
	}
	
}
