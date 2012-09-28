package com.mize.domain.util;

import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

/**
 * @author Rama Battu
 *
 */
@Component
public class JsonDateTimeSerializer extends org.codehaus.jackson.map.JsonSerializer<DateTime> {
	
	private static final DateTimeFormatter  dateFormat = DateTimeFormat.forPattern("MM-dd-yyyy HH:mm:ss");
    @Override
    public void serialize(DateTime date, org.codehaus.jackson.JsonGenerator gen, org.codehaus.jackson.map.SerializerProvider provider)
            throws IOException, org.codehaus.jackson.JsonProcessingException {
        gen.writeString(dateFormat.print(date));
    }
}
