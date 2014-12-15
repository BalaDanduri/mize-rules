package com.mize.domain.util;

import java.io.IOException;

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
	public static final String DATE_FORMAT = "MM-dd-yyyy"; // to support my-products application
	public static final String DATE_TIME_FORMAT = "MM-dd-yyyy HH:mm:ss"; // to support my-products application
	private static final String DATE_AS_LONG = "LONG";
	protected String dateFormat;
	protected String dateTimeFormat;
	protected String userTimeZone;
	protected DateTimeZone userDateTimeZone;
	protected DateTimeFormatter dateTimeFormatter;
	
	public MizeObjectMapper() {
		this(DATE_FORMAT,DATE_TIME_FORMAT, null);// to support my-products application -- don't remove arguments
	}	
		
	public static MizeObjectMapper getInstance() {
		return new MizeObjectMapper();
	}
		
	public static MizeObjectMapper getInstance(String dateFormat, String dateTimeFormat) {
		return new MizeObjectMapper(dateFormat, dateTimeFormat, null);
	}
	
	public static MizeObjectMapper getInstance(MizeDateFormat mizeDateFormat) {
		if(mizeDateFormat != null){
			return new MizeObjectMapper(mizeDateFormat.getDateFormat(),mizeDateFormat.getDateTimeFormat(),mizeDateFormat.getUserTimeZone());
		}else{
			return new MizeObjectMapper();
		}
	}
		
	public MizeObjectMapper(String dateFormat, String dateTimeFormat, String userTimeZone) {
		this.dateFormat = dateFormat;
		this.dateTimeFormat = dateTimeFormat;	
		if(this.dateFormat == null){
			this.dateFormat = MizeDateTimeUtils.getDateFormat();
		}
		if(this.dateTimeFormat == null){
			this.dateTimeFormat = MizeDateTimeUtils.getDateTimeFormat();
		}
		this.userTimeZone = userTimeZone;
		this.userDateTimeZone = MizeDateTimeUtils.getUserTimeZone(this.userTimeZone);
		this.dateTimeFormatter = getDateTimeFormatter();
		registerModule();
	}
	
	public void registerModule() {
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);			
		@SuppressWarnings("deprecation")
		SimpleModule module = new SimpleModule("MizeDeserializerModule",new Version(1, 0, 0, null));
		module.addSerializer(MizeDateTime.class, new MizeDateTimeSerializer());
		module.addDeserializer(MizeDateTime.class, new MizeDateTimeDeserializer());	
		module.addSerializer(MizeDate.class, new MizeDateSerializer());
		module.addDeserializer(MizeDate.class, new MizeDateDeserializer());	
		registerModule(module);
	}
	
	public class MizeDateTimeDeserializer extends JsonDeserializer<MizeDateTime> {
		@Override
		public MizeDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			JsonToken t = parser.getCurrentToken();
			if (t == JsonToken.VALUE_NUMBER_INT) {
				return MizeDateTime.getInstance(parser.getLongValue());
			}
			String value = parser.getText();
			if (isNotNull(value)) {
				return MizeDateTime.getInstance(value.trim(),dateTimeFormat, userDateTimeZone);
			} else {
				return null;
			}
		}
	}
	
	public class MizeDateDeserializer extends JsonDeserializer<MizeDate> {
		@Override
		public MizeDate deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			if (parser.getCurrentToken() == JsonToken.VALUE_NUMBER_INT) {
				return MizeDate.getInstance(parser.getLongValue());
			}
			String value = parser.getText();
			if (isNotNull(value)) {
				return MizeDate.getInstance(value.trim(), dateFormat);
			} else {
				return null;
			}
		}
	}
	
	public class DateTimeDeserializer extends JsonDeserializer<DateTime> {
		@Override
		public DateTime deserialize(JsonParser parser,DeserializationContext context) throws IOException, JsonProcessingException {
			if (parser.getCurrentToken() == JsonToken.VALUE_NUMBER_INT) {
				return new DateTime(parser.getLongValue(), DateTimeZone.getDefault());
			}
			if (isNotNull(parser.getText())) {
				return dateTimeFormatter.parseDateTime(parser.getText().trim());
			} else {
				return null;
			}
		}
	}

	public class MizeDateTimeSerializer extends JsonSerializer<MizeDateTime> {
		@Override
		public void serialize(MizeDateTime mizeDateTime, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
			if(mizeDateTime != null){				
				if (DATE_AS_LONG.equalsIgnoreCase(dateTimeFormat)) {
					gen.writeNumber(mizeDateTime.getMillis());
				} else {
					if(mizeDateTime.isValid()){
						gen.writeString(mizeDateTime.toString(dateTimeFormat, userDateTimeZone));
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
				if (DATE_AS_LONG.equalsIgnoreCase(dateFormat)) {
					gen.writeNumber(mizeDate.getMillis());
				} else {
					if(mizeDate.isValid()){
						gen.writeString(mizeDate.toString(dateFormat, null));
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
			if (DATE_AS_LONG.equalsIgnoreCase(dateTimeFormat)) {
				gen.writeNumber(date.getMillis());
			} else {
				gen.writeString(dateTimeFormatter.print(date));
			}
		}
	}
		
	private DateTimeFormatter getDateTimeFormatter() {
		return DateTimeFormat.forPattern(this.dateTimeFormat);
	}
	
	private boolean isNotNull(String val){
		if(val != null && val.trim().length() > 0){
			return true;
		}
		return false;
	}
}
