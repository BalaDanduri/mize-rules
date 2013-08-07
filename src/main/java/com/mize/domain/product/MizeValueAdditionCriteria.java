package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;

public class MizeValueAdditionCriteria extends MizeEntity implements Comparable<MizeValueAdditionCriteria>{
	private static final long serialVersionUID = 155385665556860537L;
	private Long productId;
	private String upc;

	@Override
	public Long getId(){
		return id;
	}
	
	@Override
	public void setId(Long id){
		this.id = id;
	}	
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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
