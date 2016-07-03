package com.example.basket.service;

import com.example.basket.model.Basket;

/**
 * Creates basket out of provided product items.
 * <p>
 *   Each provided item must identify available product.
 *   Items related to single product can be presented multiple times.
 * </p>
 */
public interface BasketFactory {

    Basket createBasket(String... items);
}