package com.mize.domain.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class NumberFormatSerializer extends org.codehaus.jackson.map.JsonSerializer<Number> {
	private static final String EMPTY = "";

	@Override
	public void serialize(Number number, org.codehaus.jackson.JsonGenerator gen,org.codehaus.jackson.map.SerializerProvider provider) throws IOException,org.codehaus.jackson.JsonProcessingException {
		String val = EMPTY;
		int value = number == null ? 0 : number.intValue();
		if (value > 999) {
			int first_divi = 1000;
			int divident = value / first_divi;
			double remainder = value % first_divi;
			int lowerLimit = 49;
			for (int i = 1; i <= 10; i++) {
				val = divident + "K";
				if (remainder > lowerLimit && !(remainder > (lowerLimit + i * 100))) {
					if (i > 9) {
						val = ++divident + "K";
					} else {
						val = divident + "." + i + "K";
					}
					break;
				}
			}
		} else {
			val = Formatter.intValue(value) + EMPTY;
		}
		gen.writeString(val);
	}
}
