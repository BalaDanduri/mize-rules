package com.mize.domain.service.schedule;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

public class ServiceSlot  extends MizeEntity implements Comparable<ServiceSlot>{
	
	private static final long serialVersionUID = 4264889614013460395L;

	@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime date;

	List<TimeSlot> timeSlots;
	@JsonSerialize(using=JsonDateSerializer.class)
	public DateTime getDate() {
		return date;
	}
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setDate(DateTime date) {
		this.date = date;
	}
	
	
	public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}
	public void setTimeSlots(List<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}
	
	@Override
	public String toString() {
		return "ServiceSlot [date=" + date + ", timeSlots= "+ timeSlots + "]";
	}
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public int compareTo(ServiceSlot arg0) {
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((timeSlots == null) ? 0 : timeSlots.hashCode());
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
		ServiceSlot other = (ServiceSlot) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (timeSlots == null) {
			if (other.timeSlots != null)
				return false;
		} else if (!timeSlots.equals(other.timeSlots))
			return false;
		return true;
	}
	
	
}
