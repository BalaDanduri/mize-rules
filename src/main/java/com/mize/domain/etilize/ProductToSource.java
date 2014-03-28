package com.mize.domain.etilize;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@Column(name="prod_source_id",nullable=true,length=11)
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "prod_id")
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	
	@Column(name="prod_to_source_id",nullable=true,length=50)
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
