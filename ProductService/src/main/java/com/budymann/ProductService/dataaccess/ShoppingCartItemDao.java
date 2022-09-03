package com.budymann.ProductService.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ShoppingCartItemDao extends JpaRepository<ShoppingCartItemEntity, Long> {
    public List<ShoppingCartItemEntity> findBySessionId(Long sessionId);
    public List<ShoppingCartItemEntity> findBySessionSessionKey(UUID sessionSessionKey);
    public ShoppingCartItemEntity findBySessionIdAndProductId(Long sessionId, Long productId);
}
