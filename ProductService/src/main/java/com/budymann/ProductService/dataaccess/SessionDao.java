package com.budymann.ProductService.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionDao extends JpaRepository<SessionEntity, Long> {

    public SessionEntity findBySessionKey(UUID sessionKey);
}
