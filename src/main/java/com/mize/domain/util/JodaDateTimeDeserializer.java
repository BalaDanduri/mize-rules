package com.mize.domain.util;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaDateTimeDeserializer extends JsonDeserializer<DateTime> {

	private static final DateTimeFormatter  dateFormat = DateTimeFormat.forPattern("MM-dd-yyyy HH:mm:ss");
	public static final DateTimeFormatter  dbdateFormat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public DateTime deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
    	return dateFormat.parseDateTime(parser.getText());
   	}
	

}
