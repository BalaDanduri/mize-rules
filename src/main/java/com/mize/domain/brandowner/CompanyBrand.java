package com.mize.domain.brandowner;

import com.mize.domain.brand.Brand;
import com.mize.domain.common.Entity;

public class CompanyBrand extends Entity {
	
	private static final long serialVersionUID = 5820346684617703353L;
	private Company company;
	private Brand brand;

	public CompanyBrand() {

	}

	public CompanyBrand(Company company, Brand brand) {
		super();
		this.company = company;
		this.brand = brand;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
		result = prime * result + ((company == null) ? 0 : company.hashCode());
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
		CompanyBrand other = (CompanyBrand) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompanyBrand [company=" + company + ", brand=" + brand + "]";
	}

}
