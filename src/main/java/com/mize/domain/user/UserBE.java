package com.mize.domain.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;


@Entity
@Table(name="users_to_be")
public class UserBE extends MizeEntity implements Comparable<UserBE>{
	
	private static final long serialVersionUID = -7447355457187568168L;
	
	/*private Long userId;*/
	/*private Long beId;*/
	private String jobRole;
	private String department;
	private Set<Brand> brands;
	private User user;
	private BusinessEntity be;
	
	@ManyToOne
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public BusinessEntity getBe() {
		return be;
	}

	public void setBe(BusinessEntity be) {
		this.be = be;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	@JsonBackReference(value="userBE_user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBE() {
		
	}
	
	public UserBE(/*Long userId, */Long beId, String jobRole, String department, Set<Brand> brands) {
		/*this.userId = userId;*/
		/*this.beId = beId;*/
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
	
	@Id
	@GenericGenerator(name="id",strategy="increment")
	@GeneratedValue
	@Column(name="id",nullable=false, length=20)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	/*@Column(name = "USER_ID",  nullable = true, length = 20)
	public Long getUserId() {
		return userId;
	}

	@Column(name = "USER_ID",  nullable = true, length = 20)
	public void setUserId(Long userId) {
		this.userId = userId;
	}*/

	/*@Transient
	public Long getBeId() {
		return beId;
	}

	
	public void setBeId(Long beId) {
		this.beId = beId;
	}*/
	
	@Column(name = "JOB_ROLE",  nullable = true, length = 200)
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
		/*if ( this.userId == be.userId && this.beId == be.beId ) 
			return EQUAL;
		else*/ if (this.id < be.id) 
			return BEFORE;
		else if (be.id == this.id) 
			return EQUAL;
		else if (this.id > be.id)
			return AFTER;
		return EQUAL;		
	}

	@ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name = "users_to_brand" , joinColumns = { @JoinColumn(name="user_id")}, inverseJoinColumns = {@JoinColumn(name="brand_id")} )
	//@JsonManagedReference(value="userbe_brandMapping")
	@Transient
	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}	
	
}
