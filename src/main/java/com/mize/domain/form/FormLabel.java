package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

public class FormLabel {
	private Long id;
	private String code;
	private List<LabelIntl> intl = new ArrayList<LabelIntl>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<LabelIntl> getIntl() {
		return intl;
	}
	public void setIntl(List<LabelIntl> intl) {
		this.intl = intl;
	}
	
}
