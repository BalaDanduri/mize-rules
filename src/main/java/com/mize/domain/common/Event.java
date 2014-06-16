package com.mize.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "event")
public class Event extends MizeEntity implements Comparable<Event>{

	private static final long serialVersionUID = 1166174073700459014L;
	private String code;
	private String eventName;
	private String eventType;
	private String description;
	private String eventStatus;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime startDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime endDate;
	private String active;
	private Integer frequencyValue;
	private Unit frequencyUnit;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime lastEventDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime nextEventDate;
	
	public enum Unit{
		DAYS,WEEKS,MONTHS,YEARS
	}
	
	@Column(name = "code",  nullable = true, length = 20)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "event_name",  nullable = true, length = 100)
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Column(name = "event_type",  nullable = true, length = 20)
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Column(name = "description",  nullable = true, length = 500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "event_status",  nullable = true, length = 500)
	public String getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "start_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getStartDate() {
		return startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "end_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getEndDate() {
		return endDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	@Column(name = "is_active",  nullable = true)
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	public Integer getFrequencyValue() {
		return frequencyValue;
	}

	public void setFrequencyValue(Integer frequencyValue) {
		this.frequencyValue = frequencyValue;
	}

	@Enumerated(EnumType.ORDINAL) 
	public Unit getFrequencyUnit() {
		return frequencyUnit;
	}

	public void setFrequencyUnit(Unit frequencyUnit) {
		this.frequencyUnit = frequencyUnit;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "last_event_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getLastEventDate() {
		return lastEventDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setLastEventDate(DateTime lastEventDate) {
		this.lastEventDate = lastEventDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "next_event_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getNextEventDate() {
		return nextEventDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setNextEventDate(DateTime nextEventDate) {
		this.nextEventDate = nextEventDate;
	}
	
	@JsonIgnore(value=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore(value=false)
	public Long getUpdatedBy() {
		return updatedBy;
	}
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	

	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator="id")
	@Column(name="id",unique=true,nullable=false,length=20)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((eventStatus == null) ? 0 : eventStatus.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((frequencyUnit == null) ? 0 : frequencyUnit.hashCode());
		result = prime * result + ((frequencyValue == null) ? 0 : frequencyValue.hashCode());
		result = prime * result + ((lastEventDate == null) ? 0 : lastEventDate.hashCode());
		result = prime * result + ((nextEventDate == null) ? 0 : nextEventDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Event other = (Event) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (eventStatus == null) {
			if (other.eventStatus != null)
				return false;
		} else if (!eventStatus.equals(other.eventStatus))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (frequencyUnit != other.frequencyUnit)
			return false;
		if (frequencyValue == null) {
			if (other.frequencyValue != null)
				return false;
		} else if (!frequencyValue.equals(other.frequencyValue))
			return false;
		if (lastEventDate == null) {
			if (other.lastEventDate != null)
				return false;
		} else if (!lastEventDate.equals(other.lastEventDate))
			return false;
		if (nextEventDate == null) {
			if (other.nextEventDate != null)
				return false;
		} else if (!nextEventDate.equals(other.nextEventDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Event [code=" + code + ", eventName=" + eventName + ", eventType=" + eventType + ", description="
				+ description + ", eventStatus=" + eventStatus + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", active=" + active + ", frequencyValue=" + frequencyValue + ", frequencyUnit=" + frequencyUnit
				+ ", lastEventDate=" + lastEventDate + ", nextEventDate=" + nextEventDate + "]";
	}

	@Override
	public int compareTo(Event arg0) {
		return 0;
	}
}
