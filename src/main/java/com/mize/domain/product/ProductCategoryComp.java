package com.mize.domain.product;


import java.util.Comparator;


public class ProductCategoryComp implements Comparator<ProductCategory> {

	public int compare(ProductCategory o1, ProductCategory o2) {
		return (o1.getName().compareToIgnoreCase(o2.getName()));		
	}
}
