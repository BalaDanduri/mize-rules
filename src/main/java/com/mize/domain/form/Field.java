package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class Field extends FormElement {

	private String type;
	private String value;
	private String sameRow;
	List<Attribute> attrs = new ArrayList<Attribute>();
	List<GroupField> fieldList = new ArrayList<GroupField>();

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

	public List<GroupField> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<GroupField> fieldList) {
		this.fieldList = fieldList;
	}

	@Override
	public String toString() {
		return "Field [type=" + type + ", value=" + value + ", sameRow=" + sameRow + ", attrs=" + attrs + ", fieldList=" + fieldList + "]";
	}

}
