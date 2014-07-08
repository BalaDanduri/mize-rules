package com.mize.domain.purchaseorder;

import java.math.BigDecimal;
import java.util.Map;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.Formatter;

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
	
	public enum Parameter{
		ShippingMethod,ShippingDays,ShippingPriority,ShippingCarrier,PaymentMethod,PricingMethod,AllowOverride,
		OrderRequired,ReturnWindow,NonReturnable,MaxAmtAllowed,ReasonRequired,InvoiceType,PurchaseOrderType,
		ApprovalRequired,DefaultWarehouse,HandlingChargePercent,LineHandlingChargePercent,
	}
	
	
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
	
	public void populateAttributes(Map<String,String> attributes){
		if(attributes != null && attributes.size() > 0){
			this.setShippingMethod(attributes.get(Parameter.ShippingMethod.toString()));
			this.setShippingDays(attributes.get(Parameter.ShippingDays.toString()));
			this.setShippingPriority(attributes.get(Parameter.ShippingPriority.toString()));
			this.setShippingCarrier(attributes.get(Parameter.ShippingCarrier.toString()));
			this.setPaymentMethod(attributes.get(Parameter.PaymentMethod.toString()));
			this.setPricingMethod(attributes.get(Parameter.PricingMethod.toString()));
			this.setAllowOverride(attributes.get(Parameter.AllowOverride.toString()));
			this.setReturnWindow(attributes.get(Parameter.ReturnWindow.toString()));
			this.setOrderRequired(attributes.get(Parameter.OrderRequired.toString()));
			this.setReasonRequired(attributes.get(Parameter.ReasonRequired.toString()));
			this.setNonReturnable(attributes.get(Parameter.NonReturnable.toString()));
			this.setMaxAmtAllowed(attributes.get(Parameter.MaxAmtAllowed.toString()));
			this.setInvoiceType(attributes.get(Parameter.InvoiceType.toString()));
			this.setPurchaseOrderType(attributes.get(Parameter.PurchaseOrderType.toString()));
			this.setDefaultWarehouse(attributes.get(Parameter.DefaultWarehouse.toString()));
			this.setApprovalRequired(attributes.get(Parameter.ApprovalRequired.toString()));
			this.setHandlingChargePercent(Formatter.toBigDecimal(attributes.get(Parameter.HandlingChargePercent.toString())));
			this.setLineHandlingChargePercent(Formatter.toBigDecimal(attributes.get(Parameter.LineHandlingChargePercent.toString())));
		}
	}	
}
