package com.example.basket.service;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductServiceImplTest {

    private ProductService underTest = new ProductServiceImpl();
    
	@Test
	public void testGetProductByName() {
		assertThat(underTest.getProductByName("Apple"), allOf(
		        hasProperty("name", equalTo("Apple")),
		        hasProperty("price", equalTo(new BigDecimal("0.50")))));

		assertThat(underTest.getProductByName("ORANGE"), allOf(
                hasProperty("name", equalTo("Orange")),
                hasProperty("price", equalTo(new BigDecimal("0.55")))));

		assertThat(underTest.getProductByName("lemon"), allOf(
                hasProperty("name", equalTo("Lemon")),
                hasProperty("price", equalTo(new BigDecimal("0.35")))));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetByNameThrowsExceptionWhenNameIsNull() {
	    underTest.getProductByName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetByNameThrowsExceptionWhenNameIsUnknown() {
	    underTest.getProductByName("Strawberry");
	}
}