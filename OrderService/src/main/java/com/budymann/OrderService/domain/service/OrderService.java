package com.budymann.OrderService.domain.service;

import com.budymann.OrderService.dataaccess.Order;
import com.budymann.OrderService.dataaccess.OrderItem;
import com.budymann.OrderService.dataaccess.Product;
import com.budymann.OrderService.domain.repository.OrderDao;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderDao orderDao;

    public Order placeOrder(String sessionId)  {
        var items = cartService.getItemsFromCart(sessionId);

        Order order = new Order();
        order.setSessionKey(UUID.fromString(sessionId));
        order.setCreatedDate(LocalDateTime.now());

        Set<OrderItem> orderItemSet = new HashSet<>();

        BigDecimal totalPrice = BigDecimal.ZERO;
        for(var item : items){
            var product = productService.getProduct(item.getProductId());

            var orderItem = OrderItem.builder()
                    .product(Product.builder()
                            .id(product.getId())
                            .productName(product.getProductName())
                            .retailPrice(product.getRetailPrice())
                            .discountedPrice(product.getDiscountedPrice())
                            .productName(product.getProductName())
                            .build())
                    .order(order)
                    .createdDate(LocalDateTime.now())
                    .price(product.getRetailPrice())
                    .quantity(item.getQuantity())
                    .build();

            totalPrice = totalPrice.add(orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
            orderItemSet.add(orderItem);
        }

        order.setOrderItems(orderItemSet);
        order.setTotalPrice(totalPrice);

        var orderEntity =  orderDao.save(order);
        return orderEntity;
    }

}
