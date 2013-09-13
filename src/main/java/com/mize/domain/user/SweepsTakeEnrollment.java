package com.mize.domain.user;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class SweepsTakeEnrollment extends MizeEntity implements Comparable<SweepsTakeEnrollment>{

	private static final long serialVersionUID = 3657381192795060009L;
	private Long sweepsTakeId;
	private Long userId;
	private String email;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime enrollmentDate;	
	private String emailValidated;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getSweepsTakeId() {
		return sweepsTakeId;
	}

	public void setSweepsTakeId(Long sweepsTakeId) {
		this.sweepsTakeId = sweepsTakeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getEnrollmentDate() {
		return enrollmentDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEnrollmentDate(DateTime enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	
	public String getEmailValidated() {
		return emailValidated;
	}

	public void setEmailValidated(String emailValidated) {
		this.emailValidated = emailValidated;
	}

	@Override
	public int compareTo(SweepsTakeEnrollment o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((emailValidated == null) ? 0 : emailValidated.hashCode());
		result = prime * result
				+ ((enrollmentDate == null) ? 0 : enrollmentDate.hashCode());
		result = prime * result
				+ ((sweepsTakeId == null) ? 0 : sweepsTakeId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SweepsTakeEnrollment [sweepsTakeId=" + sweepsTakeId
				+ ", userId=" + userId + ", email=" + email
				+ ", enrollmentDate=" + enrollmentDate + ", emailValidated="
				+ emailValidated + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SweepsTakeEnrollment other = (SweepsTakeEnrollment) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailValidated == null) {
			if (other.emailValidated != null)
				return false;
		} else if (!emailValidated.equals(other.emailValidated))
			return false;
		if (enrollmentDate == null) {
			if (other.enrollmentDate != null)
				return false;
		} else if (!enrollmentDate.equals(other.enrollmentDate))
			return false;
		if (sweepsTakeId == null) {
			if (other.sweepsTakeId != null)
				return false;
		} else if (!sweepsTakeId.equals(other.sweepsTakeId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
