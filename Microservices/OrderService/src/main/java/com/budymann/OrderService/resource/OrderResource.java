package com.budymann.OrderService.resource;

import com.budymann.OrderService.resource.model.OrderResponse;
import org.hibernate.criterion.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderResource {

    @GetMapping("order/{id}")
    public OrderResponse getOrder(@PathVariable long id){
        return OrderResponse.builder().orderId(id).amount(1).build();
    }

    //get list of order by customer
    @GetMapping("{customerId}/order")
    public List<OrderResponse> getOrders(@PathVariable long customerId){
        return null;
    }

}
