package com.mize.domain.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.hibernate.collection.PersistentBag;
import org.hibernate.collection.PersistentCollection;
import org.hibernate.collection.PersistentMap;
import org.hibernate.collection.PersistentSet;
import org.hibernate.proxy.HibernateProxy;

public class JPASerializer extends JsonSerializer<Object> {

	@SuppressWarnings("rawtypes")
	@Override
	public void serialize(Object entity, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		if(PersistentCollection.class.isAssignableFrom(entity.getClass())) {
			if (!((PersistentCollection) entity).wasInitialized()) {				
                if(PersistentMap.class.isAssignableFrom(entity.getClass()))  {
                	jgen.writeStartObject();
        			jgen.writeEndObject();
                	return;
                }
                if(PersistentBag.class.isAssignableFrom(entity.getClass()) || PersistentSet.class.isAssignableFrom(entity.getClass()))  {
                	jgen.writeStartArray();
        			jgen.writeEndArray();
                	return;
                }
              
            }else {
    			jgen.writeObject(entity);
    		}
		} else if(entity instanceof HibernateProxy && HibernateProxy.class.isAssignableFrom(entity.getClass())) {
			jgen.writeStartObject();
			jgen.writeEndObject();
            return;
		} else {
			jgen.writeObject(entity);
		}
				
	}

}
