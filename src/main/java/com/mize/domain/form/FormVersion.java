package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeSceEntity;

public class FormVersion extends MizeSceEntity implements Comparable<FormVersion> {

	private static final long serialVersionUID = -659127151003519230L;
	private String formCode;
	private String formName;
	private List<String> versionNumbers;

	public FormVersion() {
		versionNumbers = new ArrayList<String>();
	}
	
	public FormVersion(Long formId, String formCode, String formName, List<String> versionNumbers) {
		super();
		this.id = formId;
		this.formCode = formCode;
		this.formName = formName;
		this.versionNumbers = versionNumbers;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public List<String> getVersionNumbers() {
		return versionNumbers;
	}

	public void setVersionNumbers(List<String> versionNumbers) {
		this.versionNumbers = versionNumbers;
	}

	@Override
	public int compareTo(FormVersion o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
