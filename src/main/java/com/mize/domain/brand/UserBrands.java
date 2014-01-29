package com.mize.domain.brand;

import com.mize.domain.common.MizeEntity;

public class UserBrands extends MizeEntity implements Comparable<UserBrands>{
	
	private static final long serialVersionUID = 3188507890380837744L;
	private Long userId;
	private Brand brand;
	private BrandSupport brandSupport;
	private String favorite;

	public UserBrands() {
		
	}
	

	public UserBrands(long id, long userId, Brand brand,
			BrandSupport brandSupport, String favorite) {
		this.id = id;
		this.userId = userId;
		this.brand = brand;
		this.brandSupport = brandSupport;
		this.favorite = favorite;
	}


	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public BrandSupport getBrandSupport() {
		return brandSupport;
	}


	public void setBrandSupport(BrandSupport brandSupport) {
		this.brandSupport = brandSupport;
	}


	@Override
	public String toString() {
		return "UserBrands [id=" + id + ", userId=" + userId + ", brand="
				+ brand + ", brandSupport=" + brandSupport + ", favorite="
				+ favorite + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((brandSupport == null) ? 0 : brandSupport.hashCode());
		result = prime * result + ((favorite == null) ? 0 : favorite.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserBrands other = (UserBrands) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (brandSupport == null) {
			if (other.brandSupport != null)
				return false;
		} else if (!brandSupport.equals(other.brandSupport))
			return false;
		if (favorite == null) {
			if (other.favorite != null)
				return false;
		} else if (!favorite.equals(other.favorite))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public int compareTo(UserBrands entity) {
		if ( this == entity ) 
			return EQUAL;
		else if (this.id < entity.id) 
			return BEFORE;
		else if (entity.id == this.id) 
			return EQUAL;
		else if (this.id > entity.id)
			return AFTER;
		return EQUAL;
	}
	
}
