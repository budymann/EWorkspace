package com.budymann.ProductService.domain.repository;

import com.budymann.ProductService.dataaccess.ProductAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepository extends JpaRepository<ProductAttributeEntity, Long> {
}
