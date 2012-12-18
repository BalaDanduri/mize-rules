package com.mize.domain.exception;

import java.util.ArrayList;
import java.util.List;

public class MizeException extends RuntimeException {
	private static final long serialVersionUID = -438497898258707101L;
	private List<MizeError> errors = new ArrayList<MizeError>();

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

}