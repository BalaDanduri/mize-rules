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
	public static final String DATE_FORMAT = "MM-dd-yyyy";
	public static final String DATE_TIME_FORMAT = "MM-dd-yyyy HH:mm:ss";
	public static final String DATE_FORMAT1 = "dd-MM-yyyy HH:mm:ss";
	public static final String DB_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_AS_LONG = "LONG";
	protected String dateFormat;
	protected String dateTimeFormat;
	protected String timeZone;	
	protected DateTimeZone dateTimeZone;
	protected String userTimeZone;
	protected DateTimeZone userDateTimeZone;
	
	public MizeObjectMapper() {
		this(DATE_FORMAT,DATE_TIME_FORMAT);
	}	
		
	public static MizeObjectMapper getInstance() {
		return new MizeObjectMapper();
	}
	
	public static MizeObjectMapper getInstance(String dateFormat) {
		return new MizeObjectMapper(dateFormat, null, null,null);
	}
	
	public static MizeObjectMapper getInstance(String dateFormat, String dateTimeFormat) {
		return new MizeObjectMapper(dateFormat, dateTimeFormat, null,null);
	}
	
	public static MizeObjectMapper getInstance(MizeDateFormat mizeDateFormat) {
		if(mizeDateFormat != null){
			return new MizeObjectMapper(mizeDateFormat.getDateFormat(),mizeDateFormat.getDateTimeFormat(),mizeDateFormat.getTimeZone(),mizeDateFormat.getUserTimeZone());
		}else{
			return new MizeObjectMapper();
		}
	}
	
	public MizeObjectMapper(String dateFormat, String dateTimeFormat) {
		this(dateFormat, dateTimeFormat, null,null);
	}
	
	public MizeObjectMapper(String dateFormat, String dateTimeFormat,String timeZone,String userTimeZone) {
		this.dateFormat = dateFormat;
		this.dateTimeFormat = dateTimeFormat;	
		if(this.dateFormat == null){
			this.dateFormat = DATE_FORMAT;
		}
		if(this.dateTimeFormat == null){
			this.dateTimeFormat = DATE_TIME_FORMAT;
		}
		this.timeZone = timeZone;
		this.userTimeZone = userTimeZone;
		this.dateTimeZone = getTimeZone();
		this.userDateTimeZone = getUserTimeZone();
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

	private DateTimeZone getTimeZone(){
		DateTimeZone tz = null;
		if(this.timeZone == null || this.timeZone.isEmpty()){
			tz = DateTimeZone.UTC;
		}else{
			tz = DateTimeZone.forID(this.timeZone);			
		}
		tz = (tz == null ? DateTimeZone.UTC : tz);
		return  tz;
	}
	
	private DateTimeZone getUserTimeZone(){
		DateTimeZone tz = null;
		if(this.userTimeZone == null || this.userTimeZone.isEmpty()){
			tz = DateTimeZone.getDefault();
		}else{
			tz = DateTimeZone.forID(this.userTimeZone);			
		}
		return  tz;
	}
	
	public class MizeDateTimeDeserializer extends JsonDeserializer<MizeDateTime> {
		@Override
		public MizeDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			JsonToken t = parser.getCurrentToken();
			if (t == JsonToken.VALUE_NUMBER_INT) {
				return new MizeDateTime(parser.getLongValue(), dateTimeZone);
			}
			if (isNotNull(parser.getText())) {
				return new MizeDateTime(parser.getText().trim(),dateTimeFormat, dateTimeZone, userDateTimeZone);
			} else {
				return null;
			}
		}
	}
	
	public class MizeDateDeserializer extends JsonDeserializer<MizeDate> {
		@Override
		public MizeDate deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			JsonToken t = parser.getCurrentToken();
			if (t == JsonToken.VALUE_NUMBER_INT) {
				return new MizeDate(parser.getLongValue(), dateTimeZone);
			}
			if (isNotNull(parser.getText())) {
				return new MizeDate(parser.getText().trim(),dateFormat, dateTimeZone);
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
			if (t == JsonToken.VALUE_NUMBER_INT) {
				return new DateTime(parser.getLongValue(), dateTimeZone);
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
	
	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	public String getDateFormat() {
		return dateFormat;
	}
	
	private DateTimeFormatter getDateTimeFormatter() {
		return DateTimeFormat.forPattern(this.dateTimeFormat);
	}
	
	public DateTimeFormatter getDateFormatter() {
		return DateTimeFormat.forPattern(this.dateFormat);
	}
}
