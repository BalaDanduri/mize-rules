package com.mize.domain.prod.bby;

import com.mize.domain.util.MizeDateTime;

public class Product {
	private long sku;
	private float salePrice;
	private String upc;
	private MizeDateTime priceUpdateDate;
	
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
	public MizeDateTime getPriceUpdateDate() {
		return priceUpdateDate;
	}
	public void setPriceUpdateDate(MizeDateTime priceUpdateDate) {
		this.priceUpdateDate = priceUpdateDate;
	}
	

}
