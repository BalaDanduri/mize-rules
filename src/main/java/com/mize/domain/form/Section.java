package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class Section extends FormElement{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1131177443126701114L;
	private final List<Field> fields = new ArrayList<Field>();
	
	public List<Field> getFields() {
		return fields;
	}
}
