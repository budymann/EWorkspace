package com.budymann.ProductService.resource;

import org.springframework.web.bind.annotation.*;

@RestController
public class CartResource {
    @PostMapping("/cart")
    public String getPublicSessionToken(@RequestHeader(name = "SESSION_TOKEN") String sessionToken, @RequestBody ){
        return sessionService.getPublicSession();
    }

}
