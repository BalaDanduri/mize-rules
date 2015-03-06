package com.mize.domain.shipping;

import com.mize.domain.common.MizeSceEntity;

public class SpecialServiceCode extends MizeSceEntity implements Comparable<SpecialServiceCode>{

	private static final long serialVersionUID = -8099805047812407229L;
	
	private String value;
	private String code;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int compareTo(SpecialServiceCode o) {
		return 0;
	}

	
}
