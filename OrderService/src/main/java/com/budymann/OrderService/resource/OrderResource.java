package com.budymann.OrderService.resource;

import com.budymann.OrderService.dataaccess.Order;
import com.budymann.OrderService.domain.service.OrderService;
import com.budymann.OrderService.resource.model.OrderResponse;
import com.budymann.OrderService.domain.service.ProductService;
import com.budymann.product.service.apiclient.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderResource {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    //get list of order by customer
    @GetMapping("order/{customerId}")
    public List<OrderResponse> getOrders(@PathVariable Long customerId){
        return null;
    }

    @GetMapping("/product/{productId}")
    public ProductDto getProduct(@PathVariable Long productId){
        return new ProductDto();
    }

    @PostMapping("order")
    public Order placeOrder(@RequestBody String sessionKey){
        return orderService.placeOrder(sessionKey);
    }


}
