package com.budymann.ProductService.domain.dto;

import com.budymann.ProductService.dataaccess.ProductEntity;
import com.budymann.ProductService.dataaccess.SessionEntity;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Generated
@Data
@Builder
public class ShoppingCartItemDto {
    private Long id;
    private String sessionKey;
    private Long productId;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
