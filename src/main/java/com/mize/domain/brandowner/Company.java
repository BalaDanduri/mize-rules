package com.mize.domain.brandowner;

import com.mize.domain.common.Entity;

public class Company extends Entity {
	private int companyId;
	private String companyName;
	private String companyType;

	public Company() {

	}

	public Company(int companyId, String companyName, String companyType) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyType = companyType;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyId;
		result = prime * result
				+ ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result
				+ ((companyType == null) ? 0 : companyType.hashCode());
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
		Company other = (Company) obj;
		if (companyId != other.companyId)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (companyType == null) {
			if (other.companyType != null)
				return false;
		} else if (!companyType.equals(other.companyType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName="
				+ companyName + ", companyType=" + companyType + "]";
	}

}
