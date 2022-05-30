package com.backend.devtests.similarproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * The type Similarproducts application.
 *
 * @author Pedro Nieto Méndez
 */
@SpringBootApplication
public class SimilarproductsApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SimilarproductsApplication.class, args);
    }

    /**
     * Gets rest template.
     *
     * @return the rest template
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
