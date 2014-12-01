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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="work_queue_auth")
public class WorkQueueAuth extends MizeSceEntityAudit implements Comparable<WorkQueueAuth>{

	
	private static final long serialVersionUID = -1821933287120972826L;
 
	private WorkQueue workQueue;
	private String authType;
	private Long authId;
	private Authorization authorization;
	@Transient
	private Long workQueueId;
	@Transient
	private String workQueueName;
	
	public WorkQueueAuth(){
		super();
	}
	
	public WorkQueueAuth(Long id ,Long wqId ,String workQueueName,String authType){
		super();
		this.id = id;		
		this.workQueueId = wqId;
		this.workQueueName = workQueueName;
		this.authType = authType;
	}
	
	public WorkQueueAuth(WorkQueue workQueue, String authType,long authId, Authorization authorization) {
		super();
		this.workQueue = workQueue;
		this.authType = authType;
		this.authId = authId;
		this.authorization = authorization;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}
	

	@Column(name = "auth_id")
	public Long getAuthId() {
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

	@Column(name = "auth_type")
	public String getAuthType() {
		return authType;
	}
	
	
	@Transient
	public Long getWorkQueueId() {
		return workQueueId;
	}


	@Transient
	public String getWorkQueueName() {
		return workQueueName;
	}

	public void setWorkQueue(WorkQueue workQueue) {
		this.workQueue = workQueue;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}
	
	public void setAuthId(Long authId) {
		this.authId = authId;
	}
	
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	public void setWorkQueueId(Long workQueueId) {
		this.workQueueId = workQueueId;
	}

	public void setWorkQueueName(String workQueueName) {
		this.workQueueName = workQueueName;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
 
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + (int) (authId ^ (authId >>> 32));
		result = prime * result
				+ ((authType == null) ? 0 : authType.hashCode());		
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
		builder.append(", authorization=");
		builder.append(authorization);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(WorkQueueAuth o) {
		return 0;
	}

}
