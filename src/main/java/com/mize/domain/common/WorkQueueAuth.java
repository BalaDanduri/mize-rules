package com.mize.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="work_queue_auth")
public class WorkQueueAuth extends MizeEntity {

	
	private static final long serialVersionUID = -1821933287120972826L;
 
	private WorkQueue workQueue;
	private String authType;
	private long authId;
	private Authorization authorization;
	
	public WorkQueueAuth(){
		super();
	}
	
	public WorkQueueAuth(WorkQueue workQueue, String authType,long authId, Authorization authorization) {
		super();
		this.workQueue = workQueue;
		this.authType = authType;
		this.authId = authId;
		this.authorization = authorization;
	}

	@Id
	@GenericGenerator(name="id",strategy="increment")
	@GeneratedValue
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	

	@Column(name = "auth_id")
	public long getAuthId() {
		return authId;
	}

	@Transient
	public Authorization getAuthorization() {
		return authorization;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_queue_id")
	@JsonBackReference(value="workQueue_workQueueAuth")
	public WorkQueue getWorkQueue() {
		return workQueue;
	}

	@Column(name = "auth_type", length = 30, nullable = false)
	public String getAuthType() {
		return authType;
	}
	

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date")
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
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
	
	public void setWorkQueue(WorkQueue workQueue) {
		this.workQueue = workQueue;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}
	
	public void setAuthId(long authId) {
		this.authId = authId;
	}
	
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}


	@Override
	public void setId(Long id) {
		this.id = id;
	}
 
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (authId ^ (authId >>> 32));
		result = prime * result
				+ ((authType == null) ? 0 : authType.hashCode());
		result = prime * result
				+ ((authorization == null) ? 0 : authorization.hashCode());
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
		WorkQueueAuth other = (WorkQueueAuth) obj;
		if (authId != other.authId)
			return false;
		if (authType == null) {
			if (other.authType != null)
				return false;
		} else if (!authType.equals(other.authType))
			return false;
		if (authorization == null) {
			if (other.authorization != null)
				return false;
		} else if (!authorization.equals(other.authorization))
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
		builder.append("WorkQueueAuth [id=");
		builder.append(id);
		builder.append(", authId=");
		builder.append(authId);
		builder.append(", authType=");
		builder.append(authType);
		builder.append(", workQueue=");
		builder.append(workQueue);
		builder.append(", authorization=");
		builder.append(authorization);
		builder.append("]");
		return builder.toString();
	}

}
