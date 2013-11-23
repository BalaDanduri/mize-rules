package com.mize.domain.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
	public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		if(HibernateProxy.class.isAssignableFrom(value.getClass())) {
			 if (((HibernateProxy) value).getHibernateLazyInitializer().isUninitialized()) {
	             jgen.writeNull();
	             return;
	         }
		} else if(PersistentCollection.class.isAssignableFrom(value.getClass())) {
			if (!((PersistentCollection) value).wasInitialized()) {				
                if(PersistentMap.class.isAssignableFrom(value.getClass()))  {
                	jgen.writeObject(new HashMap());
                	return;
                }
                if(PersistentBag.class.isAssignableFrom(value.getClass()))  {
                	jgen.writeObject(new ArrayList());
                	return;
                }
                if(PersistentSet.class.isAssignableFrom(value.getClass()))  {
                	jgen.writeObject(new HashSet());
                	return;
                }
                
            }
		}		
				
	}

}
