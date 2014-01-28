package com.mize.domain.smooks.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.milyn.javabean.DataDecodeException;

public class SmooksDateDecoder extends org.milyn.javabean.decoders.DateDecoder{

	private static final long serialVersionUID = -2857487602735806071L;
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("MM-dd-yyyy");

	@Override
	public Object decode(String date)throws DataDecodeException{
		DateTime dateTime = null;
		if(date!= null){
			try{
				dateTime = DateTime.parse(date,DATE_FORMAT);
			}catch(Exception e){
			}
		}		
		return dateTime;
	}
}
