package com.mize.domain.prod.bby;

import org.joda.time.DateTime;

public class Product {
	private long sku;
	private float salePrice;
	private String upc;
	private DateTime priceUpdateDate;
	
	public long getSku() {
		return sku;
	}
	public void setSku(long sku) {
		this.sku = sku;
	}
	public float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public DateTime getPriceUpdateDate() {
		return priceUpdateDate;
	}
	public void setPriceUpdateDate(DateTime priceUpdateDate) {
		this.priceUpdateDate = priceUpdateDate;
	}
	

}
