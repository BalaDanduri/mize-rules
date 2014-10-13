package com.mize.domain.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeEntity;

public class FormLabel extends MizeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 650988974672502526L;
	
	private String code;
	private List<LabelIntl> intl;
	
	public FormLabel() {
		super();
		intl = new ArrayList<LabelIntl>();
	}
			
	public FormLabel(String code) {
		this.code = code;
	}	
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
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

	@Override
	public String toString() {
		return "FormLabel [id=" + id + ", code=" + code + ", intl=" + intl + "]";
	}
	
}
