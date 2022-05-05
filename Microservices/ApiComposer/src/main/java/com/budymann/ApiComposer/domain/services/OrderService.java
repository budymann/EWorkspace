package com.budymann.ApiComposer.domain.services;

import com.budymann.ApiComposer.domain.entities.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class OrderService {

    public OrderResponse getOrder(long orderId) throws URISyntaxException, IOException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<OrderResponse> response =
                restTemplate.getForEntity(String.format("http://localhost:8080/order/%s", orderId),
                        OrderResponse.class);

        return response.getBody();
    }

}
