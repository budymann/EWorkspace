package com.budymann.ProductService.resource;


import com.budymann.ProductService.dataaccess.ProductEntity;
import com.budymann.ProductService.domain.dto.CategoryDto;
import com.budymann.ProductService.domain.dto.ProductDto;
import com.budymann.ProductService.domain.repository.ProductRepository;
import com.budymann.ProductService.domain.service.ProductService;
import com.budymann.ProductService.resource.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductResource {
    @Autowired
    ProductService productService;

    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable Long productId){
        return productService.getProductDto(1L);
    }

    @GetMapping("/category/{categoryId}")
    public CategoryDto getCategory(@PathVariable Long categoryId){
        return productService.getCategory(categoryId);
    }


}
