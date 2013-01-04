package com.mize.domain.util;

import java.util.List;

import com.mize.domain.exception.MizeError;

public final class ServiceDTO<T> {
	private T dataObject;
	private List<MizeError> errors;
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
}
