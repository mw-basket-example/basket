package com.example.basket.model;
import static com.example.basket.util.TestUtils.APPLE;
import static com.example.basket.util.TestUtils.BANANA;
import static com.example.basket.util.TestUtils.ORANGE;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BasketTest {

	private Basket underTest = new Basket();

	@Test
	public void testIsEmpty() {
		assertThat(underTest.isEmpty(), is(true));
		
		underTest.addProduct(APPLE);
		assertThat(underTest.isEmpty(), is(false));
	}
	
	@Test
	public void testAddAndGetProducts() {
		assertThat(underTest.getProducts(), is(empty()));
		
		underTest.addProduct(APPLE);
		assertThat(underTest.getProducts(), containsInAnyOrder(APPLE));
		
		underTest.addProduct(ORANGE);
		assertThat(underTest.getProducts(), containsInAnyOrder(APPLE, ORANGE));
		
		underTest.addProduct(BANANA, 2);
		assertThat(underTest.getProducts(), containsInAnyOrder(APPLE, ORANGE, BANANA));
	}

	@Test
	public void testAddAndGetProductQuantity() {
		assertThat(underTest.getProductQuantity(APPLE), is(0));

		underTest.addProduct(APPLE);
		assertThat(underTest.getProductQuantity(APPLE), is(1));

		underTest.addProduct(APPLE, 11);
		assertThat(underTest.getProductQuantity(APPLE), is(12));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddProductWhenProductIsInvalid() {
		underTest.addProduct(null, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddProductWhenQuantityIsInvalid() {
		underTest.addProduct(APPLE, -1);
	}
}