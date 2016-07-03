package com.example.basket;

import java.math.BigDecimal;
import java.text.NumberFormat;

import com.example.basket.model.Basket;
import com.example.basket.service.BasketFactory;
import com.example.basket.service.BasketFactoryImpl;
import com.example.basket.service.PriceCalculator;
import com.example.basket.service.PriceCalculatorImpl;
import com.example.basket.service.ProductServiceImpl;

public class BasketPriceRunner {

    public static void main(final String[] args) {
        Basket basket = getBasketFactory().createBasket(args);
        BigDecimal totalPrice = getPriceCalculator().calculate(basket);

        System.out.println("Price of the basket is: " + NumberFormat.getCurrencyInstance().format(totalPrice));
    }

    private static BasketFactory getBasketFactory() {
        return new BasketFactoryImpl(new ProductServiceImpl());
    }

    private static PriceCalculator getPriceCalculator() {
        return new PriceCalculatorImpl();
    }
}