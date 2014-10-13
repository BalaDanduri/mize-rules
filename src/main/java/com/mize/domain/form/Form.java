package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.applicationlabel.ApplicationLabel;

public class Form extends FormElement{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7727863385524569981L;
	
	private List<SectionGroup> sectionGroups;
	
	private List<ApplicationLabel> appLabels;
	
	public Form() {
		super();
		sectionGroups = new ArrayList<SectionGroup>();
		appLabels = new ArrayList<ApplicationLabel>();
	}
	
	public List<SectionGroup> getSectionGroups() {
		return sectionGroups;
	}

	public void setSectionGroups(List<SectionGroup> sectionGroups) {
		this.sectionGroups = sectionGroups;
	}

	@JsonIgnore
	public List<ApplicationLabel> getAppLabels() {
		return appLabels;
	}

	public void setAppLabels(List<ApplicationLabel> appLabels) {
		this.appLabels = appLabels;
	}
	
}
