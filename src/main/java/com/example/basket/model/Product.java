package com.example.basket.model;

import java.math.BigDecimal;

public class Product {
	private final String name;
	private final BigDecimal price;

	public Product(final String name, final BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	@Override
	public int hashCode() {
	    return name.hashCode();
	}
	
	@Override
	public boolean equals(final Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (obj == this) {
	        return true;
	    }
	    if (obj.getClass() != getClass()) {
	        return false;
	    }
	    Product product = (Product) obj;
	    return name.equals(product.name);
	}
}