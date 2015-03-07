package com.mize.domain.shipping;

import com.mize.domain.common.MizeSceEntity;

public class NotificationType extends MizeSceEntity implements Comparable<NotificationType>{


	private static final long serialVersionUID = 2116506923841688808L;
	
	private String value;
	private String code;
	
	public NotificationType(String value, String code) {
		super();
		this.value = value;
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
	public int compareTo(NotificationType o) {
		return 0;
	}

	
}
