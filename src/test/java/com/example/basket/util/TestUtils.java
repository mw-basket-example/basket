package com.example.basket.util;

import java.math.BigDecimal;

import com.example.basket.model.Product;

public final class TestUtils {
    public static final Product APPLE = createProduct("Apple", "0.50");
    public static final Product BANANA = createProduct("Banana", "1.00");
    public static final Product LEMON = createProduct("Lemon", "0.35");
    public static final Product ORANGE = createProduct("Orange", "0.55");

    private TestUtils() {
    }

    public static Product createProduct(String name, String price) {
        return new Product(name, new BigDecimal(price));
    }
}