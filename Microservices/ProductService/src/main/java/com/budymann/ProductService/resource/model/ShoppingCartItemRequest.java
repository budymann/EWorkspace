package com.budymann.ProductService.resource.model;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@Generated
@Data
public class ShoppingCartItemRequest {
    private long shoppingCartItemId;
    private long productId;
    private int quantity;
}
