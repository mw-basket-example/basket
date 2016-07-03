package com.example.basket.service;

import java.math.BigDecimal;

import com.example.basket.model.Basket;

/**
 * Service calculating total price of provided basket.
 */
public interface PriceCalculator {

    /**
     * Returns total price of provided basket.
     * 
     * @param basket basket to calculate.
     * @return total price of provided basket.
     */
    BigDecimal calculate(Basket basket);
}