package com.budymann.ProductService.domain.service;

import com.budymann.ProductService.dataaccess.SessionEntity;
import com.budymann.ProductService.domain.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SessionService {
    @Autowired
    SessionRepository sessionRepository;

    public String getPublicSession(){
        var uuid = UUID.randomUUID();
        var session = SessionEntity.builder()
                .sessionKey(uuid)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now()).build();

        var saved = sessionRepository.save(session);

        return saved.getSessionKey().toString();
    }

}
