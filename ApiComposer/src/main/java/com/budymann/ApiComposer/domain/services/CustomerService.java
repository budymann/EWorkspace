package com.budymann.ApiComposer.domain.services;

import com.budymann.ApiComposer.domain.entities.AccountResponse;
import com.budymann.ApiComposer.domain.entities.CustomerResponse;
import com.budymann.ApiComposer.domain.entities.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class CustomerService {
    public CustomerResponse getCustomer(Long customerId) throws URISyntaxException, IOException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CustomerResponse> response =
                restTemplate.getForEntity(String.format("http://localhost:8091/customer/service/%s/customer", customerId),
                        CustomerResponse.class);

        return response.getBody();
    }
}
