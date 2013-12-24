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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((companyUrl == null) ? 0 : companyUrl.hashCode());
		result = prime * result
				+ ((userProfile == null) ? 0 : userProfile.hashCode());
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
		if (active != other.active)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailValidated != other.emailValidated)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
			return false;
		if (linkedAccounts == null) {
			if (other.linkedAccounts != null)
				return false;
		} else if (!linkedAccounts.equals(other.linkedAccounts))
			return false;
		if (userConnects == null) {
			if (other.userConnects != null)
				return false;
		} else if (!userConnects.equals(other.userConnects))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
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
		if (userProfile == null) {
			if (other.userProfile != null)
				return false;
		} else if (!userProfile.equals(other.userProfile))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BrandOwner [id=" + id + ", email=" + email + ", name=" + name
				+ ", lastLogin=" + lastLogin + ", active=" + active
				+ ", emailValidated=" + emailValidated + ", linkedAccounts="
				+ linkedAccounts+ ", userConnects="
						+ userConnects + "userProfile=" + userProfile + ", company="
				+ company + ", companyUrl=" + companyUrl + "]";
	}
	
	
	
	
}
