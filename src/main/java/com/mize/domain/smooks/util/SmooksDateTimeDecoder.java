package com.mize.domain.smooks.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.milyn.javabean.DataDecodeException;

public class SmooksDateTimeDecoder extends org.milyn.javabean.decoders.DateDecoder{

	private static final long serialVersionUID = -2857487602735806071L;
	public static final DateTimeFormatter  DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public Object decode(String date)throws DataDecodeException{
		DateTime dateTime = null;
		if(date!= null){
			try{
				dateTime = DateTime.parse(date,DATE_TIME_FORMAT);
			}catch(Exception e){
			}
		}		
		return dateTime;
	}
}
