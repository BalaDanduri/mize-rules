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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.CachedEntity;
import com.mize.domain.util.JPASerializer;


@Entity
@Table(name="users_to_be")
public class UserBE extends MizeSceEntityAudit implements Comparable<UserBE>{
	
	private static final long serialVersionUID = -7447355457187568168L;
	
	private String jobRole;
	private String department;
	private Set<Brand> brands;
	private User user;
	@CachedEntity
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

	@Column(name = "department")
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
	
	@Column(name = "JOB_ROLE")
	public String getJobRole() {
		return jobRole;
	}

	
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
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
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "users_to_brand" , joinColumns = { @JoinColumn(name="user_id")}, inverseJoinColumns = {@JoinColumn(name="brand_id")} )
	@Transient
	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((be == null) ? 0 : be.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((jobRole == null) ? 0 : jobRole.hashCode());
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
		UserBE other = (UserBE) obj;
		if (be == null) {
			if (other.be != null)
				return false;
		} else if (!be.equals(other.be))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (jobRole == null) {
			if (other.jobRole != null)
				return false;
		} else if (!jobRole.equals(other.jobRole))
			return false;
		return true;
	}	
	
	
	
	
}
