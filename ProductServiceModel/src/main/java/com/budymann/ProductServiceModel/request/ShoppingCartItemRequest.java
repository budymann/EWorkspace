package com.budymann.ProductServiceModel.request;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Generated
@Data
public class ShoppingCartItemRequest {
    private long productId;
    private int quantity;
}
