package com.budymann.ProductService.domain.service;

import com.budymann.ProductService.dataaccess.ShoppingCartItemEntity;
import com.budymann.ProductService.domain.dto.ShoppingCartItemDto;
import com.budymann.ProductService.domain.mapper.ShoppingCartMapper;
import com.budymann.ProductService.domain.repository.SessionRepository;
import com.budymann.ProductService.domain.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Autowired
    SessionRepository sessionRepository;

    public List<ShoppingCartItemDto> addItemToCart(ShoppingCartItemDto shoppingCartItemDto){

        var sessionEntity = sessionRepository.findBySessionKey(UUID.fromString(shoppingCartItemDto.getSessionKey()));


        var shoppingCartItemEntity = shoppingCartItemRepository
                .findBySessionIdAndProductId(sessionEntity.getId(), shoppingCartItemDto.getProductId());

        if(shoppingCartItemEntity == null){
            shoppingCartItemRepository.save(shoppingCartMapper.map(shoppingCartItemDto));
        }else{
            var currQuantity = shoppingCartItemEntity.getQuantity();
            shoppingCartItemEntity.setQuantity(currQuantity + shoppingCartItemDto.getQuantity());
            shoppingCartItemRepository.save(shoppingCartItemEntity);

        }

        var shoppingCartItems = shoppingCartItemRepository.findBySessionId(sessionEntity.getId());
        var shoppingCartItemDtos = new ArrayList<ShoppingCartItemDto>();

        for (var shoppingCartItem: shoppingCartItems)
        {
            shoppingCartItemDtos.add(shoppingCartMapper.map(shoppingCartItem));
        }

        return shoppingCartItemDtos;
    }

    public List<ShoppingCartItemDto> getCartItems(UUID sessionKey){
        var shoppingCartItems = shoppingCartItemRepository.findBySessionSessionKey(sessionKey);
        var shoppingCartItemDtos = new ArrayList<ShoppingCartItemDto>();

        for (var shoppingCartItem: shoppingCartItems)
        {
            shoppingCartItemDtos.add(shoppingCartMapper.map(shoppingCartItem));
        }

        return shoppingCartItemDtos;
    }
}
