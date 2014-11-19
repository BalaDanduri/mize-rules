package com.mize.domain.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;


@Entity
@Table(name="users_to_be")
public class UserBE extends MizeSceEntity implements Comparable<UserBE>{
	
	private static final long serialVersionUID = -7447355457187568168L;
	
	private String jobRole;
	private String department;
	private Set<Brand> brands;
	private User user;
	private BusinessEntity be;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="be_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getBe() {
		return be;
	}

	public void setBe(BusinessEntity be) {
		this.be = be;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonBackReference(value="userBE_user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBE() {
		
	}
	
	public UserBE(Long beId, String jobRole, String department, Set<Brand> brands) {
		this.jobRole = jobRole;
		this.department = department;
		this.brands = brands;
	}

	@Column(name = "department",  nullable = true, length = 100)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "JOB_ROLE",  nullable = true, length = 200)
	public String getJobRole() {
		return jobRole;
	}

	
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	@JsonIgnore(value=false)
	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
 
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	@JsonIgnore(value=false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "created_date",updatable = false)
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(value=false)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	@Column(name = "updated_date")
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(value=false)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@JsonIgnore(value=false)
	@Column(name = "created_by" , updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@Override
	public String toString() {
		return "UserBE [ jobRole=" + jobRole + ", department=" + department
				+ "]";
	}

	public int compareTo(UserBE be) {
		if (this.id < be.id) 
			return BEFORE;
		else if (be.id == this.id) 
			return EQUAL;
		else if (this.id > be.id)
			return AFTER;
		return EQUAL;		
	}

	@ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name = "users_to_brand" , joinColumns = { @JoinColumn(name="user_id")}, inverseJoinColumns = {@JoinColumn(name="brand_id")} )
	@Transient
	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}	
	
}
