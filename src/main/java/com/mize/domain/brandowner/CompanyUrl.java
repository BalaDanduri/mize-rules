package com.mize.domain.brandowner;

import com.mize.domain.common.Entity;

public class CompanyUrl extends Entity {
	
	private static final long serialVersionUID = 1959113184391069836L;
	private int companyUrlId;
	private String accessType;
	private int countryId;
	private String url;
	private String urlType;
	private Company company;

	public CompanyUrl() {
	}

	public CompanyUrl(int companyUrlId, String accessType, int countryId,
			String url, String urlType, Company company) {
		super();
		this.companyUrlId = companyUrlId;
		this.accessType = accessType;
		this.countryId = countryId;
		this.url = url;
		this.urlType = urlType;
		this.company = company;
	}

	public int getCompanyUrlId() {
		return companyUrlId;
	}

	public void setCompanyUrlId(int companyUrlId) {
		this.companyUrlId = companyUrlId;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlType() {
		return urlType;
	}

	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accessType == null) ? 0 : accessType.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + companyUrlId;
		result = prime * result + countryId;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((urlType == null) ? 0 : urlType.hashCode());
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
		CompanyUrl other = (CompanyUrl) obj;
		if (accessType == null) {
			if (other.accessType != null)
				return false;
		} else if (!accessType.equals(other.accessType))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (companyUrlId != other.companyUrlId)
			return false;
		if (countryId != other.countryId)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (urlType == null) {
			if (other.urlType != null)
				return false;
		} else if (!urlType.equals(other.urlType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompanyUrl [companyUrlId=" + companyUrlId + ", accessType="
				+ accessType + ", countryId=" + countryId + ", url=" + url
				+ ", urlType=" + urlType + ", company=" + company + "]";
	}

}
