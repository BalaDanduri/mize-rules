package com.mize.domain.user;

import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeSceEntity;

public class Division extends MizeSceEntity implements Comparable<Division>{

	private static final long serialVersionUID = -5870162404398103231L;
	private String name;
	private Organization organization;
	private Account account;
	private Brand brand;
	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Division [name=" + name + ", organization=" + organization + ", account=" + account + ", brand=" + brand + ", id=" + id + "]";
	}
	
	public int compareTo(Division division) {
		if ( this == division ) 
			return EQUAL;
		else if (this.id < division.id) 
			return BEFORE;
		else if (division.id == this.id) 
			return EQUAL;
		else if (this.id > division.id)
			return AFTER;
		return EQUAL;		
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
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
		Division other = (Division) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
