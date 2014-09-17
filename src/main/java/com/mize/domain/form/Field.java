package com.mize.domain.form;

public class Field extends FormElement{
	private String type;
	private String value;
	private String minimum;
	private String maximum;
	private String notes;
	private String placeHolder;
	private String expression;
	private Boolean required;
	private String formula;
	private Boolean displayOnly;
	private String prefix;
	private String suffix;
	private String decimalSeparator;
	private String thousandSeparator;
	private Integer decimalPlaces;
	private String format;
	private String groupName;
	
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
	public String getMinimum() {
		return minimum;
	}
	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}
	public String getMaximum() {
		return maximum;
	}
	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getPlaceHolder() {
		return placeHolder;
	}
	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public Boolean getRequired() {
		return required;
	}
	public void setRequired(Boolean required) {
		this.required = required;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public Boolean getDisplayOnly() {
		return displayOnly;
	}
	public void setDisplayOnly(Boolean displayOnly) {
		this.displayOnly = displayOnly;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getDecimalSeparator() {
		return decimalSeparator;
	}
	public void setDecimalSeparator(String decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}
	public String getThousandSeparator() {
		return thousandSeparator;
	}
	public void setThousandSeparator(String thousandSeparator) {
		this.thousandSeparator = thousandSeparator;
	}
	public Integer getDecimalPlaces() {
		return decimalPlaces;
	}
	public void setDecimalPlaces(Integer decimalPlaces) {
		this.decimalPlaces = decimalPlaces;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String toString() {
		return "Field [type=" + type + ", value=" + value + ", minimum="
				+ minimum + ", maximum=" + maximum + ", notes=" + notes
				+ ", placeHolder=" + placeHolder + ", expression=" + expression
				+ ", required=" + required + ", formula=" + formula
				+ ", displayOnly=" + displayOnly + ", prefix=" + prefix
				+ ", suffix=" + suffix + ", decimalSeparator="
				+ decimalSeparator + ", thousandSeparator=" + thousandSeparator
				+ ", decimalPlaces=" + decimalPlaces + ", format=" + format
				+ ", groupName=" + groupName + "]";
	}
	
}
