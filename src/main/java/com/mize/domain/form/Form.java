package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class Form extends FormElement{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7727863385524569981L;
	private final List<SectionGroup> sectionGroups = new ArrayList<SectionGroup>();
	
	public List<SectionGroup> getSectionGroups() {
		return sectionGroups;
	}
	
}
