package com.mize.domain.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomFieldMapObject implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, String> clientFieldToDbFieldMap = new HashMap<String, String>();
		
	public Map<String, String> getClientFieldToDbFieldMap() {
		return clientFieldToDbFieldMap;
	}
	
	public void setClientFieldToDbFieldMap(Map<String, String> clientFieldToDbFieldMap) {
		this.clientFieldToDbFieldMap = clientFieldToDbFieldMap;
	}
	
	public void addClientFieldToDbField(String clientField, String dbField)
	{
		if(!clientFieldToDbFieldMap.containsKey(clientField))
		{
			clientFieldToDbFieldMap.put(clientField, dbField);
		}
	}
	
	public Set<String> getAllClientFieldsFromMap() {
		return clientFieldToDbFieldMap.keySet();
	}
	
	public Collection<String> getAllDBFieldsFromMap() {
		return clientFieldToDbFieldMap.values();
	}


}
 