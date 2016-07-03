package com.example.basket.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.example.basket.model.Product;

/**
 * Provides basic implementation of {@link ProductService}.
 * <p>
 *   Products are initialised in local cache.
 * </p>
 */
public class ProductServiceImpl implements ProductService {
    
    private final Map<String, Product> productCache = new HashMap<String, Product>();

    public ProductServiceImpl() {
        initCache();
    }

    private void initCache() {
        createProduct("Apple", "0.50");
        createProduct("Banana",  "1.00");
        createProduct("Lemon",  "0.35");
        createProduct("Orange",  "0.55");
        createProduct("Peach",  "0.50");
    }
    
    private void createProduct(final String name, final String price) {
        Product product = new Product(name, new BigDecimal(price));
        productCache.put(normalise(product.getName()), product);
    }

    private String normalise(final String name) {
        return name.toLowerCase();
    }

    /**
     * @see com.example.basket.service.ProductService#getProductByName(String)
     */
    public Product getProductByName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Cannot find product with null name");
        }
        
        Product product = productCache.get(normalise(name));
        
        if (product == null) {
            throw new IllegalArgumentException("Cannot find product for name: " + name);
        }
        
        return product;
    }
}