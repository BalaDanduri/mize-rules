package com.mize.domain.product;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;

public class UserProductItem extends Entity{

	private static final long serialVersionUID = 6747681807001480512L;
	private User user;
	private ProductItem productItem;
	protected Product product;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProductItem getProductItem() {
		return productItem;
	}

	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
