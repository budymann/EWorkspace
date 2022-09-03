package com.budymann.OrderService;

import com.budymann.product.service.apiclient.ApiClient;
import com.budymann.product.service.apiclient.api.CartResourceApi;
import com.budymann.product.service.apiclient.api.ProductResourceApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        var restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean
    public ProductResourceApi productResourceApi(){
        var apiClient = new ApiClient(new RestTemplate());
        apiClient.setBasePath("localhost:8092/product/service");
        return new ProductResourceApi();
    }

    @Bean
    public CartResourceApi cartResourceApi(){
        var apiClient = new ApiClient(new RestTemplate());
        apiClient.setBasePath("localhost:8092/product/service");
        return new CartResourceApi();
    }
}
