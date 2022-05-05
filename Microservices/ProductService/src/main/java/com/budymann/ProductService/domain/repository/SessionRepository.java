package com.budymann.ProductService.domain.repository;

import com.budymann.ProductService.dataaccess.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {
}
