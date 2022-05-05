package com.budymann.ProductService.domain.service;

import com.budymann.ProductService.dataaccess.CategoryEntity;
import com.budymann.ProductService.dataaccess.ProductEntity;
import com.budymann.ProductService.domain.dto.CategoryDto;
import com.budymann.ProductService.domain.dto.ProductDto;
import com.budymann.ProductService.domain.repository.CategoryRepository;
import com.budymann.ProductService.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ProductDto getProductDto(Long productId){
        var product = productRepository.getById(productId);
        return map(product);
    }

    public CategoryDto getCategory(Long categoryId){
        return map(categoryRepository.getById(categoryId));
    }

    public CategoryDto mapRecursively(CategoryEntity from){
        CategoryDto root =  new CategoryDto();
        root.setCategoryName(from.getCategoryName());
        root.setCategoryPath(from.getCategoryPath());

        for(var x : from.getChildren()){
            if(root.getChildren() == null){
                root.setChildren(new ArrayList<>());
            }

            root.getChildren().add(mapRecursively(x));
        }

        return root;
    }

    public CategoryDto map(CategoryEntity from){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(from.getCategoryId());
        categoryDto.setCategoryName(from.getCategoryName());
        categoryDto.setCategoryPath(from.getCategoryPath());

        var categoryDtoChildrens = new ArrayList<CategoryDto>();
        for(var category : from.getChildren()){
            var catChildren = new CategoryDto();
            catChildren.setCategoryId(category.getCategoryId());
            catChildren.setCategoryPath(category.getCategoryPath());
            catChildren.setCategoryName(category.getCategoryName());
            categoryDtoChildrens.add(catChildren);
        }

        categoryDto.setChildren(categoryDtoChildrens);

        var products = from.getProducts();

        categoryDto.setProducts(new ArrayList<>());
        for(var product : products){
            var productDto = ProductDto.builder()
                    .productId(product.getProductId())
                    .productName(product.getProductName())
                    .discountedPrice(product.getDiscountedPrice())
                    .retailPrice(product.getRetailPrice())
                    .imageLink(product.getImageLink())
                    .build();

            categoryDto.getProducts().add(productDto);
        }


        return categoryDto;
    }

    public ProductDto map(ProductEntity from){

        var categoryEntity = from.getCategory();

        var categoryDto = CategoryDto.builder().categoryId(categoryEntity.getCategoryId())
                .categoryName(categoryEntity.getCategoryName())
                .categoryPath(categoryEntity.getCategoryPath())
                .build();

        var productDto = ProductDto.builder()
                .productId(from.getProductId())
                .productName(from.getProductName())
                .discountedPrice(from.getDiscountedPrice())
                .retailPrice(from.getRetailPrice())
                .imageLink(from.getImageLink())
                .category(categoryDto)
                .build();

        return productDto;
    }
}
