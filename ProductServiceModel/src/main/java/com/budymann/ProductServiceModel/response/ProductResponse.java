package com.budymann.ProductServiceModel.response;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Generated
@Data
public class ProductResponse {
    private Long id;
    private String productName;
    private BigDecimal retailPrice;
    private BigDecimal discountedPrice;
    private String imageLink;
    private ProductCategoryResponse category;
    private Set<RelatedProductResponse> relatedProductDto;
    private Set<ProductAttributeResponse> productAttributes;
}
