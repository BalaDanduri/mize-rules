package com.mize.domain.util;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class JodaDateDeserializer extends JsonDeserializer<DateTime> {

	public static final DateTimeFormatter  dateFormat = DateTimeFormat.forPattern("MM-dd-yyyy");
	public static final DateTimeFormatter  dbdateFormat = DateTimeFormat.forPattern("yyyy-MM-dd");
    @Override
    public DateTime deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
    	String tst = parser.getText();
    	DateTime dateTime;
    
    	dateTime = dateFormat.parseDateTime(tst);
    	
        return dateTime;
    }
}