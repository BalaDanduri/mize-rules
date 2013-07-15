package com.mize.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.NonEmpty;

@Entity
@Table(name = "user_signup")
public class UserSignup extends MizeEntity implements Comparable<UserSignup>{

	private static final long serialVersionUID = 6078249173358032532L;
	
	@NonEmpty(message="companyName.notnull")
	@Size(max = 30)
	private String companyName;
	
	@NonEmpty (message="firstName.notnull")
	@Size(max = 30)
	private String firstName;
	
	@NonEmpty (message="lastName.notnull")
	@Size(max = 30)
	private String lastName;
	
	@NonEmpty (message="email.notnull")
	@Size(max = 50)
	private String email;
	
	@NonEmpty (message="phone.notnull")
	@Range(min=1000000000L, max=9999999999L, message="phone.numeric")
	private String phone;
	
	@NonEmpty (message="website.notnull")
	@Size(max = 100)
	private String website;
	
	@NonEmpty (message="jobRole.notnull")
	@Size(max = 30)
	private String jobRole;
	
	private String comment;
	
	@NonEmpty (message="status.notnull")
	private Integer status;
	
	private Integer validatedBy;

	public UserSignup() {
		
	}
	public UserSignup(String companyName, String firstName, String lastName, String email, String phone,
			String website, String jobRole, String comment, Integer status, Integer validatedBy) {
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.jobRole = jobRole;
		this.comment = comment;
		this.status = status;
		this.validatedBy = validatedBy;
	}

	@Id
	@GenericGenerator(name="Id" , strategy="increment")
	@GeneratedValue(generator="Id")
	@Column(name = "id", unique = true, nullable = false, length = 11)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}

	@Column(name = "first_name", nullable = false, length = 50)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 50)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "job_role", nullable = true, length = 50)
	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	
	@Column(name = "comment", nullable = true, length = 500)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "status", nullable = true, length = 1)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Column(name = "validated_by", nullable = true, length = 20)
	public Integer getValidatedBy() {
		return validatedBy;
	}

	public void setValidatedBy(Integer validatedBy) {
		this.validatedBy = validatedBy;
	}

	@Column(name = "company_name", nullable = true, length = 100)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "email", nullable = true, length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = true, length = 12)	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "website", nullable = true, length = 200)	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	public int compareTo(UserSignup o) {
		return 0;
	}
	

	@Override
	public String toString() {
		return "UserSignup [companyName=" + companyName + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + 
				", website=" + website + ", jobRole=" + jobRole + ", comment=" + comment + ", status=" + status + ", validatedBy=" + validatedBy + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + ((comment == null) ? 0 : comment.hashCode());
		result = PRIME * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = PRIME * result + ((email == null) ? 0 : email.hashCode());
		result = PRIME * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = PRIME * result + ((jobRole == null) ? 0 : jobRole.hashCode());
		result = PRIME * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = PRIME * result + ((phone == null) ? 0 : phone.hashCode());
		result = PRIME * result + ((status == null) ? 0 : status.hashCode());
		result = PRIME * result + ((validatedBy == null) ? 0 : validatedBy.hashCode());
		result = PRIME * result + ((website == null) ? 0 : website.hashCode());
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
		UserSignup other = (UserSignup) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (jobRole == null) {
			if (other.jobRole != null)
				return false;
		} else if (!jobRole.equals(other.jobRole))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (validatedBy == null) {
			if (other.validatedBy != null)
				return false;
		} else if (!validatedBy.equals(other.validatedBy))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}
	
	

}
