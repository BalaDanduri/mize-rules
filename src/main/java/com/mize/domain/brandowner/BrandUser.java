package com.mize.domain.brandowner;

import com.mize.domain.auth.User;
import com.mize.domain.user.UserProfile;

public class BrandUser extends User{
	
	private static final long serialVersionUID = 371188296131306815L;
	private UserProfile userProfile;
	private Company company;
	private CompanyUrl companyUrl;
	public BrandUser(){}
	
	public BrandUser(UserProfile userProfile, Company company,
			CompanyUrl companyUrl) {
		super();
		this.userProfile = userProfile;
		this.company = company;
		this.companyUrl = companyUrl;
	}
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public CompanyUrl getCompanyUrl() {
		return companyUrl;
	}
	public void setCompanyUrl(CompanyUrl companyUrl) {
		this.companyUrl = companyUrl;
	}
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((companyUrl == null) ? 0 : companyUrl.hashCode());
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
		BrandUser other = (BrandUser) obj;		
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (companyUrl == null) {
			if (other.companyUrl != null)
				return false;
		} else if (!companyUrl.equals(other.companyUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BrandUser [company=" + company + ", companyUrl=" + companyUrl
				+ "]";
	}	
	
	
}
