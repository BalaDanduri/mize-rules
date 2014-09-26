package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class SectionGroup extends FormElement{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3738122979818002211L;
	private final List<Section> sections = new ArrayList<Section>();
		
	public List<Section> getSections() {
		return sections;
	}
}
