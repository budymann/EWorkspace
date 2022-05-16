package com.budymann.ProductService.domain.mapper;

import com.budymann.ProductService.dataaccess.ShoppingCartItemEntity;
import com.budymann.ProductService.domain.dto.ShoppingCartItemDto;
import com.budymann.ProductService.domain.repository.ProductRepository;
import com.budymann.ProductService.domain.repository.SessionRepository;
import com.budymann.ProductService.resource.model.ShoppingCartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ShoppingCartMapper {
    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    ProductRepository productRepository;

    public ShoppingCartItemDto map(ShoppingCartItemRequest request, String sessionToken){

        return ShoppingCartItemDto.builder()
                .sessionKey(sessionToken)
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .quantity(request.getQuantity())
                .build();
    }

    public ShoppingCartItemEntity map(ShoppingCartItemDto shoppingCartItemDto){
        var productEntity = productRepository.getById(shoppingCartItemDto.getProductId());
        var sessionEntity = sessionRepository.findBySessionKey(UUID.fromString(shoppingCartItemDto.getSessionKey()));

        return ShoppingCartItemEntity
                .builder()
                .id(shoppingCartItemDto.getId())
                .session(sessionEntity)
                .product(productEntity)
                .createdAt(shoppingCartItemDto.getCreatedAt())
                .modifiedAt(shoppingCartItemDto.getModifiedAt())
                .quantity(shoppingCartItemDto.getQuantity())
                .build();

    }

    public ShoppingCartItemDto map(ShoppingCartItemEntity shoppingCartItemDto){
        return ShoppingCartItemDto
                .builder()
                .id(shoppingCartItemDto.getId())
                .sessionKey(shoppingCartItemDto.getSession().getSessionKey().toString())
                .productId(shoppingCartItemDto.getProduct().getId())
                .createdAt(shoppingCartItemDto.getCreatedAt())
                .modifiedAt(shoppingCartItemDto.getModifiedAt())
                .quantity(shoppingCartItemDto.getQuantity())
                .build();
    }
}
