package com.mize.domain.product;


import java.util.Comparator;

import com.mize.domain.product.ProductPrices.ProductPrice;


public class PriceComparator implements Comparator<ProductPrice> {

	public int compare(ProductPrice o1, ProductPrice o2) {
		return (o1.getPrice()).compareTo(o2.getPrice());		
	}
}
