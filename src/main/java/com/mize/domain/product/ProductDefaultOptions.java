package com.mize.domain.product;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductDefaultOptions {
	private Map<String, String> listingTypeMap = new LinkedHashMap<String, String>();
	private Map<String, String> listingDurationMap = new HashMap<String, String>();
	private Map<String, String> buyerPaymentMethodMap = new HashMap<String, String>();
	private Map<String, String> countryCodeMap = new HashMap<String, String>();
	private Map<String, String> currencyCodeMap = new HashMap<String, String>();
	private Map<String, String> returnsAcceptedOptionsMap = new HashMap<String, String>();
	private Map<String, String> refundOptionsMap = new HashMap<String, String>();
	private Map<String, String> returnsWithinOptionsMap = new HashMap<String, String>();
	private Map<String, String> siteCodeMap = new HashMap<String, String>();
	private Map<String, String> categoryMap = new HashMap<String, String>();

	public Map<String, String> getListingTypeMap() {
		return listingTypeMap;
	}

	public void setListingTypeMap(Map<String, String> listingTypeMap) {
		this.listingTypeMap = listingTypeMap;
	}

	public Map<String, String> getListingDurationMap() {
		return listingDurationMap;
	}

	public void setListingDurationMap(Map<String, String> listingDurationMap) {
		this.listingDurationMap = listingDurationMap;
	}

	public Map<String, String> getBuyerPaymentMethodMap() {
		return buyerPaymentMethodMap;
	}

	public void setBuyerPaymentMethodMap(Map<String, String> buyerPaymentMethodMap) {
		this.buyerPaymentMethodMap = buyerPaymentMethodMap;
	}

	public Map<String, String> getCountryCodeMap() {
		return countryCodeMap;
	}

	public void setCountryCodeMap(Map<String, String> countryCodeMap) {
		this.countryCodeMap = countryCodeMap;
	}

	public Map<String, String> getCurrencyCodeMap() {
		return currencyCodeMap;
	}

	public void setCurrencyCodeMap(Map<String, String> currencyCodeMap) {
		this.currencyCodeMap = currencyCodeMap;
	}

	public Map<String, String> getReturnsAcceptedOptionsMap() {
		return returnsAcceptedOptionsMap;
	}

	public void setReturnsAcceptedOptionsMap(Map<String, String> returnsAcceptedOptionsMap) {
		this.returnsAcceptedOptionsMap = returnsAcceptedOptionsMap;
	}

	public Map<String, String> getRefundOptionsMap() {
		return refundOptionsMap;
	}

	public void setRefundOptionsMap(Map<String, String> refundOptionsMap) {
		this.refundOptionsMap = refundOptionsMap;
	}

	public Map<String, String> getReturnsWithinOptionsMap() {
		return returnsWithinOptionsMap;
	}

	public void setReturnsWithinOptionsMap(Map<String, String> returnsWithinOptionsMap) {
		this.returnsWithinOptionsMap = returnsWithinOptionsMap;
	}

	public Map<String, String> getSiteCodeMap() {
		return siteCodeMap;
	}

	public void setSiteCodeMap(Map<String, String> siteCodeMap) {
		this.siteCodeMap = siteCodeMap;
	}

	public Map<String, String> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<String, String> categoryMap) {
		this.categoryMap = categoryMap;
	}

}
