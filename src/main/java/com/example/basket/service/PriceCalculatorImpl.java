package com.example.basket.service;

import java.math.BigDecimal;

import com.example.basket.model.Basket;
import com.example.basket.model.Product;

/**
 * Calculates total price of provided {@link Basket}.
 */
public class PriceCalculatorImpl implements PriceCalculator {
    public static final BigDecimal ZERO = new BigDecimal("0.00");

    /**
     * @see com.example.basket.service.PriceCalculator#calculate(Basket)
     */
	public BigDecimal calculate(final Basket basket) {
		BigDecimal totalPrice = ZERO;

		if (!basket.isEmpty()) {
			for (Product product : basket.getProducts()) {
				int quantity = basket.getProductQuantity(product);
				totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
			}
		}

		return totalPrice;
	}
}