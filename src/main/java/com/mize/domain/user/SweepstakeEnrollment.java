package com.mize.domain.user;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class SweepstakeEnrollment extends MizeEntity implements Comparable<SweepstakeEnrollment>{

	private static final long serialVersionUID = 3657381192795060009L;
	private Long sweepstakeId;
	private Long userId;
	private String email;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime enrollmentDate;	
	private String emailValidated;
	private Sweepstake sweepstake;
	private Integer invitationCount;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getSweepstakeId() {
		if (Formatter.longValue(sweepstakeId) == 0) {
			sweepstakeId = Long.valueOf(1);
		}
		return sweepstakeId;}

	public void setSweepstakeId(Long sweepstakeId) {
		this.sweepstakeId = sweepstakeId;
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
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
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
	public int compareTo(SweepstakeEnrollment o) {
		return 0;
	}

	public Sweepstake getSweepstake() {
		return sweepstake;
	}

	public void setSweepstake(Sweepstake sweepstake) {
		this.sweepstake = sweepstake;
	}

	public Integer getInvitationCount() {
		return invitationCount;
	}

	public void setInvitationCount(Integer invitationCount) {
		this.invitationCount = invitationCount;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emailValidated == null) ? 0 : emailValidated.hashCode());
		result = prime * result + ((enrollmentDate == null) ? 0 : enrollmentDate.hashCode());
		result = prime * result + ((invitationCount == null) ? 0 : invitationCount.hashCode());
		result = prime * result + ((sweepstake == null) ? 0 : sweepstake.hashCode());
		result = prime * result + ((sweepstakeId == null) ? 0 : sweepstakeId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SweepstakeEnrollment [sweepstakeId=" + sweepstakeId + ", userId=" + userId + ", email=" + email
				+ ", enrollmentDate=" + enrollmentDate + ", emailValidated=" + emailValidated + ", sweepstake="
				+ sweepstake + ", invitationCount=" + invitationCount + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SweepstakeEnrollment other = (SweepstakeEnrollment) obj;
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
		if (invitationCount == null) {
			if (other.invitationCount != null)
				return false;
		} else if (!invitationCount.equals(other.invitationCount))
			return false;
		if (sweepstake == null) {
			if (other.sweepstake != null)
				return false;
		} else if (!sweepstake.equals(other.sweepstake))
			return false;
		if (sweepstakeId == null) {
			if (other.sweepstakeId != null)
				return false;
		} else if (!sweepstakeId.equals(other.sweepstakeId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
