package com.mize.domain.product;

import com.mize.domain.common.Entity;

public class Source extends Entity{

	private static final long serialVersionUID = 1143535287038637870L;
	public Integer sourceId;
	public String sourceName;

	public Source() {
		super();
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

}