package com.backend.devtests.similarproducts.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Product detail
 *
 * @author Pedro Nieto Méndez
 */
@Jacksonized
@Builder
@Getter
@Setter
@Accessors(chain = true)
public class ProductDetail {

    @Schema(description = "Product Id", example = "4")
    @NotNull
    private String id;

    @Schema(description = "Product name", example = "Boots")
    @NotNull
    private String name;

    @Schema(description = "Product price", example = "39.99")
    @NotNull
    private BigDecimal price;

    @Schema(description = "Product availability", example = "true")
    @NotNull
    private Boolean availability;

}

