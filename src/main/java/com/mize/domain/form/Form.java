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

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((appLabels == null) ? 0 : appLabels.hashCode());
		result = prime * result
				+ ((sectionGroups == null) ? 0 : sectionGroups.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)){
	         return false;
	     }
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Form other = (Form) obj;
		if (appLabels == null) {
			if (other.appLabels != null)
				return false;
		} else if (!appLabels.equals(other.appLabels))
			return false;
		if (sectionGroups == null) {
			if (other.sectionGroups != null)
				return false;
		} else if (!sectionGroups.equals(other.sectionGroups))
			return false;
		
		return false;
	}

	
	
	
	
}
