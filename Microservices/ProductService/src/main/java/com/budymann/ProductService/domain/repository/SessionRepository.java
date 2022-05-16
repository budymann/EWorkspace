package com.budymann.ProductService.domain.repository;

import com.budymann.ProductService.dataaccess.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {

    public SessionEntity findBySessionKey(UUID sessionKey);
}
