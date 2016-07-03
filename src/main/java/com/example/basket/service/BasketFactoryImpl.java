package com.example.basket.service;

import com.example.basket.model.Basket;

/**
 * Default implementation of {@link BasketFactory}.
 */
public class BasketFactoryImpl implements BasketFactory {

    private final ProductService productService;

    public BasketFactoryImpl(final ProductService productService) {
        this.productService = productService;
    }

    /**
     * @see com.example.basket.service.BasketFactory#createBasket(java.lang.String)
     */
    public Basket createBasket(final String... items) {
        if (items == null) {
            throw new IllegalArgumentException("Cannot create basket from null items");
        }

        Basket basket = new Basket();
        for (String item : items) {
            basket.addProduct(productService.getProductByName(item));
        }

        return basket;
    }
}