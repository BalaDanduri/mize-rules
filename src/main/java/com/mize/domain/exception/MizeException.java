package com.mize.domain.exception;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class MizeException extends RuntimeException {
	private static final long serialVersionUID = -438497898258707101L;
	private List<MizeError> errors = new ArrayList<MizeError>();

	public MizeException(String code){
		addErrors(code, "");
	}
	
	public MizeException(String code,String message){
		addErrors(code, message);
	}
	
	public void addError(MizeError error) {
		errors.add(error);
	}
	
	public final List<MizeError> getErrors() {
		return errors;
	}
	
	public MizeException() {
		
	}
	
	public MizeException(List<MizeError> errors ) {
		this.errors = errors;		
	}
	
	@JsonIgnore
	public void addErrors(String code,String message){
		if(errors != null){
			errors = new ArrayList<MizeError>();
		}
		errors.add(new MizeError(code, message));
	}
	
	@JsonIgnore
	public void addErrors(String code){
		addErrors(code,"");
	}

}