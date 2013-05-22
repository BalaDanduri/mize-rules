package com.mize.domain.util;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.stereotype.Component;

@Component
public class NumberValueDeserializer extends org.codehaus.jackson.map.JsonDeserializer<Number> {	
	@Override
	public Number deserialize(JsonParser parser, DeserializationContext context)throws IOException, JsonProcessingException {
		NumberFormat formatter = NumberFormat.getNumberInstance(Locale.getDefault());
		formatter.setMaximumFractionDigits(2);
		formatter.setMinimumFractionDigits(2);
		Number number = null;
		try {
			number = formatter.parse(parser.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}
	
}
