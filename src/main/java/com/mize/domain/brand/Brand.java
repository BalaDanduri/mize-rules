package com.mize.domain.brand;

import com.mize.domain.common.Entity;

public class Brand extends Entity {
	
	private int brandId;
	private String brandName;
	private String website;
	private String logoName;
	
	public Brand() {
		
	}
	
	public Brand(int brandId, String brandName, String website) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.website = website;
	}

	public Brand(int brandId, String brandName, String website, String logoName) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.website = website;
		this.logoName = logoName;
	}
	
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brandId;
		result = prime * result
				+ ((website == null) ? 0 : website.hashCode());
		result = prime * result
				+ ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result
				+ ((logoName == null) ? 0 : logoName.hashCode());
		
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
		Brand other = (Brand) obj;
		if (brandId != other.brandId)
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
			return false;
		if (logoName == null) {
			if (other.logoName != null)
				return false;
		} else if (!logoName.equals(other.logoName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName
				+ ", brandLogoLink="
				+ website + ", logoName=" + logoName + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}
}
