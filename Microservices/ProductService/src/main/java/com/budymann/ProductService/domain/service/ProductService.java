package com.budymann.ProductService.domain.service;

import com.budymann.ProductService.dataaccess.ProductEntity;
import com.budymann.ProductService.domain.dto.CategoryDto;
import com.budymann.ProductService.domain.dto.ProductDto;
import com.budymann.ProductService.domain.mapper.CategoryMapper;
import com.budymann.ProductService.domain.mapper.ProductMapper;
import com.budymann.ProductService.domain.repository.CategoryRepository;
import com.budymann.ProductService.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ProductDto getProductDto(Long productId){
        var product = productRepository.getById(productId);
        return productMapper.map(product);
    }

    public CategoryDto getCategory(Long categoryId){
        return categoryMapper.map(categoryRepository.getById(categoryId));
    }

    public ProductDto saveProduct(ProductDto productDto){
        var temp = productMapper.map(productDto);
        var productEntity = productRepository.save(temp);

        return productMapper.map(productEntity);
    }
}
