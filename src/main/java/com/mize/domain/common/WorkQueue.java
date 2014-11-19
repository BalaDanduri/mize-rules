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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name="work_queue", uniqueConstraints = {@UniqueConstraint (columnNames = {"name","tenant_id"})})
public class WorkQueue extends MizeSceEntity implements Comparable<WorkQueue>{
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
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {	
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name", length = 30, nullable = false)
	public String getName() {
		return name;
	}
  
	@Column(name = "description", length = 100, nullable = true)
	public String getDesc() {
		return desc;
	}

	@Column(name = "code", length = 30, nullable = false)
	public String getCode() {
		return code;
	}
	
	@Column(name = "is_active",  nullable = true, length = 1)
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
	
	@Override	
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name = "created_date",updatable=false)
	@JsonIgnore(value=false)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(value=false)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore(value=false)
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore(value=false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
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
     
	@Override
	@Column(name="created_date")
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(value=false)
	public void setCreatedDate(MizeDateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(value=false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Override
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}

	@Override
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
