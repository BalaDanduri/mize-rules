package com.mize.domain.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mize.domain.exception.MizeError;

public final class ServiceDTO<T> implements ServiceLiteral{
	private T dataObject;
	private List<MizeError> errors;
	private Map<String,Object> messages = new HashMap<String, Object>();

	public T getDataObject() {
		return dataObject;
	}
	public void setDataObject(T dataObject) {
		this.dataObject = dataObject;
	}
	public List<MizeError> getErrors() {
		return errors;
	}
	public void setErrors(List<MizeError> errors) {
		this.errors = errors;
	} 
	public boolean hasErrors(){
		return (errors!= null && errors.size() > 0) ? true:false;
	}
	public Map<String, Object> getMessages() {
		return messages;
	}
	public void setMessages(Map<String, Object> messages) {
		this.messages = messages;
	}
	public boolean addMessage(String msgCode,Object msgValue){
		if(messages.get(msgCode) == null){
			messages.put(msgCode, msgValue);
			return true;
		}
		return  false;
	}
	public boolean hasMessages(){
		return (messages != null && messages.size() > 0);
	}
	
}
