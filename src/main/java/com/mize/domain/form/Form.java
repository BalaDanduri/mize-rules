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
	
	private Integer maxSeverity;
	
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
		result = prime * result + ((sectionGroups == null) ? 0 : sectionGroups.hashCode());
		result = prime * result + ((maxSeverity == null) ? 0 : maxSeverity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Form other = (Form) obj;
		if (sectionGroups == null) {
			if (other.sectionGroups != null)
				return false;
		} else if (!sectionGroups.equals(other.sectionGroups))
			return false;
		if (maxSeverity == null) {
			if (other.maxSeverity != null)
				return false;
		} else if (!maxSeverity.equals(other.maxSeverity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Form [sectionGroups=" + sectionGroups + "]";
	}

	public Integer getMaxSeverity() {
		return maxSeverity;
	}

	public void setMaxSeverity(Integer maxSeverity) {
		this.maxSeverity = maxSeverity;
	}

}
