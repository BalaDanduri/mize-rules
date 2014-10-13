package com.mize.domain.labor;

import java.math.BigDecimal;
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
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "labor_hour", uniqueConstraints = {@UniqueConstraint (columnNames = {"tenant_id", "labor_code"})})
public class LaborHour extends MizeSceEntity implements Comparable<LaborHour> {

	private static final long serialVersionUID = 86846948813348698L;
	private BusinessEntity tenant;
	private String type;
	private String code;
	private MizeDateTime startDate;
	private MizeDateTime endDate;
	private BigDecimal hours;
	private List<LaborHourIntl> intls=new ArrayList<LaborHourIntl>();
	
	@Transient
	private User user;
	
	public LaborHour() {
	}
	
	public LaborHour(Long id , String code, String type, MizeDateTime startDate,
			MizeDateTime endDate, BigDecimal hours) {
		super();
		this.id = id;
		this.type = type;
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hours = hours;
	}

	public LaborHour(BusinessEntity tenant, String type, String code,
			MizeDateTime startDate, MizeDateTime endDate, BigDecimal hours,
			List<LaborHourIntl> intls, User user) {
		super();
		this.tenant = tenant;
		this.type = type;
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
		this.hours = hours;
		this.intls = intls;
		this.user = user;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column(name = "labor_type", length = 50, nullable = true)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "labor_code", length = 50, nullable = false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "start_date", nullable = true)
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(MizeDateTime startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date", nullable = true)
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(MizeDateTime endDate) {
		this.endDate = endDate;
	}

	@Column(name = "labor_hours", nullable = true)
	public BigDecimal getHours() {
		return hours;
	}

	public void setHours(BigDecimal hours) {
		this.hours = hours;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "laborHour" ,orphanRemoval= true)
	@JsonManagedReference(value="laborHour")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<LaborHourIntl> getIntls() {
		return intls;
	}

	public void setIntls(List<LaborHourIntl> intls) {
		this.intls = intls;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "created_by" , updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@JsonIgnore(value=false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "created_date",updatable = false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((hours == null) ? 0 : hours.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		LaborHour other = (LaborHour) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (hours == null) {
			if (other.hours != null)
				return false;
		} else if (!Formatter.equal(hours, other.hours))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;		
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int compareTo(LaborHour labor) {
		if ( this == labor ) 
			return EQUAL;
		else if (this.id < labor.id) 
			return BEFORE;
		else if (labor.id == this.id) 
			return EQUAL;
		else if (this.id > labor.id)
			return AFTER;
		return EQUAL;
	}
	
}
