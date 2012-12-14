package com.mize.domain.common;

import java.io.Serializable;
import java.util.ArrayList;

public class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 6651571123697401305L;
	private ArrayList<String> errorMessages = new ArrayList<>();
	
	public ArrayList<String> getErrorMessage() {
		return errorMessages;
	}
	
	public void addErrorMessage(String errorMessage) {
		errorMessages.add(errorMessage);
	}

}