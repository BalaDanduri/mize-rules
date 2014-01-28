package com.mize.domain.product;

import com.mize.domain.common.Entity;

public class ProdStatus extends Entity{

	private static final long serialVersionUID = -6500469784533589799L;
	protected int id;
	protected String type;
	
	public ProdStatus(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProdStatus [id=" + id + ", type=" + type + "]";
	}

}
