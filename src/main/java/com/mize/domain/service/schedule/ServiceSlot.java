package com.mize.domain.service.schedule;

import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.DateTime;

public class ServiceSlot  extends MizeSceEntity implements Comparable<ServiceSlot>{
	
	private static final long serialVersionUID = 4264889614013460395L;

	//@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime date;
	
	private String startTime;
	
	private String endTime;
	
	//@JsonSerialize(using=JsonDateSerializer.class)
	public DateTime getDate() {
		return date;
	}
	//@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setDate(DateTime date) {
		this.date = date;
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "ServiceSlot [date=" + date + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
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
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	
}
