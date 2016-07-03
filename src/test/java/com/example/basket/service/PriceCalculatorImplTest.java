package com.example.basket.service;

import static com.example.basket.service.PriceCalculatorImpl.ZERO;
import static com.example.basket.util.TestUtils.APPLE;
import static com.example.basket.util.TestUtils.BANANA;
import static com.example.basket.util.TestUtils.LEMON;
import static com.example.basket.util.TestUtils.ORANGE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import com.example.basket.model.Basket;

public class PriceCalculatorImplTest {

    private PriceCalculator underTest = new PriceCalculatorImpl();

    @Test
    public void testCalculatePriceWhenBasketIsEmpty() {
        assertThat(underTest.calculate(new Basket()), equalTo(ZERO));
    }

    @Test
    public void testCalculatePriceWhenSingleItemIsProvided() {
        Basket basket = new Basket();
        basket.addProduct(APPLE, 1);

        assertThat(underTest.calculate(basket), equalTo(APPLE.getPrice()));
    }

    @Test
    public void testCalculateWhenMultipleItemsAreAvailableInBasket() {
        Basket basket = new Basket();
        basket.addProduct(APPLE, 12);
        basket.addProduct(BANANA, 25);
        basket.addProduct(ORANGE, 17);
        basket.addProduct(LEMON, 7);

        assertThat(underTest.calculate(basket), equalTo(new BigDecimal("42.80")));
    }
}