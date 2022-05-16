package com.budymann.ProductService.resource;

import com.budymann.ProductService.domain.dto.ShoppingCartItemDto;
import com.budymann.ProductService.domain.mapper.ShoppingCartMapper;
import com.budymann.ProductService.domain.service.SessionService;
import com.budymann.ProductService.domain.service.ShoppingCartService;
import com.budymann.ProductService.resource.model.ShoppingCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CartResource {
    @Autowired
    SessionService sessionService;

    @Autowired
    ShoppingCartService shoppingService;

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @PostMapping("/cart")
    public List<ShoppingCartItemDto> addItemToCart(@RequestHeader(name = "SESSION_TOKEN") String sessionToken, @RequestBody ShoppingCartItemRequest shoppingCartItemRequest){

        var cartDto = shoppingCartMapper.map(shoppingCartItemRequest, sessionToken);

        return shoppingService.addItemToCart(cartDto);
    }

    @GetMapping("/cart/{sessionKey}")
    public List<ShoppingCartItemDto> getItemsFromCart(@PathVariable String sessionKey){
        return shoppingService.getCartItems(UUID.fromString(sessionKey));
    }
}
