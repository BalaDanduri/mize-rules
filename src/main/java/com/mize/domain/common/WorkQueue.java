package com.mize.domain.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.util.JodaDateTimeDeserializer;


public class WorkQueue extends MizeEntity {


	private static final long serialVersionUID = -488011181561672299L;
	private String name;
	private String desc;
	private String code;
	
	private List<WorkQueueAuth> workQueueAuths  =new ArrayList<WorkQueueAuth>();
	

	public WorkQueue(){
		super();

	}

	public WorkQueue(String name, String desc,String code,
			List<WorkQueueAuth> workQueueAuths) {
		super();
		this.name = name;
		this.desc = desc;
		this.code = code;
		this.workQueueAuths = workQueueAuths;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
	
		return id;
	}
 
	@Column(name = "name", length = 30, nullable = false)
	public String getName() {
		return name;
	}
  
	@Column(name = "description", length = 100, nullable = false)
	public String getDesc() {
		return desc;
	}

	public String getCode() {
		return code;
	}
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workQueue")
	public List<WorkQueueAuth> getWorkQueueAuths() {
		return workQueueAuths;
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


	@Override
	public void setId(Long id) {
		this.id = id;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((workQueueAuths == null) ? 0 : workQueueAuths.hashCode());
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
		if (workQueueAuths == null) {
			if (other.workQueueAuths != null)
				return false;
		} else if (!workQueueAuths.equals(other.workQueueAuths))
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
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", name=");
		builder.append(name);
		builder.append(", workQueueAuths=");
		builder.append(workQueueAuths);
		builder.append("]");
		return builder.toString();
	}


	

	
	
}
