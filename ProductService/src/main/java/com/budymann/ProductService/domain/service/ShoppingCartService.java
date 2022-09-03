package com.budymann.ProductService.domain.service;

import com.budymann.ProductService.domain.dto.ShoppingCartItemDto;
import com.budymann.ProductService.domain.mapper.ShoppingCartMapper;
import com.budymann.ProductService.dataaccess.SessionDao;
import com.budymann.ProductService.dataaccess.ShoppingCartItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartItemDao shoppingCartItemDao;

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Autowired
    SessionDao sessionDao;

    public List<ShoppingCartItemDto> addItemToCart(ShoppingCartItemDto shoppingCartItemDto){

        var sessionEntity = sessionDao.findBySessionKey(UUID.fromString(shoppingCartItemDto.getSessionKey()));


        var shoppingCartItemEntity = shoppingCartItemDao
                .findBySessionIdAndProductId(sessionEntity.getId(), shoppingCartItemDto.getProductId());

        if(shoppingCartItemEntity == null){
            shoppingCartItemDao.save(shoppingCartMapper.map(shoppingCartItemDto));
        }else{
            var currQuantity = shoppingCartItemEntity.getQuantity();
            shoppingCartItemEntity.setQuantity(currQuantity + shoppingCartItemDto.getQuantity());
            shoppingCartItemDao.save(shoppingCartItemEntity);

        }

        var shoppingCartItems = shoppingCartItemDao.findBySessionId(sessionEntity.getId());
        var shoppingCartItemDtos = new ArrayList<ShoppingCartItemDto>();

        for (var shoppingCartItem: shoppingCartItems)
        {
            shoppingCartItemDtos.add(shoppingCartMapper.map(shoppingCartItem));
        }

        return shoppingCartItemDtos;
    }

    public List<ShoppingCartItemDto> getCartItems(UUID sessionKey){
        var shoppingCartItems = shoppingCartItemDao.findBySessionSessionKey(sessionKey);
        var shoppingCartItemDtos = new ArrayList<ShoppingCartItemDto>();

        for (var shoppingCartItem: shoppingCartItems)
        {
            shoppingCartItemDtos.add(shoppingCartMapper.map(shoppingCartItem));
        }

        return shoppingCartItemDtos;
    }
}
