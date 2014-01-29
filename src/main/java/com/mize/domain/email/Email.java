package com.mize.domain.email;

public class Email {
	
	private int id;
	private String emailType;
	private int userId;
	private String emailFrom;
	private String emailTo;
	private String emailCC;
	private String subject;
	private String content;
	
	public Email(int id, String emailType, int userId, String emailFrom,
			String emailTo, String emailCC, String subject, String content) {
		super();
		this.id = id;
		this.emailType = emailType;
		this.userId = userId;
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.emailCC = emailCC;
		this.subject = subject;
		this.content = content;
	}
	public Email() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getEmailCC() {
		return emailCC;
	}
	public void setEmailCC(String emailCC) {
		this.emailCC = emailCC;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Email [id=" + id + ", emailType=" + emailType + ", userId="
				+ userId + ", emailFrom=" + emailFrom + ", emailTo=" + emailTo
				+ ", emailCC=" + emailCC + ", subject=" + subject
				+ ", content=" + content + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((emailCC == null) ? 0 : emailCC.hashCode());
		result = prime * result
				+ ((emailFrom == null) ? 0 : emailFrom.hashCode());
		result = prime * result + ((emailTo == null) ? 0 : emailTo.hashCode());
		result = prime * result
				+ ((emailType == null) ? 0 : emailType.hashCode());
		result = prime * result + id;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + userId;
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
		Email other = (Email) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (emailCC == null) {
			if (other.emailCC != null)
				return false;
		} else if (!emailCC.equals(other.emailCC))
			return false;
		if (emailFrom == null) {
			if (other.emailFrom != null)
				return false;
		} else if (!emailFrom.equals(other.emailFrom))
			return false;
		if (emailTo == null) {
			if (other.emailTo != null)
				return false;
		} else if (!emailTo.equals(other.emailTo))
			return false;
		if (emailType == null) {
			if (other.emailType != null)
				return false;
		} else if (!emailType.equals(other.emailType))
			return false;
		if (id != other.id)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}	

}
