package com.budymann.ProductService.domain.mapper;

import com.budymann.ProductService.dataaccess.CategoryEntity;
import com.budymann.ProductService.domain.dto.CategoryDto;
import com.budymann.ProductService.domain.dto.ProductDto;
import com.budymann.ProductService.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategoryMapper {
    @Autowired
    CategoryRepository categoryRepository;

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
        categoryDto.setId(from.getId());
        categoryDto.setCategoryName(from.getCategoryName());
        categoryDto.setCategoryPath(from.getCategoryPath());

        var categoryDtoChildrens = new ArrayList<CategoryDto>();
        for(var category : from.getChildren()){
            var catChildren = new CategoryDto();
            catChildren.setId(category.getId());
            catChildren.setCategoryPath(category.getCategoryPath());
            catChildren.setCategoryName(category.getCategoryName());
            categoryDtoChildrens.add(catChildren);
        }

        categoryDto.setChildren(categoryDtoChildrens);

        var products = from.getProducts();

        categoryDto.setProducts(new ArrayList<>());
        for(var product : products){
            var productDto = ProductDto.builder()
                    .id(product.getId())
                    .productName(product.getProductName())
                    .discountedPrice(product.getDiscountedPrice())
                    .retailPrice(product.getRetailPrice())
                    .imageLink(product.getImageLink())
                    .build();

            categoryDto.getProducts().add(productDto);
        }


        return categoryDto;
    }


    /* TODO: Consider cases:
        1. When only need to add singular category
        2. When editing category info (Does this ever happen??)
        3. When adding new product do we need category dto to be updated with new product in the entity?
    */
    public CategoryEntity map(CategoryDto categoryDto){
        if(categoryDto == null){
            return null;
        }

        var categoryEntity = new CategoryEntity();
        if(categoryDto.getId() != null) {
            categoryEntity = categoryRepository.getById(categoryDto.getId());
        }

        categoryEntity.setCategoryName(categoryDto.getCategoryName());
        categoryEntity.setCategoryPath(categoryDto.getCategoryPath());
        categoryEntity.setParent(map(categoryDto.getParent()));
        return categoryEntity;
    }


}
