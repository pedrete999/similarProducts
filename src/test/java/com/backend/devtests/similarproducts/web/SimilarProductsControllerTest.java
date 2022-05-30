package com.backend.devtests.similarproducts.web;

import com.backend.devtests.similarproducts.model.ProductDetail;
import com.backend.devtests.similarproducts.service.SimilarProductsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SimilarProductsController.class)
@AutoConfigureMockMvc
class SimilarProductsControllerTest {
    ProductDetail productDetail1 = ProductDetail.builder().id("2").name("Dress").price(BigDecimal.valueOf(19.99))
            .availability(true).build();
    ProductDetail productDetail2 = ProductDetail.builder().id("3").name("Blazer").price(BigDecimal.valueOf(29.99))
            .availability(false).build();
    ProductDetail productDetail3 = ProductDetail.builder().id("4").name("Boots").price(BigDecimal.valueOf(39.99))
            .availability(true).build();

    @MockBean
    SimilarProductsService similarProductsService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetSimilarProducts() throws Exception {
        List<ProductDetail> similarProducts = List.of(productDetail1, productDetail2,
                productDetail3);
        Mockito.when(similarProductsService.getProductSimilar(anyString())).thenReturn(similarProducts);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/1/similar")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[1].name", is("Blazer")));

    }
}
