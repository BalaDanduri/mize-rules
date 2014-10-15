package com.mize.domain.form;

import com.mize.domain.common.MizeEntity;

public class FormAttachment extends MizeEntity {

	private static final long serialVersionUID = 1062311193646728616L;
	private String type;
	private String name;
	private String url;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
