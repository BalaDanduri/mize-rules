package com.mize.domain.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="work_queue")
public class WorkQueue extends MizeSceEntityAudit implements Comparable<WorkQueue>{
	private static final long serialVersionUID = -488011181561672299L;
	private String name;
	private String desc;
	private String code;
	private String isActive;
	@Transient
	private User user;	
	private List<WorkQueueAuth> workQueueAuths  = new ArrayList<WorkQueueAuth>();
	private BusinessEntity tenant;
	@Transient
	private boolean isAssociateAuth;
	
	public WorkQueue(){
		super();
	}

	public WorkQueue(String name, String desc,String code,List<WorkQueueAuth> workQueueAuths) {
		super();
		this.name = name;
		this.desc = desc;
		this.code = code;
		this.workQueueAuths = workQueueAuths;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {	
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
  
	@Column(name = "description")
	public String getDesc() {
		return desc;
	}

	@Column(name = "code")
	public String getCode() {
		return code;
	}
	
	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}
	
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy = "workQueue",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="workQueue_workQueueAuth")
	public List<WorkQueueAuth> getWorkQueueAuths() {
		return workQueueAuths;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}
	
	public void setName(String name) {
		this.name = name;
	}
 
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setWorkQueueAuths(List<WorkQueueAuth> workQueueAuths) {
		this.workQueueAuths = workQueueAuths;
	}
	
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
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
	public boolean isAssociateAuth() {
		return isAssociateAuth;
	}

	public void setAssociateAuth(boolean isAssociateAuth) {
		this.isAssociateAuth = isAssociateAuth;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());		
		result = prime * result + ((workQueueAuths == null) ? 0 : workQueueAuths.hashCode());
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
		WorkQueue other = (WorkQueue) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;		
		if (workQueueAuths == null) {
			if (other.workQueueAuths != null)
				return false;
		} else if (!workQueueAuths.containsAll(other.workQueueAuths))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkQueue [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", description=");
		builder.append(desc);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(WorkQueue arg0) {
		return 0;
	}	
}
