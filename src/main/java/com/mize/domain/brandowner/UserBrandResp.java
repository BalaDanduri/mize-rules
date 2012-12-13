package com.mize.domain.brandowner;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;
import com.mize.domain.brand.Brand;

public class UserBrandResp extends Entity {

	private User user;
	private Brand brand;

	public UserBrandResp() {

	}

	public UserBrandResp(User user, Brand brand) {
		super();
		this.user = user;
		this.brand = brand;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBrandResp other = (UserBrandResp) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
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
		return "UserBrandResp [user=" + user + ", brand=" + brand + "]";
	}

}
