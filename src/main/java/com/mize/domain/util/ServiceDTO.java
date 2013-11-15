package com.mize.domain.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.mize.domain.appmsg.AppMessage;
import com.mize.domain.exception.MizeError;

public final class ServiceDTO<T> implements ServiceLiteral{

	private static final long serialVersionUID = 3924014526748017303L;
	private T dataObject;
	private List<MizeError> errors;
	private Map<String,Object> messages = new HashMap<String, Object>();
	private Map<String,String> validationMessages = new HashMap<String, String>();
	private List<AppMessage> appMessages = new ArrayList<AppMessage>();
	private Integer severity;
	private boolean isValid;

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
	
	@JsonIgnore
	public boolean hasErrors(){
		return (errors!= null && errors.size() > 0) ? true : false;
	}
	
	@JsonIgnore
	public boolean hasValidations(){
		return (validationMessages!= null && validationMessages.size() > 0) ? true : false;
	}
	
	public Map<String, Object> getMessages() {
		return messages;
	}
	
	public void setMessages(Map<String, Object> messages) {
		this.messages = messages;
	}
	
	@JsonIgnore
	public boolean setMessage(String msgCode,Object msgValue){
		return addMessage(msgCode,msgValue);
	}
	
	@JsonIgnore
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
	
	public Map<String, String> getValidationMessages() {
		return validationMessages;
	}
	
	public void setValidationMessages(Map<String, String> validationMessages) {
		this.validationMessages = validationMessages;
	}
	
	@JsonIgnore
	public boolean setValidationMessage(String msgCode,String msgValue){
		return addValidationMessage(msgCode,msgValue);
	}
	
	@JsonIgnore
	public boolean addValidationMessage(String msgCode,String msgValue){
		if(validationMessages.get(msgCode) == null){
			validationMessages.put(msgCode, msgValue);
			return true;
		}
		return  false;
	}
	
	@JsonIgnore
	public boolean addValidationMessage(String msgCode){
		return addValidationMessage(msgCode,msgCode);
	}
	
	@JsonIgnore
	public boolean setErrorMessage(String msgCode,String msgValue){
		return addErrorMessage(msgCode,msgValue);
	}
	
	@JsonIgnore
	public boolean addErrorMessage(String msgCode,String msgValue){
		MizeError error = new MizeError(msgCode, msgValue);
		if(errors == null){
			errors = new ArrayList<MizeError>();
		}
		errors.add(error);
		return  true;
	}
	
	@JsonIgnore
	public boolean addErrorMessage(String msgCode){
		return addErrorMessage(msgCode,msgCode);
	}
	
	@JsonIgnore
	public List<String> getErrorKeys(){
		List<String> keys = new ArrayList<String>();
		if(errors != null){
			for(MizeError error : errors){
				keys.add(error.getCode());
			}
		}
		return keys;
	}
	
	@JsonIgnore
	public List<String> getValidationMessageKeys(){
		List<String> keys = new ArrayList<String>();
		if(validationMessages != null){
			keys.addAll(validationMessages.keySet());
		}
		return keys;
	}
	
	@JsonIgnore
	public boolean isValid(){
		return !(hasErrors() || hasValidations());
	}
	
	@JsonIgnore
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@JsonIgnore
	public boolean getIsValid(){
		return !(hasErrors() || hasValidations());
	}
	
	@JsonIgnore
	public boolean hasValidationKey(String key){
		return getValidationMessageKeys().contains(key);
	}
	
	@JsonIgnore
	public boolean hasErrorKey(String key){
		return getErrorKeys().contains(key);
	}
	
	public List<AppMessage> getAppMessages() {
		return appMessages;
	}

	public void setAppMessages(List<AppMessage> appMessages) {
		this.appMessages = appMessages;
	}

	@JsonIgnore
	public void addAppMessage(Integer severity, String code){
		addAppMessage(severity,code,null);
	}
	
	@JsonIgnore
	public void addAppMessage(Integer severity, String code,String shortDesc){
		if(appMessages == null){
			appMessages = new ArrayList<AppMessage>();
		}
		if(Formatter.intValue(this.severity) > Formatter.intValue(severity)){
			this.severity = severity;
		}
		appMessages.add(new AppMessage(severity, code,shortDesc));
	}
	
	public Integer getSeverity() {
		return Formatter.intValue(severity);
	}


	@Override
	public String toString() {
		return "ServiceDTO [errors=" + errors
				+ ", messages=" + messages + ", validationMessages="
				+ validationMessages + ", isValid=" + isValid + "]";
	}
	
	
}
