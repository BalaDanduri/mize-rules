package com.mize.domain.service.schedule;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class ServiceSlot {
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime date;

	String startTime;
	String endTime;
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
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
		return "ServiceSlot [date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}
