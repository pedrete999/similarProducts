package com.backend.devtests.similarproducts.web;

import com.backend.devtests.similarproducts.model.ProductDetail;
import com.backend.devtests.similarproducts.service.SimilarProductsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Similar products controller.
 *
 * @author Pedro Nieto Méndez
 */
@RestController
@Validated
@Api(value = "product", description = "Product API.")
public class SimilarProductsController {

    private final SimilarProductsService similarProductsService;

    /**
     * Instantiates a new Similar products controller.
     *
     * @param similarProductsService the similar products service
     */
    @Autowired
    public SimilarProductsController(SimilarProductsService similarProductsService) {
        this.similarProductsService = similarProductsService;
    }

    /**
     * GET /product/{productId}/similar : Similar products
     *
     * @param productId (required)
     * @return OK (status code 200) or Product Not found (status code 404)
     */
    @ApiOperation(value = "Similar products", nickname = "getProductSimilar", notes = "", response = ProductDetail.class, responseContainer = "List", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ProductDetail.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Product Not found")})
    @RequestMapping(value = "/product/{productId}/similar",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<List<ProductDetail>> getSimilarProducts(@ApiParam(value = "", required = true)
                                                                  @PathVariable("productId") String productId) {
        List<ProductDetail> similarProducts = similarProductsService.getProductSimilar(productId);
        return new ResponseEntity<>(similarProducts, HttpStatus.OK);
    }
}
