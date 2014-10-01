package com.mize.domain.form;

import java.io.Serializable;


public class Attribute implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4495186453091139534L;
	private String name;	
	private String value;
	private String severity;
	private String formula;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	@Override
	public String toString() {
		return "Attribute [name=" + name + ", value=" + value + ", severity=" + severity + ", formula=" + formula + "]";
	}
	
}