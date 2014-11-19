package com.mize.domain.user;

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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name="users_to_brand")
public class UserBrandMapping extends MizeSceEntity implements Comparable<UserBrandMapping>{

	private static final long serialVersionUID = -289763682693109655L;
	
	private User user;
	private Brand brand;
	private String isActive;
	private Brand userBrand;
	
	public UserBrandMapping(User user,Brand brand,String isActive) {
			super();
			this.user = user;
			this.brand = brand;
			this.isActive = isActive;
	} 
	
	public UserBrandMapping() {
		
	} 
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",unique=true,nullable=false,length=20)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	@JsonBackReference(value="user_brandMapping")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="brand_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonBackReference(value="brand_userbrandMapping")
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name="active_indicator",nullable=false)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override	
	@Column(name = "created_date", updatable = false)
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(value=false)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override
	@JsonIgnore(value=false)
	public void setCreatedDate(MizeDateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	
	@Column(name = "updated_date", nullable = true)
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(value=false)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	
	@JsonIgnore(value=false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override	
	@JsonIgnore(value=false)
	@Column(name = "created_by", nullable = true, length = 20, updatable = false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}
	
	@Override
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore(value=false)
	@Column(name = "updated_by", nullable = true, length = 20)
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
	
	@Transient
	public Brand getUserBrand() {
		return userBrand;
	}

	public void setUserBrand(Brand userBrand) {
		this.userBrand = userBrand;
	}

	@Override
	public int compareTo(UserBrandMapping userBrand) {
		if ( this == userBrand ) 
			return EQUAL;
		else if (this.id < userBrand.id) 
			return BEFORE;
		else if (userBrand.id == this.id) 
			return EQUAL;
		else if (this.id > userBrand.id)
			return AFTER;
		return EQUAL;		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		UserBrandMapping other = (UserBrandMapping) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserBrandMapping [user=" + user + ", brand=" + brand
				+ ", isActive=" + isActive + "]";
	}
	
	
}
