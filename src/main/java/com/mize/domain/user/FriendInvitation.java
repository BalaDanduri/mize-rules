package com.mize.domain.user;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class FriendInvitation extends MizeEntity implements Comparable<FriendInvitation>{

	private static final long serialVersionUID = 3657381192795060009L;
	private Long sentFrom ;
	private String sentTo;
	private String channel;
	private String successfulConversion;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime sendDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime successfulConversionDate ;	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getSuccessfulConversion() {
		return successfulConversion;
	}

	public void setSuccessfulConversion(String successfulConversion) {
		this.successfulConversion = successfulConversion;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getSendDate() {
		return sendDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setSendDate(DateTime sendDate) {
		this.sendDate = sendDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getSuccessfulConversionDate() {
		return successfulConversionDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setSuccessfulConversionDate(DateTime successfulConversionDate) {
		this.successfulConversionDate = successfulConversionDate;
	}

	@Override
	public int compareTo(FriendInvitation o) {
		return 0;
	}

	public Long getSentFrom() {
		return sentFrom;
	}

	public void setSentFrom(Long sentFrom) {
		this.sentFrom = sentFrom;
	}

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result
				+ ((sendDate == null) ? 0 : sendDate.hashCode());
		result = prime * result
				+ ((sentFrom == null) ? 0 : sentFrom.hashCode());
		result = prime * result + ((sentTo == null) ? 0 : sentTo.hashCode());
		result = prime
				* result
				+ ((successfulConversion == null) ? 0 : successfulConversion
						.hashCode());
		result = prime
				* result
				+ ((successfulConversionDate == null) ? 0
						: successfulConversionDate.hashCode());
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
		FriendInvitation other = (FriendInvitation) obj;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (sendDate == null) {
			if (other.sendDate != null)
				return false;
		} else if (!sendDate.equals(other.sendDate))
			return false;
		if (sentFrom == null) {
			if (other.sentFrom != null)
				return false;
		} else if (!sentFrom.equals(other.sentFrom))
			return false;
		if (sentTo == null) {
			if (other.sentTo != null)
				return false;
		} else if (!sentTo.equals(other.sentTo))
			return false;
		if (successfulConversion == null) {
			if (other.successfulConversion != null)
				return false;
		} else if (!successfulConversion.equals(other.successfulConversion))
			return false;
		if (successfulConversionDate == null) {
			if (other.successfulConversionDate != null)
				return false;
		} else if (!successfulConversionDate
				.equals(other.successfulConversionDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FriendInvitation [sentFrom=" + sentFrom + ", sentTo=" + sentTo + ", channel=" + channel
				+ ", successfulConversion=" + successfulConversion + ", sendDate=" + sendDate
				+ ", successfulConversionDate=" + successfulConversionDate + "]";
	}

}
