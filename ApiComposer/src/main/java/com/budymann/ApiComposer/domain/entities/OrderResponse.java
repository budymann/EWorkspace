package com.budymann.ApiComposer.domain.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private int orderId;
    private int amount;
}

