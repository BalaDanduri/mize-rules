package com.mize.domain.util;

import java.io.IOException;
import java.text.DecimalFormat;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.springframework.stereotype.Component;

/**
 * @author Rama Battu
 *
 */
@Component
public class DecimalValueSerializer extends org.codehaus.jackson.map.JsonSerializer<Double> {    
	private static final DecimalFormat formatter = new DecimalFormat("#.##");
	
	public void serialize(Double value, JsonGenerator gen,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		gen.writeNumber(Double.valueOf(formatter.format(value)));
	}
}
