package com.mize.domain.util;

import java.io.IOException;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MizeObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -8050459397871080943L;
	public static final String DATE_FORMAT = "MM-dd-yyyy HH:mm:ss";
	public static final String DATE_FORMAT1 = "dd-MM-yyyy HH:mm:ss";
	public static final String DB_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_AS_LONG = "LONG";

	String dateFormat = DATE_FORMAT;
	DateTimeFormatter dateTimeFormatter;

	public MizeObjectMapper() {
		this(DATE_FORMAT);
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public DateTimeFormatter getDateTimeFormatter() {
		if (dateTimeFormatter == null) {
			dateTimeFormatter = DateTimeFormat.forPattern(this.dateFormat);
		}
		
		return dateTimeFormatter;
	}

	public MizeObjectMapper(String dateFormat) {
		this.dateFormat = dateFormat;
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);			
		@SuppressWarnings("deprecation")
		SimpleModule module = new SimpleModule("MizeDeserializerModule",new Version(1, 0, 0, null));
		module.addSerializer(MizeDateTime.class, new MizeDateTimeSerializer());
		module.addDeserializer(MizeDateTime.class, new MizeDateTimeDeserializer());				
		registerModule(module);
	}

	
	public class MizeDateTimeDeserializer extends JsonDeserializer<MizeDateTime> {
		@Override
		public MizeDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException,
		JsonProcessingException {
			JsonToken t = parser.getCurrentToken();
			TimeZone tz = context.getTimeZone();
			DateTimeZone dtz = (tz == null) ? DateTimeZone.UTC : DateTimeZone.forTimeZone(tz);

			if (t == JsonToken.VALUE_NUMBER_INT) {
				return new MizeDateTime(parser.getLongValue(), dtz);
			}
			if (isNotNull(parser.getText())) {
				return new MizeDateTime(parser.getText().trim(),dateFormat);
			} else {
				return null;
			}
		}
	}
	
	private boolean isNotNull(String val){
		if(val != null && val.trim().length() > 0){
			return true;
		}
		return false;
	}
	
	public class DateTimeDeserializer extends JsonDeserializer<DateTime> {
		@Override
		public DateTime deserialize(JsonParser parser,
				DeserializationContext context) throws IOException,
				JsonProcessingException {
			JsonToken t = parser.getCurrentToken();
			TimeZone tz = context.getTimeZone();
			DateTimeZone dtz = (tz == null) ? DateTimeZone.UTC : DateTimeZone.forTimeZone(tz);
			
			if (t == JsonToken.VALUE_NUMBER_INT) {
				return new DateTime(parser.getLongValue(), dtz);
			}
			if (parser.getText() != null
					&& parser.getText().trim().length() > 0) {
				return getDateTimeFormatter().parseDateTime(parser.getText());
			} else {
				return null;
			}
		}
	}

	public class MizeDateTimeSerializer extends JsonSerializer<MizeDateTime> {
		@Override
		public void serialize(MizeDateTime mizeDateTime, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
			if (dateFormat.equalsIgnoreCase(DATE_AS_LONG)) {
				gen.writeNumber(mizeDateTime.getMillis());
			} else {
				gen.writeString(mizeDateTime.toString(dateFormat));
			}
		}
	}

	
	public class DateTimeSerializer extends JsonSerializer<DateTime> {
		@Override
		public void serialize(DateTime date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
			if (dateFormat.equalsIgnoreCase(DATE_AS_LONG)) {
				gen.writeNumber(date.getMillis());
			} else {
				gen.writeString(getDateTimeFormatter().print(date));
			}
		}
	}

	public static void main(String[] args) {
		try {
			MizeObjectMapper mapper = new MizeObjectMapper(DATE_FORMAT1);
			Employee emp = new Employee();
			emp.setCreatedDate(MizeDateTime.now());
			emp.setId(100l);
			emp.setName("bala");
			System.out.println(mapper.writeValueAsString(emp));
			Employee e = mapper.readValue(mapper.writeValueAsString(emp), Employee.class);
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
