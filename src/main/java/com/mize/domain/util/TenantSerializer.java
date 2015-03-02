package com.mize.domain.util;

import java.io.IOException;

import org.hibernate.collection.internal.PersistentBag;
import org.hibernate.collection.internal.PersistentMap;
import org.hibernate.collection.internal.PersistentSet;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.proxy.HibernateProxy;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mize.domain.businessentity.BusinessEntity;

public class TenantSerializer extends JsonSerializer<BusinessEntity> {
    @Override
    public void serialize(BusinessEntity tenant, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
    	
    		if(PersistentCollection.class.isAssignableFrom(tenant.getClass())) {
    			if (!((PersistentCollection) tenant).wasInitialized()) {				
                    if(PersistentMap.class.isAssignableFrom(tenant.getClass()))  {
                    	jgen.writeStartObject();
            			jgen.writeEndObject();
                    	return;
                    }
                    if(PersistentBag.class.isAssignableFrom(tenant.getClass()) || PersistentSet.class.isAssignableFrom(tenant.getClass()))  {
                    	jgen.writeStartArray();
            			jgen.writeEndArray();
                    	return;
                    }
                  
                }else {
        			serializeCustomInfo(tenant, jgen);
        			return;
        		}
    		} else if(tenant instanceof HibernateProxy && HibernateProxy.class.isAssignableFrom(tenant.getClass())) {
    			jgen.writeStartObject();
    			jgen.writeEndObject();
                return;
    		} else {
    			serializeCustomInfo(tenant, jgen);
    			return;
    		}
    				
    	}

 public void serializeCustomInfo(BusinessEntity tenant, JsonGenerator jgen) throws IOException, JsonGenerationException {
		if(tenant != null)
		{
		jgen.writeStartObject();
		jgen.writeNumberField("id", tenant.getId());
		jgen.writeStringField("code", tenant.getCode());
		jgen.writeEndObject();
		}
	}
    	
}