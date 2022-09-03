package com.budymann.OrderService.domain.service;

import com.budymann.product.service.apiclient.api.ProductResourceApi;
import com.budymann.product.service.apiclient.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductResourceApi productResourceApi;

    public ProductDto getProduct(Long productId){
        return productResourceApi.getProduct(productId);
    }
}
