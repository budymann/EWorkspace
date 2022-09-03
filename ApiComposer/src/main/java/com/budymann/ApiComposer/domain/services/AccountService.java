package com.budymann.ApiComposer.domain.services;

import com.budymann.ApiComposer.domain.entities.AccountResponse;
import com.budymann.ApiComposer.domain.entities.OrderResponse;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class AccountService {
    public AccountResponse getAccount(String bsb, String accountNo) throws URISyntaxException, IOException, InterruptedException {

        RetryConfig config = RetryConfig.custom().maxAttempts(2).build();
        RetryRegistry registry = RetryRegistry.of(config);
        Retry retry = registry.retry("my");

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AccountResponse> response =
                restTemplate.getForEntity(String.format("http://localhost:8090/account/service/%s/%s/account", bsb, accountNo),
                        AccountResponse.class);

        return response.getBody();
    }
}
