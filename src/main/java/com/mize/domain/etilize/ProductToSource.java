package com.mize.domain.etilize;

import com.mize.domain.common.MizeEntity;


public class ProductToSource extends MizeEntity{

	private static final long serialVersionUID = -17526446685342722L;
	
	private Long sourceId;
	private Long productSourceId;
	private Long prodId;
	public enum Source{
		SOURCE_MIZE(1) ,SOURCE_AMAZON(2) ,SOURCE_ETILIZE(3);
		Integer value;
		Source(Integer val){
			value = val;
		}
		public Integer getValue(){
			return value;
		}
	}
	
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
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
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
}
