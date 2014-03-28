package com.mize.domain.purchaseorder;

import com.mize.domain.common.MizeEntity;

public class PurchaseOrderParameter extends MizeEntity {
	
	private static final long serialVersionUID = 3401950292780169711L;
	private String shippingMethod;
	private String shippingPriority;
	private String shippingCarrier;
	private String paymentMethod;
	private String pricingMethod;
	
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getShippingPriority() {
		return shippingPriority;
	}
	public void setShippingPriority(String shippingPriority) {
		this.shippingPriority = shippingPriority;
	}
	public String getShippingCarrier() {
		return shippingCarrier;
	}
	public void setShippingCarrier(String shippingCarrier) {
		this.shippingCarrier = shippingCarrier;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
		
	public String getPricingMethod() {
		return pricingMethod;
	}
	public void setPricingMethod(String pricingMethod) {
		this.pricingMethod = pricingMethod;
	}
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "PurchaseOrderParameter [shippingMethod=" + shippingMethod
				+ ", shippingPriority=" + shippingPriority
				+ ", shippingCarrier=" + shippingCarrier + ", paymentMethod="
				+ paymentMethod + ", pricingMethod=" + pricingMethod + "]";
	}
	
}
