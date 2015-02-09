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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="users_to_brand")
public class UserBrandMapping extends MizeSceEntityAudit implements Comparable<UserBrandMapping>{

	private static final long serialVersionUID = -289763682693109655L;
	
	private User user;
	private Brand brand;
	private String isActive;
	private Brand userBrand;
	private String isDefault;
	
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
	@Column(name="id")
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

	@Column(name="active_indicator")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	
	@Transient
	public Brand getUserBrand() {
		return userBrand;
	}

	public void setUserBrand(Brand userBrand) {
		this.userBrand = userBrand;
	}	

	@Column(name="is_default")
	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
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
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		return true;
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
	public String toString() {
		return "UserBrandMapping [user=" + user + ", brand=" + brand + ", isActive=" + isActive + ", isDefault=" + isDefault + "]";
	}
	
	
}
