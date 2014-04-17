package com.mize.domain.util;

import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author Rama Battu
 *
 */
@Component
public class JsonDateSerializer extends JsonSerializer<DateTime> {
	
	private static final DateTimeFormatter  dateFormat = DateTimeFormat.forPattern("MM-dd-yyyy");
    @Override
    public void serialize(DateTime date,JsonGenerator gen, SerializerProvider provider) throws IOException,JsonProcessingException {
        gen.writeString(dateFormat.print(date));
    }
}
