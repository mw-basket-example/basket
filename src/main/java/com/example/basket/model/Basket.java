package com.example.basket.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Contains products and corresponding quantity.
 */
public class Basket {

    private final Map<Product, Integer> items = new HashMap<Product, Integer>();

    public void addProduct(final Product product) {
        addProduct(product, 1);
    }

    public void addProduct(final Product product, final int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot add product to basket: product is null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Cannot add product to basket: invalid quantity " + quantity);
        }

        Integer currentQuantity = items.get(product);
        if (currentQuantity == null) {
            items.put(product, quantity);
        } else {
            items.put(product, currentQuantity + quantity);
        }
    }

    public Set<Product> getProducts() {
        return items.keySet();
    }

    public int getProductQuantity(Product product) {
        Integer quantity = items.get(product);
        return quantity == null ? 0 : quantity;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}