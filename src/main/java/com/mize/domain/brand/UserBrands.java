package com.mize.domain.brand;

import com.mize.domain.common.Entity;

public class UserBrands extends Entity {
	
	private int userId;
	private Brand brand;
	private int brandSupportId;
	private char favorite;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public int getBrandSupportId() {
		return brandSupportId;
	}
	public void setBrandSupportId(int brandSupportId) {
		this.brandSupportId = brandSupportId;
	}
	public char getFavorite() {
		return favorite;
	}
	public void setFavorite(char favorite) {
		this.favorite = favorite;
	}

}
