package com.mize.domain.batch;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="mize_job_instance")
public class MizeJobInstance extends MizeEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1638699269504919603L;
	private MizeJob job;
	private MizeJob transientJob;
	private String instanceCode;
	private String instanceName;
	private Date lastRun;
	private Date nextRun;
	private DateTime lastRunTime;
	private DateTime nextRunTime;
	private String jobStatus;
	private List<MizeJobInstanceParameter> jobParameters;
	private MizeJobSchedule schedule;
	private String isActive;
	private BusinessEntity tenant;
	private User user;
	public static final String STATUS_NOT_PLANNED = "NOT_PLANNED";
	public static final String STATUS_WAITING = "WAITING";
	public static final String STATUS_RUNNING = "RUNNING";
	public static final String STATUS_DELETED = "DELETED";
	
	public MizeJobInstance() {
		
	}

	public MizeJobInstance(Long id, String instanceCode, String instanceName, DateTime lastRunTime, DateTime nextRunTime, String jobStatus, String isActive) {
		super();
		super.id = id;
		this.instanceCode = instanceCode;
		this.instanceName = instanceName;
		this.lastRunTime = lastRunTime;
		this.nextRunTime = nextRunTime;
		this.jobStatus = jobStatus;
		this.isActive = isActive;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "jobInstance", orphanRemoval = true)
	@JsonSerialize(using = JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value = "jobInstance")
	public List<MizeJobInstanceParameter> getJobParameters() {
		return jobParameters;
	}
	
	public void setJobParameters(List<MizeJobInstanceParameter> jobParameters) {
		this.jobParameters = jobParameters;
	}
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "jobInstance",orphanRemoval = true)
	@JsonSerialize(using = JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value = "schedule")
	public MizeJobSchedule getSchedule() {
		return schedule;
	}
	
	public void setSchedule(MizeJobSchedule schedule) {
		this.schedule = schedule;
	}
	
	@Column(name = "job_status",nullable = true,length = 20)
	public String getJobStatus() {
		return jobStatus;
	}
	
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "job_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonBackReference(value = "jobInstance")
	public MizeJob getJob() {
		return job;
	}
	
	public void setJob(MizeJob job) {
		this.job = job;
	}

	@Transient
	public MizeJob getTransientJob() {
		return transientJob;
	}

	public void setTransientJob(MizeJob transientJob) {
		this.transientJob = transientJob;
	}

	@Column(name = "instance_code",nullable = false,length = 50)
	public String getInstanceCode() {
		return instanceCode;
	}
	
	public void setInstanceCode(String instanceCode) {
		this.instanceCode = instanceCode;
	}
	
	@Column(name = "instance_name",nullable = true,length = 150)
	public String getInstanceName() {
		return instanceName;
	}
	
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	
	@Transient
	public Date getLastRun() {
		return lastRun;
	}
	
	public void setLastRun(Date lastRun) {
		this.lastRun = lastRun;
	}
	
	@Transient
	public Date getNextRun() {
		return nextRun;
	}
	
	public void setNextRun(Date nextRun) {
		this.nextRun = nextRun;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@Column(name = "last_run",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getLastRunTime() {
		return lastRunTime;
	}

	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setLastRunTime(DateTime lastRunTime) {
		this.lastRunTime = lastRunTime;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@Column(name = "next_run",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getNextRunTime() {
		return nextRunTime;
	}

	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setNextRunTime(DateTime nextRunTime) {
		this.nextRunTime = nextRunTime;
	}

	@Column(name = "is_active",nullable = true,length = 1)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Transient
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id")
	@JsonSerialize(using = JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
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

	@Override
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name="created_date",updatable=false)
	@JsonIgnore(value=false)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	@Override
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name="updated_date")
	@JsonIgnore(value=false)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override	
	@JsonIgnore
	@Column(name = "created_by", nullable = true, length = 20, updatable = false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore
	@Column(name = "updated_by", nullable = true, length = 20)
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
	
	@Override
	public String toString() {
		return "MizeJobInstance [job=" + job + ", instanceCode=" + instanceCode + ", instanceName=" + instanceName 
				+ ", lastRunTime=" + lastRunTime + ", nextRunTime=" + nextRunTime + ", jobStatus=" + jobStatus 
				+ ", jobParameters=" + jobParameters + ", schedule=" + schedule + ", isActive=" + isActive 
				+ ", tenant=" + tenant + ", id=" + id + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((instanceCode == null) ? 0 : instanceCode.hashCode());
		result = prime * result + ((instanceName == null) ? 0 : instanceName.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((jobParameters == null) ? 0 : jobParameters.hashCode());
		result = prime * result + ((jobStatus == null) ? 0 : jobStatus.hashCode());
		result = prime * result + ((lastRunTime == null) ? 0 : lastRunTime.hashCode());
		result = prime * result + ((nextRunTime == null) ? 0 : nextRunTime.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
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
		MizeJobInstance other = (MizeJobInstance) obj;
		if (instanceCode == null) {
			if (other.instanceCode != null)
				return false;
		} else if (!instanceCode.equals(other.instanceCode))
			return false;
		if (instanceName == null) {
			if (other.instanceName != null)
				return false;
		} else if (!instanceName.equals(other.instanceName))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (jobParameters == null) {
			if (other.jobParameters != null)
				return false;
		} else if (!jobParameters.equals(other.jobParameters))
			return false;
		if (jobStatus == null) {
			if (other.jobStatus != null)
				return false;
		} else if (!jobStatus.equals(other.jobStatus))
			return false;
		if (lastRunTime == null) {
			if (other.lastRunTime != null)
				return false;
		} else if (!lastRunTime.equals(other.lastRunTime))
			return false;
		if (nextRunTime == null) {
			if (other.nextRunTime != null)
				return false;
		} else if (!nextRunTime.equals(other.nextRunTime))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		return true;
	}
	
}
