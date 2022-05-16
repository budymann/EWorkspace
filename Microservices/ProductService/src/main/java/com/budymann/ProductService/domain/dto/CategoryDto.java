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
public class CategoryDto {
    private Long id;
    private String categoryName;
    private String categoryPath;
    private CategoryDto parent;
    private List<CategoryDto> children;
    private List<ProductDto> products;
}
