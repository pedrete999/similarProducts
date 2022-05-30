package com.backend.devtests.similarproducts.service;

import com.backend.devtests.similarproducts.model.ProductDetail;

import java.util.List;

/**
 * The interface Product service.
 *
 * @author Pedro Nieto Méndez
 */
public interface ProductService {
    /**
     * Gets product similar ids.
     *
     * @param productId the product id
     * @return the product similar ids
     */
    List<String> getProductSimilarIds(String productId);

    /**
     * Gets product by id.
     *
     * @param productId the product id
     * @return the product by id
     */
    ProductDetail getProductById(String productId);
}
