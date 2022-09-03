package com.budymann.ProductService.domain.dto;

import com.budymann.ProductService.dataaccess.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Generated
@Data
@Getter
@Setter
@Builder
public class ProductDto {
    private Long id;
    private String productName;
    private BigDecimal retailPrice;
    private BigDecimal discountedPrice;
    private String imageLink;
    private CategoryDto category;
    private Set<RelatedProductDto> relatedProductDto;
    private Set<ProductAttributeDto> productAttributes;
}
