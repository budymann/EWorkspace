package com.budymann.ProductService.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeDao extends JpaRepository<ProductAttributeEntity, Long> {
}
