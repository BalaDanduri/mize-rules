package com.mize.domain.user;

import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

public class FriendInvitation extends MizeSceEntity implements Comparable<FriendInvitation>{

	private static final long serialVersionUID = 3657381192795060009L;
	private Long sentFrom ;
	private String sentTo;
	private String channel;
	private String successfulConversion;
	private MizeDateTime sendDate;
	private MizeDateTime successfulConversionDate ;	

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
	public MizeDateTime getSendDate() {
		return sendDate;
	}

	public void setSendDate(MizeDateTime sendDate) {
		this.sendDate = sendDate;
	}

	public MizeDateTime getSuccessfulConversionDate() {
		return successfulConversionDate;
	}

	public void setSuccessfulConversionDate(MizeDateTime successfulConversionDate) {
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
