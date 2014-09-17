package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class Form extends FormElement{

	private final List<SectionGroup> sectionGroups = new ArrayList<SectionGroup>();
	
	public List<SectionGroup> getSectionGroups() {
		return sectionGroups;
	}
	
}
