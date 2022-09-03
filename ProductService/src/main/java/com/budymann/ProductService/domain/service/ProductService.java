package com.budymann.ProductService.domain.service;

import com.budymann.ProductService.domain.dto.CategoryDto;
import com.budymann.ProductService.domain.dto.ProductDto;
import com.budymann.ProductService.domain.mapper.CategoryMapper;
import com.budymann.ProductService.domain.mapper.ProductMapper;
import com.budymann.ProductService.dataaccess.CategoryDao;
import com.budymann.ProductService.dataaccess.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ProductDao productDao;

    @Autowired
    CategoryDao categoryDao;

    public ProductDto getProductDto(Long productId){
        var product = productDao.getById(productId);
        return productMapper.map(product);
    }

    public List<ProductDto> getProductDtos(){
        var products = productDao.findAll();
        return products.stream().map(x -> productMapper.map(x)).collect(toList());
    }


    public CategoryDto getCategory(Long categoryId){
        return categoryMapper.map(categoryDao.getById(categoryId));
    }

    public ProductDto saveProduct(ProductDto productDto){
        var temp = productMapper.map(productDto);
        var productEntity = productDao.save(temp);

        return productMapper.map(productEntity);
    }
}
