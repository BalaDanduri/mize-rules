package com.mize.domain.product;

public class ProductSource {

	public int sourceId;
	public String sourceName;
	public String sourceProdId;
	
	public ProductSource() {
		// TODO Auto-generated constructor stub
	}

	public ProductSource(int sourceId, String sourceName, String sourceProdId) {
		this.sourceId = sourceId;
		this.sourceName = sourceName;
		this.sourceProdId = sourceProdId;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceProdId() {
		return sourceProdId;
	}

	public void setSourceProdId(String sourceProdId) {
		this.sourceProdId = sourceProdId;
	}

}
