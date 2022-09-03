package com.budymann.ProductService.domain.dto;

import com.budymann.ProductService.dataaccess.CategoryEntity;
import com.budymann.ProductService.dataaccess.ProductEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
/**
 * Category can be returned from 2 part
 * 1. When full details ARE required when trying to get detail about category EG: in admin management
 * 2. As part of Product DTO, in case of product dto we don't need self-referencing loop between product and category, what do we do in this case? do we
 * simply generate different response type??
 */
public class CategoryDto {
    private Long id;
    private String categoryName;
    private String categoryPath;
    private CategoryDto parent;
    private List<CategoryDto> children;
    private List<ProductDto> products;
}
