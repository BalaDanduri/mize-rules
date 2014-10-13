package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class Section extends FormElement{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1131177443126701114L;
	
	private List<Field> fields;
	
	public Section() {
		super();
		fields = new ArrayList<Field>();
	}
	
	public List<Field> getFields() {
		return fields;
	}
	
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
}
