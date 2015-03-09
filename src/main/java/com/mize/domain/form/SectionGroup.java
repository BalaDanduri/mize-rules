package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class SectionGroup extends FormElement{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3738122979818002211L;
	
	private List<Section> sections;
	private Integer totalCount;
	private Integer doneCount;
	
	public SectionGroup() {
		super();
		sections = new ArrayList<Section>();
	}
	
	public List<Section> getSections() {
		return sections;
	}
	
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getDoneCount() {
		return doneCount;
	}

	public void setDoneCount(Integer doneCount) {
		this.doneCount = doneCount;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((sections == null) ? 0 : sections.hashCode());
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
		SectionGroup other = (SectionGroup) obj;
		if (sections == null) {
			if (other.sections != null)
				return false;
		} else if (!sections.equals(other.sections))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SectionGroup [sections=" + sections + "]";
	}
	
}
