package com.mize.domain.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.Entity;
import com.mize.domain.util.DecimalValueDeserializer;
import com.mize.domain.util.NumberValueSerializer;

public class Retailer extends Entity{

private static final long serialVersionUID = -7613756473871400062L;
	
	private String sourceName;
	private Long sourceId;
	private Double price;	
	private String productLink;
	private String reviewLink;
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	
	@JsonSerialize(using=NumberValueSerializer.class)
	public Double getPrice() {
		return price;
	}
	
	@JsonDeserialize(using=DecimalValueDeserializer.class)
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getProductLink() {
		return productLink;
	}
	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}
	public String getReviewLink() {
		return reviewLink;
	}
	public void setReviewLink(String reviewLink) {
		this.reviewLink = reviewLink;
	}

}
