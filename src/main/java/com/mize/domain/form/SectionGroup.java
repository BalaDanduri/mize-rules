package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class SectionGroup extends FormElement{
	private final List<Section> sections = new ArrayList<Section>();
		
	public List<Section> getSections() {
		return sections;
	}
}
