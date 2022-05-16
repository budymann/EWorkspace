package com.budymann.ProductService.domain.repository;

import com.budymann.ProductService.dataaccess.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}