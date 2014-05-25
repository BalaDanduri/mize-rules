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
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="work_queue_entity_history")
public class WorkQueueEntityHistory extends MizeEntity implements Comparable<WorkQueueEntityHistory>{

	private static final long serialVersionUID = -3123309680746498668L;

	private WorkQueue workQueue;
	private String entityType;
	private String entityCode;
	private Long entityId;
	private String status;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime entityInDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime entityOutDate;	
	@Transient
	private User user;
	@Transient
	private BusinessEntity tenant;
	
	public WorkQueueEntityHistory(){
		super();
	}
	
	public enum EntityType{
		Claim,Service_Order,Support_Request,Parts_Order,Service_Entity,Inspection,ProductRegistration,Purchase_Order
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
 
	@ManyToOne(fetch = FetchType.EAGER)
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
	@Column(name = "created_by",updatable = false)
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
	public int compareTo(WorkQueueEntityHistory arg0) {
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
	@JsonIgnore
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "entity_in_date",updatable = false)
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getEntityInDate() {
		return entityInDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	public void setEntityInDate(DateTime entityInDate) {
		this.entityInDate = entityInDate;
	}

	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "entity_out_date",updatable = false)
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getEntityOutDate() {
		return entityOutDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	public void setEntityOutDate(DateTime entityOutDate) {
		this.entityOutDate = entityOutDate;
	}

	@Override
	public String toString() {
		return "WorkQueueEntityHistory [entityType=" + entityType
				+ ", entityCode=" + entityCode + ", entityId=" + entityId
				+ ", status=" + status + ", entityInDate=" + entityInDate
				+ ", entityOutDate=" + entityOutDate + ", id=" + id + "]";
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
				+ ((entityInDate == null) ? 0 : entityInDate.hashCode());
		result = prime * result
				+ ((entityOutDate == null) ? 0 : entityOutDate.hashCode());
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
		WorkQueueEntityHistory other = (WorkQueueEntityHistory) obj;
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
		if (entityInDate == null) {
			if (other.entityInDate != null)
				return false;
		} else if (!entityInDate.equals(other.entityInDate))
			return false;
		if (entityOutDate == null) {
			if (other.entityOutDate != null)
				return false;
		} else if (!entityOutDate.equals(other.entityOutDate))
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
	
}
