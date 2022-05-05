package com.budymann.ProductService.resource;

import com.budymann.ProductService.domain.dto.ProductDto;
import com.budymann.ProductService.domain.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionResource {

    @Autowired
    SessionService sessionService;

    @GetMapping("/session/public")
    public String getPublicSessionToken(){
        return sessionService.getPublicSession();
    }
}
