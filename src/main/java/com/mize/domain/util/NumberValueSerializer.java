package com.mize.domain.util;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class NumberValueSerializer extends JsonSerializer<Number> {
	@Override
	public void serialize(Number value, JsonGenerator gen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		NumberFormat formatter = NumberFormat.getNumberInstance(Locale.getDefault());
		formatter.setMaximumFractionDigits(2);
		formatter.setMinimumFractionDigits(2);
		gen.writeString(formatter.format(value));
	}
}
