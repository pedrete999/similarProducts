package com.backend.devtests.similarproducts.service.impl;

import com.backend.devtests.similarproducts.model.ProductDetail;
import com.backend.devtests.similarproducts.service.ProductService;
import com.backend.devtests.similarproducts.service.SimilarProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The interface Similar Product service.
 *
 * @author Pedro Nieto Méndez
 */
@Service
public class SimilarProductsServiceImpl implements SimilarProductsService {

    private final ProductService productService;


    /**
     * Instantiates a new Similar products service.
     *
     * @param productService the product service
     */
    @Autowired
    public SimilarProductsServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    /**
     * get list of similar products to a given one ordered by similarity.
     *
     * @param id the id
     * @return the product similar details
     */
    @Override
    public List<ProductDetail> getProductSimilar(String id) {
        return productService.getProductSimilarIds(id).stream().map(productService::getProductById).collect(
                Collectors.toList());
    }
}
