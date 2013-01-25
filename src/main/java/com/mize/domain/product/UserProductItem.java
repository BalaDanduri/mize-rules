package com.mize.domain.product;

import com.mize.domain.auth.User;

/*
 * This class us used for selling an User product on ebay or other stores.
 */
public class UserProductItem {

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
