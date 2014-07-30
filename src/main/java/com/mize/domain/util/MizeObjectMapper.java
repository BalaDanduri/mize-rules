package com.mize.domain.util;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class MizeObjectMapper extends ObjectMapper {
	
	private static final long serialVersionUID = -8050459397871080943L;
	public static String DATE_FORMAT = "MM-dd-yyyy HH:mm:ss";
	public static String DB_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/*public static final DATE_FORMAT = DateTimeFormat.forPattern("MM-dd-yyyy HH:mm:ss");
	public static final DATE_FORMAT1 = DateTimeFormat.forPattern("MM-dd-yyyy");
	public static final DATE_FORMAT3 = DateTimeFormat.forPattern("MM/dd/yyyy");
	public static final DB_DATE_TIME_FORMAT = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	public static final DateTimeFormatter  DATE_FORMAT2 = DateTimeFormat.forPattern("yyyy-MM-dd");*/
	
	String timeZone;
	String dateFormatt;
	DateTimeFormatter dateTimeFormatter;
	public MizeObjectMapper(){
		this(null,null);		
	}
	public MizeObjectMapper(String dateFormatt) {
		this(dateFormatt,null);
    }
	
	public MizeObjectMapper(String dateFormatt,String timeZone) {
        super();
        this.dateFormatt = dateFormatt;
        this.timeZone = timeZone;
        if(dateFormatt == null){
        	this.dateFormatt = 	DATE_FORMAT;
        }
        dateTimeFormatter = DateTimeFormat.forPattern(this.dateFormatt);
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        JodaModule jodaModule = new JodaModule();
        jodaModule.addSerializer(DateTime.class, new JsonDateTimeSerializer());
        jodaModule.addDeserializer(DateTime.class, new JodaDateTimeDeserializer());
        registerModule(jodaModule);        
    }
	
	public class JodaDateTimeDeserializer extends JsonDeserializer<DateTime> {
		@Override
		public DateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
			if(parser.getText() != null && parser.getText().trim().length() > 0){
				return dateTimeFormatter.parseDateTime(parser.getText());
			}else{
				return null;
			}
		}
	}
	
	public class JodaDateDeserializer extends JsonDeserializer<DateTime> {
	    public DateTime deserialize(JsonParser parser, DeserializationContext context)  throws IOException, JsonProcessingException {
	    	String tst = parser.getText();
	    	if(parser.getText() != null && parser.getText().trim().length() > 0){
	    		return dateTimeFormatter.parseDateTime(tst);
	    	}else{
	    		return null;
	    	}
	    }
	}
	
	public class JsonDateTimeSerializer extends JsonSerializer<DateTime> {		
	    @Override
	    public void serialize(DateTime date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
	        gen.writeString(dateTimeFormatter.print(date));
	    }
	}
	
	public class JsonDateSerializer extends JsonSerializer<DateTime> {		
	    @Override
	    public void serialize(DateTime date,JsonGenerator gen, SerializerProvider provider) throws IOException,JsonProcessingException {
	        gen.writeString(dateTimeFormatter.print(date));
	    }
	}
	
	public static void main(String[] args) {
		 try{
			 MizeObjectMapper mapper = new MizeObjectMapper();
			 Employee emp = new Employee();
			 emp.setCreatedDate(DateTime.now());
			 emp.setId(100l);
			 emp.setName("bala");
			 System.out.println(mapper.writeValueAsString(emp));
			 mapper = new MizeObjectMapper(MizeObjectMapper.DB_DATE_TIME_FORMAT);
			 System.out.println(mapper.writeValueAsString(emp));
		 }catch(Exception e){
			e.printStackTrace();
		}
	}
}
