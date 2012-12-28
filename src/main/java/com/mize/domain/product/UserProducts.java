package com.mize.domain.product;

import java.util.HashMap;
import java.util.Map;

import com.mize.domain.common.Entity;

public class UserProducts extends Entity{
	private static final long serialVersionUID = 8309438613443876062L;
	UserProduct userProduct;
	
	private Map<String,String> msgMap = new HashMap<String,String>();	
	public UserProducts() {
		userProduct = new UserProduct();
	}
	public UserProduct getUserProduct() {
		return userProduct;
	}
	public void setUserProduct(UserProduct userProduct) {
		this.userProduct = userProduct;
	}
	public Map<String, String> getMsgMap() {
		return msgMap;
	}
	public void setMsgMap(Map<String, String> msgMap) {
		this.msgMap = msgMap;
	}
	
}
