package com.mize.domain.purchaseorder;

import java.math.BigDecimal;

import com.mize.domain.common.MizeEntity;

public class PurchaseOrderParameter extends MizeEntity {
	
	private static final long serialVersionUID = 3401950292780169711L;
	private String shippingMethod;
	private String shippingPriority;
	private String shippingCarrier;
	private String paymentMethod;
	private String pricingMethod;
	private String shippingDays;
	private String allowOverride;
	private String returnWindow;
	private String orderRequired;
	private String reasonRequired;
	private String nonReturnable;
	private String maxAmtAllowed;
	private String invoiceType;
	private String purchaseOrderType;
	private String approvalRequired;
	private String defaultWarehouse;
	private BigDecimal handlingChargePercent;
	private BigDecimal lineHandlingChargePercent;
		
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
	public String getShippingDays() {
		return shippingDays;
	}
	public void setShippingDays(String shippingDays) {
		this.shippingDays = shippingDays;
	}
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getAllowOverride() {
		return allowOverride;
	}
	public void setAllowOverride(String allowOverride) {
		this.allowOverride = allowOverride;
	}
	
	public String getReturnWindow() {
		return returnWindow;
	}
	public void setReturnWindow(String returnWindow) {
		this.returnWindow = returnWindow;
	}
	public String getOrderRequired() {
		return orderRequired;
	}
	public void setOrderRequired(String orderRequired) {
		this.orderRequired = orderRequired;
	}
	public String getReasonRequired() {
		return reasonRequired;
	}
	public void setReasonRequired(String reasonRequired) {
		this.reasonRequired = reasonRequired;
	}
	public String getNonReturnable() {
		return nonReturnable;
	}
	public void setNonReturnable(String nonReturnable) {
		this.nonReturnable = nonReturnable;
	}
	public String getMaxAmtAllowed() {
		return maxAmtAllowed;
	}
	public void setMaxAmtAllowed(String maxAmtAllowed) {
		this.maxAmtAllowed = maxAmtAllowed;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getPurchaseOrderType() {
		return purchaseOrderType;
	}
	public void setPurchaseOrderType(String purchaseOrderType) {
		this.purchaseOrderType = purchaseOrderType;
	}
	
	public String getApprovalRequired() {
		return approvalRequired;
	}
	public void setApprovalRequired(String approvalRequired) {
		this.approvalRequired = approvalRequired;
	}	
		
	public String getDefaultWarehouse() {
		return defaultWarehouse;
	}
	public void setDefaultWarehouse(String defaultWarehouse) {
		this.defaultWarehouse = defaultWarehouse;
	}	
	public BigDecimal getHandlingChargePercent() {
		return handlingChargePercent;
	}
	public void setHandlingChargePercent(BigDecimal handlingChargePercent) {
		this.handlingChargePercent = handlingChargePercent;
	}
	public BigDecimal getLineHandlingChargePercent() {
		return lineHandlingChargePercent;
	}
	public void setLineHandlingChargePercent(BigDecimal lineHandlingChargePercent) {
		this.lineHandlingChargePercent = lineHandlingChargePercent;
	}	
	
	@Override
	public String toString() {
		return "PurchaseOrderParameter [shippingMethod=" + shippingMethod
				+ ", shippingPriority=" + shippingPriority
				+ ", shippingCarrier=" + shippingCarrier + ", paymentMethod="
				+ paymentMethod + ", pricingMethod=" + pricingMethod
				+ ", shippingDays=" + shippingDays + ", allowOverride="
				+ allowOverride + ", returnWindow=" + returnWindow
				+ ", orderRequired=" + orderRequired + ", reasonRequired="
				+ reasonRequired + ", nonReturnable=" + nonReturnable
				+ ", maxAmtAllowed=" + maxAmtAllowed + ", invoiceType="
				+ invoiceType + ", purchaseOrderType=" + purchaseOrderType
				+ ", approvalRequired=" + approvalRequired
				+ ", defaultWarehouse=" + defaultWarehouse
				+ ", handlingChargePercent=" + handlingChargePercent
				+ ", lineHandlingChargePercent=" + lineHandlingChargePercent
				+ "]";
	}
	
}
