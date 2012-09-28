package com.mize.domain.brand;

import com.mize.domain.common.Entity;

public class Brand extends Entity {
	
	private int brandId;
	private String brandName;
	private String brandLogoLink;
	
	public Brand() {
		
	}
	
	public Brand(int brandId, String brandName, String brandLogoLink) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandLogoLink = brandLogoLink;
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
	public String getBrandLogoLink() {
		return brandLogoLink;
	}
	public void setBrandLogoLink(String brandLogoLink) {
		this.brandLogoLink = brandLogoLink;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brandId;
		result = prime * result
				+ ((brandLogoLink == null) ? 0 : brandLogoLink.hashCode());
		result = prime * result
				+ ((brandName == null) ? 0 : brandName.hashCode());
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
		if (brandLogoLink == null) {
			if (other.brandLogoLink != null)
				return false;
		} else if (!brandLogoLink.equals(other.brandLogoLink))
			return false;
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName
				+ ", brandLogoLink="
				+ brandLogoLink + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
