package com.mize.domain.product;

import com.mize.domain.common.MizeSceEntity;

public class MizeValueAdditionCriteria extends MizeSceEntity implements Comparable<MizeValueAdditionCriteria>{
	private static final long serialVersionUID = 155385665556860537L;
	private Long prodId;
	private String upc;

	@Override
	public Long getId(){
		return id;
	}
	
	@Override
	public void setId(Long id){
		this.id = id;
	}	
	

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long productId) {
		this.prodId = productId;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	@Override
	public int compareTo(MizeValueAdditionCriteria arg0) {
		return 0;
	}
	
}
