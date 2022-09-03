package com.budymann.ProductService.domain.mapper;

import com.budymann.ProductService.dataaccess.ProductEntity;
import com.budymann.ProductService.dataaccess.ProductProductAttributeEntity;
import com.budymann.ProductService.dataaccess.RelatedProductEntity;
import com.budymann.ProductService.domain.dto.CategoryDto;
import com.budymann.ProductService.domain.dto.ProductAttributeDto;
import com.budymann.ProductService.domain.dto.ProductDto;
import com.budymann.ProductService.domain.dto.RelatedProductDto;
import com.budymann.ProductService.dataaccess.ProductAttributeDao;
import com.budymann.ProductService.dataaccess.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductMapper {
    @Autowired
    ProductDao productDao;

    @Autowired
    ProductAttributeDao productAttributeDao;

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

        productDto.setRelatedProductDto(new HashSet<>());
        for(var relatedProduct : from.getRelatedProducts()){
            productDto.getRelatedProductDto().add(RelatedProductDto.builder()
                    .id(relatedProduct.getProduct().getId())
                    .productName(relatedProduct.getProduct().getProductName())
                    .build());
        }

        productDto.setProductAttributes(new HashSet<>());
        for(var productAttribute: from.getProductAttributes()){
            productDto.getProductAttributes().add(ProductAttributeDto.builder()
                            .id(productAttribute.getProductAttribute().getId())
                            .name(productAttribute.getProductAttribute().getName())
                            .value(productAttribute.getValue())
                    .build());
        }


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
            productEntity = productDao.getOne(productDto.getId());
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
            var relatedProductEntityDetail = productDao.getById(relatedProduct.getId());
            relatedProductEntity.setRelatedProduct(relatedProductEntityDetail);
            relatedProductEntity.setActive(true);
            relatedProductSet.add(relatedProductEntity);
        }

        for(var productAttribute: productDto.getProductAttributes()){
            ProductProductAttributeEntity productProductAttributeEntity = new ProductProductAttributeEntity();
            productProductAttributeEntity.setProduct(productDao.getById(productDto.getId()));
            productProductAttributeEntity.setProductAttribute(productAttributeDao.getById(productAttribute.getId()));
            productProductAttributeEntity.setValue(productAttribute.getValue());
            productEntity.getProductAttributes().add(productProductAttributeEntity);
        }

        return productEntity;
    }
}
