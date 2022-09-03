package com.budymann.ProductService.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelatedProductDto {
    private Long id;
    private String productName;
}
