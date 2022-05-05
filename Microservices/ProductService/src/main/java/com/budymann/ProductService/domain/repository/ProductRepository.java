package com.budymann.ProductService.domain.repository;

import com.budymann.ProductService.dataaccess.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
