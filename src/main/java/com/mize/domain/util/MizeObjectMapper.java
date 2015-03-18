package com.mize.domain.util;

import java.io.IOException;
import java.text.DecimalFormat;

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
import com.mize.domain.applicationformat.ApplicationFormatCache;
import com.mize.domain.common.BigDecimal;
import com.mize.domain.datetime.Date;

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
	protected DecimalFormat decimalFormatter;
	protected String decimalFormat;
	
	public MizeObjectMapper() {
		this(DATE_FORMAT,DATE_TIME_FORMAT, null);// to support my-products application -- don't remove arguments
	}	
		
	public static MizeObjectMapper getInstance() {
		return new MizeObjectMapper();
	}
		
	public static MizeObjectMapper getInstance(String dateFormat, String dateTimeFormat) {
		return new MizeObjectMapper(dateFormat, dateTimeFormat, null);
	}
	
	public static MizeObjectMapper getInstance(ApplicationFormatCache formatCache) {
		return getInstance(formatCache, null);
	}
	
	public static MizeObjectMapper getInstance(ApplicationFormatCache formatCache,String userTimeZone) {
		if(formatCache != null){
			String dateTimeFormat = formatCache.getUserDateTimeFormat();
			String dateFormat = formatCache.getUserDateFormat();
			String decimalFormat = formatCache.getUserDecimalFormat();
			return new MizeObjectMapper(dateFormat,dateTimeFormat,userTimeZone,decimalFormat);
		}else{
			return new MizeObjectMapper();
		}
	}
	
	public MizeObjectMapper(String dateFormat, String dateTimeFormat, String userTimeZone, String decimalFormat) {
		this.dateFormat = dateFormat;
		this.dateTimeFormat = dateTimeFormat;
		this.decimalFormat = decimalFormat;
		if(this.dateFormat == null){
			this.dateFormat = DateTimeUtils.getDateFormat();
		}
		if(this.dateTimeFormat == null){
			this.dateTimeFormat =DateTimeUtils.getDateTimeFormat();
		}
		if(this.decimalFormat == null){
			this.decimalFormat = "#,##,##,###.00";
		}
		
		this.userTimeZone = userTimeZone;
		this.userDateTimeZone = DateTimeUtils.getUserTimeZone(this.userTimeZone);
		this.dateTimeFormatter = getDateTimeFormatter();
		this.decimalFormatter = getDecimalFormatter();
		registerModule();
	}
	
	public MizeObjectMapper(String dateFormat, String dateTimeFormat, String userTimeZone) {
		this(dateFormat, dateTimeFormat, userTimeZone, null);
	}
	
	public void registerModule() {
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);			
		@SuppressWarnings("deprecation")
		SimpleModule module = new SimpleModule("MizeDeserializerModule",new Version(1, 0, 0, null));
		module.addSerializer(com.mize.domain.datetime.DateTime.class, new MizeDateTimeSerializer());
		module.addDeserializer(com.mize.domain.datetime.DateTime.class, new MizeDateTimeDeserializer());	
		module.addSerializer(Date.class, new MizeDateSerializer());
		module.addDeserializer(Date.class, new MizeDateDeserializer());
		
		module.addSerializer(com.mize.domain.datetime.DateTime.class, new DateTimeNewSerializer());
		module.addDeserializer(com.mize.domain.datetime.DateTime.class, new DateTimeNewDeserializer());	
		
		module.addSerializer(Date.class, new DateSerializer());
		module.addDeserializer(Date.class, new DateDeserializer());	
		
		module.addSerializer(BigDecimal.class, new BigDecimalSerializer());
		module.addDeserializer(BigDecimal.class, new BigDecimalDeserializer());
		
		registerModule(module);
	}
	
	public class MizeDateTimeDeserializer extends JsonDeserializer<com.mize.domain.datetime.DateTime> {
		@Override
		public com.mize.domain.datetime.DateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			JsonToken t = parser.getCurrentToken();
			if (t == JsonToken.VALUE_NUMBER_INT) {
				return com.mize.domain.datetime.DateTime.getInstance(parser.getLongValue());
			}
			String value = parser.getText();
			if (isNotNull(value)) {
				return com.mize.domain.datetime.DateTime.getInstance(value.trim(),dateTimeFormat, userDateTimeZone);
			} else {
				return null;
			}
		}
	}
	
	public class MizeDateDeserializer extends JsonDeserializer<Date> {
		@Override
		public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			if (parser.getCurrentToken() == JsonToken.VALUE_NUMBER_INT) {
				return Date.getInstance(parser.getLongValue());
			}
			String value = parser.getText();
			if (isNotNull(value)) {
				return Date.getInstance(value.trim(), dateFormat);
			} else {
				return null;
			}
		}
	}
	
	@Deprecated
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

	public class MizeDateTimeSerializer extends JsonSerializer<com.mize.domain.datetime.DateTime> {
		@Override
		public void serialize(com.mize.domain.datetime.DateTime mizeDateTime, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
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
	
	public class MizeDateSerializer extends JsonSerializer<Date> {
		@Override
		public void serialize(Date mizeDate, JsonGenerator gen, SerializerProvider provider) throws IOException,JsonProcessingException {
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
	
	@Deprecated
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
	
	public class DateTimeNewDeserializer extends JsonDeserializer<com.mize.domain.datetime.DateTime> {
		@Override
		public com.mize.domain.datetime.DateTime deserialize(JsonParser parser,DeserializationContext context) throws IOException, JsonProcessingException {
			JsonToken t = parser.getCurrentToken();
			if (t == JsonToken.VALUE_NUMBER_INT) {
				return com.mize.domain.datetime.DateTime.getInstance(parser.getLongValue());
			}
			String value = parser.getText();
			if (isNotNull(value)) {
				return com.mize.domain.datetime.DateTime.getInstance(value.trim(),dateTimeFormat, userDateTimeZone);
			} else {
				return null;
			}
		}
	}
	
	public class DateTimeNewSerializer extends JsonSerializer<com.mize.domain.datetime.DateTime> {
		@Override
		public void serialize(com.mize.domain.datetime.DateTime dateTime, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
			if(dateTime != null){				
				if (DATE_AS_LONG.equalsIgnoreCase(dateTimeFormat)) {
					gen.writeNumber(dateTime.getMillis());
				} else {
					if(dateTime.isValid()){
						gen.writeString(dateTime.toString(dateTimeFormat, userDateTimeZone));
					}else{
						gen.writeString(dateTime.getDateTimeValue());
					}
				}
			}
		}
	}
	
	public class DateSerializer extends JsonSerializer<Date> {
		@Override
		public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
			if(date != null){
				if (DATE_AS_LONG.equalsIgnoreCase(dateFormat)) {
					gen.writeNumber(date.getMillis());
				} else {
					if(date.isValid()){
						gen.writeString(date.toString(dateFormat, null));
					}else{
						gen.writeString(date.getDateValue());
					}
				}
			}
		}
	}
	
	public class DateDeserializer extends JsonDeserializer<Date> {
		@Override
		public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			if (parser.getCurrentToken() == JsonToken.VALUE_NUMBER_INT) {
				return Date.getInstance(parser.getLongValue());
			}
			String value = parser.getText();
			if (isNotNull(value)) {
				return Date.getInstance(value.trim(), dateFormat);
			} else {
				return null;
			}
		}
	}
	
	public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {
		@Override
		public void serialize(BigDecimal bigDecimal, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
			if(bigDecimal != null){
				if(bigDecimal.isValid()){
					gen.writeString(bigDecimal.toString(decimalFormatter));
				}else{
					gen.writeString(bigDecimal.getDecimalValue());
				}
			}
		}
	}
	
	public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {
		@Override
		public BigDecimal deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			String value = parser.getText();
			if (isNotNull(value)) {
				return BigDecimal.getInstance(value.trim(), decimalFormat, decimalFormatter);
			} else {
				return null;
			}
		}
	}
		
	private DateTimeFormatter getDateTimeFormatter() {
		return DateTimeFormat.forPattern(this.dateTimeFormat);
	}
	
	private DecimalFormat getDecimalFormatter() {
		return new DecimalFormat(this.decimalFormat);
	}
	
	private boolean isNotNull(String val){
		if(val != null && val.trim().length() > 0){
			return true;
		}
		return false;
	}
}
