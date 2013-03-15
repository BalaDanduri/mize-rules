package com.mize.domain.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;

public class UserWownit extends Entity{

	private static final long serialVersionUID = -5112664139693276593L;
	private User user;
	private Map<String, Set<Product>> wownitProducts; 
	
	public UserWownit() {
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
