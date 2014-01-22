package com.mize.domain.util;

import java.io.IOException;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JodaDateTimeDeserializer extends JsonDeserializer<DateTime> {

	private static final DateTimeFormatter  dateFormat = DateTimeFormat.forPattern("MM-dd-yyyy HH:mm:ss");
	public static final DateTimeFormatter  dbdateTimeFormat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public DateTime deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
    	return dateFormat.parseDateTime(parser.getText());
   	}
	

}
