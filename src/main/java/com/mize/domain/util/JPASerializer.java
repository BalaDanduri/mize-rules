package com.mize.domain.util;

import java.io.IOException;


import org.hibernate.collection.internal.PersistentBag;
import org.hibernate.collection.internal.PersistentMap;
import org.hibernate.collection.internal.PersistentSet;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.proxy.HibernateProxy;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JPASerializer extends JsonSerializer<Object> {

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
