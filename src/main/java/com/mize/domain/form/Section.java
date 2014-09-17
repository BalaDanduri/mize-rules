package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class Section extends FormElement{
	private final List<Field> fields = new ArrayList<Field>();
	
	public List<Field> getFields() {
		return fields;
	}
}
