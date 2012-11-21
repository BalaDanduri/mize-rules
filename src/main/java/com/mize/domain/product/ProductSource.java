package com.mize.domain.product;

public class ProductSource extends Source {

	public String sourceProdId;
	
	public ProductSource() {
		// TODO Auto-generated constructor stub
	}

	public ProductSource(Integer sourceId, String sourceName, String sourceProdId) {
		this.sourceId = sourceId;
		this.sourceName = sourceName;
		this.sourceProdId = sourceProdId;
	}

	public String getSourceProdId() {
		return sourceProdId;
	}

	public void setSourceProdId(String sourceProdId) {
		this.sourceProdId = sourceProdId;
	}

}
