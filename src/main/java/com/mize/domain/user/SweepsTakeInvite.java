package com.mize.domain.user;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class SweepsTakeInvite extends MizeEntity implements Comparable<SweepsTakeInvite>{

	private static final long serialVersionUID = 3657381192795060009L;
	private String from ;
	private String to;
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
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
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
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getSendDate() {
		return sendDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setSendDate(DateTime sendDate) {
		this.sendDate = sendDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getSuccessfulConversionDate() {
		return successfulConversionDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setSuccessfulConversionDate(DateTime successfulConversionDate) {
		this.successfulConversionDate = successfulConversionDate;
	}

	@Override
	public int compareTo(SweepsTakeInvite o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result
				+ ((sendDate == null) ? 0 : sendDate.hashCode());
		result = prime
				* result
				+ ((successfulConversion == null) ? 0 : successfulConversion
						.hashCode());
		result = prime
				* result
				+ ((successfulConversionDate == null) ? 0
						: successfulConversionDate.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		SweepsTakeInvite other = (SweepsTakeInvite) obj;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (sendDate == null) {
			if (other.sendDate != null)
				return false;
		} else if (!sendDate.equals(other.sendDate))
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
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SweepsTakeInvite [from=" + from + ", to=" + to + ", channel="
				+ channel + ", successfulConversion=" + successfulConversion
				+ ", sendDate=" + sendDate + ", successfulConversionDate="
				+ successfulConversionDate + "]";
	}

}
