package com.mize.domain.prod;


public class ProductToSource extends Entity{

	private static final long serialVersionUID = -17526446685342722L;
	private Long id;
	private Long productSourceId;
	private Long prodId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public Long getProductSourceId() {
		return productSourceId;
	}
	public void setProductSourceId(Long productSourceId) {
		this.productSourceId = productSourceId;
	}
	
}
