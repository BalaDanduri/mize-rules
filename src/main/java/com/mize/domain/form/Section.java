package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class Section extends FormElement{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1131177443126701114L;
	
	private List<Field> fields;
	
	public Section() {
		super();
		fields = new ArrayList<Field>();
	}
	
	public List<Field> getFields() {
		return fields;
	}
	
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
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
		Section other = (Section) obj;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Section [fields=" + fields + "]";
	}
	
}
