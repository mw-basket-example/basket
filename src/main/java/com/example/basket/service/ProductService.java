package com.example.basket.service;

import com.example.basket.model.Product;

/**
 * Service providing product data.
 */
public interface ProductService {

    /**
     * Returns product by provided name.
     * 
     * @param name product name
     * @return product by provided name.
     */
    Product getProductByName(String name);
}