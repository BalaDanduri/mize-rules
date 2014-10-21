package com.mize.domain.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
	public static final String DATE_FORMAT = "MM-dd-yyyy";
	public static final String DATE_TIME_FORMAT = "MM-dd-yyyy HH:mm:ss";
	public static final String DATE_FORMAT1 = "dd-MM-yyyy HH:mm:ss";
	public static final String DB_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_AS_LONG = "LONG";
	public static final String PARAM_DATE_TIME_FORMAT = "dateTimeFormat";
	public static final String PARAM_DATE_FORMAT = "dateFormat";
	protected Map<String,String> paramsMap = new HashMap<String,String>();
	protected String dateFormat;
	protected String dateTimeFormat;
	
	

	public MizeObjectMapper() {
		this(DATE_FORMAT,DATE_TIME_FORMAT);
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public DateTimeFormatter getDateTimeFormatter() {
		return DateTimeFormat.forPattern(this.dateTimeFormat);
	}
	
	public DateTimeFormatter getDateFormatter() {
		return DateTimeFormat.forPattern(this.dateFormat);
	}

	public MizeObjectMapper(String dateFormat) {
		new MizeObjectMapper(dateFormat,null);
	}
	
	public MizeObjectMapper(Map<String,String> paramsMap) {
		this.paramsMap = paramsMap;
		if(this.paramsMap != null){
			this.dateFormat = this.paramsMap.get(PARAM_DATE_FORMAT);
			this.dateTimeFormat = this.paramsMap.get(PARAM_DATE_TIME_FORMAT);
		}
		if(this.dateFormat == null){
			this.dateFormat = DATE_FORMAT;
		}
		if(this.dateTimeFormat == null){
			this.dateTimeFormat = DATE_TIME_FORMAT;
		}
		registerModule();
	}
	
	public MizeObjectMapper(String dateFormat, String dateTimeFormat) {
		this.dateFormat = dateFormat;
		this.dateTimeFormat = dateTimeFormat;	
		if(this.dateFormat == null){
			this.dateFormat = DATE_FORMAT;
		}
		if(this.dateTimeFormat == null){
			this.dateTimeFormat = DATE_TIME_FORMAT;
		}
		registerModule();
	}
	
	public void registerModule() {
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);			
		@SuppressWarnings("deprecation")
		SimpleModule module = new SimpleModule("MizeDeserializerModule",new Version(1, 0, 0, null));
		module.addSerializer(MizeDateTime.class, new MizeDateTimeSerializer());
		module.addDeserializer(MizeDateTime.class, new MizeDateTimeDeserializer());	
		//module.addSerializer(MizeDate.class, new MizeDateSerializer());
		//module.addDeserializer(MizeDate.class, new MizeDateDeserializer());	
		registerModule(module);
	}

	
	public class MizeDateTimeDeserializer extends JsonDeserializer<MizeDateTime> {
		@Override
		public MizeDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			JsonToken t = parser.getCurrentToken();
			TimeZone tz = context.getTimeZone();
			DateTimeZone dtz = (tz == null) ? DateTimeZone.UTC : DateTimeZone.forTimeZone(tz);
			if (t == JsonToken.VALUE_NUMBER_INT) {
				return new MizeDateTime(parser.getLongValue(), dtz);
			}
			if (isNotNull(parser.getText())) {
				return new MizeDateTime(parser.getText().trim(),dateTimeFormat);
			} else {
				return null;
			}
		}
	}
	
	public class MizeDateDeserializer extends JsonDeserializer<MizeDate> {
		@Override
		public MizeDate deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			JsonToken t = parser.getCurrentToken();
			TimeZone tz = context.getTimeZone();
			DateTimeZone dtz = (tz == null) ? DateTimeZone.UTC : DateTimeZone.forTimeZone(tz);
			if (t == JsonToken.VALUE_NUMBER_INT) {
				return new MizeDate(parser.getLongValue(), dtz);
			}
			if (isNotNull(parser.getText())) {
				return new MizeDate(parser.getText().trim(),dateFormat);
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
		public DateTime deserialize(JsonParser parser,DeserializationContext context) throws IOException, JsonProcessingException {
			JsonToken t = parser.getCurrentToken();
			TimeZone tz = context.getTimeZone();
			DateTimeZone dtz = (tz == null) ? DateTimeZone.UTC : DateTimeZone.forTimeZone(tz);

			if (t == JsonToken.VALUE_NUMBER_INT) {
				return new DateTime(parser.getLongValue(), dtz);
			}
			if (isNotNull(parser.getText())) {
				return getDateTimeFormatter().parseDateTime(parser.getText().trim());
			} else {
				return null;
			}
		}
	}

	public class MizeDateTimeSerializer extends JsonSerializer<MizeDateTime> {
		@Override
		public void serialize(MizeDateTime mizeDateTime, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
			if(mizeDateTime != null){
				if (dateTimeFormat.equalsIgnoreCase(DATE_AS_LONG)) {
					gen.writeNumber(mizeDateTime.getMillis());
				} else {
					if(mizeDateTime.isValid()){
						gen.writeString(mizeDateTime.toString(dateTimeFormat));
					}else{
						gen.writeString(mizeDateTime.getDateTimeValue());
					}
				}
			}
		}
	}
	
	public class MizeDateSerializer extends JsonSerializer<MizeDate> {
		@Override
		public void serialize(MizeDate mizeDate, JsonGenerator gen, SerializerProvider provider) throws IOException,JsonProcessingException {
			if(mizeDate != null){
				if (dateFormat.equalsIgnoreCase(DATE_AS_LONG)) {
					gen.writeNumber(mizeDate.getMillis());
				} else {
					if(mizeDate.isValid()){
						gen.writeString(mizeDate.toString(dateFormat));
					}else{
						gen.writeString(mizeDate.getDateValue());
					}
				}
			}
		}
	}
	
	public class DateTimeSerializer extends JsonSerializer<DateTime> {
		@Override
		public void serialize(DateTime date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
			if (dateTimeFormat.equalsIgnoreCase(DATE_AS_LONG)) {
				gen.writeNumber(date.getMillis());
			} else {
				gen.writeString(getDateTimeFormatter().print(date));
			}
		}
	}

	public static void main(String[] args) {
		try {
			MizeObjectMapper mapper = new MizeObjectMapper(DATE_FORMAT);
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
