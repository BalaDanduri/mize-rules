package com.mize.domain.util;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.springframework.stereotype.Component;

@Component
public class DecimalValueDeserializer extends org.codehaus.jackson.map.JsonDeserializer<Double> {	
	@Override
	public Double deserialize(JsonParser parser, DeserializationContext context)throws IOException, JsonProcessingException {
		NumberFormat formatter = NumberFormat.getNumberInstance(Locale.getDefault());
		formatter.setMaximumFractionDigits(2);
		formatter.setMinimumFractionDigits(2);
		Double double1 = null;
		try {
			Number number = formatter.parse(parser.getText());
			double1 = number.doubleValue();
		} catch (Exception e) {
		}
		return double1;
	}	
}