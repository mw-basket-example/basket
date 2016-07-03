package com.example.basket.service;

import static com.example.basket.util.TestUtils.APPLE;
import static com.example.basket.util.TestUtils.BANANA;
import static com.example.basket.util.TestUtils.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.basket.model.Basket;

@RunWith(MockitoJUnitRunner.class)
public class BasketFactoryImplTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private BasketFactoryImpl underTest;

    @Before
    public void setUp() {
        when(productService.getProductByName(APPLE.getName())).thenReturn(APPLE);
        when(productService.getProductByName(BANANA.getName())).thenReturn(BANANA);
        when(productService.getProductByName(ORANGE.getName())).thenReturn(ORANGE);
    }

    @Test
    public void testCreateBasketWhenItemsAreNotProvided() {
        Basket basket = underTest.createBasket();

        assertThat(basket.isEmpty(), is(true));

        verifyZeroInteractions(productService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBasketWhenItemsParameterIsNull() {
        underTest.createBasket((String[]) null);
    }

    @Test
    public void testCreateBasketWhenSingleItemIsProvided() {
        Basket basket = underTest.createBasket(APPLE.getName());

        assertThat(basket.getProducts(), contains(APPLE));
        assertThat(basket.getProductQuantity(APPLE), equalTo(1));

        verify(productService).getProductByName(APPLE.getName());
    }

    @Test
    public void testCreateBasketWhenSingleItemIsProvidedMultipleTimes() {
        Basket basket = underTest.createBasket(APPLE.getName(), APPLE.getName(), APPLE.getName());

        assertThat(basket.getProducts(), contains(APPLE));
        assertThat(basket.getProductQuantity(APPLE), equalTo(3));

        verify(productService, times(3)).getProductByName(APPLE.getName());
    }

    @Test
    public void testCreateBasketWhenMultipleItemsAreProvided() {
        Basket basket = underTest.createBasket(
                APPLE.getName(), BANANA.getName(), APPLE.getName(), ORANGE.getName(), BANANA.getName(), APPLE.getName());

        assertThat(basket.getProducts(), containsInAnyOrder(APPLE, BANANA, ORANGE));
        assertThat(basket.getProducts(), not(contains(LEMON)));
        assertThat(basket.getProductQuantity(APPLE), equalTo(3));
        assertThat(basket.getProductQuantity(BANANA), equalTo(2));
        assertThat(basket.getProductQuantity(ORANGE), equalTo(1));
        assertThat(basket.getProductQuantity(LEMON), equalTo(0));

        verify(productService, times(3)).getProductByName(APPLE.getName());
        verify(productService, times(2)).getProductByName(BANANA.getName());
        verify(productService, times(1)).getProductByName(ORANGE.getName());
    }
}