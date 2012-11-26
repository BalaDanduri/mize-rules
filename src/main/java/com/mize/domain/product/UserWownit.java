package com.mize.domain.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.mize.domain.auth.User;

public class UserWownit {

	private User user;
	private Map<String, Set<Product>> wownitProducts; 
	
	public UserWownit() {
		// TODO Auto-generated constructor stub
		wownitProducts = new HashMap<String, Set<Product>>();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, Set<Product>> getWownitProducts() {
		return wownitProducts;
	}

	public void setWownitProducts(Map<String, Set<Product>> wownitProducts) {
		this.wownitProducts = wownitProducts;
	}
	
}
