package com.mize.domain.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormLabel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 650988974672502526L;
	private Long id;
	private String code;
	private List<LabelIntl> intl = new ArrayList<LabelIntl>();
	
	public FormLabel() {}
			
	public FormLabel(String code) {
		this.code = code;
	}	
	
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
