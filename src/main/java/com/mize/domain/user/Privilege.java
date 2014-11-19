package com.mize.domain.user;

import com.mize.domain.common.MizeSceEntity;

public class Privilege extends MizeSceEntity{

	private static final long serialVersionUID = -5913874308418995423L;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
}
