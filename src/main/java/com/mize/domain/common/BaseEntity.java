package com.mize.domain.common;

import java.io.Serializable;
import java.util.ArrayList;

import com.mize.domain.exception.MizeException;

public class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 6651571123697401305L;
	private ArrayList<MizeException> mizeExceptions = new ArrayList<MizeException>();
	
	public ArrayList<MizeException> getExceptions() {
		return mizeExceptions;
	}
	
	public void addException(MizeException exception) {
		mizeExceptions.add(exception);
	}

}