package com.mize.domain.brandowner;

import com.mize.domain.auth.User;
import com.mize.domain.user.UserProfile;

public class BrandUser extends User{
	
	private UserProfile userProfile;
	private Company company;
	private CompanyUrl companyUrl;
	public String email;
	public String password;
	public BrandUser()
	{
		
	}
	public BrandUser(UserProfile userProfile, Company company,
			CompanyUrl companyUrl, String email, String password) {
		super();
		this.userProfile = userProfile;
		this.company = company;
		this.companyUrl = companyUrl;
		this.email = email;
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((companyUrl == null) ? 0 : companyUrl.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		return "BrandOwner [userProfile=" + userProfile + ", company="
				+ company + ", companyUrl=" + companyUrl + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	
}
