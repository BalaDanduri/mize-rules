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
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.mize.domain.businessentity.BusinessEntity;

public class MizeObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -8050459397871080943L;
	public static final String DATE_FORMAT = "MM-dd-yyyy HH:mm:ss";
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
		JodaModule jodaModule = new JodaModule();
		jodaModule.addSerializer(DateTime.class, new MizeDateTimeSerializer());
		jodaModule.addDeserializer(DateTime.class, new MizeDateTimeDeserializer());
		registerModule(jodaModule);
	}

	public class MizeDateTimeDeserializer extends JsonDeserializer<DateTime> {
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

	public class MizeDateTimeSerializer extends JsonSerializer<DateTime> {
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

			MizeObjectMapper mapper = new MizeObjectMapper();
			BusinessEntity be = new BusinessEntity();
			be.setCreatedDate(DateTime.now());
			be.setId(100l);
			be.setUpdatedDate(DateTime.now());

			System.out.println(mapper.writeValueAsString(be));
			BusinessEntity be2 = mapper.readValue(mapper.writeValueAsString(be).getBytes(), BusinessEntity.class);
			System.out.println(be2.getCreatedDate());
			
			MizeObjectMapper mapper2 = new MizeObjectMapper(MizeObjectMapper.DATE_AS_LONG);

			System.out.println(mapper2.writeValueAsString(be));

			be2 = mapper2.readValue(mapper2.writeValueAsString(be).getBytes(), BusinessEntity.class);
			System.out.println(be2.getCreatedDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
