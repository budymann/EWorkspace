package com.budymann.ProductService.domain.mapper;

import com.budymann.ProductService.dataaccess.CategoryEntity;
import com.budymann.ProductService.dataaccess.ProductEntity;
import com.budymann.ProductService.dataaccess.RelatedProductEntity;
import com.budymann.ProductService.domain.dto.CategoryDto;
import com.budymann.ProductService.domain.dto.ProductDto;
import com.budymann.ProductService.domain.dto.RelatedProductDto;
import com.budymann.ProductService.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class ProductMapper {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public ProductDto map(ProductEntity from){

        var categoryEntity = from.getCategory();

        var categoryDto = CategoryDto.builder().id(categoryEntity.getId())
                .categoryName(categoryEntity.getCategoryName())
                .categoryPath(categoryEntity.getCategoryPath())
                .build();

        var productDto = ProductDto.builder()
                .id(from.getId())
                .productName(from.getProductName())
                .discountedPrice(from.getDiscountedPrice())
                .retailPrice(from.getRetailPrice())
                .imageLink(from.getImageLink())
                .category(categoryDto)
                .build();

        return productDto;
    }

    /*
        Considerations:
        1. Saving new product, with category attached
        2. Editing product, changing its categories (?)
     */
    public ProductEntity map(ProductDto productDto){

        ProductEntity productEntity = new ProductEntity();

        if(productDto.getId() != null){
            //If i do this then cant edit no more
            productEntity = productRepository.getOne(productDto.getId());
        }

        productEntity.setProductName(productDto.getProductName());
        productEntity.setDiscountedPrice(productDto.getDiscountedPrice());
        productEntity.setRetailPrice(productDto.getRetailPrice());
        productEntity.setImageLink(productDto.getImageLink());
        productEntity.setCategory(categoryMapper.map(productDto.getCategory()));

        Set<RelatedProductEntity> relatedProductSet = productEntity.getRelatedProducts();
        for(var relatedProduct : productDto.getRelatedProductDto()){
            RelatedProductEntity relatedProductEntity = new RelatedProductEntity();
            relatedProductEntity.setProduct(productEntity);
            var relatedProductEntityDetail = productRepository.getById(relatedProduct.getId());
            relatedProductEntity.setRelatedProduct(relatedProductEntityDetail);
            relatedProductEntity.setActive(true);
            relatedProductSet.add(relatedProductEntity);
        }

        var a = productEntity.getProductName();
        return productEntity;
    }
}
