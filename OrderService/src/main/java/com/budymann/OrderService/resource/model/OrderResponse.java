package com.budymann.OrderService.resource.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderResponse {
    private long orderId;
    private int amount;
}
