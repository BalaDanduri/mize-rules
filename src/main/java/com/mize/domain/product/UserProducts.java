package com.mize.domain.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mize.domain.common.Entity;

public class UserProducts extends Entity{
	private static final long serialVersionUID = 8309438613443876062L;
	Long count;
	List<UserProduct> userProducts;
	private Map<String,String> msgMap = new HashMap<String,String>();	
	public UserProducts() {
		userProducts = new ArrayList<UserProduct>();
	}
	
	public void setUserProduct(UserProduct userProduct) {
		this.userProducts.add(userProduct);
	}
	public Map<String, String> getMsgMap() {
		return msgMap;
	}
	public void setMsgMap(Map<String, String> msgMap) {
		this.msgMap = msgMap;
	}
	public List<UserProduct> getUserProducts() {
		return userProducts;
	}
	public void setUserProducts(List<UserProduct> userProducts) {
		this.userProducts = userProducts;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
