package com.mize.domain.util;

import java.io.IOException;
import java.text.DecimalFormat;

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
public class DecimalValueSerializer extends JsonSerializer<Double> {    
	private static final DecimalFormat formatter = new DecimalFormat("#.##");
	
	public void serialize(Double value, JsonGenerator gen,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		gen.writeNumber(Double.valueOf(formatter.format(value)));
	}
}
