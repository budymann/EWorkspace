package com.budymann.ProductService.domain.repository;

import com.budymann.ProductService.dataaccess.ShoppingCartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItemEntity, Long> {
    public List<ShoppingCartItemEntity> findBySessionId(Long sessionId);
    public List<ShoppingCartItemEntity> findBySessionSessionKey(UUID sessionSessionKey);
    public ShoppingCartItemEntity findBySessionIdAndProductId(Long sessionId, Long productId);
}
