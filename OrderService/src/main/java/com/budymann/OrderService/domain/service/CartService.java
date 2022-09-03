package com.budymann.OrderService.domain.service;

import com.budymann.product.service.apiclient.api.CartResourceApi;
import com.budymann.product.service.apiclient.model.ShoppingCartItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartResourceApi cartResourceApi;

    public List<ShoppingCartItemDto> getItemsFromCart(String sessionKey) {
        return cartResourceApi.getItemsFromCart(sessionKey);
    }
}
