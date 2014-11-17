package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Field extends FormElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7247110131511609763L;
	
	private String type;
	private String value;
	private String sameRow;
	private List<Attribute> attrs;
	private List<GroupField> fieldList;
	private List<FormAttachment> attachments;
	
	public Field() {
		super();
		attrs = new ArrayList<Attribute>();
		fieldList = new ArrayList<GroupField>();
		attachments = new ArrayList<FormAttachment>();
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

	public String getSameRow() {
		return sameRow;
	}

	public void setSameRow(String sameRow) {
		this.sameRow = sameRow;
	}

	@JsonInclude(Include.NON_EMPTY)
	public List<Attribute> getAttrs() {
		return attrs;
	}

	public void setAttrs(List<Attribute> attrs) {
		this.attrs = attrs;
	}

	@JsonInclude(Include.NON_EMPTY)
	public List<GroupField> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<GroupField> fieldList) {
		this.fieldList = fieldList;
	}

	@JsonInclude(Include.NON_EMPTY)
	public List<FormAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<FormAttachment> attachments) {
		this.attachments = attachments;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((attachments == null) ? 0 : attachments.hashCode());
		result = prime * result + ((attrs == null) ? 0 : attrs.hashCode());
		result = prime * result + ((fieldList == null) ? 0 : fieldList.hashCode());
		result = prime * result + ((sameRow == null) ? 0 : sameRow.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Field other = (Field) obj;
		if (attachments == null) {
			if (other.attachments != null)
				return false;
		} else if (!attachments.equals(other.attachments))
			return false;
		if (attrs == null) {
			if (other.attrs != null)
				return false;
		} else if (!attrs.equals(other.attrs))
			return false;
		if (fieldList == null) {
			if (other.fieldList != null)
				return false;
		} else if (!fieldList.equals(other.fieldList))
			return false;
		if (sameRow == null) {
			if (other.sameRow != null)
				return false;
		} else if (!sameRow.equals(other.sameRow))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Field [type=" + type + ", value=" + value + ", sameRow="
				+ sameRow + ", attrs=" + attrs + ", fieldList=" + fieldList
				+ ", attachments=" + attachments + "]";
	}
	
}
