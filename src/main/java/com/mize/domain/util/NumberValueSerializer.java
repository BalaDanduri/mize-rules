package com.mize.domain.util;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class NumberValueSerializer extends org.codehaus.jackson.map.JsonSerializer<Number> {
	@Override
	public void serialize(Number value, org.codehaus.jackson.JsonGenerator gen, org.codehaus.jackson.map.SerializerProvider provider)
			throws IOException, org.codehaus.jackson.JsonProcessingException {
		NumberFormat formatter = NumberFormat.getNumberInstance(Locale.getDefault());
		formatter.setMaximumFractionDigits(2);
		formatter.setMinimumFractionDigits(2);
		gen.writeString(formatter.format(value));
	}
}
