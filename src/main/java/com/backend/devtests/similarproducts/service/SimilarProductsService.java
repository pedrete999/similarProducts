package com.backend.devtests.similarproducts.service;

import com.backend.devtests.similarproducts.model.ProductDetail;

import java.util.List;

/**
 * The interface Similar Product service.
 *
 * @author Pedro Nieto Méndez
 */
public interface SimilarProductsService {
    /**
     * get list of similar products to a given one ordered by similarity.
     *
     * @param id the id
     * @return the product similar details
     */
    List<ProductDetail> getProductSimilar(String id);
}
