package com.mize.domain.brandowner;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class CompanyUser extends Entity {
	
	private static final long serialVersionUID = 3037663684148720786L;
	private User user;
	private Company company;
	private boolean isValidated;
	private String validatedBy;
	private DateTime validatedDate;
	private String internalComments;

	public CompanyUser() {
	}

	public CompanyUser(User user, Company company, boolean isValidated,
			String validatedBy, DateTime validatedDate, String internalComments) {
		super();
		this.user = user;
		this.company = company;
		this.isValidated = isValidated;
		this.validatedBy = validatedBy;
		this.validatedDate = validatedDate;
		this.internalComments = internalComments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}

	public String getValidatedBy() {
		return validatedBy;
	}

	public void setValidatedBy(String validatedBy) {
		this.validatedBy = validatedBy;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public DateTime getValidatedDate() {
		return validatedDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	public void setValidatedDate(DateTime validatedDate) {
		this.validatedDate = validatedDate;
	}

	public String getInternalComments() {
		return internalComments;
	}

	public void setInternalComments(String internalComments) {
		this.internalComments = internalComments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime
				* result
				+ ((internalComments == null) ? 0 : internalComments.hashCode());
		result = prime * result + (isValidated ? 1231 : 1237);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((validatedBy == null) ? 0 : validatedBy.hashCode());
		result = prime * result
				+ ((validatedDate == null) ? 0 : validatedDate.hashCode());
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
		CompanyUser other = (CompanyUser) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (internalComments == null) {
			if (other.internalComments != null)
				return false;
		} else if (!internalComments.equals(other.internalComments))
			return false;
		if (isValidated != other.isValidated)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (validatedBy == null) {
			if (other.validatedBy != null)
				return false;
		} else if (!validatedBy.equals(other.validatedBy))
			return false;
		if (validatedDate == null) {
			if (other.validatedDate != null)
				return false;
		} else if (!validatedDate.equals(other.validatedDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompanyUser [user=" + user + ", company=" + company
				+ ", isValidated=" + isValidated + ", validatedBy="
				+ validatedBy + ", validatedDate=" + validatedDate
				+ ", internalComments=" + internalComments + "]";
	}

}
