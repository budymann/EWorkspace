package com.budymann.ProductService.domain.dto;

import com.budymann.ProductService.dataaccess.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Generated
@Data
@Getter
@Setter
@Builder
public class ProductDto {
    private Long productId;
    private String productName;
    private BigDecimal retailPrice;
    private BigDecimal discountedPrice;
    private String imageLink;
    private CategoryDto category;
}
