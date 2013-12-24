package com.mize.domain.util;

import java.io.Serializable;
import java.util.Calendar;

public class LogMetrics implements Serializable{
	private static final long serialVersionUID = -4682972504716094968L;
	private long startTime;
	private LogMetrics(){
		
	}
	public void start(){
		startTime = Calendar.getInstance().getTimeInMillis();
	}
	public void clear(){
		startTime = 0;
	}
	public long getTime(){
		return (Calendar.getInstance().getTimeInMillis() - startTime);
	}
	public static LogMetrics getInstance(){
		LogMetrics logMetrics = new LogMetrics();
		logMetrics.startTime = Calendar.getInstance().getTimeInMillis();
		return logMetrics;
	}
}
