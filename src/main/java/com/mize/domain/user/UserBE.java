package com.mize.domain.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "user_to_be")
public class UserBE extends MizeEntity implements Comparable<UserBE>{
	
	private static final long serialVersionUID = -7447355457187568168L;
	
	private Long userId;
	private Long beId;
	private String jobRole;
	private String department;
	private Set<Brand> brands;
	
	public UserBE() {
		
	}
	
	public UserBE(Long userId, Long beId, String jobRole, String department, Set<Brand> brands) {
		this.userId = userId;
		this.beId = beId;
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
	public Long getId() {
		return userId;
	}

	@Override
	public void setId(Long id) {
		this.userId = id;
	}	
	
	@Column(name = "USER_ID",  nullable = true, length = 20)
	public Long getUserId() {
		return userId;
	}

	@Column(name = "USER_ID",  nullable = true, length = 20)
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "BE_ID",  nullable = true, length = 20)
	public Long getBeId() {
		return beId;
	}

	@Column(name = "BE_ID",  nullable = true, length = 20)
	public void setBeId(Long beId) {
		this.beId = beId;
	}

	@Column(name = "JOB_ROLE",  nullable = true, length = 200)
	public String getJobRole() {
		return jobRole;
	}

	@Column(name = "JOB_ROLE",  nullable = true, length = 200)
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	@Override
	public String toString() {
		return "UserBE [userId=" + userId + ", beId=" + beId + ", jobRole=" + jobRole + ", department=" + department
				+ "]";
	}

	public int compareTo(UserBE be) {
		if ( this.userId == be.userId && this.beId == be.beId ) 
			return EQUAL;
		else if (this.id < be.id) 
			return BEFORE;
		else if (be.id == this.id) 
			return EQUAL;
		else if (this.id > be.id)
			return AFTER;
		return EQUAL;		
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_to_brand" , joinColumns = { @JoinColumn(name="user_id")}, inverseJoinColumns = {@JoinColumn(name="brand_id")} )
	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}	
	
}
