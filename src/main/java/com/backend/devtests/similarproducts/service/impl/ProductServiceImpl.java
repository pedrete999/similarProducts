package com.backend.devtests.similarproducts.service.impl;

import com.backend.devtests.similarproducts.model.ProductDetail;
import com.backend.devtests.similarproducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The type Product service.
 *
 * @author Pedro Nieto Méndez
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final RestTemplate productRestTemplate;

    /**
     * Instantiates a new Product service.
     *
     * @param productRestTemplate the product rest template
     */
    @Autowired
    public ProductServiceImpl(RestTemplate productRestTemplate) {
        this.productRestTemplate = productRestTemplate;
    }

    @Value("${client.product.baseUri}")
    private String baseUri;

    @Value("${client.product.endpoints.get-product-similarids.path}")
    private String productSimilarIdsPath;
    @Value("${client.product.endpoints.get-product-productId.path}")
    private String productByIdPath;

    /**
     * Gets product similar ids.
     *
     * @param productId the product id
     * @return the product similar ids
     */
    @Override
    public List<String> getProductSimilarIds(String productId) {
        try {
            return Arrays.asList(Objects.requireNonNull(
                    productRestTemplate.getForObject(this.getProductSimilarIdsEndpoint(), String[].class, productId)));
        } catch (HttpClientErrorException errorException) {
            throw new ResponseStatusException(errorException.getStatusCode(), errorException.getMessage(),
                    errorException);
        }
    }

    /**
     * Gets product by id.
     *
     * @param productId the product id
     * @return the product by id
     */
    @Override
    public ProductDetail getProductById(String productId) {
        try {
            return productRestTemplate.getForObject(this.getProductByIdEndPoint(), ProductDetail.class, productId);
        } catch (HttpClientErrorException errorException) {
            throw new ResponseStatusException(errorException.getStatusCode(), errorException.getMessage(),
                    errorException);
        }

    }

    private String getProductSimilarIdsEndpoint() {
        return this.baseUri.concat(this.productSimilarIdsPath);
    }

    private String getProductByIdEndPoint() {
        return this.baseUri.concat(this.productByIdPath);
    }
}
