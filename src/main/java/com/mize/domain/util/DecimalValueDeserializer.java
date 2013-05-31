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
	private static final NumberFormat formatter = NumberFormat.getNumberInstance(Locale.getDefault());
	static  {	
		formatter.setMaximumFractionDigits(2);
		formatter.setMinimumFractionDigits(2);
	}
	public Double deserialize(JsonParser parser, DeserializationContext context)throws IOException, JsonProcessingException {
		Double double1 = null;
		try {
			Number number = formatter.parse(parser.getText());
			double1 = number.doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return double1;
	}	
}