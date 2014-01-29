package com.mize.domain.util;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Component
public class DecimalValueDeserializer extends JsonDeserializer<Double> {	
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