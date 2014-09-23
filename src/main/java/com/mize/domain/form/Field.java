package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class Field extends FormElement {

	private String id;
	private String name;
	private String type;
	private String value;
	private String ref;
	private String sameRow;
	List<Attribute> attrs = new ArrayList<Attribute>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getSameRow() {
		return sameRow;
	}

	public void setSameRow(String sameRow) {
		this.sameRow = sameRow;
	}

	public List<Attribute> getAttrs() {
		return attrs;
	}

	public void setAttrs(List<Attribute> attrs) {
		this.attrs = attrs;
	}

	@Override
	public String toString() {
		return "Field [id=" + id + ", name=" + name + ", type=" + type + ", value=" + value + ", ref=" + ref 
				+ ", sameRow=" + sameRow + ", attrs=" + attrs + "]";
	}

}
